package weg.manutencaoIndustrial.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import static weg.manutencaoIndustrial.view.Mensagens.*;

public class Utils {

    static Scanner input = new Scanner(System.in);

    public static int inputNumber(){

        boolean valorValido = false;
        int numero = 0;

        while(!valorValido){
            try{
                numero = input.nextInt();
                valorValido = true;
            }catch(InputMismatchException error){
                valorErradoNumero();
                input.nextLine();
            }
        }
        input.nextLine();
        return numero;
    }

    public static String inputString(){

        boolean valorValido = false;
        String string = "";
        while(!valorValido){
            try{
                string = input.nextLine();
                if(string.isEmpty()){
                    valorErradoString();
                }
                else{
                    valorValido = true;
                }
            } catch(InputMismatchException error){
                valorErradoString();
            }
        }
        return string;
    }

    public static void main(String[] args) {
        inputString();
    }
}
