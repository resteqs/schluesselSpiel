import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageWir{
    //Pfad der Bilddatei
    private String pfad;
    //Position des Bildes
    private int xKoordinate;
    private int yKoordinate;
    //Groeße des Bildes
    private int breite;
    private int hoehe;
    //Für die Anzeige des Bildes notwendig
    private JLabel jLabel;
    private ImageIcon icon;

    public ImageWir(String pfad, int breite, int hoehe, int x, int y) {
        //setzen des Dateipfades
        this.pfad = pfad;

        //setzen der Position
        xKoordinate = x;
        yKoordinate = y;

        //setzen der Groeße des Bildes
        this.breite = breite;
        this.hoehe  = hoehe;

        //Laden des Bildes und skalieren auf die gegebene Groeße
        URL bildURL = getClass().getResource(pfad);
        icon        = new ImageIcon(bildURL);

        icon.setImage(icon.getImage().getScaledInstance(breite, hoehe, java.awt.Image.SCALE_DEFAULT));

        //Erstellen des Labels mit Bild
        jLabel = new JLabel(icon);

        //Sorgt dafür, dass das Bild auf dem Spielfenster angezeigt wird
        BildschirmFenster fenster = BildschirmFenster.getInstance();
        Window window             = fenster.getWindow();
        window.add(jLabel);
    }

    /**
     * Sorgt dafür, dass das Bild an der neuen Position gezeichnet wird
     * @param newX neue x-Koordinate
     * @param newY neue y-Koordinate
     * @param graphics
     */
    public void zeichne(int newX, int newY, Graphics graphics) {
        //Legt die neuen Koordinaten fest
        xKoordinate = newX;
        yKoordinate = newY;

        draw(graphics);
    }

    /**
     * Zeichnet das Bild
     * @param graphics
     */
    public void draw(Graphics graphics) {
        icon.paintIcon(null, graphics, xKoordinate, yKoordinate);
    }

    /**
     * Gibt die Breite des Bildes zurück
     * @return
     */
    public int getBreite() {
        return breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    public JLabel getjLabel() {
        return jLabel;
    }
}
