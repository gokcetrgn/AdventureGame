package AboutGame.Location.BattleLoc;

import java.util.Scanner;

import AboutGame.Inventory;
import AboutGame.Characters.Person;
import AboutGame.Location.Location;
import AboutGame.Location.NormalLoc.SafeHouse;
import AboutGame.Monsters.Monster;

public abstract class BattleLoc extends Location{
    boolean location;
    Inventory inventory;
    Person person;
    Monster monster;
    int monsterNumber;

    public BattleLoc(Monster monster){
        this.monster = monster;
    }
    public abstract boolean onLocation(boolean location);
    public abstract void addItem();

    public void cumbat(int monsterNumber){
        
        this.monsterNumber = monsterNumber;

        SafeHouse safeHouse = new SafeHouse();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tehlikeli bolgedesin! Kacmak icin 1 Savasmak icin 2");

        int secim = scanner.nextInt();

        if(secim == 1){

            safeHouse.onLocation(true);

        }else if(secim == 2){
            while(this.monsterNumber == 0){
                this.monster.setHealth(this.monster.getHealth() -  this.person.getDamage());

                if(winner()){
                    System.out.println("Bir canavari alt ettin!!!");
                    monsterNumber--;
                }
                int monsterDamage = this.inventory.getArmorDefence() - this.monster.getDamage();
                this.person.setHealth(this.person.getHealth() -  monsterDamage);

                if(winner() == false){
                    System.out.println("Kaybettin!!! Safe Area'ya yönlendiriliyorsun.");
                    safeHouse.onLocation(true);
                    break;
                }
            }
        }
        scanner.close();
    }
    
    public boolean winner(){
        if(this.person.getHealth() == 0){
            return false;
        }else{
            return true;
        }
    }
    

}
