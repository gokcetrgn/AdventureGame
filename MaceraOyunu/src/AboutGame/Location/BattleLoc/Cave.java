package AboutGame.Location.BattleLoc;

import AboutGame.Monsters.Zombie;
import AboutGame.Player;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player,"Cave",new Zombie());
    }

    @Override
    public void addItem(){
        this.player.getInventory().setFirewood(true);
    }
}
