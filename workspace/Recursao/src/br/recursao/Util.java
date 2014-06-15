/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.recursao;

public class Util {

    private String inverso;
    public int fatorial(int numero) {
        if (numero == 1) {
            return 1;
        }
        return numero * fatorial(numero - 1);
    }

    public int soma(int valor) {
        if (valor == 1) {
            return 1;
        } else {
            return valor + soma(valor - 1);
        }
    }
    
    public String imprimirInverso(int valor) {
        int valorInverso;
        if (valor < 10) {
            return String.valueOf(valor);
        } else {
            inverso = String.valueOf(valor % 10);
            valorInverso = valor /10;
            return inverso + imprimirInverso(valorInverso);
        }
    }
}