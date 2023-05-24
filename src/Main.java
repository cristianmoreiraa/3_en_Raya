import vista.*;
import controler.*;
import modelo.*;

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