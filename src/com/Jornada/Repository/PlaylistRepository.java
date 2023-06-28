package com.Jornada.Repository;

import com.Jornada.Entity.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {


    public Playlist criaPlaylist(Integer idusuario, Playlist p){

        Connection connection = null;

        try {
            connection = ConexaoDb.getConnection();

            String sequence = "select seq_playlist.nextval proxval from DUAL";

            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sequence);

            String sql = "Insert into PLAYLIST (id_playlist, nome, id_usuario) VALUES (?,?,?)";

            Integer idM = -1;
            if(res.next())
                idM = res.getInt("proxval");

            PreparedStatement preparedStatement =connection.prepareStatement(sql);

            preparedStatement.setInt(1,idM);
            preparedStatement.setString(2, p.getNome());
            preparedStatement.setInt(3, idusuario);

            preparedStatement.executeUpdate();

            p.setIdUsuario(idM);

            System.out.println("Playlist criada com sucesso: ");
            return p;

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if (!connection.isClosed() && connection !=null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return p;
    }

    public List<Playlist> listarPlaylist(){

        List<Playlist> listaPlaylists = new ArrayList<>();

        Connection connection = null;

        try {

            connection = ConexaoDb.getConnection();

            String sql = "select * from PLAYLIST";

            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql);

            while(res.next()){

                Playlist p = new Playlist();
                p.setNome(res.getString("nome"));
                p.setIdPlaylist(res.getInt("id_playlist"));
                p.setIdUsuario(res.getInt("id_usuario"));
                listaPlaylists.add(p);

            }

            return listaPlaylists;

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(!connection.isClosed() && connection !=null) connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }

            return listaPlaylists;
        }


    }

    public boolean excluirPlaylist(Integer id){

        Connection connection = null;


        try{

            connection = ConexaoDb.getConnection();

            String sql = "DELETE FROM playlist WHERE id_playlist = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();

            return true;

        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            try{
                if(!connection.isClosed() && connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        System.out.println("Erro no banco");
        return false;
    }

}
