package com.carlospereira;

import com.carlospereira.classes.Carro;

public class Main {
    public static void main(String[] args) {
        Carro camaro = new Carro("Camaro", "Amarelo", 461, 350000);
        Carro fusca = new Carro("Fusca", "Azul", 800, 12000);
        
        System.out.println("Carros registrados:");
        System.out.println(camaro);
        System.out.println(fusca);
    }
}