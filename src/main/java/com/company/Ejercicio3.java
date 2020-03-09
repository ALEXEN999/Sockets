package com.company;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        Ejercicio3 ejercicio3 = new Ejercicio3();
        URL url = new URL("https://docs.google.com/forms/u/0/d/e/1FAIpQLScE6sxLFb3BmCmT2TKHQH5ormS0qvjHwO-uTAR8MXaagBvSSQ/formResponse");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setDoInput(true);
        con.connect();

        String nombre = "alejandro";
        String radiobutton = "Si";
        DataOutputStream dataOutputStream = new DataOutputStream(con.getOutputStream());

        dataOutputStream.writeBytes("entry.835030737="+nombre);
        dataOutputStream.writeBytes("&entry.1616686619="+radiobutton);

        dataOutputStream.flush();
        dataOutputStream.close();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));


        bufferedReader.close();
    }
}
