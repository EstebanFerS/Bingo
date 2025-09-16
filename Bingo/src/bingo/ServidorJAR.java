package bingo;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class ServidorJAR {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java ServidorJAR <MODALIDAD> <CANTIDAD_JUGADORES>");
            return;
        }

        String modalidad = args[0]; // "FULLHOUSE" o "PATRON"
        int cantJugadores = Integer.parseInt(args[1]);

        // 🔹 Arrancamos el servidor de Bingo
        ServidorBingo servidor = new ServidorBingo(modalidad, cantJugadores);
        new Thread(servidor::iniciar).start();

        // 🔹 También arrancamos el servidor HTTP para distribuir el .jar
        try {
            int httpPort = 8080;
            String jarPath = "ClienteBingo.jar"; // Debe estar en la misma carpeta

            HttpServer httpServer = HttpServer.create(new InetSocketAddress(httpPort), 0);
            httpServer.createContext("/ClienteBingo.jar", new JarHandler(jarPath));
            httpServer.setExecutor(null);
            httpServer.start();

            String localIp = InetAddress.getLocalHost().getHostAddress();
            System.out.println("========================================");
            System.out.println("Servidor Bingo iniciado en puerto 5000");
            System.out.println("Modalidad: " + modalidad + " | Jugadores esperados: " + cantJugadores);
            System.out.println("----------------------------------------");
            System.out.println("Servidor JAR disponible en:");
            System.out.println("http://" + localIp + ":" + httpPort + "/ClienteBingo.jar");
            System.out.println("========================================");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class JarHandler implements HttpHandler {
        private final String jarPath;

        public JarHandler(String jarPath) {
            this.jarPath = jarPath;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            File file = new File(jarPath);
            if (!file.exists()) {
                String response = "Archivo ClienteBingo.jar no encontrado en el servidor.";
                exchange.sendResponseHeaders(404, response.length());
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
                return;
            }

            exchange.getResponseHeaders().add("Content-Type", "application/java-archive");
            exchange.sendResponseHeaders(200, file.length());

            try (OutputStream os = exchange.getResponseBody();
                 FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        }
    }
}