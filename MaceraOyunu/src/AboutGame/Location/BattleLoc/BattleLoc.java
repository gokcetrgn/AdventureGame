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
    public int chanceNumber(){
        random = new Random();
        return random.nextInt(100);
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
				addItem();
				System.out.println("Food kazandin!" );
                System.out.println(">>>>>>>>>>>>>>>>>");
			}
			case 2 -> {
				addItem();
				System.out.println("Firewood kazandin!" );
                System.out.println(">>>>>>>>>>>>>>>>>>>>");
			}
			case 3 -> {
				addItem();
				System.out.println("Water kazandin! ");
                System.out.println(">>>>>>>>>>>>>>>>>>>>>");
			}
            case 4 -> {
                addItem();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>");
            }
			
		}
	}
    public void fight(int initialRandomObstacle){
        int originalHealth = this.monster.getHealth();
        int remainingRandomObstacles = initialRandomObstacle;
        System.out.println("Mücadeleye hazırlan!");
        System.out.println("Senin sağlığın: " + this.player.getHealth() + "\nCanavarın sağlığı: "+ this.monster.getHealth());
        System.out.println("----------------------------------------------");
        while (remainingRandomObstacles != 0) {
            int chance = chanceNumber();
            System.out.println(chance);
            if(chance < 50){
                this.monster.setHealth(this.monster.getHealth() - (this.player.getDamage()+ this.player.getInventory().getWeaponDamage()));
                System.out.println(this.player.getName() + " vurdu: " + this.player.getDamage());
                System.out.println("Canavarın kalan sağlığı: " + this.monster.getHealth());

                if (this.monster.getHealth() == 0) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Bir canavari alt ettin!!!");
                    this.monster.setHealth(originalHealth);
                    this.player.setMoney(this.player.getMoney() + this.monster.getMoney());
                    System.out.println("--------------------------------------------------");
                    remainingRandomObstacles--;
                    System.out.println("Kalan canavar sayisi: " + remainingRandomObstacles);

                    if(remainingRandomObstacles == 0){
                        getInventoryPrize();
                        break;
                    }
                }
            } else {
                System.out.println(this.monster.getId() + " .Canavar vurdu: " + this.monster.getDamage());

                this.player.setHealth(this.player.getHealth() - this.monster.getDamage());
                System.out.println("Kalan sağlığın: " + this.player.getHealth());

                if (!winner()) {
                    System.out.println("^^^^^^^^^^^^----^^^^^^^^^^^^^");
                    System.out.println("Kaybettin!!! ");
                    System.exit(0);
                }
            }
        }
    }
}
