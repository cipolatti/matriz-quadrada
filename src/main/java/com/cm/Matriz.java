package com.cm;

import java.util.ArrayList;
import java.util.Random;

public class Matriz {

    public int[][] criar(int numeroLinhasColunas){
        int i, j;
        int matrizQuadrada[][] = new int[numeroLinhasColunas][numeroLinhasColunas];
        Random gerador = new Random();
        for (i=0; i<numeroLinhasColunas; i++) {
            for (j=0; j<numeroLinhasColunas; j++) {
                matrizQuadrada[i][j] = gerador.nextInt(10);
            }
        }
        System.out.printf("\n");
        System.out.printf("Matriz gerada aleatóriamente");
        this.imprimir(matrizQuadrada, numeroLinhasColunas);
        return matrizQuadrada;
    }

    private void imprimir(int[][] novaMatrizQuadrada, int numeroLinhasColunas) {
        int i, j;
        System.out.printf("\n");
        for (i=0; i<numeroLinhasColunas; i++) {
            System.out.printf("%da. linha: ", (i+1));
            for (j=0; j<numeroLinhasColunas; j++) {
                System.out.printf("%d ", novaMatrizQuadrada[i][j]);
            }
            System.out.printf("\n");
        }
    }

    public void gerarDiagonaisInversas(int[][] novaMatrizQuadrada, int numeroLinhasColunas) {
        var listaDiagonalPrincipal = new ArrayList<Integer>();
        var listaDiagonalSecundaria = new ArrayList<Integer>();
        for (int i = 0; i < numeroLinhasColunas; i++) {
            int valor = novaMatrizQuadrada[i][i];
            listaDiagonalPrincipal.add(valor);
        }
        System.out.printf("\n");
        System.out.println("Diagonal principal = " + listaDiagonalPrincipal);

        for (int i = 0; i < numeroLinhasColunas; i++) {
            int valor = novaMatrizQuadrada[i][numeroLinhasColunas - 1 - i];
            listaDiagonalSecundaria.add(valor);
        }
        System.out.println("Diagonal Secundária = " + listaDiagonalSecundaria);

        int matrizQuadradaDiagonaisInvertidas[][] = new int[numeroLinhasColunas][numeroLinhasColunas];
        int contadorDeColunas = numeroLinhasColunas - 1;
        int posicaoNaListaSecudaria = 0;
        int posicaoNaListaPrincipal = 0;
        System.out.printf("\n");
        System.out.printf("Matriz com as diagonais invertidas");
        for (int i=0; i<numeroLinhasColunas; i++) {
            for (int j=0; j<numeroLinhasColunas; j++) {
               if(i==j){
                   matrizQuadradaDiagonaisInvertidas[i][j] = listaDiagonalSecundaria.get(posicaoNaListaSecudaria);
                   posicaoNaListaSecudaria++;
               } else {
                   matrizQuadradaDiagonaisInvertidas[i][j] = novaMatrizQuadrada[i][j];
               }
               if(j == contadorDeColunas) {
                   matrizQuadradaDiagonaisInvertidas[i][j] = listaDiagonalPrincipal.get(posicaoNaListaPrincipal);
                   contadorDeColunas--;
                   posicaoNaListaPrincipal++;
               }
            }
        }
        this.imprimir(matrizQuadradaDiagonaisInvertidas, numeroLinhasColunas);
    }

    public int verificarQuantasVezesEncontrada(int[][] matrizQuadradaPrincipal, int numeroLinhasColunasSubmatriz) {
        int submatrizQuadrada[][] = this.criar(numeroLinhasColunasSubmatriz);

        int count = 0;
        int sizeA = matrizQuadradaPrincipal.length;
        int sizeB = submatrizQuadrada.length;

        for (int i = 0; i <= sizeA - sizeB; i++) {
            for (int j = 0; j <= sizeA - sizeB; j++) {
                if (this.isSubmatriz(matrizQuadradaPrincipal, submatrizQuadrada, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isSubmatriz(int[][] matrizQuadradaPrincipal, int[][] submatrizQuadrada, int inicioLinha, int inicioColuna) {
        int tamanhoB = submatrizQuadrada.length;

        for (int i = 0; i < tamanhoB; i++) {
            for (int j = 0; j < tamanhoB; j++) {
                if (matrizQuadradaPrincipal[inicioLinha + i][inicioColuna + j] != submatrizQuadrada[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
