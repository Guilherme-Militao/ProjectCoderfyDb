package com.Jornada.Services;

import com.Jornada.Entity.Usuario;
import com.Jornada.Repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServices {


    private UsuarioRepository usuarioRepository;

    //constrói a variável de UsuarioRepositório pra poder manipular na camada de serviço
    public UsuarioServices(){

        usuarioRepository = new UsuarioRepository();

    }

    // metodo para verificar se o email é de fato email, se possui @
    public void verficaEmail(Usuario user) throws Exception {
        if(!user.getEmail().contains("@")){
            throw new Exception("Email não Válido:");
        }
    }
    public void verficaEmail(String email) throws Exception {
        if(!email.contains("@")){
            throw new Exception("Email não Válido:");
        }
    }

    public Usuario CadastrarUsuario(Usuario user) throws Exception {
        verficaEmail(user);

        Usuario userSalvo = usuarioRepository.CadastrarUser(user);

        System.out.println("Usuario cadastrado com Sucesso service");
        return userSalvo;
    }

    public List<Usuario> ListarUsers(){
        List<Usuario> lista = usuarioRepository.listarUsuarios();
        //lista.stream().forEach(System.out::println);

        return lista;

    }

    public int verificaUsuario(List<Usuario> listUsers,String senha, Integer id) {

        for (Usuario user : listUsers){
            if(user.getSenha().equals(senha) && (user.getId_usuario()==id)){
                return 1;
            }
        }

        return 0;
    }

    public boolean UpdateUser(Usuario user) throws Exception {

        verficaEmail(user);

        return usuarioRepository.UpdateUsuario(user);


    }

    public boolean DeleteUser( Integer id){

        return this.usuarioRepository.ExcluirUsuario(id);
    }

    public boolean userDate(Integer id){

        List<Usuario> listaUsers = usuarioRepository.listarUsuarios();

        for (Usuario u: listaUsers) {

            if(id == u.getId_usuario()){

                System.out.println("Dados do usuario:");
                System.out.println("ID_USUARIO = " +  u.getId_usuario());
                System.out.println("NOME = "+ u.getNome());
                System.out.println("EMAIL = "+ u.getEmail());
                System.out.println("DATA_REGISTRO " + u.getDataRegistro());
                System.out.println();

                return true;
            }
        }
        return  false;
    }

}
