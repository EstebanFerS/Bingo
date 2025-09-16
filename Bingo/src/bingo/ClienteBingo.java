package bingo;

import javax.swing.*;
import java.io.*;
import java.net.*;

public class ClienteBingo {
    private String host = "localhost"; // cámbialo si el servidor corre en otra máquina
    private int port = 5000;
    private String nombre;

    public ClienteBingo(String nombre) {
        this.nombre = nombre;
    }

    public void conectar() {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Conectado al servidor.");

            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF(nombre);

            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            String modalidad = entrada.readUTF();
            System.out.println("Modalidad recibida: " + modalidad);

            SwingUtilities.invokeLater(() -> {
                if ("FULLHOUSE".equalsIgnoreCase(modalidad)) {
                    FullHouse fh = new FullHouse(nombre);
                    fh.setVisible(true);
                } else {
                    Patron pt = new Patron();
                    pt.setVisible(true);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}