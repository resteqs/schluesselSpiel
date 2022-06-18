import javax.swing.*;
import java.awt.*;

public class Text {
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

        //Erstellen des Labels mit dem Text
        jlabel = new JLabel(inhalt);

        //Sorgt dafür, dass der Text angezeigt wird
        BildschirmFenster fenster = BildschirmFenster.getInstance();
        Window window             = fenster.getWindow();
        window.add(jlabel);
    }

    /**
     * Sorgt dafür, dass der Text im Spielfenster aktualisiert wird
     * @param newText neuer Text
     * @param graphics
     */
    public void zeichne(String newText, Graphics graphics) {
        //Legt den neuen Text fest
        inhalt = newText;

        draw(graphics);
    }

    /**
     * Zeichnet den Text
     * @param graphics
     */
    public void draw(Graphics graphics) {
        graphics.setFont(new Font(Font.MONOSPACED, Font.BOLD, schriftGroesse));
        graphics.setColor(schriftFarbe);
        graphics.drawString(inhalt, xKoordinate, yKoordinate);
    }
}
