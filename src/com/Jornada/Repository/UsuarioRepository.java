package com.Jornada.Repository;

import com.Jornada.Entity.Usuario;
import oracle.jdbc.proxy.annotation.Pre;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {
//teste

    public Usuario CadastrarUser(Usuario user){

        Connection connection =  null;

        try {

            connection=ConexaoDb.getConnection();

            String sql = "insert into Usuario (id_usuario,nome,email,data_registro,senha)"+
                    "Values (?,?,?,?,?)";

            String sequence = "select seq_usuario.nextval proxval from DUAL";

            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sequence);

            Integer idUser = -1;

            if(res.next()){

                idUser = res.getInt("proxval");


            }

            PreparedStatement preparedStatement =connection.prepareStatement(sql);

            preparedStatement.setInt(1,idUser);
            preparedStatement.setString(2, user.getNome());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setDate(4, new Date(user.getDataRegistro().getTime()));
            preparedStatement.setString(5,user.getSenha());

            int retorno = preparedStatement.executeUpdate();

            user.setId_usuario(idUser);

            System.out.println("Usuario cadastrado com sucesso DB");
            return user;

        }catch (SQLException e){

            e.printStackTrace();

        }
        finally {
            try {
                if(!connection.isClosed() && connection != null) connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

            return user;
        }
    }

    public List<Usuario> listarUsuarios(){

        List<Usuario> listaUsers = new ArrayList<>();

        Connection connection = null;

        try {

            connection = ConexaoDb.getConnection();

            String sql = "select * from Usuario";

            Statement statement = connection.createStatement();

            ResultSet res = statement.executeQuery(sql);

            while(res.next()){

                Usuario user = new Usuario();
                user.setNome(res.getString("nome"));
                user.setEmail(res.getString("email"));
                user.setDataRegistro(res.getDate("data_registro"));
                user.setSenha(res.getString("senha"));
                user.setId_usuario(res.getInt("id_usuario"));
                listaUsers.add(user);

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

            return listaUsers;
        }


    }

    public boolean UpdateUsuario(Usuario user){

        Connection connection = null;

        try {
            connection = ConexaoDb.getConnection();

            String sql = "update USUARIO set nome = ?, email = ?, data_registro = ?, senha = ? where id_usuario = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, user.getNome());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setDate(3,new Date(user.getDataRegistro().getTime()));
            preparedStatement.setString(4,user.getSenha());
            preparedStatement.setInt(5,user.getId_usuario());


            preparedStatement.executeUpdate();
            System.out.println("Atualizado");
            return true;


        }catch(SQLException e){

            e.printStackTrace();

        }
        finally {
            try{

                if(!connection.isClosed() && connection != null)
                    connection.close();

            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        return  false;
    }

    public boolean ExcluirUsuario(Integer id){

        Connection connection = null;
        //DELETE FROM USUARIO u WHERE id_usuario = 5 AND senha = '1234';


        try{

            connection = ConexaoDb.getConnection();

            String sql = "DELETE FROM Usuario WHERE id_usuario = ?";

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
