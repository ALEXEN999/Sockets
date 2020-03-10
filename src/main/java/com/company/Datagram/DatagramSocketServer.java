package com.company.Datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramSocketServer {

    public static void main(String[] args) throws IOException {
        //port a escoltar el servei que estem implementant
        int portAEscoltar = 25565;
//vector de bytes en el qual rebre el missatge amb una capacitat de 1.024 bytes
        byte[] missatge = new byte[1024];
//creació del paquet en el qual rebre les dades de 1.024 bytes com a màxim
        DatagramPacket packet = new DatagramPacket(missatge,
                missatge.length);
//creació d'un sòcol que escolti el port passat per paràmetre
        DatagramSocket socket = new DatagramSocket(portAEscoltar);
//recepció d'un paquet
        while (true){
            socket.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        }
    }
}
