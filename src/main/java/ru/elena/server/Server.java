package ru.elena.server;

public class Server{
    boolean isServerWorking;
    private final ServerListenable listener;


    public Server(ServerListenable listener) {
        this.listener = listener;
        this.isServerWorking = false;
    }

    public void start(){
        if(!isServerWorking){
            listener.onMessageReceived("Server started");
            isServerWorking = true;
        }else {
            listener.onMessageReceived("Server is already working");
        }

    }
    public void stop(){
        if(isServerWorking){
            listener.onMessageReceived("Server stopped");
            isServerWorking = false;
        }else {
            listener.onMessageReceived("Server is already stopped");
        }

    }
}
