import java.util.ArrayList;
import java.util.List;

/*
Game Class which runs the battle between 2 players and decides the winner!
 */
public class Game implements IGame{

    //instance variables
    private Player player1;
    private Player player2;
    private List<Gear> gearItems = new ArrayList<>();


    /*
    Game constructor which take 2 players and a list of 10 gear items to pick from
     */
    public Game(Player player1, Player player2,List<Gear> items)
    {
        this.player1 = player1;
        this.player2 = player2;

        this.gearItems = items;
        if(items.size()<10)
        {
            throw new IllegalArgumentException("Gears list cannot be less than 10");
        }

    }


    /*
    Method to instantiate the game play of picking gear items between 2 players
     */
    @Override
    public String pickGearItems() {
        int t = gearItems.size();
        for(int i =0 ; i< t; i++)
        {
            if(i%2==0)
            {
            Gear o = player1.addGear(gearItems);
            System.out.println("Player 1:"+ player1.getGearDescription(gearItems) +""+ player1.getAttack() +" "+ player1.getDefence());
            System.out.println();
            gearItems.remove(o);

            }
            else
            {
                Gear o = player2.addGear(gearItems);
                System.out.println("Player 2:"+ player2.getGearDescription(gearItems) +""+ player2.getAttack() +" "+ player2.getDefence());
                System.out.println();
                gearItems.remove(o);
            }

        }

        return gameResult();

    }


    /*
    Method to calculate the winner based on their attack and defence points
     */
    private String gameResult()
    {

        int player1Damage = player2.getAttack() - player1.getDefence();
        int player2Damage = player1.getAttack() - player2.getDefence();

        if(player1Damage<player2Damage)
        {
            return "Player 1 wins";
        } else if (player2Damage<player1Damage)
        {
            return "Player 2 wins";
        }
        else {
            return "It's a TIE!!";
        }
    }
}
