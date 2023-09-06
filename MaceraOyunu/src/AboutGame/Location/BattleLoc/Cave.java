package AboutGame.Location.BattleLoc;

import AboutGame.Monsters.Monster;

public class Cave extends BattleLoc{
    public Cave(Monster monster) {
        super(monster);
    }

    boolean location;

    @Override
    public boolean onLocation(boolean location) {
        return this.location = location;
    }
    @Override
    public void addItem(){
        this.player.getInventory().setFirewood(true);
    }
}
