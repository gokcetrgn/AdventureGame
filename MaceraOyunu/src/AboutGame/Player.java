package AboutGame;

import AboutGame.Characters.Person;

public class Player {

 
    private String name;
    private int id;
    private int damage = 0;
    private int health = 0;
    private int money = 0;
    private Inventory inventory = new Inventory();
    


    public Player(){

    }

    public Player(int id,int damage,int health,int money) {
		this.id = id;
		this.damage = damage;
		this.health = health;
		this.money = money;		
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {

        this.money = money;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
