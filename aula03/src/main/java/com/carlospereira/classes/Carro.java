package com.carlospereira.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Testando as anotações do Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    private String nome;
    private String cor;
    private int cavalos;
    private double valor;
}
