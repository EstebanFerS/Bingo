package bingo;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorBingo {
    private ServerSocket serverSocket;
    private final int port = 5000;
    private int maxJugadores;
    private String modalidad;
    private List<Socket> clientes = new ArrayList<>();
    private List<String> nombres = new ArrayList<>();

    public ServidorBingo(String modalidad, int maxJugadores) {
        this.modalidad = modalidad;
        this.maxJugadores = maxJugadores;
    }

    public void iniciar() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("ServidorBingo iniciado en puerto " + port);
            System.out.println("Modalidad: " + modalidad + " | Jugadores esperados: " + maxJugadores);

            while (clientes.size() < maxJugadores) {
                Socket cliente = serverSocket.accept();
                System.out.println("Nuevo jugador conectado: " + cliente);

                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                String nombreJugador = entrada.readUTF();

                clientes.add(cliente);
                nombres.add(nombreJugador);

                // Mandamos modalidad al cliente
                DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                salida.writeUTF(modalidad);

                System.out.println("Jugador " + nombreJugador + " registrado.");
            }

            System.out.println("Todos los jugadores se han conectado.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}