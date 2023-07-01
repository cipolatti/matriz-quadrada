package com.cm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Informe o numero de linha/colunas da matriz quadrada,\nela será gerada com números aleatórios:\n");
        int numeroLinhasColunas = scanner.nextInt();

        var matriz = new Matriz();
        int[][] novaMatrizQuadrada = matriz.criar(numeroLinhasColunas);

        matriz.gerarDiagonaisInversas(novaMatrizQuadrada, numeroLinhasColunas);
    }
}
