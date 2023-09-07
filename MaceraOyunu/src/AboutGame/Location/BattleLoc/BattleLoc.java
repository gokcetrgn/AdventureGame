package AboutGame.Location.BattleLoc;

import java.util.Random;
import java.util.Scanner;
import AboutGame.Player;
import AboutGame.Location.Location;
import AboutGame.Location.NormalLoc.SafeHouse;
import AboutGame.Monsters.Monster;

public abstract class BattleLoc extends Location {
    Player player;
    Monster monster;
    Random random;
    String name;
    Location location;
    int randomObstacle = randomObstacle();

    public BattleLoc(Player player, String name, Monster monster){
        this.player = player;
        this.name = name;
        this.monster = monster;
        this.randomObstacle = randomObstacle();

    }


    public  boolean onLocation(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tehlikeli bolgedesin! Canavar sayisi: " + this.randomObstacle + "\nKacmak icin 1 Savasmak icin 2");

        int secim = scanner.nextInt();

        if (secim == 1) {
            System.out.println("Safe House'a yönlendiriliyorsun.");
            location = new SafeHouse(player, player.getName());
            location.onLocation();

        } else if (secim == 2) {
            fight(randomObstacle);
        }
        if(this.player.getInventory().getWater() && this.player.getInventory().getFood() && this.player.getInventory().getFirewood()){
            System.out.println("KAZANDIN!!!");
            System.exit(0);
        }
        return true;
    }

    public abstract void addItem();


    public boolean winner() {
        return this.player.getHealth() != 0;
    }

    public int randomObstacle() {
        random = new Random();
        return random.nextInt(3) + 1;
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
    public void fight(int initialRandomObstacle){
        int originalHealth = this.monster.getHealth();
        int remainingRandomObstacles = initialRandomObstacle;

        while (remainingRandomObstacles != 0) {

            this.monster.setHealth(this.monster.getHealth() - this.player.getDamage());

            if (this.monster.getHealth() == 0) {
                System.out.println("Bir canavari alt ettin!!!");
                System.out.println("Kalan canavar sayisi: " + remainingRandomObstacles);

                this.player.setMoney(this.player.getMoney() + this.monster.getMoney());
                remainingRandomObstacles--;

                if(remainingRandomObstacles == 0){
                    getInventoryPrize();
                    addItem();
                    break;
                }
            }
            this.monster.setHealth(originalHealth);

            int monsterDamage = this.monster.getDamage() - this.player.getInventory().getArmorDefence();
            this.player.setHealth(this.player.getHealth() - monsterDamage);

            if (!winner()) {
                System.out.println("Kaybettin!!! ");
                System.exit(0);
            }
        }
    }
}
