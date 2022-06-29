import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class MusicPlayer {
//Stellt sicher, dass nur ein MusicPlayer existiert
    public static MusicPlayer singleton = new MusicPlayer();
    public static AudioInputStream inputStream = null;
    public static Clip clip = null;
    private MusicPlayer()
    {

    }
//Gibt das Singleton zurueck, um anderen Klassen Zugriff zu gewähren
    public static MusicPlayer getInstance() {
        return singleton;
    }
    public static void RunMusic(String path)
    {
        try {
            //Daten von der Datei beziehen
            inputStream = AudioSystem.getAudioInputStream(new File(path));
            //Daten in einen Clip verwandeln
            clip = AudioSystem.getClip();
            //Clip mit den Daten der Datei erstellen und loopen
            clip.open(inputStream);
            clip.loop(500);
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
    public static void StopClip() {
        {
            clip.stop();
        }
    }
}