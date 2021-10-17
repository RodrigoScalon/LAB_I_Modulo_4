//Autor: Rodrigo Mariano Scalon Fraga - Unisinos 2021/2 - Desafio módulo 4 - Laboratório I.
import java.util.ArrayList;
import java.util.Scanner;

public class TesteFun4Study {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        ArrayList<Cidade> city = new ArrayList<>();
        ArrayList<Estudante> student = new ArrayList<>();

// PARTE 1 - MENU DO USUÁRIO - PÁGINA CADASTRAL

        boolean cadastrando = true; // o programa ficará rodando equanto '0' não for inserido

        while (cadastrando) {

            System.out.println();
            System.out.println("***PÁGINA DE CADASTRO***");
            System.out.println("[1] - Novo Cadastro."); // cadastrar cidade e alunos
            System.out.println("[2] - Exibir Dados Cadastrados."); // output dos dados
            System.out.println("[3] - Alterar Senha (Painel do Administrador)."); // mudar a senha
            System.out.println("[4] - Alterar Dados Cadastrados (Painel do Administrador).");
            System.out.println("[0] - Sair do sistema."); // logout
            System.out.print("Entre com a opção desejada: ");
            String opcao = input.nextLine();

// PARTE 2 - SISTEMA CADASTRAL DE CIDADES E ALUNOS

            switch (opcao) {

                case "1": {

                    System.out.println();
                    System.out.println("*** CADASTRO DE CIDADE ***");
                    System.out.printf("Nome da Cidade: ");
                    String nomeCidade = input.nextLine();
                    System.out.printf("Descrição: ");
                    String descricao = input.nextLine();
                    System.out.printf("UF: ");
                    String uf = input.nextLine();
                    System.out.printf("Quantos estudantes serão cadastrados nesta cidade? "); // mínimo 4
                    int qtdeEstudantes = input.nextInt();

                    if (qtdeEstudantes <4) {
                    input.nextLine();
                    System.out.println("\tO mínimo de estudantes cadastrados por cidade é 4.");
                    break;
                    }

                    Cidade cid = new Cidade(nomeCidade, descricao, uf, qtdeEstudantes);
                    city.add(cid);
                    input.nextLine();

                    for (int i = 1; i <= qtdeEstudantes; i++) {

                        System.out.println("ESTUDANTE Nº" + i + ": ");
                        System.out.printf("Nome do Estudante: ");
                        String nome = input.nextLine();
                        System.out.printf("Data de nascimento: ");
                        String dtNascimento = input.nextLine();
                        System.out.printf("E-mail: ");
                        String email = input.nextLine();
                        System.out.printf("Crie a senha de primeiro acesso: ");
                        String senha = input.nextLine();

                        Estudante estudante = new Estudante(nome, dtNascimento, email, senha, cid);
                        student.add(estudante);
                    }

                    break;
                }

// PARTE 3 - OUTPUT DOS DADOS CADASTRADOS PELO USUÁRIO

                case "2": {

                    System.out.println();
                    System.out.println("== CIDADES CADASTRADAS ==");

                    for (int i = 0; i < city.size(); i++) {
                        Cidade c = city.get(i);
                        System.out.println("CIDADE Nº " + i + "|");
                        c.exibeDadosCidade(); // parametro dos dados da cidade
                    }

                    System.out.println();
                    System.out.println("== ESTUDANTES CADASTRADOS ==");

                    for (int i = 0; i < student.size(); i++) {
                        Estudante e = student.get(i);
                        System.out.println("ESTUDANTE Nº " + i + "|");
                        e.exibeDadosEstudante(); // parametro dos dados dos alunos cadastrados em uma cidade
                    }
                    break;
                }

// PARTE 4 - ALTERAÇÃO DE SENHA

                case "3": { // para ter acesso a alteração de senha e cadastro o usuário primeiro deverá
                            // efetuar o login.
                    System.out.println();
                    System.out.println("== ADMINISTRADOR ==");
                    System.out.println("Digite o NOME e a SENHA de algum estudante já cadastrado para ter acesso: ");
                    System.out.print("Nome Estudante: ");
                    String nome = input.nextLine();
                    System.out.printf("Senha Cadastrada: ");
                    String senha = input.nextLine();

                    boolean senhaSucesso = false;

                    for (Estudante e : student) { // este for percorre a lista de todos os estudantes cadastrados
                        e.getNome(); // pega o nome
                        e.getSenha(); // pega a senha

                        boolean nomeConfere = nome.equals(e.getNome()); // confere se o nome digitado é igual ao
                                                                        // armazenado
                        boolean senhaConfere = senha.equals(e.getSenha()); // o mesmo com a senha

                        if (nomeConfere && senhaConfere) { // se o nome e senha forem identicos = true
                            senhaSucesso = true;
                            break;
                        }
                    }

                    if (!senhaSucesso) { // se algum dado for diferente volta ao menu. Não achei legal usar o while
                                         // aqui.
                        System.out.println("\tDado incorreto. Retornando ao menu por segurança......");
                        break;
                    } else {
                        System.out.println("\t>>>Acesso permitido<<<");

                    }

                    System.out.println();
                    System.out.println("== ESTUDANTES CADASTRADOS ==");

                    for (int i = 0; i < student.size(); i++) { // lista todos os estudantes cadastrados

                        Estudante e = student.get(i);
                        System.out.println(" (" + i + ") " + e.getNome()); // mostra a opção de qual estudante terá a
                                                                           // senha alterada
                    }

                    System.out.println();
                    System.out.println("== ALTERAÇÃO DE SENHA ==");
                    System.out.printf("Qual o número do estudante que terá a senha alterada: ");
                    int posicao = input.nextInt();
                    input.nextLine();

                    System.out.printf("Digite a nova senha: ");
                    String novaSenha = input.nextLine();
                    System.out.print("Confirme a sua nova senha: ");
                    String senhaN = input.nextLine();
                    System.out.println();

                    while (!senhaN.equals(novaSenha)) { // se forem diferentes, retorna o loop.
                        System.out.print("Senha não confere! Digite novamente: ");
                        senhaN = input.nextLine();
                    }

                    if (senhaN.equals(novaSenha)) {
                        System.out.println("\tSenha atualizada!");
                    }

                    Estudante e = student.get(posicao);
                    e.setSenha(novaSenha); // senha é trocada no array

                    break;

                }

// PARTE 5 - ALTERAÇÃO DE DADOS

                case "4": {

                    System.out.println();
                    System.out.println("== ALTERAÇÃO DE DADOS =="); // nome, data nascimento e e-mail

                    for (Estudante e : student) {
                        e.getNome(); // pega o nome
                    }

                    for (int i = 0; i < student.size(); i++) { // lista todos os estudantes cadastrados

                        Estudante e = student.get(i);
                        System.out.println(" (" + i + ") " + e.getNome()); // mostra a opção de qual estudante terá a
                                                                           // senha alterada
                    }
                    System.out.println();
                    System.out.printf("Selecione o número do estudante para alteração: ");
                    int posicao = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    System.out.println(
                    "Qual atributo deseja alterar: [1] Nome; [2] Data Nascimento; [3] E-mail; [4] Sair.");
                    System.out.printf("Entre com o código: ");
                    Integer codigo = input.nextInt();
                    input.nextLine();

                    Estudante e = student.get(posicao);

                    while (codigo != 4) {

                        if (codigo == 1) {
                            System.out.printf("Digite o novo nome: ");
                            String novoNome = input.nextLine();
                            e.setNome(novoNome);
                            System.out.println("\tNome atualizado!");
                            break;
                        } else if (codigo == 2) {
                            System.out.printf("Digite a nova data de nascimento: ");
                            String novaDataNascimento = input.nextLine();
                            e.setDtNascimento(novaDataNascimento);
                            System.out.println("\tData de Nascimento atualizada!");
                            break;
                        } else if (codigo == 3) {
                            System.out.printf("Digite o novo e-mail: ");
                            String novoEmail = input.nextLine();
                            e.setEmail(novoEmail);
                            System.out.println("\tE-mail atualizado!");
                            break;
                        }
                        codigo = input.nextInt(); // necessário para não permanecer no loop infinito
                    }
                    break;
                }

// PARTE 6 - FIM DO PROGRAMA

                case "0": {

                    cadastrando = false; // sai do laço de repetição quando "0" for inserido
                    System.out.println("\tPrograma encerrado pelo usuário!");
                }
            }
        }

        input.close();
    }

}
