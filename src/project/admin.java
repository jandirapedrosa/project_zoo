package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static project.biblioteca.contarLinhasFicheiro;

public class admin {

    public static String[][] ficheiroMatrizAnimais(String caminho) throws FileNotFoundException {

        // Declarar variável
        int linhaAtual = 0;

        // Contar as linhas do ficheiro (usar biblioteca)
        int contadorAnimais = contarLinhasFicheiro(caminho) - 1;

        // Criar a matriz à medida - AQUI ESTÁ ESTA MATRIZ
        String[][] matrizCompletaAnimal = new String[contadorAnimais][6];

        File ficheiroAnimais = new File(caminho);
        Scanner sc = new Scanner(ficheiroAnimais);

        // Avançar o cabeçalho
        String linha = sc.nextLine();

        while (sc.hasNextLine()) {
            linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            for (int coluna = 0; coluna < matrizCompletaAnimal[0].length; coluna++) {
                matrizCompletaAnimal[linhaAtual][coluna] = linhaSeparada[coluna];
            }

            linhaAtual++;
        }

        return matrizCompletaAnimal;
    }

    public static String[][] ficheiroMatrizClientes(String caminhoCl) throws FileNotFoundException {

        // Declarar variáveis
        int lineAtual = 0;

        // Contar as linhas do ficheiro (usando a biblioteca)
        int contarLinhas = contarLinhasFicheiro(caminhoCl) - 1;

        // Criar a matriz
        String [][] matrizCompletaClientes = new String[contarLinhas][4];

        File ficheiroClientes = new File(caminhoCl);
        Scanner sc = new Scanner(ficheiroClientes);

        // Avançar o cabeçalho
        String linha = sc.nextLine();

        while (sc.hasNextLine()) {
            linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            for (int coluna =0; coluna < matrizCompletaClientes[0].length; coluna++) {
                matrizCompletaClientes[lineAtual][coluna] = linhaSeparada[coluna];
            }

            lineAtual++;
        }

        return matrizCompletaClientes;

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


