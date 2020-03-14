package com.company.Datagram;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static com.company.Datagram.Carta.*;
import static java.lang.System.exit;

public class DatagramSocketClient {
    public static InetAddress adrecaDesti;
    public static List<Carta> baraja = new ArrayList<>();
    static String nombre;
    static {
        try {
            adrecaDesti = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static int portDesti = 25565;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.println("Cual es tu nombre?");
        System.out.println();
        nombre = in.nextLine();


        rellenar();


        while (true){
            System.out.println();
            System.out.println("Que quieres hacer?");
            System.out.println();
            System.out.println("1.-Pedir Carta\n2.-Mostrar Cartas");

            int op = in.nextInt();

            switch (op){
                case 1:
                    cojerCarta();
                    if (puntosTotales > 21){
                        System.out.println();
                        System.out.println("Te has pasado, lo siento");
                        mostrarCartas();
                        exit(0);
                    }
                    break;
                case 2:
                    mostrarCartas();
                    break;
            }
        }
    }


    public static void mostrarCartas() throws IOException {
        System.out.println(baraja);
        byte[] missatge = " ".getBytes();
            if (puntosTotales>21){
                missatge = String.valueOf(nombre+" -> "+puntosTotales+" puntos -> HA PERDIDO").getBytes();
            }else {
                missatge = String.valueOf(nombre+" -> "+puntosTotales+" puntos").getBytes();
            }

            //creació del paquet a enviar
            DatagramPacket packet = new DatagramPacket(missatge,
                    missatge.length,
                    adrecaDesti,
                    portDesti);

            //creació d'un sòcol temporal amb el qual realitzar l'enviament
            DatagramSocket socket = new DatagramSocket();


            //Enviament del missatge
            socket.send(packet);
    }
}