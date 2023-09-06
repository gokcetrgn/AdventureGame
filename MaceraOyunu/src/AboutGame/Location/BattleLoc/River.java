package AboutGame.Location.BattleLoc;

import AboutGame.Monsters.Monster;

public class River extends BattleLoc{
    

    public River(Monster monster) {
        super(monster);
    }

    boolean location;

    @Override
    public boolean onLocation(boolean location) {
        return this.location = location;
    }
    public void addItem(){
        this.player.getInventory().setWater(true);
    }
}
