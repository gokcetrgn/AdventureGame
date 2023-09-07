package AboutGame.Location.BattleLoc;


import AboutGame.Monsters.Vampire;
import AboutGame.Player;

public class Forest extends BattleLoc{

    public Forest(Player player) {
        super(player, "Forest",new Vampire());
        
    }
    public void addItem(){
        this.player.getInventory().setFood(true);

    }
    
    
    
}
