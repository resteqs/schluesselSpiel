import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Image extends JPanel{
    //Pfad der Bilddatei
    private String pfad;
    //Für die Anzeige des Bildes notwendig
    private JLabel jLabel;
    private ImageIcon icon;

    public Image(String pfad, int breite, int hoehe) {
        //setzen des Dateipfades
        this.pfad = pfad;

        //Laden des Bildes und skalieren auf die gegebene Groeße
        URL bildURL = getClass().getResource(pfad);
        icon = new ImageIcon(bildURL);
        icon.setImage(icon.getImage().getScaledInstance(breite, hoehe, java.awt.Image.SCALE_DEFAULT));

        //Erstellen des Labels mit Bild
        jLabel = new JLabel(icon);

        BildschirmFenster.getInstance().addToMenu(this);

        //Sorgt dafür, dass das Bild auf dem Spielfenster angezeigt wird
        repaint();
    }

    /**
     * Zeichnet das Bild aufs Spielfenster
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        icon.paintIcon(null, g, 0, 0);
    }
}
