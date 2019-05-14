package comparator;

import java.util.Comparator;

/**
 * Created by AmitAgarwal on 3/18/19.
 */
public class Checker implements Comparator<Player> {


    @Override
    public int compare(Player player1, Player player2) {
        if(player1.getScore() == player2.getScore()){
            return player1.getName().compareTo(player2.getName());
        }else{
            return player1.getScore() - player2.getScore();
        }
    }
}
