package com.Jornada.Services;

import com.Jornada.Entity.Musica;
import com.Jornada.Repository.MusicaRepository;

import java.util.List;

public class MusicaServices {

    private MusicaRepository musicaRepository;

    public MusicaServices(){

        musicaRepository = new MusicaRepository();

    }


    public void listaMusicas(){

        List<Musica>listaM = musicaRepository.listarMusicas();


        for (Musica m: listaM) {

            System.out.println("Id = " + m.getIdMusica());
            System.out.println("Nome = " + m.getNome());
            System.out.println("Duração = " + m.getDuracaoSec());
            System.out.println();
        }
    }
    public boolean isEmpty(){
        return musicaRepository.listarMusicas().size()==0 ?true:false;
    }


}
