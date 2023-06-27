package com.Jornada.Repository;

import com.Jornada.Entity.Musica;
import com.Jornada.Entity.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusicaRepository {

    public List<Musica> listarMusicas(){

        List<Musica> listaMusicas = new ArrayList<>();

        Connection connection = null;

        try {

            connection = ConexaoDb.getConnection();

            String sql = "select * from Musicas";

            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql);

            while(res.next()){

                Musica m = new Musica();
                m.setId_musica(res.getInt("id_musica"));
                m.setNome(res.getString("nome"));
                m.setDuracao_sec(res.getInt("duracao_sec"));
                m.setId_album(res.getInt("id_album"));
                m.setId_artista(res.getInt("id_artista"));

                listaMusicas.add(m);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(!connection.isClosed() && connection !=null) connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }

            return listaMusicas;
        }


    }

}
