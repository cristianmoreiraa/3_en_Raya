import controler.controlerGame;
import modelo.Juego;
import vista.Game;

public class Main {

    public static void main(String[] args) {
        //nuevas instancias de clase
        Juego modelo = new Juego();
        Game vista = new Game();
        controlerGame controler = new controlerGame( vista , modelo );
        controler.iniciar_vista();
        vista.setVisible(true);

    }
}