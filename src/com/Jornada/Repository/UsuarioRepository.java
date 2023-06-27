package com.Jornada.Repository;

import com.Jornada.Entity.Usuario;

import java.sql.*;

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

}
