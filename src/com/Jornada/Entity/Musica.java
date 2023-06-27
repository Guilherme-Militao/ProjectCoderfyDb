package com.Jornada.Entity;

public class Musica {

    private Integer id_musica;
    private String nome;
    private Integer duracao_sec;
    private Integer id_album;
    private Integer id_artista;

    public Integer getId_musica() {
        return id_musica;
    }

    public void setId_musica(Integer id_musica) {
        this.id_musica = id_musica;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracao_sec() {
        return duracao_sec;
    }

    public void setDuracao_sec(Integer duracao_sec) {
        this.duracao_sec = duracao_sec;
    }

    public Integer getId_album() {
        return id_album;
    }

    public void setId_album(Integer id_album) {
        this.id_album = id_album;
    }

    public Integer getId_artista() {
        return id_artista;
    }

    public void setId_artista(Integer id_artista) {
        this.id_artista = id_artista;
    }
}
