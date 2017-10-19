package DAO;

import Conexion.DbUtil;
import VO.ContextoNavegacion;
import VO.UnidadAbstracta;
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
public class ServiciosUnidadAbs {

    private Connection connection;

    public ServiciosUnidadAbs() {
        connection = DbUtil.getConnection();
    }

    public void agregarUnidadAbs(UnidadAbstracta unia) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into UnidadAbstracta(id_unidadAbs,id_contexto,id_Tabla) values (?, ? ,? )");
            // Parameters start with 1
            preparedStatement.setInt(1, unia.getId_unidadAbs());
            preparedStatement.setInt(2, unia.getId_contexto());
            preparedStatement.setInt(3, unia.getId_Tabla());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UnidadAbstracta> listarUniABs() {
        ArrayList<UnidadAbstracta> unidades = new ArrayList<UnidadAbstracta>();
        try {
            System.out.println("LLegue hasta aca");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select * from UnidadAbstracta");
            while (rs.next()) {
                UnidadAbstracta UAB = new UnidadAbstracta();

                UAB.setId_unidadAbs(rs.getInt("id_unidadAbs"));
                UAB.setId_contexto(rs.getInt("id_contexto"));
                UAB.setId_Tabla(rs.getInt("id_Tabla"));

                unidades.add(UAB);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return unidades;
    }

}
