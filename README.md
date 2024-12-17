<h2> Algoritmo 03 - Pratica de algoritmos em Java </h2>

<h2> Sobre: </h2>

<p> O Algoritmo abaixo tem por finalidade fazer validação da entrada de tipos distintos de dados usando recursos condicionais tal como loops para atingir seu proposito que é fazer a coleta do nome do usuário, idade do usuário, salário do usuário, o genero do usuário e o estado civil do usuário. O algoritmo também uttiliza o recurso de funções para torna-lo mais modular que facilita a manutenção do código.</p>

<h2> Código: </h2>

```java 
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class App {

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
```

<h2> Analise: </h2>

- Nas primeiras linhas fizemos a importação de algumas funcionalidades que algumas classes possuem, por exemplo:
1) <b>Import java.ultil.InputMismatchException</b> 
<p> Responsavel para tratar erros de entrada do usuário quando usamos o recurso do <b>try-catch{}</b> que é usado para lidar com as exceções.

2) <b>import java.util.Scanner</b>
<p> Responsavel para tratar também dos dados de entrada, ou seja, coleta as informações que o usuário informa ao programa, ela utiliza-se da classe Scanner para esse tipo de finalidade.</p>

3) <b>import java.util.DecimalFormat</b>
<p> Responsável para formatar a saida dos dados que foram antes informados ao programa. ou seja, ele é responsável, por exemplo, para tratar da situação onde ha necessidade da saida mostrar as casas decimais que estão antes ou depois da virgula.

- Declaramos a classe principal do programa chamado <b>App</b>
- Declaramos o metoodo principal do programa chamado <b>main</b>
- Usamos, afim como uma demostração de entrada do programa, <b>Syste.out.println()</b> afim de imprimir alguns caracteres na apresentação.

- Criamos 2 objetos, um objeto chamado <b>scan</b> da classe Scanner para coleta dos dados do usuário e outro objeto chamado <b>df</b> responsável pela formatação da saida dos dados de tipo inteiro ou float.

- Declaramos 2 variaveis de tipo <b>String</b> uma chamada outputtUserName e outra chamada outputSexo, logo declaramos uma variavel de tipo <b>char</b> após declaramos uma variavel de tipo <b>inteiro</b> chamado outputUserIdade e por fim declaramos uma variavel de tipo <b>float</b>.
- Utilizamos a partir daqui algumas estruturas <b>try-catch{}</b> para tratar das possiveis exceções que podem surgir na entrada dos dados.
- Criamos dentro de cada estrutura <b>try-catch</b> chamadas de funções que irão tratar independentemente cada dado fornecido pelo usuário, por exemplo a variavel <b>outputUserName</b> receberá a chamada da função <b>validarNome(scan)</b>, perceba que nesse caso estamos passando como parametro o objeto scan, justamente aquele responsável para lidar com entrada de dados.

<h3>lista das funções do algoritmo:</h3>

a) validarName(scan)
b) validarIdade(scan)
c) validarSalario(scan)
d) validarSexo(scan)
e) validarEstadoCivil(scan)

- <b>validarNome(scan)</b> é a função responsável por tratar do tipo de dado String. No algoritmo fica claro que existe a solicitação do nome por parte do usuário, a variavel de tipo String chamada <b>inputUserName</b> é a que irá armazenar a entrada do nome, abaixo existe uma laço de repetição, um loop while:

```java
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
```
<p> perceba que a condição loop while estará avaliando o tamanho da string informada, ou seja, se o nome do usuário tiver menos que 3 letras (true), ele continuará a imprimir em tela o nome é incorreto, e apos irá solicitar novamente seu nome. Se caso o nome informado estiver acima dos 3 caracteres que compõem uma String a condição reconhecerá que é falsa, portanto, fara a quebra do looping while retornando o valor informado, ou seja, imprimindo o nome.</p>

- <b>validarIdade(scan)</b> é a função responsável por tratar a idade informada pelo usuário. A informação ficará armazenada na varivável <b>inputUserIdade</b> que é coletada pelo nosso objeto responsável por isso, scan. abaixo segue o trecho do codigo responsável por avaliar a idade do usuário:

