package AboutGame.Location;

import AboutGame.Player;

public abstract class Location {
    public Player player;
    String name;

    public Location(){}

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }
    public abstract boolean onLocation();
}
