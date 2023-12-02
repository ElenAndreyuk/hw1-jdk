package ru.elena.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;


/*
Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля,
IP-адреса сервера, порта подключения к серверу, область ввода сообщений, JTextArea область
просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат.
Желательно сразу сгруппировать компоненты, относящиеся к серверу сгруппировать
на JPanel сверху экрана, а компоненты, относящиеся к отправке сообщения – на JPanel снизу

ДЗ
+Выполнить все задания семинара, если они не были решены, без ограничений по времени;
+Отправлять сообщения из текстового поля сообщения в лог по нажатию кнопки или
по нажатию клавиши Enter на поле ввода сообщения;
-Продублировать импровизированный лог (историю) чата в файле;
-При запуске клиента чата заполнять поле истории из файла, если он существует.
Обратите внимание, что чаще всего история сообщений хранится на сервере и заполнение истории
чата лучше делать при соединении с сервером, а не при открытии окна клиента.
 */

public class ChatClient extends JFrame {
    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_POSX = 300;
    private static final int WINDOW_POSY = 0;
    private static final String PATH = "log.txt";
    JLabel loginLabel = new JLabel("введите логин:");
    JTextField login = new JTextField();
    JLabel passwordLabel = new JLabel("введите пароль");
    JTextField password = new JTextField();
    JLabel serverIPLabel = new JLabel("введите IP сервера");
    JTextField serverIP = new JTextField();
    JLabel serverPortLabel = new JLabel("введите порт сервера");
    JTextField serverPort = new JTextField();
    JLabel textLabel = new JLabel("введите сообщение");
    JTextField message = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton btnSendText = new JButton("отправить сообщение");
    JButton btnServer  = new JButton("подключиться к серверу");

    ChatClient() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat Client");
        setResizable(true);



        JPanel panelServer = new JPanel(new GridLayout(6, 1));
        panelServer.add(serverIPLabel);
        panelServer.add(serverIP);
        panelServer.add(serverPortLabel);
        panelServer.add(serverPort);
        panelServer.add(btnServer);
        add(panelServer, BorderLayout.NORTH);

        add(textArea, BorderLayout.CENTER);

        JPanel panelText = new JPanel(new GridLayout(7, 1));
        panelText.add(loginLabel);
        panelText.add(login);
        panelText.add(passwordLabel);
        panelText.add(password);
        panelText.add(textLabel);
        panelText.add(message);
        panelText.add(btnSendText);
        add(panelText, BorderLayout.SOUTH);




        btnServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start server "  + new Date());
                try(FileReader reader = new FileReader(PATH))
                {
                    Scanner scanner = new Scanner(reader);
                    while (scanner.hasNext()){
                        textArea.append(scanner.nextLine() + "\n");
                    }
                }catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
        });

        btnSendText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(login.getText() + ": " + message.getText() +"\n");
                System.out.println("Send message "  + new Date() );
                writeLog(message.getText());

            }
        });

        message.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                textArea.append(login.getText() + ": " + s +"\n");
                writeLog(message.getText());
            }
        });
        setVisible(true);
    }



    private void writeLog(String mes) {
        try (FileWriter writer = new FileWriter(PATH, false)){
            writer.write(textArea.getText());
          writer.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }




}
