/*
 *  Programa para validar campos usando como recurso laços de repetições como opção.
 *  (1) - Função para averiguar a entrada do nome do usuário.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class App {

   // - (1)
   public static String validarNome(Scanner scan) {

    System.out.println("Insira seu nome: ");
    String inputUserName = scan.next();

    while(inputUserName.length() <= 3) {
       
        System.out.println("( - ) Nome incorreto: ");
        System.out.println("Insira novamente seu nome: ");
        inputUserName = scan.next();  
    }
    return inputUserName;
   }   

    public static int validarIdade(Scanner scan) {

      System.out.println("( - ) Insira sua idade: ");
      int inputUserIdade = scan.nextInt();

      while(inputUserIdade < 0 || inputUserIdade > 150) {

        System.out.println("-> Idade incorreta: ");
        System.out.println("Insira novamente sua idade: ");
        inputUserIdade = scan.nextInt();
     }
      return inputUserIdade;
    }

    public static float validarSalario(Scanner scan) {

        System.out.println("( - ) Insira seu Salario: ");
        float inputUserSalario = scan.nextFloat();

        while(inputUserSalario < 0) {
            
            System.out.println("(-) ... Idade incorreta.");
            System.out.println("Insira novamente seu salario: ");
            inputUserSalario = scan.nextFloat();
        }
        return inputUserSalario;
    } 

    public static String validarSexo(Scanner scan) {
    
        System.out.println("( - ) Insira seu sexo F ou M: ");
        String inputUserSexo = scan.next();

        while(!inputUserSexo.equalsIgnoreCase("m") && !inputUserSexo.equalsIgnoreCase("f")) {
            
            System.out.println("( - ) ... Sexo incorreto");
            System.out.println("Insira novamente seu sexo: Masculino (m) ou Feminino (f)");
            inputUserSexo = scan.next();
        }
        return inputUserSexo;
    }

    public static char validaEstadoCivil(Scanner scan) {

        System.out.println("( - ) Insira seu estado civil -> C (Casado) | S (Solteiro) | V (Viúvo) | D (Divorciado)");
        char inputUserEstadoCivil = scan.next().toUpperCase().charAt(0);

        while(inputUserEstadoCivil != 'C' && inputUserEstadoCivil != 'S' && inputUserEstadoCivil != 'V' && inputUserEstadoCivil != 'D' ) {

            System.out.println("( - ) ...estado civil incorreto");
            System.out.println("Insira novoamente seu estado civil: C ou S ou V ou D");
            inputUserEstadoCivil = scan.next().toUpperCase().charAt(0);
        } 
        return inputUserEstadoCivil;
    } 
    public static void main(String[] args) throws Exception {

        System.out.println("****************************");
        System.out.println("*     Validando Campos     *");
        System.out.println("****************************");
 
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");
       
        String outputUserName;
        String outputSexo; 
        char outputEstadoCivil; 
        int outputUserIdade = 0;
        float outputUserSalario = 0.0f;
        
        try {
             outputUserName = validarNome(scan);
        
        } catch (InputMismatchException e) {
            System.out.println("Error: ... Tipo de dado invalido.");
            return;
        }
   
        try {
            outputUserIdade = validarIdade(scan);
        
        } catch (InputMismatchException e) {
            System.out.println("Error: .... Tipo de dado para idade incorreto");
            return;
        }
      
        try {
            outputUserSalario = validarSalario(scan);
        
        } catch (InputMismatchException e) {
            System.out.println("Error ... tipo de dado invalido");
            return;
        }        
        
        try {
           outputSexo = validarSexo(scan);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: ... tipo de dado invalido");    
            return;
        }
       
        try {
            
           outputEstadoCivil = validaEstadoCivil(scan);

        } catch (InputMismatchException e) {
            System.out.println("Error ... tipo de dado invalido"); 
            return;
        }
        
        System.out.println("*****************************************************");
        System.out.println(); 
        System.out.println("-> Seu Nome é: " + outputUserName + "\n" + 
        "-> Sua idade é: " + outputUserIdade + "\n" + 
        "-> Seu salario: " + df.format(outputUserSalario) + "\n" + 
        "-> Seu sexo é: " + outputSexo + "\n" +
        "-> Seu estado civil é: " + outputEstadoCivil);
        
        scan.close();
    }
}
