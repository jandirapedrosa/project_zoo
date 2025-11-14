package project;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static project.biblioteca.*;

public class admin {

    /**
     * Método para validar o utilizador admin
     * @param userName
     * @param password
     */
    public static void validarAdmin(String userName, String password) {

        // Imporar o Scanner
        Scanner input = new Scanner(System.in);

        // Declarar variáveis
        String usernameCorreto = "admin";
        String palavrapasseCorreto = "code";
        String username, palavrapasse;
        boolean valido = false;

        // Pedir ao utilizador e repetir até acertar
        while (!valido) {

            System.out.print("USERNAME: ");
            username = input.next();

            System.out.println("PASSWORD: ");
            palavrapasse = input.next();

            // Aqui validar
            if (username.equals(usernameCorreto) && palavrapasse.equals(palavrapasseCorreto)) {
                System.out.println("\nLogin bem-sucedido! Bem vindo" + username + ".");
                valido = true;
            } else {
                System.out.println("\nUsername ou password incorretos. Tente novamente.\n");
            }
        }
    }

    /**
     * Método para o menu Admin
     */
    public static void menuAdmin() throws FileNotFoundException {

        // Colocar e trazer para aqui as matriz
        String [][] matrizAnimais = ficheiroMatrizAnimais("ficheiros/animais.csv");
        String [][] matrizCliente = ficheiroMatrizClientes("ficheiros/clientes.csv");
        String [][] matrizInteracoes = ficheiroMatrizInteracoes("ficheiros/interacoes.csv");

        // Pedir input ao utilizador
        Scanner input = new Scanner(System.in);

        // Declarar as variáveis
        int opcaoAdmin;
        int fichListarConteudo;

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
                    System.out.println("1 - Animais");
                    System.out.println("2 - Clientes");
                    System.out.println("3 - Interações");
                    fichListarConteudo = input.nextInt();

                    if (fichListarConteudo == 1) {
                        listarConteudos(ficheiroMatrizAnimais("animais.csv"));
                    } else if (fichListarConteudo == 2) {
                        listarConteudos(ficheiroMatrizClientes("clientes.csv"));
                    } else if (fichListarConteudo == 3) {
                        listarConteudos(ficheiroMatrizInteracoes("interacoes.csv"));
                    }
//                    break;

                case 2:
                    System.out.println("2. Estatísticas gerais de interações");
                    estatisticasGeraisInteracoes(ficheiroMatrizInteracoes("interacoes.csv"));
//                    break;

                case 3:
                    System.out.println("3. Receita total por tipo de interação");
                    break;

                case 4:
                    System.out.println("4. Animal mais popular");
                    animalPopular(matrizAnimais, matrizInteracoes);
//                    break;

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

    public static void listarConteudos(String[][] matriz) {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + ";");
            }
            System.out.println();
        }

    }

    public static void estatisticasGeraisInteracoes(String[][] matrizInteracoes) {

        // Declarar as variáveis
        int visita = 0, espetaculo = 0, alimentacao = 0, apadrinha = 0;
        int total = matrizInteracoes.length;
        String tipoInteracao;

        // exer09 do prof - pesquisarGenero
        for (int i = 0; i < matrizInteracoes.length; i++) {
            tipoInteracao = matrizInteracoes[i][2];

            switch (tipoInteracao) {
                case "visita": visita++;
                case "espetaculo": espetaculo++;
                case "alimentacao": alimentacao++;
                case "apadrinhamento": apadrinha++;
            }

        }

        System.out.println("Total de interações: " + total);
        System.out.println("VISITA: " + visita);
        System.out.println("ESPETACULO: " + espetaculo);
        System.out.println("ALIMENTAÇÃO : " + alimentacao);
        System.out.println("APADRINHAMENTO: " + apadrinha);

    }

    public static void receitaTotal(String[][] interacoes) {

        // Declarar as variáveis
//        double visita = 0, espetaculo = 0, alimentacao = 0, apadrinha = 0;
//        String tipo;

//
//        for (int i = 0; i < interacoes.length; i++) {


//        }

    }

    public static void animalPopular(String[][] animais, String[][] interacoes) {

        // Declarar variáveis
        int [] contagem = new int[animais.length];
        String idAnimal;

        // Contar interações por animal
        for (int i = 0; i < interacoes.length; i++) {
            idAnimal = interacoes[i][3];

            for (int j = 0; j < animais.length; i++) {

                if (animais[j][0] == idAnimal) {
                    contagem[j]++;
                }
            }
        }

        // Declarar variável guardar o vetor contagem
        int totalVetor = 0;

        for (int i = 1; i < contagem.length; i++) {

            if (contagem[i] > contagem[totalVetor]) {
                totalVetor = i;
            }
        }

//        System.out.println("Animal mais popular: ");
        System.out.println("Nome: " + animais[totalVetor][1]);
        System.out.println("Espécie: " + animais[totalVetor][2]);
        System.out.println("Habitat: " + animais[totalVetor][3]);
        System.out.println("Interações: " + contagem[totalVetor]);





    }


    public static void main(String[] args) throws FileNotFoundException {

        menuAdmin();
//        ficheiroMatrizInteracoes("interacoes.csv");



    }
}


