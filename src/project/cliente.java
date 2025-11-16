package project;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static project.biblioteca.*;

public class cliente {

    /**
     * Método para o menu clientes
     */
    public static void menuCliente() throws FileNotFoundException {

        // Colocar e trazer para aqui as matriz
        String [][] matrizAnimais = ficheiroMatrizAnimais("ficheiros/animais.csv");
        String [][] matrizCliente = ficheiroMatrizClientes("ficheiros/clientes.csv");
        String [][] matrizInteracoes = ficheiroMatrizInteracoes("ficheiros/interacoes.csv");

        Scanner input = new Scanner(System.in);

        int opcaoCliente;

        do {
            System.out.println("*_*_*_*_*_* MENU CLIENTE *_*_*_*_*_*");
            System.out.println("1. Ver catálogo de animais por habitat");
            System.out.println("2. Ver atividades de um animal (espetáculos e alimentações");
            System.out.println("3. Simular apadrinhamento de um animal");
            System.out.println("4. Jogo: adivinha a espécie");
            System.out.println("0. Sair");

            System.out.println("Qual a sua opção: ");
            opcaoCliente = input.nextInt();
            input.nextLine();


            switch (opcaoCliente) {

                case 1:
                    System.out.println("1. Ver catálogo de animais por habitat");
                    catalogoPorHabitat(matrizAnimais);
                    break;

                case 2:
                    System.out.println("2. Ver atividades de um animal (espetáculos e alimentações");
                    System.out.print("Id do animal (ex: A01): ");
                    String id = input.nextLine();
                    // descobrir porque não está a funcionar
                    atividadesAnimal(id, matrizAnimais, matrizInteracoes);
                    break;

                case 3:
                    System.out.println("3. Simular apadrinhamento de um animal");
                    simularApadrinhamento(matrizAnimais);
                    break;

                case 4:
                    System.out.println("4. Jogo: adivinha a espécie");
                    jogoAdivinhaEspecie(matrizAnimais);
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


    public static void catalogoPorHabitat(String[][] animais) {

        // Listar habitats únicos
//        String[] habitats = new String[animais.length];
//        int contagem = 0;
//        String habitat;

//        for (int i = 0; i < animais.length; i++) {
//            habitat = animais[i][3];
//            boolean encontrado = false;
//
//            for (int j = 0; j < contagem; j++)
//                if (habitats[j].equals())
//        }

        // guardar habitats já listados
        String habitatsUsados = "";
        String habitatAtual;

        for (int i = 0; i < animais.length; i++) {

            habitatAtual = animais[i][3];

            // Verificar se imprimimos este habitat
            if (!(habitatsUsados.equals(habitatAtual))) {

                // marcar habitat como usado
                habitatsUsados += habitatAtual + ";";


                System.out.println("\n*** " + habitatAtual + " ***");

                // listar animais nesse habitat
                for (int j = 0; j < animais.length; j++) {
                    if (animais[j][3].equals(habitatAtual)) {
                        System.out.println("- " + animais[j][1] + " (" + animais[j][2] + ")");
                    }
                }
            }
        }
    }

    public static void atividadesAnimal(String id, String[][] animais, String[][] interacoes) {

//        Scanner input = new Scanner(System.in);
//        System.out.print("ID do animal (ex.: A01): ");
//        String id = input.next();

        boolean existe = false;
        String nome = "", especie = "";

        for (int i = 0; i < animais.length; i++) {
            if (animais[i][0].equals(id)) {
                existe = true;
                nome = animais[i][1];
                especie = animais[i][2];
            }
        }

        if (!existe) {
            System.out.println("Animal não encontrado.");
            return;
        }

        int espetaculos = 0;
        int alimentacoes = 0;

        System.out.println("\nAtividades do animal " + nome + " (" + especie + "):");

        System.out.println("\nESPETÁCULOS:");
        for (int i = 0; i < interacoes.length; i++) {
            if (interacoes[i][3].equals(id) && interacoes[i][2].equals("ESPETACULO")) {
                System.out.println("- " + interacoes[i][4]);
                espetaculos++;
            }
        }
        if (espetaculos == 0) System.out.println("Nenhum espetáculo.");

        System.out.println("\nALIMENTAÇÕES:");
        for (int i = 0; i < interacoes.length; i++) {
            if (interacoes[i][3].equals(id) && interacoes[i][2].equals("ALIMENTACAO")) {
                System.out.println("- " + interacoes[i][4]);
                alimentacoes++;
            }
        }
        if (alimentacoes == 0) System.out.println("Nenhuma alimentação.");
    }

    public static void simularApadrinhamento(String[][] animais) {

        Scanner input = new Scanner(System.in);

        System.out.print("Nome do cliente: ");
        String nomeCliente = input.nextLine();

        System.out.print("Email: ");
        String email = input.nextLine();

        System.out.print("ID do animal: ");
        String idAnimal = input.nextLine();

        String nomeAnimal = "", especie = "", habitat = "";
        boolean existe = false;

        for (int i = 0; i < animais.length; i++) {
            if (animais[i][0].equals(idAnimal)) {
                existe = true;
                nomeAnimal = animais[i][1];
                especie = animais[i][2];
                habitat = animais[i][3];
            }
        }

        if (!existe) {
            System.out.println("Animal não encontrado.");
            return;
        }

        System.out.print("Valor mensal (€): ");
        double valor = input.nextDouble();

        String plano;
        if (valor <= 25) plano = "Apadrinhamento Simples";
        else if (valor <= 50) plano = "Apadrinhamento Gold";
        else plano = "Apadrinhamento Diamond";

        System.out.println("\nResumo do Apadrinhamento:");
        System.out.println("Padrinho: " + nomeCliente + " (" + email + ")");
        System.out.println("Animal: " + nomeAnimal + " (" + especie + ") - " + habitat);
        System.out.println("Plano: " + plano);
        System.out.println("Valor: " + valor + " €/mês");
    }

    public static void jogoAdivinhaEspecie(String[][] animais) {

        Scanner input = new Scanner(System.in);

        int aleatorio = (int)(Math.random() * animais.length);
        String habitat = animais[aleatorio][3];
        String dieta = animais[aleatorio][4];
        String perigo = animais[aleatorio][5];
        String especie = animais[aleatorio][2];

        System.out.println("PISTA 1: Vive em " + habitat);
        System.out.println("PISTA 2: Dieta: " + dieta);
        System.out.println("PISTA 3: Perigo de extinção: " + perigo);

        int tentativas = 0;
        String resposta;

        do {
            System.out.print("Qual é a espécie? ");
            resposta = input.nextLine();
            tentativas++;

        } while (!resposta.equalsIgnoreCase(especie));

        System.out.println("Acertou! Número de tentativas: " + tentativas);
    }
//}

    public static void main(String[] args) throws FileNotFoundException {

        menuCliente();
    }

}
//}
