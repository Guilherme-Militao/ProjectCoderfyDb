package com.Jornada.Services;

import com.Jornada.Entity.PlaylistMusica;
import com.Jornada.Repository.PlaylistMusicaRepository;

import java.util.List;

public class PlaylistMusicaServices {

    private PlaylistMusicaRepository playlistMusicaRepository;

    public PlaylistMusicaServices(){

        playlistMusicaRepository = new PlaylistMusicaRepository();
    }

    public boolean insereMusica(Integer idP, Integer idM){

        return playlistMusicaRepository.InsereMusicaPlay(idP,idM);
    }

    //lista musicas
    public List<PlaylistMusica> listar(Integer idp){

        List<PlaylistMusica>lista = playlistMusicaRepository.listar(idp);
        lista.stream().forEach(System.out::println);

        return lista;
    }

    //status da exclusão
    public boolean exluir(Integer idPlaylist){
        return playlistMusicaRepository.excluir(idPlaylist);
    }




}
