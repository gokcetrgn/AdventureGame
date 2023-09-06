package AboutGame.Location.BattleLoc;

import AboutGame.Monsters.Monster;
public class Forest extends BattleLoc{
    boolean location;
    Monster monster;

    @Override
    public boolean onLocation(boolean location) {
        return this.location = location;
    }

    public Forest(Monster monster) {
        super(monster);
        
    }
    public void addItem(){
        this.player.getInventory().setFood(true);

    }
    
    
    
}
