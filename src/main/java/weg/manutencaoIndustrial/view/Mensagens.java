package weg.manutencaoIndustrial.view;

public class Mensagens {

    public static void valorErradoNumero(){
        System.out.println("\u001b[31m┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\u001b[0m");
        System.out.println("\u001b[31m┃ Você digitou um valor incorreto, tente um número ┃\u001b[0m");
        System.out.print  ("\u001b[31m┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n:\u001b[0m");
    }

    public static void valorErradoString(){
        System.out.println("\u001b[31m┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\u001b[0m");
        System.out.println("\u001b[31m┃    O Campo está vazio! Digite alguma coisa!      ┃\u001b[0m");
        System.out.print  ("\u001b[31m┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n:\u001b[0m");
    }

    public static void OpcaoInvalida(){
        System.out.println("\u001b[31m┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\u001b[0m");
        System.out.println("\u001b[31m┃ Você digitou um opção inexistente,Tente Novamente ┃\u001b[0m");
        System.out.println("\u001b[31m┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\u001b[0m");
    }

    public static void Agradecimento(){
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ Obrigado por utilizar o nosso sistema, Até a próxima ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
}
