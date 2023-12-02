package ru.elena.server;

import ru.elena.server.Server;
import ru.elena.server.ServerListenable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Создать простейшее окно управления сервером (по сути, любым),
содержащее две кнопки (JButton) – запустить сервер и остановить сервер.
Кнопки должны просто логировать нажатие (имитировать запуск и остановку сервера, соответственно)
и выставлять внутри интерфейса соответствующее булево isServerWorking.
 */

public class ServerWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_POSX = 300;
    private static final int WINDOW_POSY = 100;
    Server server;

    JButton btnStart = new JButton("запустить сервер");
    JButton btnStop = new JButton("остановить сервер");

    ServerWindow(Server server) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        this.server = server;
       // Server server = new Server(this);
        setResizable(true);

        setLayout(new GridLayout(1, 2));
        add(btnStart);
        add(btnStop);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.start();
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.stop();
            }
        });


        setVisible(true);
    }

//    @Override
//    public void onMessageReceived(String msg) {
//        System.out.println(msg);
//    }
}