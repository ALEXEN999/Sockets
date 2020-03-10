package com.company.Datagram;

import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatagramSocketClient {
    public static java.util.List<String> cartas = new ArrayList<>();
    public static InetAddress adrecaDesti;

    public static List<String> baraja = new ArrayList<>();

    static {
        try {
            adrecaDesti = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static int portDesti = 25565;



    public static void main(String[] args) throws IOException {

        //cargando cartas
        cartas(cartas);
        pedirCarta(baraja);
        pedirCarta(baraja);
        pedirCarta(baraja);
        pedirCarta(baraja);

        mostrarCartas();




    }

    public static void mostrarCartas() throws IOException {
        System.out.println(baraja);

        for (int i = 0; i < 52; i++) {

            byte[] missatge = cartas.get(i).getBytes();

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
    public static java.util.List<String> cartas(java.util.List<String>cartas){

        int countTrebol = 1;
        int countPicas = 1;
        int countCorazones = 1;
        int countDiamantes = 1;


        for (int i = 1; cartas.size()<= 51 ; i++) {

            if (countTrebol<=13){
                if (countTrebol == 11){
                    cartas.add("J-Trebol");
                    countTrebol++;
                }else if (countTrebol == 12){
                    cartas.add("Q-Trebol");
                    countTrebol++;
                }else if (countTrebol == 13){
                    cartas.add("K-Trebol");
                    countTrebol++;
                }else if (countTrebol<=10){
                    cartas.add(i+"-Trebol");
                    countTrebol++;
                }
            }

            if (countPicas<=13){
                if (countPicas == 11){
                    cartas.add("J-Picas");
                    countPicas++;
                }else if (countPicas == 12){
                    cartas.add("Q-Picas");
                    countPicas++;
                }else if (countPicas == 13){
                    cartas.add("K-Picas");
                    countPicas++;
                }else if (countPicas<=10){
                    cartas.add(i+"-Picas");
                    countPicas++;
                }
            }
            if (countCorazones<=13){
                if (countCorazones == 11){
                    cartas.add("J-Corazones");
                    countCorazones++;
                }else if (countCorazones == 12){
                    cartas.add("Q-Corazones");
                    countCorazones++;
                }else if (countCorazones == 13){
                    cartas.add("K-Corazones");
                    countCorazones++;
                }else if (countCorazones<=10){
                    cartas.add(i+"-Corazones");
                    countCorazones++;
                }
            }
            if (countDiamantes<=13){
                if (countDiamantes == 11){
                    cartas.add("J-Diamantes");
                    countDiamantes++;
                }else if (countDiamantes == 12){
                    cartas.add("Q-Diamantes");
                    countDiamantes++;
                }else if (countDiamantes == 13){
                    cartas.add("K-Diamantes");
                    countDiamantes++;
                }else if (countDiamantes<=10){
                    cartas.add(i+"-Diamantes");
                    countDiamantes++;
                }
            }
        }
        return cartas;
    }

    public static java.util.List<String> pedirCarta(java.util.List<String> baraja){

        int numCartaRandom = (int) ((Math.random() * (52)) + 0);
        if (baraja.isEmpty()){
            baraja.add(cartas.get(numCartaRandom));
        }else {
            for (int i  = 1; i != baraja.size()+1; i++) {

                if (Integer.parseInt(String.valueOf(baraja.indexOf(i))) == numCartaRandom){
                    numCartaRandom = (int) ((Math.random() * (52)) + 0);
                }else {
                    baraja.add(cartas.get(numCartaRandom));

                    break;

                }

            }
        }

        return baraja;
    }
}