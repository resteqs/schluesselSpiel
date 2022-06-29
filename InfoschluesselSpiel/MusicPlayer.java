import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class MusicPlayer {

    public static void RunMusic(String path)
    {
        try {
            //Daten von der Datei beziehen
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            //Daten in einen Clip verwandeln
            Clip clip = AudioSystem.getClip();
            //Clip mit den Daten der Datei erstellen und loopen
            clip.open(inputStream);
            clip.loop(0);
        }
        catch(UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
}