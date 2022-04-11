package com.example.exemplo1.Modelos;

public class Questoes {

    public String mQuestoes[]={
            "\"__________ é um endereço de memória que proporciona um modo de acesso a uma variável sem referenciá-la, diretamente. Seu valor indica onde uma variável está armazenada, e não o que está armazenado.\" Qual das alternativas, a seguir, completa corretamente a lacuna?",
            "1. var 2. cont,n,resultado:inteiro 3. inicio 4. resultado <-1 5. leia(n) 6. para cont de 1 ate n passo 1 faca 7. resultado <- resultado *cont 8. fimpara 9. escreva(resultado) 10. fimalgoritmo\n" +
                    "Em relação à lógica do algoritmo precedente, caso o valor de n (linha 5) seja igual a",
            "Assinale a opção que apresenta o comando que tem a função de implementar desvios incondicionais no programa, mas que é de uso proibido na programação estruturada.",
            "Conforme as leis fundamentais da álgebra booleana, cada expressão ou identidade algébrica dedutível a partir dos postulados em uma álgebra booleana continua válida se todas as ocorrências dos operadores + e · e os elementos identidade 0 e 1 são trocados um pelo outro. O enunciado se refere ao",
            "Deseja-se chamar uma sub-rotina Quadrado, dentro de um programa principal, passando a ela um parâmetro x. Tal parâmetro conterá, como entrada, um certo valor inteiro e, como saída, receberá esse valor elevado ao quadrado.\n" +
                    "O tipo de passagem de parâmetro que permite que x seja um parâmetro tanto de entrada como também de saída da sub-rotina é denominado passagem de parâmetro",
            "As linguagens de programação, usualmente, provêm um conjunto fixo de tipos de dados embutidos, bem como facilidades para permitir a definição de tipos de dados pelo usuário. Assim, é correto afirmar, sobre lógica de programação, que os tipos de dados podem ser:",
            "Assinale a alternativa que apresenta o nome de uma estrutura que tem por objetivo tomar uma decisão de acordo com o resultado de apenas uma condição de um teste lógico, sendo que esta deve ser verdadeira para que o comando possa ser executado, já que, caso não seja verdadeiro o teste lógico, o comando não será executado.",
            "Se os primeiros cinco números de uma sequência são 0.5, 2, 8, 32, 128, conclui-se que",
    };
    public String Alternativas[] []={
            {"Bloco", "Booleano", "Ponteiro","TAD","Bool"},
            {"4, e o resultado sera 4", "3, e o resultado sera 5", "2, e o resultado sera 12","6, e o resultado sera 30","5, e o resultado sera 120"},
            {" IF-THEN-ELSE", "CASE", "GOTO","WHILE","REPEAT"},
            {"Princípio da Possibilidade.", "Princípio da Operação.", " Princípio da Identidade.","Princípio da Validade."," Princípio da Dualidade."},
            {"A ubíqua.", "ambígua.", " independente"," por referência.","por valor."},
            {" definidos e abstratos.", "elementares e estruturados.", "básicos e complexos."," inteiros e lógicos.","inteiros e lógicos.\n" +
                    "E instanciados ou alocados."},
            {"Desvio Condicional Composto.", "Desvio Encadeado.", "Desvio Condicional Complexo."," Desvio Condicional Simples.","Desvio com Condição Múltipla."},
            {" o próximo número é ímpar.", " não há uma lógica na geração dos números da sequência.", " o sétimo número é menor que 1000."," todos os expoentes são pares.","o sexto número é 512."},

    };
    private String cRespostas[]={"Ponteiro","5, e o resultado sera 120","GOTO"," Princípio da Dualidade."," por referência.","elementares e estruturados."," Desvio Condicional Simples.","o sexto número é 512."};

    public String getQuestoes(int a){
    String Questao= mQuestoes[a];
    return Questao;
    }
    public String getAlternativa1(int a){
        String  Alternativa= Alternativas[a][0];
        return Alternativa;
    }
    public String getAlternativa2(int a){
        String Alternativa=Alternativas[a][1];
        return Alternativa;
    }
    public String getAlternativa3(int a){
        String  Alternativa= Alternativas[a][2];
        return Alternativa;
    }
    public String getAlternativa4(int a){
        String  Alternativa= Alternativas[a][3];
        return Alternativa;
    }
    public String getAlternativa5(int a){
        String  Alternativa= Alternativas[a][4];
        return Alternativa;
    }

    public String getcRespostas (int a) {
      String Resposta =cRespostas[a];
      return Resposta;
}


}
