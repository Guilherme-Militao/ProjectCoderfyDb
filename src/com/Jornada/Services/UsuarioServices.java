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

    public Usuario CadastrarUsuario(Usuario user) throws Exception {
        verficaEmail(user);

        Usuario userSalvo = usuarioRepository.CadastrarUser(user);

        System.out.println("Usuario cadastrado com Sucesso service");
        return userSalvo;
    }

    public List<Usuario> ListarUsers(){
        List<Usuario> lista = usuarioRepository.listarUsuarios();
        lista.stream().forEach(System.out::println);

        return lista;

    }

    public int verificaUsuario(List<Usuario> listUsers,String senha, String email, Integer id){

        for (Usuario user : listUsers){
            if(user.getEmail().equalsIgnoreCase(email ) && user.getSenha().equals(senha) && (user.getId_usuario()==id)){
                return 1;
            }
        }

        return 0;
    }
}
