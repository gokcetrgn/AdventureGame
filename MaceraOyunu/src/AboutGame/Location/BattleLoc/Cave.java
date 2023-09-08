package AboutGame.Location.BattleLoc;

import AboutGame.Monsters.Vampire;
import AboutGame.Player;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player,"Cave",new Vampire());
    }

    @Override
    public void addItem(){
        this.player.getInventory().setFirewood(true);
    }
}
