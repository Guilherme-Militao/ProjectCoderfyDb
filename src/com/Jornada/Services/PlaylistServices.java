package com.Jornada.Services;

import com.Jornada.Entity.Musica;
import com.Jornada.Entity.Playlist;
import com.Jornada.Entity.Usuario;
import com.Jornada.Repository.ConexaoDb;
import com.Jornada.Repository.PlaylistRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlaylistServices {

    private PlaylistRepository playlistRepository;

    public PlaylistServices(){
        playlistRepository = new PlaylistRepository();
    }
    public Playlist criarPlaylist(Integer idUser, Playlist p) throws Exception {

        Playlist psalvo = playlistRepository.criaPlaylist(idUser,p);

        System.out.println("Playlist cadastrada com sucesso:");
        return psalvo;
    }

    public void ListarPlaylists(){
        List<Playlist> lista = playlistRepository.listarPlaylist();

        for (Playlist p: lista) {
            System.out.println("Id da playlist -> " + p.getIdPlaylist());
            System.out.println("Nome da playlist -> " + p.getNome());
            System.out.println();
        }

    }

    public boolean excluirPlaylist(Integer idPlaylist){

        return playlistRepository.excluirPlaylist(idPlaylist);
    }

}
