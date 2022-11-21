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

public class Q01{
    static class marombeiro{
        String nome, tipoTreino;
        double peso, altura, imc;
        int idade, tempo, dia;
        int statusCadastro;
    } //classe com dados dos frequentadores e status (para dizer se o cadastro já foi feito ou não)

    public static void main(String[] args){

        marombeiro[] alunos;
        alunos = new marombeiro[100];

        marombeiro[] alunosCadastro;
        alunosCadastro = new marombeiro[100];

        //linhas 31 e 32 - criando o primeiro vetor para cadastrar alunos
        //linhas 34 e 35 - criando o vetor que vai receber os alunos depois do cadastro

        for(int i=0; i<100; i++){
            alunos[i] = new marombeiro();
            alunosCadastro[i] = new marombeiro();
        }

        for(int i=0; i<100; i++){
            alunos[i].statusCadastro = 0;
            alunosCadastro[i].statusCadastro = 0;
        }

        // linhas 40 a 43 - instanciando o cadastro de todos
        // linhas 45 a 48 - definindo todos os cadastros como 0 (não feitos)

        int diames, choose, opcao, execucao=1;
        // diames = escolher dia do mês
        // choose = usado para procurar o aluno
        // opcao = usado para escolher se vai consultar dados ou criar cadastro

        Scanner leia = new Scanner(System.in);

        System.out.print("Bem-vindo ao programa da Academia TOPLINE!");
        System.out.print("\nInforme o dia do mês que estamos hoje: ");
        diames = leia.nextInt();

        while(execucao == 1){ //while feito para continuar ou não a execução do programa.
            System.out.print("\nDigite a opção 1 para CONSULTAR UM ALUNO.\nDigite a opção 2 para CADASTRAR UM ALUNO.\n");
            opcao = leia.nextInt();
            //seletor de opções. também pode ser feito usando char.

            if(opcao == 1){
                System.out.print("\tCONSULTA DE CADASTROS\nDigite algum número de 0 a 100 para consultar o cadastro: ");
                choose = leia.nextInt();
                ConsultarAluno(alunosCadastro, choose);
                //escolhe a posição do cadastro e aciona o método ConsultarAluno;
            }else if(opcao == 2)
                alunosCadastro = CadastrarAluno(alunos, diames);
            //serve para cadastrar novos alunos, informando dia do mês e colocando o vetor alunos

            alunos = alunosCadastro;
            // serve para atualizar a informações de cadastro, usado também para não sobrecarregar
            // o vetor alunos.

            System.out.print("Deseja cadastrar ou consultar outro aluno?\nSe sim, digite 1. Se não, digite 2.\n");
            execucao = leia.nextInt();
            //define a execução do programa.
        }
    }

