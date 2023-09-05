package AboutGame;

import AboutGame.Characters.Person;
import AboutGame.Envanter.Silahlar.Silah;
import AboutGame.Envanter.Zırhlar.Zirh;

public class Inventory {
    Person person;
    Zirh zirh = new Zirh();
    Silah silah = new Silah();

    private boolean water = false;
    private boolean food = false;
    private boolean firewood = false;
    private String weaponName = null;
    private String armorName = null;
    private int weaponDamage = 0;
    private int armorDefence = 0;
    
    public boolean getWater() {
        return water;
    }
    public void setWater(boolean water) {
        this.water = water;
    }
    public boolean getFood() {
        return food;
    }
    public void setFood(boolean food) {
        this.food = food;
    }
    public boolean getFirewood() {
        return firewood;
    }
    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }
    public String getWeaponName() {
        return weaponName;
    }
    public void setWeaponName() {
        this.weaponName = silah.getName();
    }
    public String getArmorName() {
        return armorName;
    }
    public void setArmorName() {
        this.armorName = zirh.getName();
    }
    public int getWeaponDamage() {
        return weaponDamage;
    }
    public void setWeaponDamage() {
        this.weaponDamage = silah.getDamage();
        person.setDamage( person.getDamage() + this.weaponDamage);
    }
    public int getArmorDefence() {
        return armorDefence;
    }
    public void setArmorDefence() {
        this.armorDefence = zirh.getDefence();
        person.setDamage( person.getDamage() + this.armorDefence);
    }
    public void print(){
        System.out.println("Water: " + this.water);
        System.out.println("Food: " + this.food);
        System.out.println("Firewood: " + this.firewood);
        System.out.println("Silahiniz: " + this.weaponName);
        System.out.println("Silah hasari: " + this.weaponDamage);
        System.out.println("Zirhiniz: " + this.armorName);
        System.out.println("Zirhinizin engelleme gücü: " + this.armorDefence);
    }
}