```java
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
```
<p> Novamente estamos solicitando mais uma entrada do usuário, so que agora, estamos avaliando o dado de tipo inteiro. Na tela solicitamos a idade, ela é armazenada numa variavel local que criamos, no caso <b>inputUserIdade</b> que é coletada pelo nosso objeto scan. Abaixo observamos que novamente aparece um loop while avaliando uma condição verdadeira ou falsa. Nossa estrutura de repetição repetira indefinidamente enquanto inputUserIdade for menor que 0 OU inputUserIdade for maior que 150. Isso quer dizer que se a idade informada pelo usuário for abaixo de 0 ou acima de 150 ele irá informar que a idade esta incorreta, e novamente solicitará ela, caso a idade esteja dentro dos limites usados 0 ou 150, ele irá sair do looping While retornando a idade correta.</p>

- <b>validarSalario(scan)</b> é a função responsável para avaliar a entrada de dado referente a salario, no caso usamos o tipo de dado float, porque salario utiliza-se de virgula, então necessita de uma precisão maior para tratar esse tipo de dado. A função não distingue das demais senão so pelo seu tipo. Ela solicita a entrada de dado para usuário, uma varivael de tipo float chamada inputUserSalario é usada para armazenar esse valor coletado pelo objeto scan.

```java

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

```
<p> Novamente nos deparamos com uma estrutura de repetição while, nele, é avaliada a seguinte condição caso verdadeira, se salario menor que 0, ele informará que o valor é incorreto e novamente solicitará a entrada de algum valoor referente ao salario, portanto novamente a condição irá averiguar a validade, ou seja se é true ou false, caso true, o looping while encerra-se, retornando um valor valido por return inputUserSalario.</p>


- <b>validarSexo(scan)</b> é a função responsável por validar o sexo informado pelo usuário, e o tipo de dado utilizado é do tipo String. Utilizamos a varivavel inputUserSexo, e o seu valor é coletado pelo objeto scan.

```java
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
```
<p> Agora estamos novamente solicitado outra entrada, porem, apenas F ou M, essa informação é avaliada pelo looping while, na qual a condição avaliada caso verdadeira, novamente se repetirá, solicitando F ou M, caso falso, o looping while encerra-se.</p>


- <b>validarEstadoCivil(scan)</b> é a função responsável por avaliar a entrada do usuário em relação a seu estado civil, utlizando apenas caracteres. (C)asado - (S)olteiro - (V)iuvo - (D)ivorciado.

```java

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
```
<p> Estamos agora averiguando a entrada do tipo char, a informação ficará armazenada na variavel inputUserEstadoCivil, scan é o objeto utilizado para coleta da informação. Perceba que utlizamos também <b>toUpperCase()</b> argumento para transformar toda e qualquer informação com letra maiscula. Também usamos o argumento <b>charAt(0)</b>que fará a entrada ficar no index 0 evitando qualquer tpo de problema. O looping while recebe a condição que averigua qualquer divergencias em relação a qualquer um dos caracteres informados previamente que respresenta algum estado civil.</p>


<h2>Conclusão: </h2>

- Nesse algoritmo tentei ser um pouco mais sofisticado em relação ao algoritmo anterior, utilizei além dos loopings while as funções, afim de modularizar ainda mais o algortimo. Esse tipo de pratica é importante porque facilita a manutenção do programa por outros programadores. Cabe lembrar que usei bastante try-catchs mas foi por um motivo que acredito que seja valido, ja que estamos usando mais que um tipo de dado houve a necessidade de se precaver com os possiveis problemas que podem surgir em função disso. No geral o programa atinge seu propósito que é cadastrar e informar as informações cadastradas ao usuário.

<h2>Referências: </h2>

<h3>import java.util.InputMismatchException</h3>

[Consulta a documentação referência a bilbioteca] (https://docs.oracle.com/javase/8/docs/api/java/util/InputMismatchException.html)

<h3>import java.util.Scanner</h3>

[Consulta a documentação referencia a biblioteca]
 (https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)

<h3>import java.text.DecimalFormat</h3>

[Consulta a documentação referência a biblioteca]
 (https://docs.oracle.com/javase/8/docs/api/java/text/DecimalFormat.html)