import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;

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
            case VK_A:
                spieler = "links";
                break;

            case VK_RIGHT:
            case VK_D:
                spieler = "rechts";
                break;
            case VK_ESCAPE:
            	GameManager gameManager = GameManager.getInstance();
            	gameManager.startStop();
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
            case VK_D:
            case VK_A:
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
