package AboutGame.Location.BattleLoc;

import java.util.Scanner;
import AboutGame.Player;
import AboutGame.Location.Location;
import AboutGame.Location.NormalLoc.SafeHouse;
import AboutGame.Monsters.Monster;

public abstract class BattleLoc extends Location {
    Player player;
    Monster monster;
    int monsterNumber;
    Location location;

    public BattleLoc(Monster monster) {
        this.monster = monster;
    }

    public abstract boolean onLocation(boolean location);

    public abstract void addItem();

    public void cumbat(int monsterNumber) {

        this.monsterNumber = randomObstacle();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tehlikeli bolgedesin! Kacmak icin 1 Savasmak icin 2");

        int secim = scanner.nextInt();

        if (secim == 1) {
            System.out.println("Safe House'a yönlendiriliyorsun.");
            location = new SafeHouse(player);
            location.onLocation(true);

        } else if (secim == 2) {
            while (this.monsterNumber == 0) {
                this.monster.setHealth(this.monster.getHealth() - this.player.getDamage());

                if (winner()) {
                    System.out.println("Bir canavari alt ettin!!!");
                    
                    player.setMoney(player.getMoney() + monster.getMoney());
                    monsterNumber--;
                }
                int monsterDamage = this.player.getInventory().getArmorDefence() - this.monster.getDamage();
                this.player.setHealth(this.player.getHealth() - monsterDamage);

                if (winner() == false) {
                    System.out.println("Kaybettin!!! ");
                    System.exit(0);
                }
            }
            
        }
        if(this.monsterNumber == 0){
            getInventoryPrize();
        }
        if(this.player.getInventory().getWater() && this.player.getInventory().getFood() && this.player.getInventory().getFirewood()){
                System.out.println("KAZANDIN!!!");
                System.exit(0);
            }
        scanner.close();
    }

    public boolean winner() {
        if (this.player.getHealth() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int randomObstacle() {
        return monsterNumber = (int) Math.random() * 3;
    }

   
    public void getInventoryPrize() {
		int monsterID = this.monster.getId();

		switch (monsterID) {
			case 1 -> {
				this.player.getInventory().setWater(true);
				System.out.println("Kazandin!" );
			}
			case 2 -> {
				this.player.getInventory().setFirewood(true);
				System.out.println("Kazandin! " );
			}
			case 3 -> {
				this.player.getInventory().setFood(true);
				System.out.println("Kazandin! ");
			}
			
		}
	}

}
// if (inventory.getFood() == true && inventory.getWater() == true && inventory.getFirewood() == true) {
  //          System.out.println("Bütün ödülleri kazandigin icin oyunu bitirdin! Tebrikler!!!!");
     //   }