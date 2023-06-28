package com.Jornada.Entity;

public class PlaylistMusica {

    private Integer idPlaylist;
    private Integer idMusica;

    private Musica musica;

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }

    public Integer getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Integer idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public Integer getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(Integer idMusica) {
        this.idMusica = idMusica;
    }

    @Override
    public String toString() {
        return "PlaylistMusica{" +
                ", Nome Musica=" + musica.getNome() +
                ", Duração Musica=" + musica.getDuracaoSec() +" seg" +
                '}';
    }
}
