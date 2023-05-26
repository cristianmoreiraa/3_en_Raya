package Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

    Connection conectar;

    public Connection establecerConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/tres_en_raya", "root", "");
            JOptionPane.showMessageDialog(null,"Se ha conectado correctamente");
            //System.out.println("Conectado corretamente ");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conecto a la base correctamente, espabila");
        }

        return conectar;
    }
    public Connection establecerConexion1(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/tres_en_raya", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conecto a la base correctamente, espabila");
        }
        return conectar;
    }
}
