package AboutGame.Location.NormalLoc;

import AboutGame.Player;
import AboutGame.Location.Location;

public class SafeHouse extends Location {
    Player player;
    boolean onLocation;

    public SafeHouse(Player player){
        this.player = player;
    }

    @Override
    public boolean onLocation(boolean onLocation) {
        recover();
        return this.onLocation = onLocation;
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