    public static void ConsultarAluno(marombeiro[] lista, int escolha)
    { // método usado para consultar algum cadastro. recebe o vetor com dados dos alunos e
        // a posição escolhida para consultar.

        Scanner read = new Scanner(System.in);
        while(escolha != 100) {

            char escolher; // usado para continuar consultando alunos ou não, dependendo do que for inserido.
            int verificador = -1; // libera a ficha do aluno quando achar um cadastro.

            System.out.print("Verificando se o aluno " + escolha + " está cadastrado.\n");

            for (int i = escolha; i < 100; i++){ // for para verificar se o cadastro foi feito previamente.
                if (lista[i].statusCadastro == 0)
                { // se o statusCadastro for 0, significa que o aluno não foi cadastrado.
                    System.out.print("Não existe aluno cadastrado na posição " + i + "!");
                    System.out.print("\nDeseja consultar outro aluno? Digite s para sim e n para não: ");

                    escolher = read.next().charAt(0);
                    if (escolher == 'n') {
                        verificador = 0;
                        i = 100;
                    } else if (escolher == 's') {
                        System.out.print("\nEscolha outro aluno para consultar os dados.");
                        escolha = read.nextInt();
                    }

                    // da linha 106 até a 113, estamos vendo se o usuário vai querer
                    // verificar outro cadastro ou parar por ali mesmo.

                } else { // se não, significa que o aluno foi cadastrado com sucesso.
                    System.out.print("Aluno encontrado! Vamos fazer o display de todos os dados.");
                    verificador = 1;
                    i = 100;
                }
            }

            while(verificador == 1) { //faz o display de dados quando encontra um cadastro.
                for (int i = escolha; i < 100; i++) {
                    System.out.print("\nNome do aluno " + i + ": " + lista[i].nome + ".");
                    System.out.print("\nIdade do aluno " + i + ": " + lista[i].idade + " anos.");
                    System.out.print("\nPeso do aluno " + i + ": " + lista[i].peso + "kg.");
                    System.out.print("\nAltura do aluno " + i + ": " + lista[i].altura + "m.");
                    System.out.print("\nIMC do aluno " + i + ": " + lista[i].imc + "m.");
                    System.out.print("\nTempo de treino do aluno " + i + ": " + lista[i].tempo + ".");
                    System.out.print("\nTipo de treino do aluno " + i + ": " + lista[i].tipoTreino + ".");

                    System.out.print("\nDeseja consultar outro aluno? Digite s para sim e n para não: ");
                    escolher = read.next().charAt(0);
                    if (escolher == 'n') {
                        verificador = 0;
                        i = 100;
                        escolha = 100; // linhas 139 e 140 - não vai escolher nenhum aluno
                    } else if (escolher == 's') {
                        System.out.print("\nEscolha outro aluno para consultar os dados.");
                        escolha = read.nextInt();
                    }

                    //linhas 135 a 144 - verifica se o usuário quer fazer outra leitura de código.
                }
            }
        }
    }
    public static marombeiro[] CadastrarAluno(marombeiro[] list, int day){
        Scanner leitor = new Scanner(System.in);
        int escolha = 1; // verifica se o usuário vai querer cadastrar outro usuário após o cadastro
        // do primeiro.

        while (escolha == 1) {

            System.out.print("Verificando cadastros.\n");
            for (int i=0; i<100; i++) {
                if (list[i].statusCadastro == 0){
                    System.out.print("Posição " + i + " vaga! Vamos cadastrar seu aluno nessa posição.\n");
                    escolha = i;
                    i = 100;
                }
            }

            // linhas 158 a 165 - verifica qual posição pode ser cadastrada.

            for(int i=escolha; i<100; i++){
                System.out.print("Olá, você está cadastrando o aluno " + i + "!\n");
                System.out.print("Escreva e aperte enter para os seguintes dados do aluno: \nNome; \nIdade;\nPeso (kg);\nAltura (m);\nDia do cadastro (apenas dia);\nTempo que treina (meses);\n");

                list[i].statusCadastro = 1;
                list[i].nome = leitor.nextLine();
                list[i].idade = leitor.nextInt();
                list[i].peso = leitor.nextDouble();
                list[i].altura = leitor.nextDouble();
                list[i].dia = leitor.nextInt();
                list[i].tempo = leitor.nextInt();
                // recebe o tempo informado pelo usuário.

                list[i].tempo = calcularTempo(list[i].dia, day, list[i].tempo);
                // vai verificar se o tempo em meses foi atualizado com sucesso (orientação do Carlos).
                // usa o método calcularTempo.

                list[i].imc = calculoImc(list[i].peso, list[i].altura);
                // usa o método calculoImc para calcular o IMC do usuário, e vai atribuir o IMC exato
                // quando o cálculo for encerrado.

                list[i].tipoTreino = tiparTreino(list[i].tempo);
                // verifica qual treino vai ser dado para o aluno.

                System.out.print("Deseja cadastrar mais alunos?\n1 para SIM\n2 para NÃO.\n");
                escolha = leitor.nextInt();

                if (escolha == 2)
                    i = 100;
                else
                    System.out.print("\nCadastrando o próximo aluno.");

                // linhas 193 a 199 - verifica se o usuário deseja cadastrar mais alunos (ou não).
            }
        }
        return list;
        //envia a lista atualizada para o main (e para ser usada em outras verificações/cadastros).
    }

    public static int calcularTempo(int diaCadastro, int diaMes, int mes){
        if(diaMes >= diaCadastro)
            mes = mes+1;

        return mes;
    } // método usado para calcular se o tempo de treino dele aumentou ou não.
    // usa o dia informado no cadastro, o dia que estamos executando e quantos meses
    // o aluno tem de academia.

    public static double calculoImc(double kg, double alt){
        double imc;
        imc = kg/(alt*alt);
        return imc;
    } // método usado para calcular o IMC do aluno.
    // fórmula: peso * (altura^2)

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
    } // método usado para definir o treino, conforme enunciado da questão:
    // até 3 meses: iniciante,
    // 4 e 6 meses: intermediário,
    // entre 7 meses e 1 ano: marombeiro junior,
    // entre 1 e 2 anos: marombeiro sênior,
    // acima de 2 anos: Arnold Schwarzenegger.
}