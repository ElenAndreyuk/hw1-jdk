package ru.elena.server;

public class Main {
    public static void main(String[] args) {
        ServerListenable listener = new LogServerListener();
        Server server = new Server(listener);
        ServerWindow window = new ServerWindow(server);



    }
}