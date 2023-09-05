package AboutGame.Characters;

import AboutGame.Inventory;

public class Person {
    Inventory inventory;
    private int id;
    private int damage = 0;
    private int health = 0;
    private int money = 0;
    
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
        if(money >= 0){
        this.money = money;
        System.out.println("Paraniz: "+ this.money);
        }else{
            System.out.println("Bu envanteri satin alamazsiniz!!");
            System.out.println("Paraniz: " + this.money);
        }
    }
    public void print(){
        System.out.println("Damage: " + this.damage);
        System.out.println("Health: " + this.health);
        System.out.println("Money: " + this.money);
        inventory.print();
    }

}
