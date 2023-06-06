package controler;

import Conexion.Conectar;
import modelo.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import ventana.Leaderboard;
import ventana.Register;
import vista.*;

/**
 * Clase controladora para el juego 3 en raya.
 */
public class controlerGame implements ActionListener {

    private Game vista;
    private Juego juego;
    private String titulo = "3 en Raya MVC * jc-mouse.net ";
    Conectar con1 = new Conectar();
    Connection conet;
    PreparedStatement ps;
    Leaderboard obj = new Leaderboard();

    /**
     * Constructor de la clase.
     *
     * @param vista  La vista del juego.
     * @param modelo El modelo del juego.
     */
    public controlerGame(Game vista, Juego modelo) {
        this.vista = vista;
        this.juego = modelo;
    }

    /**
     * Inicializa la vista del juego y añade ActionListener a los botones.
     */
    public void iniciar_vista() {
        vista.setTitle(this.titulo);
        vista.setLocationRelativeTo(null);
        this.vista.casilla1.addActionListener(this);
        this.vista.casilla2.addActionListener(this);
        this.vista.casilla3.addActionListener(this);
        this.vista.casilla4.addActionListener(this);
        this.vista.casilla5.addActionListener(this);
        this.vista.casilla6.addActionListener(this);
        this.vista.casilla7.addActionListener(this);
        this.vista.casilla8.addActionListener(this);
        this.vista.casilla9.addActionListener(this);
    }

    /**
     * Captura las acciones de los botones de la vista.
     *
     * @param e El evento de acción.
     */
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();

        if (this.juego.ganador() == 0) {
            if (boton == this.vista.casilla1)
                this.vista.casilla1.setText(this.juego.set_movimiento(1));
            else if (boton == this.vista.casilla2)
                this.vista.casilla2.setText(this.juego.set_movimiento(2));
            else if (boton == this.vista.casilla3)
                this.vista.casilla3.setText(this.juego.set_movimiento(3));
            else if (boton == this.vista.casilla4)
                this.vista.casilla4.setText(this.juego.set_movimiento(4));
            else if (boton == this.vista.casilla5)
                this.vista.casilla5.setText(this.juego.set_movimiento(5));
            else if (boton == this.vista.casilla6)
                this.vista.casilla6.setText(this.juego.set_movimiento(6));
            else if (boton == this.vista.casilla7)
                this.vista.casilla7.setText(this.juego.set_movimiento(7));
            else if (boton == this.vista.casilla8)
                this.vista.casilla8.setText(this.juego.set_movimiento(8));
            else if (boton == this.vista.casilla9)
                this.vista.casilla9.setText(this.juego.set_movimiento(9));
            if (this.juego.get_error())
                JOptionPane.showMessageDialog(null, "Error: la casilla ya está marcada \n Perdiste tu turno");

            this.vista.setTitle(this.titulo + this.juego.get_turno());
        }

        if (this.juego.ganador() == 1)
            mensaje(" 'X' ");
        else if (this.juego.ganador() == 2)
            mensaje(" 'O' ");
        else if (this.juego.ganador() == 3)
            mensaje(" 'Es un empate' ");
    }

    /**
     * Muestra un mensaje al finalizar el juego y actualiza los resultados en la base de datos.
     *
     * @param s El mensaje a mostrar.
     */
    private void mensaje(String s) {
        boolean jugadorEncontradoGanador = false;
        while (!jugadorEncontradoGanador) {
            String nombreGanador = JOptionPane.showInputDialog(null, "Nombre del jugador que ganó");
            try {
                // Verifica si el jugador existe
                conet = con1.establecerConexion1();
                ps = conet.prepareStatement("SELECT Nombre FROM tres_en_raya.casino WHERE Nombre = ?");
                ps.setString(1, nombreGanador);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    // El jugador existe, actualiza el registro del ganador
                    ps = conet.prepareStatement("UPDATE tres_en_raya.casino SET Win = Win + 1 WHERE Nombre = ?");
                    ps.setString(1, nombreGanador);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Resultados actualizados correctamente");
                    jugadorEncontradoGanador = true;
                } else {
                    // El jugador no existe
                    int opcion = JOptionPane.showOptionDialog(null, "El jugador no existe. ¿Deseas registrarlo?", "Jugador no encontrado", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (opcion == JOptionPane.YES_OPTION) {
                        // Registrar nuevo jugador
                        ps = conet.prepareStatement("INSERT INTO tres_en_raya.casino(Nombre, Win, Lose) VALUES (?, 0, 0)");
                        ps.setString(1, nombreGanador);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Jugador registrado correctamente");

                        ps = conet.prepareStatement("UPDATE tres_en_raya.casino SET Win = Win + 1 WHERE Nombre = ?");
                        ps.setString(1, nombreGanador);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Resultados actualizados correctamente");

                        jugadorEncontradoGanador = true;
                    } else {
                        jugadorEncontradoGanador = false;
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar los resultados");
            }
        }

        boolean jugadorEncontradoPerdedor = false;
        while (!jugadorEncontradoPerdedor) {
            String nombrePerdedor = JOptionPane.showInputDialog(null, "Nombre del jugador que perdió");
            try {
                conet = con1.establecerConexion1();
                ps = conet.prepareStatement("SELECT Nombre FROM tres_en_raya.casino WHERE Nombre = ?");
                ps.setString(1, nombrePerdedor);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    ps = conet.prepareStatement("UPDATE tres_en_raya.casino SET Lose = Lose + 1 WHERE Nombre = ?");
                    ps.setString(1, nombrePerdedor);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Resultados actualizados correctamente");
                    jugadorEncontradoPerdedor = true;
                } else {
                    int opcion = JOptionPane.showOptionDialog(null, "El jugador no existe. ¿Deseas registrarlo?", "Jugador no encontrado", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                    if (opcion == JOptionPane.YES_OPTION) {
                        ps = conet.prepareStatement("INSERT INTO tres_en_raya.casino(Nombre, Win, Lose) VALUES (?, 0, 0)");
                        ps.setString(1, nombrePerdedor);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Jugador registrado correctamente");

                        ps = conet.prepareStatement("UPDATE tres_en_raya.casino SET Lose = Lose + 1 WHERE Nombre = ?");
                        ps.setString(1, nombrePerdedor);
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Resultados actualizados correctamente");

                        jugadorEncontradoPerdedor = true;
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar los resultados");
            }
        }

        int seleccion = JOptionPane.showOptionDialog(null, " ¿Qué desea hacer?", "Fin del juego",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{" Jugar otra vez ", " Salir del programa "},
                "Jugar otra vez");

        if (seleccion != -1) {
            if ((seleccion + 1) == 1) {
                this.juego.Jugar_otra_vez();
                this.vista.setTitle(titulo);
                this.vista.casilla1.setText("");
                this.vista.casilla2.setText("");
                this.vista.casilla3.setText("");
                this.vista.casilla4.setText("");
                this.vista.casilla5.setText("");
                this.vista.casilla6.setText("");
                this.vista.casilla7.setText("");
                this.vista.casilla8.setText("");
                this.vista.casilla9.setText("");
            } else {
                obj.setVisible(true);
                vista.dispose();
            }
        }
    }
}
