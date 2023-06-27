package com.Jornada.Services;

import com.Jornada.Entity.Usuario;
import com.Jornada.Repository.UsuarioRepository;

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
}
