import javax.swing.*;
import java.awt.*;

public class Text extends JPanel {
    //Inhalt des Textes
    private String inhalt;
    //Position des Textes
    private int xKoordinate;
    private int yKoordinate;
    //Größe des Textes
    private int schriftGroesse;
    private Color schriftFarbe;
    //Für die Anzeige des Textes notewndig
    private JLabel jlabel;

    public Text(String text, int x, int y, int schrift, Color farbe) {
        //Setzen des Textinhalts
        inhalt = text;

        //Setzen der Position des Textes
        xKoordinate = x;
        yKoordinate = y;

        //Setzen der Art der Schrift des Textes
        schriftGroesse = schrift;
        schriftFarbe = farbe;

        //Sorgt dafür, dass der Text angezeigt wird
        BildschirmFenster.getInstance().addGraphic(this);
    }

    /**
     * Sorgt dafür, dass der Text im Spielfenster aktualisiert wird
     * @param newText neuer Text
     */
    public void zeichne(String newText, Graphics g) {
        //Legt den neuen Text fest
        inhalt = newText;

        draw(g);
    }

    /**
     * Zeichnet den Text
     * @param g
     */
    public void draw(Graphics g) {
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, schriftGroesse));
        g.setColor(schriftFarbe);
        g.drawString(inhalt, xKoordinate, yKoordinate);
    }
}
