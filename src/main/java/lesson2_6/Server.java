package lesson2_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private final int SERVER_PORT = 8189;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            openConnection();
            sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openConnection() throws IOException {
        serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Сервер запущен, ожидаем подключения...");
        socket = serverSocket.accept();
        System.out.println("Клиент подключился");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String messageIn = in.readUTF();
                        if (!socket.isConnected()) {
                            System.out.println("Клиент отключился");
                            break;
                        }
                        if ("/end".equalsIgnoreCase(messageIn)) {
                            System.out.println("Сервер остановлен");
                            break;
                        }
                        System.out.println("Сообщение от клиента: " + messageIn);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendMessage() {
        try {
            while (true) {
                String messageOut = scanner.nextLine();
                out.writeUTF(messageOut);
                if ("/end".equalsIgnoreCase(messageOut)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

   public void closeConnection() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}