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

}
