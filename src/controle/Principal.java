/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

/**
 *
 * @author apolo
 */
public class Principal {
    public static void main(String[] args) {
        boolean up = true;
        System.out.println("Teste java");
        for (int i = 0; i < 10; i++) {
            System.out.println("Execução " + i);
            System.out.println("\ngit config --global --list");
            if(up){
                System.out.println("Subiu o projeto");
            }else{
                System.out.println("Verificar o que houve");
                System.out.println("ERRADO");
            }
        }
    }
}
