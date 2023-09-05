package AboutGame.Location;

import AboutGame.Player;

public abstract class Location {
    Player player;
    String name;
    boolean location;

    public Location(){

    }
    public abstract boolean onLocation(boolean location);
}
