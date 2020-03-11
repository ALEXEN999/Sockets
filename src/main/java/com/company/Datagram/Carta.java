package com.company.Datagram;

import java.util.ArrayList;
import java.util.List;

import static com.company.Datagram.DatagramSocketClient.baraja;

public class Carta {

    public static List<String> listaTipos = new ArrayList<>();
    public static List<Integer> listaValores = new ArrayList<>();

    String tipo;
    String valor;


    public Carta(String tipo, String valor){
        this.tipo = tipo;
        this.valor = valor;
    }


    public static Carta cojerCarta(){

        int numValorCartaRandom = (int) ((Math.random() * (13)) + 1);
        int numTipoCartaRandom = (int) ((Math.random() * (4)) + 0);
        String valorRandom = "";
        if (numValorCartaRandom<=10){
            valorRandom = String.valueOf(listaValores.get(numValorCartaRandom)-1);
        }else if (numValorCartaRandom==11){
            valorRandom = "J";
        }else if (numValorCartaRandom==12){
            valorRandom = "Q";
        }else if (numValorCartaRandom==13){
            valorRandom = "K";
        }

        String tipoRandom = listaTipos.get(numTipoCartaRandom);

        Carta carta = new Carta(tipoRandom, valorRandom);
        System.out.println(carta);

//        baraja.add(carta);
        int i = 0;
        if (baraja.isEmpty()){
            baraja.add(carta);
        }else {

            String finalValorRandom = valorRandom;
            String v = String.valueOf(baraja.stream()
                    .filter(baraja->baraja.valor.equals(finalValorRandom))
                    .count());
            System.out.println(v);
//            for (i = 0; i <=baraja.size(); i++) {
//                if (!baraja.get(i).valor .equals(valorRandom)){
//                    baraja.add(carta);
//                    return carta;
//                } else {
//                    if (i==baraja.size()) {
//                        break;
//                    }
//                }
//            }
        }
        if (baraja.size()==i){
            baraja.add(carta);
        }

        return carta;
    }
    public static void rellenar(){
        listaTipos.add("Corazones");
        listaTipos.add("Diamantes");
        listaTipos.add("Picas");
        listaTipos.add("Treboles");

        for (int i = 1; i <=13 ; i++) {
            listaValores.add(i);
        }
    }


    @Override
    public String toString() {
        return "Carta{ "+valor+"-"+tipo+" }";
    }

}
