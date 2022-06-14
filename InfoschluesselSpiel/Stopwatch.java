import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//frag einfach nicht was genau da importiert wird

public class Stopwatch
{
    public volatile double startTime;               // Variable, auf der die Zeit gespeichert wird, die seit dem Programmstart vergangen ist
    public volatile double currentTime;             // Zeit, die seit start des Timers vergangen ist
    private Timer timer;                            //Timer initialisieren


    public Stopwatch()                              //Konstruktor i guess, ist aber leer
    {
        timerStarten();
    }


    public void timerStarten()                         //Startet den Timer, wo jede 500 ms der Inhalt dieser Funktion "actionperformed" ausgeführt wird
    {
        startTime =  (System.nanoTime());               //Auf startTime wird die Zeit gespeichert, die Seit programmstart vergangen ist
        timer = new Timer(500, new ActionListener()     //definiert den Zeitabstand
        {
            public void actionPerformed(ActionEvent e)          //Methode für Timer
            {
                currentTime = ((System.nanoTime()) - startTime)/1000000000;     //Bisschen Quick math um von den beiden Zeiten die Zeit dazwischen auszurechnen,
                System.out.println(currentTime);                                //also die, die seit startTimer() vergangen ist   //serieller Output, für Debuggen
            }
        });

        timer.start();      //startet den timer
        System.out.println("Stopwatch now just started");            //serieller Output, für Debuggen

    }

    public void timerReset()
    {
        currentTime = 0;                                        //gespeicherte Zeit wird auf 0 gesetzt
        System.out.println("Stopwatch wurde resettet");         //serieller Output, für Debuggen
    }


    public void timerStoppen()
    {
        timer.stop();                                           // der Timer wird angehalten, macht man gewöhnlich direkt nach dem Reset
        System.out.println(currentTime);                        //serieller Output, für Debuggen
        System.out.println("Aus");                              //serieller Output, für Debuggen
    }



}