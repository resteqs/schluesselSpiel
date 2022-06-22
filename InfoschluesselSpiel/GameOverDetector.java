public class GameOverDetector {

    public GameOverDetector()
    {


    }



    public void check(Key[] keys, Spieler spieler, Stopwatch zeit) {



        for (int j = 0; j < keys.length; j++) {
            //System.out.println("Test");
            if ((keys[j].getyKoordinate() + keys[j].getGraphik().getHoehe())  >= (spieler.getyKoordinate() + spieler.getFigurAbweichungOben()) && (keys[j].getyKoordinate()) <= (spieler.getyKoordinate() + spieler.getFigur().getHoehe() + spieler.getFigurAbweichungOben()))
            {
                //System.out.println("Jetzt");
                if((keys[j].getxKoordinate())  <= (spieler.getxKoordinate() + spieler.getFigur().getBreite() + spieler.getFigurAbweichungLinks()) && (spieler.getxKoordinate() + spieler.getFigurAbweichungLinks()) <= (keys[j].getxKoordinate() + keys[j].getGraphik().getBreite()))
                {
                    //starte game over screeen (Funktioniert noch nicht das spiel muss dann noch angehalten werden)
                	
                	GameOverMenu.getInstance().menuAnzeigen();

                    zeit.timerStoppen();
                	
                    //System.out.println("GAME OVER");
                }
            }
        }
    }


}


