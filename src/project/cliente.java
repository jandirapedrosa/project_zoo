package project;

import java.util.Scanner;

public class cliente {

    /**
     * Método para o menu clientes
     */
    public static void menuCliente() {

        Scanner input = new Scanner(System.in);

        int opcaoCliente;

        do {
            System.out.println("*_*_*_*_*_* MENU CLIENTE *_*_*_*_*_*");
            System.out.println("1. Ver catálogo de animais por habitat");
            System.out.println("2. Ver atividades de um animal (espetáculos e alimentações");
            System.out.println("3. Simular apadrinhamento de um animal");
            System.out.println("4. Encontrar 'amigos de zoo'");
            System.out.println("5. Jogo: adivinha a espécie");
            System.out.println("0. Sair");

            System.out.println("Qual a sua opção: ");
            opcaoCliente = input.nextInt();


            switch (opcaoCliente) {

                case 1:
                    System.out.println("1. Ver catálogo de animais por habitat");
                    break;

                case 2:
                    System.out.println("2. Ver atividades de um animal (espetáculos e alimentações");
                    break;

                case 3:
                    System.out.println("3. Simular apadrinhamento de um animal");
                    break;

                case 4:
                    System.out.println("4. Encontrar 'amigos de zoo'");
                    break;

                case 0:
                    System.out.println("0. Sair");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;

            }

        } while (opcaoCliente != 0);


    }


    public static void main(String[] args) {

    }

}
