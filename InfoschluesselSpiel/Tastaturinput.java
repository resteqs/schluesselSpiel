import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Tastaturinput extends KeyAdapter implements KeyListener {
    //Singleton für den Tastaturinput
    private static Tastaturinput singleton = new Tastaturinput();

    //Damit der Spieler erfahren kann, welche Aktion er ausführen soll
    private String spieler = "anhalten";

    @Override
    public void keyTyped(KeyEvent e) {
        //nicht benötigt
    }

    /**
     * Reagiert, wenn eine Taste gedrückt wird
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_LEFT:
                spieler = "links";
                break;

            case VK_RIGHT:
                spieler = "rechts";
                break;
        }

    }

    /**
     * Reagiert, wenn eine Taste losgelassen wird
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case VK_LEFT:
            case VK_RIGHT:
                spieler = "anhalten";
                break;
        }
    }

    /**
     * Gibt das Singleton zurück
     * @return
     */
    public static Tastaturinput getInstance() {
        return singleton;
    }

    /**
     * Gibt die Spieler-Aktion zurück
     * @return
     */
    public String getSpieler() {
        return spieler;
    }
}
