/*
01 - Considere uma academia de musculação que realiza um acompanhamento dos alunos matriculados.
Para cada aluno são armazenados o nome, idade, peso, altura, a quanto tempo treina (em meses),
o tipo de treino e o dia da matrícula.

Escreva um programa que contenha funções que permitam cadastrar um aluno (com o limite de 100 alunos),
atualizar o tempo de treino de todos os alunos que se matricularam em um determinado dia, consultar os
dados de um aluno (pesquisando pelo número), calcular o IMC de um aluno e atualizar o tipo de treino de
todos os alunos:

até 3 meses: iniciante,
4 e 6 meses: intermediário,
entre 7 meses e 1 ano: marombeiro junior,
entre 1 e 2 anos: marombeiro sênior,
acima de 2 anos: Arnold Schwarzenegger.
 */

import java.util.*;

public class Q01 {
    
    class marombeiro{
        String nome, tipoTreino, statusCadastro;
        double peso, altura, imc;
        int idade, tempo, dia;
    }

    public static void main(String[] args){

        marombeiro[] alunos = new marombeiro[100];
        int diames, choose;
        Scanner leia = new Scanner(System.in);

        System.out.print("Informe o dia do mês que estamos hoje:");
        diames = leia.nextInt();


        for(int i=0; i<100; i++){
            alunos[i].statusCadastro = "Sem";
        }

        System.out.print("Deseja consultar o cadastro de algum aluno previamente cadastrado?\nDigite 100 para não consultar nenhum e qualquer outro de 0 a 100 para consultar.\n");
        choose = leia.nextInt();
        while(choose != 100){
            int verificador = 0;

            System.out.print("Verificando se o aluno "+choose+" está cadastrado.\n");
            for (int i=choose; i<100; i++) {
                if (alunos[i].statusCadastro.equals("Sem")){
                    System.out.print("Não existem alunos cadastrados na posição " + i + "! Tente novamente mais tarde.");
                }else{
                    System.out.print("Aluno encontrado! Vamos fazer o display de todos os dados.");
                    verificador = 1;
                }
            }

            while(verificador == 1){
                for(int i=choose; i<100; i++){
                    System.out.print("\nNome do aluno "+i+": "+alunos[i].nome+".");
                    System.out.print("\nIdade do aluno "+i+": "+alunos[i].idade+" anos.");
                    System.out.print("\nPeso do aluno "+i+": "+alunos[i].nome+"kg.");
                    System.out.print("\nAltura do aluno "+i+": "+alunos[i].altura+"m.");
                    System.out.print("\nAltura do aluno "+i+": "+alunos[i].altura+"m.");
                    System.out.print("\nTempo de treino do aluno "+i+": "+alunos[i].tempo+".");
                    System.out.print("\nTipo de treino do aluno "+i+": "+alunos[i].tipoTreino+".");

                }

                char escolher;
                System.out.print("\nDeseja consultar outro aluno? Digite s para sim e n para não.");
                escolher = leia.next().charAt(0);
                if(escolher == 'n'){
                    verificador = 0;
                }else if(escolher=='s'){
                    System.out.print("\nEscolha outro aluno para consultar os dados.");
                    choose = leia.nextInt();
                }
            }
        }
        System.out.print("Você deseja cadastrar um aluno? Digite 1 para sim e 2 para não.");
        choose = leia.nextInt();

        while(choose == 1){

            System.out.print("Verificando cadastros.\n");
            for (int i=0; i<100; i++) {
                if (alunos[i].statusCadastro.equals("Sem")){
                    System.out.print("Posição " + i + " vaga! Vamos cadastrar seu aluno nessa posição.");
                    choose = i;
                    i = 100;
                }
            }

            for(int i=choose; i<alunos.length; i++){
                System.out.print("\nOlá, você está cadastrando o aluno "+i+"!");
                System.out.print("Escreva e aperte enter para os seguintes dados do aluno: \nNome; \nIdade;\nPeso (kg);\nAltura (m);\nDia do cadastro (apenas dia);\nTempo que treina (meses);\n");

                alunos[i].statusCadastro = "Cadastrado";
                alunos[i].nome = leia.nextLine();
                alunos[i].idade = leia.nextInt();
                alunos[i].peso = leia.nextDouble();
                alunos[i].altura = leia.nextDouble();
                alunos[i].dia = leia.nextInt();
                alunos[i].tempo = leia.nextInt();

                alunos[i].tempo = calcularTempo(alunos[i].dia, diames, alunos[i].tempo);
                alunos[i].imc = calculoImc(alunos[i].peso, alunos[i].altura);
                alunos[i].tipoTreino = tiparTreino(alunos[i].tempo);

                int escolha;
                System.out.print("Deseja cadastrar mais alunos?\n1 para SIM\n2 para NÃO.");
                escolha = leia.nextInt();

                if(escolha == 2) {
                    i=100;
                }
                else
                    System.out.print("\nCadastrando o próximo aluno.");

            }
        }
    }

    public static int calcularTempo(int diaCadastro, int diaMes, int mes){
        if(diaCadastro >= diaMes)
            mes++;
        return mes;
    }

    public static double calculoImc(double kg, double alt){
        double imc;
        imc = kg/(alt*alt);
        return imc;
    }

    public static String tiparTreino(int time){
        String tipTrain;
        if(time<=3)
            tipTrain = "Iniciante";
        else if(time<=6)
            tipTrain = "Intermediario";
        else if(time<=12)
            tipTrain = "Marombeiro junior";
        else if(time <= 24)
            tipTrain = "Marombeiro senior";
        else
            tipTrain = "Arnold Schwaznegger";
        return tipTrain;
    }
}
