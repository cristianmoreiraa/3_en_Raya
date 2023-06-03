/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventana;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Conexion.Conectar;
import controler.controlerGame;
import modelo.Juego;
import vista.Game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import static javax.swing.JOptionPane.*;


/**
 *
 * @author crist
 */
public class Leaderboard extends javax.swing.JFrame {
    Conectar con1 = new Conectar();
    Connection conet;
    PreparedStatement ps;



    public JTable getjTable1() {
        return jTable1;
    }

    /**
     * Creates new form Leaderboard
     */
    public Leaderboard() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bJugar = new javax.swing.JButton();
        bConectar = new javax.swing.JButton();
        bActualizar = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        bRegister = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leaderboard", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bJugar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bJugar.setText("Jugar");
        bJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bJugarActionPerformed(evt);
            }
        });
        jPanel1.add(bJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 120, 50));

        bConectar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bConectar.setText("Conectar");
        bConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConectarActionPerformed(evt);
            }
        });
        jPanel1.add(bConectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 50));

        bActualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bActualizar.setText("Actualizar");
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(bActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 120, 50));

        bExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bExit.setText("Exit");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });
        jPanel1.add(bExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 120, 50));

        bRegister.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bRegister.setText("Register");
        bRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(bRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, 120, 50));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Nombre", "Win", "Lose"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 470, 370));
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 560, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void bRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        Register siguienteVentana = new Register();
        siguienteVentana.setVisible(true);
        dispose();

    }

    private void bConectarActionPerformed(java.awt.event.ActionEvent evt) {
        Conectar con = new Conectar();
            //con.establecerConexion();     Conexion Cristian
            con.establecerConexionJorge();

    }

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Conectar obj = new Conectar();
            conet = obj.establecerConexionJorge();
            //conet = obj.establecerConexion(); Conexion Cristian
            // Obtener los datos de la tabla
            String sql = "SELECT * FROM tres_en_raya.casino" ;
            Statement statement = conet.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Crear el modelo de la tabla
            DefaultTableModel tableModel = new DefaultTableModel();

            // Obtener metadatos de la consulta
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(resultSet.getMetaData().getColumnLabel(i));
            }

            // Agregar filas a la tabla con los datos de la consulta
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(row);
            }

            showMessageDialog(null, "Se ha actualizado la tabla");

            // Asignar el modelo a la tabla
            jTable1.setModel(tableModel);
        } catch (SQLException e) {
            e.printStackTrace();
            showMessageDialog(null, "Error al mostrar los datos de la tabla");
        }
    }

    private void bJugarActionPerformed(java.awt.event.ActionEvent evt) {
        setVisible(false);
        Juego modelo = new Juego();
        Game vista = new Game();
        controlerGame controler = new controlerGame( vista , modelo );
        controler.iniciar_vista();
        vista.setVisible(true);
        dispose();
    }

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(3);
    }

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {
        // Agrega un MouseAdapter a la tabla para detectar clics en las filas
        jTable1.addMouseListener(new MouseAdapter() {
            private String jugador1 = null;
            private String jugador2 = null;

            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = jTable1.getSelectedRow();

                // Obtén el nombre del jugador de la fila seleccionada
                String nombreJugador = (String) jTable1.getValueAt(filaSeleccionada, 0);

                if (jugador1 == null) {
                    // Si aún no se ha seleccionado un jugador 1, almacena el nombre en jugador1
                    jugador1 = nombreJugador;
                } else if (jugador2 == null) {
                    // Si ya se seleccionó un jugador 1 pero no un jugador 2, almacena el nombre en jugador2
                    jugador2 = nombreJugador;

                    // Realiza alguna acción con los nombres de los jugadores
                    //System.out.println("Jugador 1: " + jugador1);
                    //System.out.println("Jugador 2: " + jugador2);

                    // Reinicia las variables para futuras selecciones
                    jugador1 = null;
                    jugador2 = null;
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leaderboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bConectar;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bJugar;
    private javax.swing.JButton bRegister;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
