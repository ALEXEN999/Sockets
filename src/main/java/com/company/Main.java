package com.company;


import javax.print.DocFlavor;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        InetAddress[] addresses = new InetAddress[2];

        addresses[0] = InetAddress.getLoopbackAddress();
        addresses[1] = InetAddress.getByName("ioc.xtec.cat");


        String ip = "87.238.19.51";

        String addressHostName = addresses[1].getCanonicalHostName();

        byte [] address = addresses[1].getAddress();

        System.out.println("Esta es la direccion obtenida a partir de bytes: "+InetAddress.getByAddress(address));

        System.out.println("Este es el nombre de la maquina mas la ip local: "+Inet4Address.getLocalHost());

        System.out.println("Esto es la ip del host publico: "+addressHostName);

        System.out.println("Esta es la direccion obtenida en bytes: "+address);

        System.out.println();

        for(InetAddress adress: addresses){
            if(adress.isLoopbackAddress()){
                System.out.println(adress.getHostName() + " té una adreça loopback");
            }else{
                System.out.println(adress.getHostName() + " no té una adreça loopback");
            }
        }

        URL url = new URL("https://moodle.elpuig.xeill.net");

        System.out.println();

        System.out.println("Este es el authority del moodle del puig: "+url.getAuthority());
        System.out.println("Este es el host del moodle del puig: "+url.getHost());
        System.out.println("Este es el protocolo del moodle del puig: "+url.getProtocol());
        System.out.println("Este es el puerto del moodle del puig: "+url.getPort());
        System.out.println("Este es el content del moodle del puig: "+url.getContent().toString());

    }
}
