import controler.controlerGame;
import modelo.Juego;
import ventana.Leaderboard;
import vista.Game;

/**
 * Clase principal que contiene el método main para iniciar la aplicación del juego.
 */
public class Main {

    /**
     * Método principal de la aplicación. Crea una instancia de la ventana Leaderboard y la hace visible.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {

        Leaderboard obj = new Leaderboard();
        obj.setVisible(true);
    }
}
