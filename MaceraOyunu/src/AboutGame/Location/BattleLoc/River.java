package AboutGame.Location.BattleLoc;

import AboutGame.Monsters.Bear;
import AboutGame.Player;

public class River extends BattleLoc{
    

    public River(Player player) {
        super(player,"Forest",new Bear());
    }

    public void addItem(){
        this.player.getInventory().setWater(true);
    }
}
