package AboutGame.Location.NormalLoc;

import AboutGame.Player;
import AboutGame.Location.Location;

public class SafeHouse extends Location {

    public SafeHouse(Player player, String name){
        super(player,name);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Safe House! Canın yenileniyor..");
        recover();
        return true;
    }

    public void recover() {
        try {
            if (this.player.getId() == 1) {
                this.player.setHealth(21);
            } else if (this.player.getId() == 2) {
                this.player.setHealth(18);
            } else if (this.player.getId() == 3) {
                this.player.setHealth(24);
            }

        } catch (Exception e) {
            System.out.println("Something went wrong.Invalid character");
        }
    }
}
