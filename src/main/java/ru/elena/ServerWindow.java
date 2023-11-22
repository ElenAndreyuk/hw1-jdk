package ru.elena;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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
    boolean isServerWorking;
    JButton btnStart = new JButton("запустить сервер");
    JButton btnStop = new JButton("остановить сервер");

    ServerWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(true);

        setLayout(new GridLayout(1, 2));
        add(btnStart);
        add(btnStop);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                System.out.println("Start server "  + new Date());
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                System.out.println("Stop server " + new Date());
            }
        });


        setVisible(true);
    }

}