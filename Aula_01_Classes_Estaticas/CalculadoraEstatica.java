import java.util.Scanner;

class Calculadora{
    //Método Operação SOMAR
    public static double somar(double a, double b){
        return a + b;
    }
    
    //Método Operação SUBTRAIR
    public static double subtrair(double a, double b){
        return a - b;
    }
    
    //Método Operação MULTIPLICAR
    public static double multiplicar(double a, double b){
        return a * b;
    }
    
    //Método Operação DIVIDIR
    public static double dividir(double a, double b){
        return a / b;
    }
}

public class CalculadoraEstatica {
    
    //instancia o teclado (Scanner)
    private static Scanner teclado = new Scanner(System.in);

    //Método para validar botões do menu
    private static int ler_int(int minimo, int maximo){
        int valor_lido;
        do{
            System.out.print("Digite um valor inteiro entre " + minimo + " e " + maximo + ": ");
            valor_lido = teclado.nextInt();
        }while (valor_lido < minimo || valor_lido > maximo);
        return valor_lido;
    }
    
    private static double ler_real(){
        double valor_lido = 0;
        System.out.print("Digite um valor real: ");
        valor_lido = teclado.nextDouble();
        return valor_lido;
    }
    
    private static double ler_real_dif_zero(){
        double valor_lido = 0;
        do{
            System.out.print("Digite um valor real diferente de 0: ");
            valor_lido = teclado.nextDouble();
        }while (valor_lido == 0);
        return valor_lido;
    }
    
    //Método para identificar operação
    private static void realizar_calculo(int operacao){
        double res = 0;
        
        switch (operacao){
        case 1: 
            res = Calculadora.somar(ler_real(), ler_real());
            break;
        case 2: 
            res = Calculadora.subtrair(ler_real(), ler_real());
            break;
        case 3: 
            res = Calculadora.multiplicar(ler_real(), ler_real());
            break;
        case 4:
            res = Calculadora.dividir(ler_real(), ler_real_dif_zero());
            break;
        }
        System.out.println("O resultado eh: " + res);
    }
    
    //Método do menu
    private static int menu(){
        System.out.println("\nOpções: ");
        System.out.println("1. Somar dois números");
        System.out.println("2. Subtrair dois números");
        System.out.println("3. Multiplicar dois números");
        System.out.println("4. Dividir dois números");
        System.out.println("0. Sair da aplicação");
        return ler_int(0,4);
    }
    
    //Ponto de entrada 'void Start'
    public static void main(String[] args) {
        System.out.println("Calculadora em Métodos Estáticos! :-)");
        
        boolean usuario_on = true;
        
        do{
           int opcao = menu();
           if (opcao != 0){
               realizar_calculo(opcao);
           }
           else{
               usuario_on = false;
           }
            
        }while(usuario_on);
        
        System.out.println("Saindo da aplicação");
    }
}