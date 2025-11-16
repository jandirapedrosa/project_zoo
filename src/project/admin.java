package project;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static project.biblioteca.*;

public class admin {

    /**
     * Método para validar o utilizador admin
     *
     * @return
     *
     */
    public static boolean validarAdmin() {

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
        return valido;
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
//            opcaoAdmin = input.nextInt();
            while (!input.hasNextInt()) {
                System.out.println("Qual a sua opção?: ");
                input.nextLine(); // para descartar o texto inválido
            }

            opcaoAdmin = input.nextInt();
            input.nextLine();


            switch (opcaoAdmin) {

                case 1:
                    System.out.println("1. Listar conteúdos dos ficheiros");
                    System.out.println("1 - Animais");
                    System.out.println("2 - Clientes");
                    System.out.println("3 - Interações");
//                    fichListarConteudo = input.nextInt();
                    while (!input.hasNextInt()) {
                        System.out.println("Qual a sua opção?: ");
                        input.nextLine(); // para descartar o texto inválido
                    }

                    fichListarConteudo = input.nextInt();
                    input.nextLine();

                    if (fichListarConteudo == 1) {
                        listarConteudos(ficheiroMatrizAnimais("ficheiros/animais.csv"));
                    } else if (fichListarConteudo == 2) {
                        listarConteudos(ficheiroMatrizClientes("ficheiros/clientes.csv"));
                    } else if (fichListarConteudo == 3) {
                        listarConteudos(ficheiroMatrizInteracoes("ficheiros/interacoes.csv"));
                    }
                    break;

                case 2:
                    System.out.println("2. Estatísticas gerais de interações");
                    estatisticasGeraisInteracoes(ficheiroMatrizInteracoes("ficheiros/interacoes.csv"));
                    break;

                case 3:
                    System.out.println("3. Receita total por tipo de interação");
                    receitaTotalPorTipo(matrizInteracoes);
                    break;

                case 4:
                    System.out.println("4. Animal mais popular");
                    animalPopular(matrizAnimais, matrizInteracoes);
//                    break;

                case 5:
                    System.out.println("5. Top 3 espécies com mais apadrinhamentos");
                    //AINDA NÃO FIZ ESTE
                    break;

                case 6:
                    System.out.println("6. Listar padrinhos de um animal");
                    System.out.print("ID do animal (ex: A01): ");
                    String id = input.nextLine();
                    // AINDA NÃO FIZ ESTE TBM
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

    public static void estatisticasGeraisInteracoes(String[][] interacoes) {

        // Declarar as variáveis
        int visita = 0, espetaculo = 0, alimentacao = 0, apadrinha = 0;
        int total = interacoes.length;
        String tipoInteracao;

        // exer09 do prof - pesquisarGenero
        for (int i = 0; i < interacoes.length; i++) {
            tipoInteracao = interacoes[i][2];

            switch (tipoInteracao) {
                case "visita":
                    visita++;
                    break;
                case "espetaculo":
                    espetaculo++;
                    break;
                case "alimentacao":
                    alimentacao++;
                    break;
                case "apadrinhamento":
                    apadrinha++;
                    break;
            }

        }

        System.out.println("Total de interações: " + total);
        System.out.println("visita: " + visita);
        System.out.println("espetaculo: " + espetaculo);
        System.out.println("alimentacao : " + alimentacao);
        System.out.println("apadrinhamento: " + apadrinha);

    }

    public static void receitaTotalPorTipo(String[][] interacoes) {

        // Declarar as variáveis
        double rVisita = 0, rEspetaculo = 0, rAlimentacao = 0, rApadrinha = 0;
        String tipo;
        double valor, total;

        for (int i = 0; i < interacoes.length; i++) {
            tipo = interacoes[i][2];
            valor = Double.parseDouble(interacoes[i][5]);

            switch (tipo) {
                case "visita":
                    rVisita += valor;
                    break;
                case "espetaculo":
                    rEspetaculo += valor;
                    break;
                case "alimentacao":
                    rAlimentacao += valor;
                    break;
                case "apadrinhamento":
                    rApadrinha += valor;
                    break;
            }
        }

        total = rVisita + rEspetaculo + rAlimentacao + rApadrinha;

        System.out.println("Receita visita: " + rVisita);
        System.out.println("Receita espetaculo: " + rEspetaculo);
        System.out.println("Receita alimentacao : " + rAlimentacao);
        System.out.println("Receita apadrinhamento: " + rApadrinha);
        System.out.println("Receita total: " + total);

    }

    public static void animalPopular(String[][] animais, String[][] interacoes) {

        // Declarar variáveis
        int [] contagem = new int[animais.length];
        String idInteracoes;

        // Contar interações por animal
        for (int i = 0; i < interacoes.length; i++) {
            idInteracoes = interacoes[i][3];

            for (int j = 0; j < animais.length; j++) {

                if (animais[j][0].equals(idInteracoes)) {
                    contagem[j]++;
                }
            }
        }

        // Declarar variável guardar o vetor contagem
        int totalVetor = 0;

        for (int i = 1; i < contagem.length; i++) {

            if (contagem[i] > contagem[totalVetor]) totalVetor = i;
//            if (contagem[i] > contagem[totalVetor]) {
//                totalVetor = i;
//            }
        }

        System.out.println("Animal mais popular: ");
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


