package AboutGame.Location.BattleLoc;


import AboutGame.Monsters.Vampire;
import AboutGame.Monsters.Zombie;
import AboutGame.Player;

public class Forest extends BattleLoc{

    public Forest(Player player) {
        super(player, "Forest",new Zombie());
        
    }
    public void addItem(){
        this.player.getInventory().setFood(true);

    }
    
    
    
}
