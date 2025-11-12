package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static project.biblioteca.contarLinhasFicheiro;
import static project.biblioteca.ficheiroMatrizAnimais;

public class admin {

    public static void validarAdmin(String userName, String password) {

        // Imporar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        String usernameCorreto = "admin";
        String palavrapasseCorreto = "code";
        String username, palavrapasse;

        System.out.print("Username: ");
        username = input.next();

        System.out.println("Palavra-passe: ");
        palavrapasse = input.next();

        // Validar

        do {

        if (username.equals(usernameCorreto) && palavrapasse.equals(palavrapasseCorreto)) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + username + ".");
        } else {
            System.out.println("Username ou palavra-passe incorretos.");
        }

        } while (username == usernameCorreto && palavrapasse == palavrapasseCorreto);


        input.close();

    }

    /**
     * Método para o menu Admin
     */
    public static void menuAdmin() throws FileNotFoundException {

        String [][] matrizAnimais = ficheiroMatrizAnimais("ficheiros/animais.csv");

        Scanner input = new Scanner(System.in);

        int opcaoAdmin;

        do {
            System.out.println("*_*_*_*_*_* MENU ADMIN *_*_*_*_*_*");
            System.out.println("1. Listar conteúdos dos ficheiros");
            System.out.println("2. Estatísticas gerais de interações");
            System.out.println("3. Receita total por tipo de interação");
            System.out.println("4. Animal mais popular");
            System.out.println("5. Top 3 espécies com mais apadrinhamentos");
            System.out.println("6. Listar padrinhos de um animal");
            System.out.println("7. Espetáculo mais rentável");
            System.out.println("8. Ranking de animais em perigo de extinção");
            System.out.println("9. Estatística por habitat");
            System.out.println("0. Sair");

            System.out.println("Qual a sua opção: ");
            opcaoAdmin = input.nextInt();


            switch (opcaoAdmin) {

                case 1:
                    System.out.println("1. Listar conteúdos dos ficheiros");
                    break;

                case 2:
                    System.out.println("2. Estatísticas gerais de interações");
                    break;

                case 3:
                    System.out.println("3. Receita total por tipo de interação");
                    break;

                case 4:
                    System.out.println("4. Animal mais popular");
                    break;

                case 5:
                    System.out.println("5. Top 3 espécies com mais apadrinhamentos");
                    break;

                case 6:
                    System.out.println("6. Listar padrinhos de um animal");
                    break;

                case 7:
                    System.out.println("7. Espetáculo mais rentável");
                    break;

                case 8:
                    System.out.println("8. Ranking de animais em perigo de extinção");
                    break;

                case 9:
                    System.out.println("9. Estatística por habitat");
                    break;

                case 0:
                    System.out.println("0. Sair");
                    break;

                default:
                    System.out.println("Opção inválida" + opcaoAdmin);
                    break;

            }

        } while (opcaoAdmin != 0);

    }


    public static void main(String[] args) throws FileNotFoundException {

        menuAdmin();
//        ficheiroMatrizAnimais("ficheiros/animais.csv");

    }
}


