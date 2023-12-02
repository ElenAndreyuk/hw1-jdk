package ru.elena.developers;

public class Backender extends Developer implements Backendable{
    @Override
    public void back() {
        System.out.println("Make back");
    }
}
