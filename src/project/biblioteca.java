package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class biblioteca {

    /**
     * Método para contar quantas linhas tem um ficheiro
     * @param caminho
     * @return
     */
    public static int contarLinhasFicheiro(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contadorLinha = 0;

        while (sc.hasNextLine()) {
            contadorLinha++;
            sc.nextLine();
        }

        return contadorLinha;

    }

    /**
     * Método para fazer a matriz do conteúdo animais
     * @param caminho
     * @return
     * @throws FileNotFoundException
     */
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

    /**
     * Método para fazer a matriz do conteúdo clientes
     * @param caminhoCl
     * @return
     * @throws FileNotFoundException
     */
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
     * Método para fazer a matriz do conteúdo interações
     * @param caminhoInte
     * @return
     * @throws FileNotFoundException
     */
    public static String[][] ficheiroMatrizInteracoes(String caminhoInte) throws FileNotFoundException {

        // Declarar variáveis
        int lineAtual = 0;

        // Contar as linhas do ficheiro (usando a biblioteca)
        int contarLinhas = contarLinhasFicheiro(caminhoInte) - 1;

        // Criar a matriz
        String [][] matrizCompletaInteracoes = new String[contarLinhas][7];

        File ficheiroInteracoes = new File(caminhoInte);
        Scanner sc = new Scanner(ficheiroInteracoes);

        // Avançar o cabeçalho
        String linha = sc.nextLine();

        while (sc.hasNextLine()) {
            linha = sc.nextLine();
            String[] linhaSeparada = linha.split(";");

            for (int coluna =0; coluna < matrizCompletaInteracoes[0].length; coluna++) {
                matrizCompletaInteracoes[lineAtual][coluna] = linhaSeparada[coluna];
            }

            lineAtual++;
        }

        return matrizCompletaInteracoes;

    }

}
