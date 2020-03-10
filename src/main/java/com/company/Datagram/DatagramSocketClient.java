package com.company.Datagram;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class DatagramSocketClient {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.println("Escribe un msg...");
        byte[] missatge = in.nextLine().getBytes();
//adreça IP del destí
        InetAddress adrecaDesti = InetAddress.getByName("localhost");
//port destí
        int portDesti = 25565;
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