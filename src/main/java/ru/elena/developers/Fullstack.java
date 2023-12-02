package ru.elena.developers;

public class Fullstack extends Developer implements Frontendable, Backendable{
    @Override
    public void back() {
        System.out.println("Make back");
    }

    @Override
    public void front() {
        System.out.println("Make front");

    }
}
