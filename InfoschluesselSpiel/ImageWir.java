import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageWir extends JPanel{
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

        BildschirmFenster.getInstance().addGraphic(this);

        //Sorgt dafür, dass das Bild auf dem Spielfenster angezeigt wird
        repaint();
    }

    /**
     * Sorgt dafür, dass das Bild an der neuen Position gezeichnet wird
     * @param newX neue x-Koordinate
     * @param newy neue y-Koordinate
     */
    public void zeichne(int newX, int newy) {
        xKoordinate = newX;
        yKoordinate = newy;

        repaint();
    }

    /**
     * Zeichnet das Bild aufs Spielfenster kla
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        icon.paintIcon(null, g, xKoordinate, yKoordinate);
    }

    /**
     * Gibt die Breite des Bildes zurück
     * @return
     */
    public int getBreite() {
        return breite;
    }
}
