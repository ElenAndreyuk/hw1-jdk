package ru.elena.server;
/*
– На предыдущем семинаре было описано окно сервера приложения, содержащее две кнопки (старт и стоп)
 и текстовое поле журнала. Необходимо вынести логику работы сервера в класс ChatServer,
 а в обработчиках кнопок оставить только логику нажатия кнопки и журналирования сообщений от сервера.
Для достижения цели необходимо описать интерфейс «слушатель сервера», с методом
«получить сообщение», вызывать его с одной стороны, и реализовать с другой. Вариант
решения
 */
public interface ServerListenable {
    void onMessageReceived(String msg);
}
