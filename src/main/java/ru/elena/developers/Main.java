package ru.elena.developers;
/*
– Описать команду разработчиков. В команде разработчиков могут находиться бэкендеры,
которые в состоянии писать серверный код, фронтендеры, которые могут программировать экранные формы,
 и фуллстэк разработчики, совмещающие в себе обе компетенции.
Реализовать класс фулстэк разработчика, создать экземпляр и последовательно вызвать
все его методы.
 */
public class Main {
    public static void main(String[] args) {
        Developer developer = new Frontender();
        if(developer instanceof Frontendable){
            ((Frontendable) developer).front();
        }
        Developer developer2 = new Fullstack();
        if(developer2 instanceof Frontendable){
            ((Frontendable) developer2).front();
        }
        Developer developer3 = new Backender();
        if(developer3 instanceof Frontendable){
            ((Frontendable) developer3).front();
        }
    }
}
