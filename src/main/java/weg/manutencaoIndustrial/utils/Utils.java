package weg.manutencaoIndustrial.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import static weg.manutencaoIndustrial.view.Mensagens.valorErrado;

public class Utils {

    static Scanner input = new Scanner(System.in);

    public static int inputNumero(){

        boolean valorValido = false;

        while(!valorValido){
            try{
                int numero = input.nextInt();
                valorValido = true;
            }catch(InputMismatchException error){
                valorErrado();
                input.nextLine();
            }
        }

        return 0;
    }

}
