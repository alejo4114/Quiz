package DAO;

import Conexion.DbUtil;
import VO.ContextoNavegacion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class ServiciosContexto {

    private Connection connection;

    public ServiciosContexto() {
        connection = DbUtil.getConnection();
    }

    public void agregarContexto(ContextoNavegacion CN) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into ContextoNavegacion(id_contexto,id_modelo,link) values (?, ? ,? )");
            // Parameters start with 1
            preparedStatement.setInt(1, CN.getId_contexto());
            preparedStatement.setInt(2, CN.getId_modelo());
            preparedStatement.setString(3, CN.getLink());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ContextoNavegacion> listarCN() {
        ArrayList<ContextoNavegacion> contexto = new ArrayList<ContextoNavegacion>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from ContextoNavegacion");
            while (rs.next()) {
                ContextoNavegacion CN = new ContextoNavegacion();

                CN.setId_contexto(rs.getInt("id_contexto"));
                CN.setId_modelo(rs.getInt("id_modelo"));
                CN.setLink(rs.getString("link"));

                contexto.add(CN);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contexto;
    }

}
