package com.cm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n");
        System.out.printf("Informe o numero de linha/colunas da matriz quadrada,\nela será gerada com números aleatórios: \n");
        int numeroLinhasColunas = scanner.nextInt();

        var matriz = new Matriz();
        int[][] novaMatrizQuadrada = matriz.criar(numeroLinhasColunas);

        matriz.gerarDiagonaisInversas(novaMatrizQuadrada, numeroLinhasColunas);

        System.out.printf("\n");
        System.out.println("Informe o numero de linhas/colunas de uma submatriz menor que " + numeroLinhasColunas + " da matriz principal: ");
        int numeroLinhasColunasSubmatriz = scanner.nextInt();
        System.out.println("Número de ocorrências da submatriz na matriz principal é de: "
                + matriz.verificarQuantasVezesEncontrada(novaMatrizQuadrada, numeroLinhasColunasSubmatriz));
    }
}