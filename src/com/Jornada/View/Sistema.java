package com.Jornada.View;

import com.Jornada.Entity.Playlist;
import com.Jornada.Entity.Usuario;
import com.Jornada.Services.PlaylistServices;
import com.Jornada.Services.UsuarioServices;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Sistema {


    public static void main(String[] args) {

        UsuarioServices usuarioServices = new UsuarioServices();
        PlaylistServices playlistServices = new PlaylistServices();

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


                    //TELA DE MENU DO USUÁRIO LOGADO
                    try{ //tratamento de exeção IndexOutOfBoundsException, pois caso o id passado (que equeivale ao indice) esteja fora do limite da lista o programa não será interrompido


                        System.out.println("Informe sua senha");
                        String senha = scanner.nextLine();

                        System.out.println("Informe seu id: ");
                        Integer id= Integer.parseInt(scanner.nextLine());
                        int res = usuarioServices.verificaUsuario( usuarioServices.ListarUsers(),senha,id);

                        if(res!=0){
                            int op = 0;
                            while (op != 7) {
                                System.out.println("""
                                            1- Atualizar dados do usuário
                                            2- Excluir usuário
                                            3- Exibir informações do usuário
                                            4- Criar playlist
                                            5- Listar playlists
                                            6- Excluir playlist
                                            7- sair""");
                                op = Integer.parseInt(scanner.nextLine());
                                switch (op) {

                                    case 1 -> { //Atualizar dados do usuário

                                        System.out.println("Atualizando Dados:");
                                        Usuario user = new Usuario();

                                        System.out.println("Informe seu nome: ");
                                        user.setNome(scanner.nextLine());

                                        System.out.println("Informe seu email:");
                                        user.setEmail(scanner.nextLine());

                                        System.out.println("Informe sua nova senha:");
                                        user.setSenha(scanner.nextLine());

                                        user.setDataRegistro(new Date());
                                        user.setId_usuario(id);

                                        try {
                                            boolean editado = usuarioServices.UpdateUser(user);
                                            System.out.println("Editado = " + editado);

                                        }catch (Exception e){
                                            System.err.println(e.getMessage());
                                        }

                                    }
                                    case 2 -> { //Excluir usuário

                                        System.out.println("Deletando Usuario:");

                                        System.out.println("Informe sua senha");
                                        String confirmaSenha = scanner.nextLine();

                                        if(confirmaSenha.equals(senha)){
                                            if(usuarioServices.DeleteUser(id))
                                                System.out.println("Usuario excluido com sucesso!");

                                            op = 7;
                                        }else{
                                            System.out.println("Erro");
                                        }


                                    }
                                    case 3 -> { //Exibir informações do usuário

                                        usuarioServices.userDate(id);

                                    }
                                    case 4 -> { //Criar playlist

                                        Playlist p= new Playlist();

                                        System.out.println("Digite o nome para playlist:: ");
                                        p.setNome(scanner.nextLine());

                                        p.setId_usuario(id);

                                        try {
                                            playlistServices.criarPlaylist(id, p);
                                            System.out.println("Playlist cadastrado com sucesso!");

                                        }catch (Exception e){
                                            System.err.println(e.getMessage());
                                        }

                                    }
                                    case 5->{ //Listar playlists

                                        playlistServices.ListarPlaylists();

                                    }
                                    case 6->{ //Excluir Playlist

                                        playlistServices.ListarPlaylists();

                                            System.out.println("Informe o id da Playlist: ");
                                            Integer idPlaylist = Integer.parseInt(scanner.nextLine());

                                            if(playlistServices.excluirPlaylist(idPlaylist))
                                                System.out.println("Playlist excluida com Sucesso! ");


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
