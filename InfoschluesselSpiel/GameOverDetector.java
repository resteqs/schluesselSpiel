public class GameOverDetector {
    public int j;

    public GameOverDetector()
    {


    }



    public void check(Key [] keys, Spieler spieler) {



        for (int j = 0; j < 5; j++) {
            //System.out.println("Test");
            if (keys[j].getyKoordinate() + keys[j].getGraphik().getHoehe()  >= spieler.getyKoordinate() && keys[j].getyKoordinate() <= spieler.getyKoordinate() + spieler.getFigur().getHoehe()) {
                //System.out.println("Jetzt");
                if(keys[j].getxKoordinate()  <= spieler.getxKoordinate() + spieler.getFigur().getBreite() && spieler.getxKoordinate() <= keys[j].getxKoordinate() + keys[j].getGraphik().getBreite())
                {
                    //starte game over screeen
                    //System.out.println("GAME OVER");
                }
            }
        }
    }


}


