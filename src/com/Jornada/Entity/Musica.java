package com.Jornada.Entity;

public class Musica {

    private Integer idMusica;
    private String nome;
    private Integer duracaoSec;
    private Integer idAlbum;
    private Integer idArtista;
    private Artista artista;
    private Albuns album;

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Albuns getAlbum() {
        return album;
    }

    public void setAlbum(Albuns album) {
        this.album = album;
    }

    public Integer getIdMusica() {
        return idMusica;
    }

    public void setIdMusica(Integer idMusica) {
        this.idMusica = idMusica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracaoSec() {
        return duracaoSec;
    }

    public void setDuracaoSec(Integer duracaoSec) {
        this.duracaoSec = duracaoSec;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "idMusica=" + idMusica +
                ", nome='" + nome + '\'' +
                ", duracaoSec=" + duracaoSec +
                ", idAlbum=" + idAlbum +
                ", idArtista=" + idArtista +
                ", artista=" + artista +
                ", album=" + album +
                '}';
    }
}
