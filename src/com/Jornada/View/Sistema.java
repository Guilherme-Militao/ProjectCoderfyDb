package com.Jornada.View;

import com.Jornada.Entity.Usuario;
import com.Jornada.Services.UsuarioServices;

import java.util.Date;
import java.util.Scanner;

public class Sistema {


    public static void main(String[] args) {

        UsuarioServices usuarioServices = new UsuarioServices();

        Scanner scanner = new Scanner(System.in);

        //TELA DE MENU INICIAL
        System.out.println("*** BEM-VINDO AO CODEFY ***");
        System.out.println("Entre ou crie uma conta!\n");
        int opcao=0;
        while (opcao!= 3){

            System.out.println("O que deseja fazer? Escolha uma das opções abaixo:");
            System.out.println("""
                        1-Criar conta
                        2-Entrar em uma conta existente
                        3-sair""");
            opcao = Integer.parseInt(scanner.nextLine()); //variável que recebe a opção escolhida pelo usuário
            switch (opcao) { //switch case para executar a opção escolhida no menu
                case 1 -> { //cria um conta no app Codfy

                    Usuario user = new Usuario();

                    System.out.println("Digite seu nome: ");
                    user.setNome(scanner.nextLine());

                    System.out.println("Dgite seu email: ");
                    user.setEmail(scanner.nextLine());

                    System.out.println("Dgite sua senha: ");
                    user.setSenha(scanner.nextLine());

                    user.setDataRegistro(new Date());

                    try {
                         Usuario userSalvo = usuarioServices.CadastrarUsuario(user);
                        System.out.println("Usuario cadastrado com sucesso! com id = "+userSalvo.getId_usuario());

                    }catch (Exception e){
                        System.err.println(e.getMessage());
                    }
                }
                case 2 -> { //Entra em uma conta que já tenha sido cadastrada
                    //VALICAÇÃO DA CONTA DO USUÁRIO

                    Usuario user = new Usuario();



                    //TELA DE MENU DO USUÁRIO LOGADO
                    try{ //tratamento de exeção IndexOutOfBoundsException, pois caso o id passado (que equeivale ao indice) esteja fora do limite da lista o programa não será interrompido
                        if(1 == 1){
                            int op = 0;
                            while (op != 7) {
                                System.out.println("Vamos lá! assine nosso plano e seja premium ou crie sua playlist");
                                System.out.println("""
                                            1- Atualizar dados do usuário
                                            2- Excluir usuário
                                            3- Exibir informações do usuário
                                            4- Criar playlist
                                            5- Excluir playlist
                                            6- Buscar música
                                            7- sair""");
                                op = Integer.parseInt(scanner.nextLine());
                                switch (op) {
                                    case 1 -> { //Atualizar dados do usuário

                                    }
                                    case 2 -> { //Excluir usuário

                                    }
                                    case 3 -> { //Exibir informações do usuário

                                    }
                                    case 4 -> { //Criar playlist


                                    }
                                    case 5->{ //Excluir playlist

                                    }
                                    case 6->{ //Buscar música

                                    }
                                    case 7->{ //sair
                                        System.out.println("Estamos te direcionando para o menu inicial...");
                                        System.out.println();

                                    }

                                }
                            }
                        }else{
                            System.out.println("Não encontramos o usuário");
                            System.out.println();
                        }
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("Opção selecionada inválida");
                        System.out.println();
                    }catch (NumberFormatException e) {
                        System.out.println("Entrada inválida!");
                        System.out.println();
                    }

                }
                case 3-> System.out.println("Encerrando o Codefy");
                default -> {
                    System.out.println("Opção inválida. Escolha uma das opções listadas");
                    System.out.println();
                }
            }
        }
    }

}
