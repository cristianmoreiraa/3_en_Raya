package Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase utilizada para establecer conexiones a bases de datos utilizando JDBC.
 */
public class Conectar {

    Connection conectar;

    /**
     * Establece una conexión con la base de datos "tres_en_raya".
     *
     * @return La conexión establecida.
     */
    public Connection establecerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/tres_en_raya", "root", "");
            JOptionPane.showMessageDialog(null, "Se ha conectado correctamente");
            System.out.println("Conectado correctamente ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó a la base correctamente" + e.getMessage());
        }

        return conectar;
    }

    /**
     * Establece una conexión a la base de datos "tres_en_raya".
     *
     * @return La conexión establecida.
     */
    public Connection establecerConexion1() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/tres_en_raya", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó a la base correctamente");
        }
        return conectar;
    }

    /**
     * Establece una conexión a la base de datos "baseprog".
     *
     * @return La conexión establecida.
     */
    public Connection establecerConexionJorge() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/baseprog", "root", "Usatorre1210");
            System.out.println("Conectado correctamente ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conectó a la base correctamente" + e.toString());
        }

        return conectar;
    }

}
