package AboutGame.Monsters;

public class Monster {
    private int id;
    private int damage = 0;
    private int health = 0;
    private int money = 0;
    
    public Monster(int id, int damage, int health, int money) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
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
        if(health < 0){
            this.health = 0;
        }else{
            this.health = health;
        };
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public Monster(){

    }
    
}
