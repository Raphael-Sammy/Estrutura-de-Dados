package merg_sort_string;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortString {
    public static void main(String[] args) {

    // Solicita entrada ao usuario, lê, classifica e imprime a saída: Linha 10 ate 18
        Scanner leitor = new Scanner(System.in);
        System.out.print("\033[1;35mEntrada:\033[m ");
        String entrada = leitor.nextLine();

        String[] ordenadorDeStrings = ordenarStringPorTamanho(entrada);

        System.out.print("\033[1;35mSaída:\033[m ");
        System.out.println(String.join(" ", ordenadorDeStrings));
    }
    // Implementa o algoritmo Merge Sort para classificar uma matriz de ‘strings’: Linha 20 ate 33
    public static String[] mergeSort(String[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int mid = arr.length / 2;
        String[] esquerda = Arrays.copyOfRange(arr, 0, mid);
        String[] direita = Arrays.copyOfRange(arr, mid, arr.length);

        esquerda = mergeSort(esquerda);
        direita = mergeSort(direita);

        return merge(esquerda, direita);
    }
    // Mescla duas metades de uma matriz de ‘strings’ ordenadas por tamanho numa única matriz ordenada: Linha 35 ate 60
    public static String[] merge(String[] esquerda, String[] diteira) {
        int esquerdaLength = esquerda.length;
        int direitaLength = diteira.length;
        int totalLength = esquerdaLength + direitaLength;
        String[] resultado = new String[totalLength];

        int i = 0, j = 0, k = 0;

        while (i < esquerdaLength && j < direitaLength) {
            if (esquerda[i].length() > diteira[j].length()) {
                resultado[k++] = esquerda[i++];
            } else {
                resultado[k++] = diteira[j++];
            }
        }

        while (i < esquerdaLength) {
            resultado[k++] = esquerda[i++];
        }

        while (j < direitaLength) {
            resultado[k++] = diteira[j++];
        }

        return resultado;
    }
    //Método feito...Linha: 62 ate 65
    public static String[] ordenarStringPorTamanho(String input) {
        String[] stringArray = input.split(" ");
        return mergeSort(stringArray);
    }
}

