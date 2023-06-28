package com.Jornada.Repository;

import com.Jornada.Entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistMusicaRepository {


    public boolean InsereMusicaPlay(Integer idP, Integer idM){

        Connection connection = null;

                try{

                    connection = ConexaoDb.getConnection();

                    String sql = "insert into playlist_musicas "+
                            "(id_playlist, id_musica)"+
                            "values (?, ?)";

                    PreparedStatement preparedStatement = connection.prepareStatement(sql);

                    preparedStatement.setInt(1,idP);
                    preparedStatement.setInt(2,idM);

                    preparedStatement.executeUpdate();

                    System.out.println("Inserção ok");
                    return true;


                }catch (SQLException e){
                    e.printStackTrace();
                }
                finally {
                    try{
                        if(!connection.isClosed() && connection!= null) connection.close();

                    }catch (SQLException s){

                        s.printStackTrace();
                    }
                }
        return false;
    }

    public List<PlaylistMusica> listar(Integer idP) {

        List<PlaylistMusica> listap = new ArrayList<>();

        Connection connection = null;

        try {

            connection = ConexaoDb.getConnection();

            String sql = "SELECT m.nome,m.DURACAO_SEC FROM MUSICAS m \n" +
                    "LEFT JOIN PLAYLIST_MUSICAS pm on(PM.ID_MUSICA = m.ID_MUSICA)\n" +
                    "WHERE pm.ID_PLAYLIST =?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idP);

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {


                Musica m = new Musica();
                //nome e duração
                m.setNome(res.getString("nome"));
                m.setDuracaoSec(res.getInt("duracao_sec"));

                PlaylistMusica p = new PlaylistMusica();
                p.setIdMusica(m.getIdMusica());
                p.setMusica(m);
                listap.add(p);

            }

            return listap;


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (!connection.isClosed() && connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return listap;
    }

    public boolean excluir(Integer idPplaylist){

        Connection connection = null;

        try{

            connection = ConexaoDb.getConnection();

            String sql = "DELETE  FROM PLAYLIST_MUSICAS pm WHERE pm.id_playlist = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,idPplaylist);

            preparedStatement.executeUpdate();

            System.out.println("exluir ok");
            return true;


        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(!connection.isClosed() && connection!= null) connection.close();

            }catch (SQLException s){

                s.printStackTrace();
            }
        }
        return false;
    }

}
