package ru.elena.server;

import java.io.FileWriter;
import java.io.IOException;

public class LogServerListener implements ServerListenable{
    private final String PATH = "log.txt";
    @Override
    public void onMessageReceived(String msg) {
        try(FileWriter writer = new FileWriter(PATH, true)){
            writer.write(msg + "\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
