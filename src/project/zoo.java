package project;

import java.util.Scanner;


public class zoo {

    /**
     * Método para menu principal
     */
    public static void menuPrincipal() {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("*_*_*_*_*_*_ HOME *_*_*_*_*_*_");
            System.out.println("Tipo de utilizador: ADMIN || CLIENTE || SAIR ");
            System.out.println();
            System.out.println("1. Admin");
            System.out.println("2. Cliente");
            System.out.println("0. Sair");


            opcao = input.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Menu admin");
                    break;

                case 2:
                    System.out.println("Menu cliente");
                    break;

                case 0:
                    System.out.println("Sair");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;

            }

        } while (opcao != 0);

    }



    public static void main(String[] args) {
        menuPrincipal();
    }
}
