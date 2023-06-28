package com.Jornada.Entity;

import java.util.Date;

public class Albuns {

    private Integer idAlbum;
    private String titulo;
    private Date ano;

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    private Integer idArtista;

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    @Override
    public String toString() {
        return "Albuns{" +
                "idAlbum=" + idAlbum +
                ", titulo='" + titulo + '\'' +
                ", ano='" + ano + '\'' +
                '}';
    }
}
