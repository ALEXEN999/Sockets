package com.company.Datagram;


import java.util.ArrayList;
import java.util.List;

import static com.company.Datagram.DatagramSocketClient.baraja;
import static com.company.Datagram.DatagramSocketClient.portDesti;

public class Carta {
    public static List<Carta> listaCartas = new ArrayList<>();

    String tipo;
    String valor;
    public static int puntosTotales;

    public Carta(String valor, String tipo){
        this.tipo = tipo;
        this.valor = valor;
    }

    public static void cojerCarta(){
        int numCartaRandom = (int) ((Math.random() * (listaCartas.size())) + 0);
        baraja.add(listaCartas.get(numCartaRandom));
        System.out.println();
        System.out.println("Te ha tocado un "+listaCartas.get(numCartaRandom).valor+"-"+listaCartas.get(numCartaRandom).tipo);
        puntosTotales = 0;

        for (Carta carta : baraja) {
            if (carta.valor.equals("J") || carta.valor.equals("Q") || carta.valor.equals("K")) {
                puntosTotales += 10;
            } else {
                puntosTotales += Integer.parseInt(carta.valor);
            }
        }
        System.out.println("Tienes "+puntosTotales+" puntos");
        listaCartas.remove(numCartaRandom);
    }

    public static List<Carta> rellenar(){
        int countTrebol = 1;
        int countPicas = 1;
        int countCorazones = 1;
        int countDiamantes = 1;


        for (int i = 1; listaCartas.size()<= 51 ; i++) {

            if (countTrebol<=13){
                if (countTrebol == 11){
                    listaCartas.add(new Carta("J","Trebol"));
                    countTrebol++;
                }else if (countTrebol == 12){
                    listaCartas.add(new Carta("Q","Trebol"));
                    countTrebol++;
                }else if (countTrebol == 13){
                    listaCartas.add(new Carta("K","Trebol"));
                    countTrebol++;
                }else if (countTrebol<=10){
                    listaCartas.add(new Carta(String.valueOf(i),"Trebol"));
                    countTrebol++;
                }
            }

            if (countPicas<=13){
                if (countPicas == 11){
                    listaCartas.add(new Carta("J","Picas"));
                    countPicas++;
                }else if (countPicas == 12){
                    listaCartas.add(new Carta("Q","Picas"));
                    countPicas++;
                }else if (countPicas == 13){
                    listaCartas.add(new Carta("K","Picas"));
                    countPicas++;
                }else if (countPicas<=10){
                    listaCartas.add(new Carta(String.valueOf(i),"Picas"));
                    countPicas++;
                }
            }
            if (countCorazones<=13){
                if (countCorazones == 11){
                    listaCartas.add(new Carta("J","Corazones"));
                    countCorazones++;
                }else if (countCorazones == 12){
                    listaCartas.add(new Carta("Q","Corazones"));
                    countCorazones++;
                }else if (countCorazones == 13){
                    listaCartas.add(new Carta("K","Corazones"));
                    countCorazones++;
                }else if (countCorazones<=10){
                    listaCartas.add(new Carta(String.valueOf(i),"Corazones"));
                    countCorazones++;
                }
            }
            if (countDiamantes<=13){
                if (countDiamantes == 11){
                    listaCartas.add(new Carta("J","Diamantes"));
                    countDiamantes++;
                }else if (countDiamantes == 12){
                    listaCartas.add(new Carta("Q","Diamantes"));
                    countDiamantes++;
                }else if (countDiamantes == 13){
                    listaCartas.add(new Carta("K","Diamantes"));
                    countDiamantes++;
                }else if (countDiamantes<=10){
                    listaCartas.add(new Carta(String.valueOf(i),"Diamantes"));
                    countDiamantes++;
                }
            }
        }
        return listaCartas;
    }


    @Override
    public String toString() {
        return "Carta{ "+valor+"-"+tipo+" }";
    }

}
