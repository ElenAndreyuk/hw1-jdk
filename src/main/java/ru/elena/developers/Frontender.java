package ru.elena.developers;

public class Frontender extends Developer implements Frontendable{
    @Override
    public void front() {
        System.out.println("Make front");
    }
}
