import java.util.Scanner;

import AboutGame.Inventory;
import AboutGame.Player;
import AboutGame.Characters.Person;
import AboutGame.Location.BattleLoc.BattleLoc;
import AboutGame.Location.BattleLoc.Cave;
import AboutGame.Location.BattleLoc.Forest;
import AboutGame.Location.BattleLoc.River;
import AboutGame.Location.NormalLoc.SafeHouse;
import AboutGame.Location.NormalLoc.ToolStore;
import AboutGame.Monsters.Bear;
import AboutGame.Monsters.Vampire;
import AboutGame.Monsters.Zombie;

public class Game {
    Person person = new Person();
    Scanner scanner = new Scanner(System.in);
    SafeHouse safeHouse = new SafeHouse();
    BattleLoc battleLoc;
    int monsterNumber;
    Inventory inventory;



    public void start(){
        while(person.getHealth() == 0){
            Player player = new Player();
            System.out.println("Adinizi giriniz: ");
            String name = scanner.nextLine();

            player.setName(name);

            player.selectChar(person);

            person.print();

            System.out.println("Safe Area'da doğdunuz. Unutmayin, burada caniniz her zaman yenilenir.");

            safeHouse.place();

            int yerSecimi = scanner.nextInt();

            if(yerSecimi == 1){
                ToolStore toolStore = new ToolStore();
                toolStore.onLocation(true);

                System.out.println("Menu aktariliyor... ");
                toolStore.menu();

            }else if(yerSecimi == 2){
                
                battleLoc = new Forest(new Zombie());
                battleLoc.onLocation(true);
                monsterNumber = (int) Math.random() * 4;
                battleLoc.cumbat(monsterNumber);
                System.out.println("Odul kazandin! 'Food'");
                inventory.setFood(true);

            }else if(yerSecimi == 3){
                battleLoc = new Cave(new Vampire());
                battleLoc.onLocation(true);
                monsterNumber = (int) Math.random() * 4;
                battleLoc.cumbat(monsterNumber);
                System.out.println("Odul kazandin! 'Firewood'");
                inventory.setFirewood(true);

            }else if(yerSecimi == 4){
                battleLoc = new River(new Bear());
                battleLoc.onLocation(true);
                monsterNumber = (int) Math.random() * 4;
                battleLoc.cumbat(monsterNumber);
                System.out.println("Odul kazandin! 'Water'");
                inventory.setWater(true);

            }
            if(inventory.getFood() == true && inventory.getWater() == true && inventory.getFirewood() == true){
                System.out.println("Bütün ödülleri kazandigin icin oyunu bitirdin! Tebrikler!!!!");
                break;
            }
        }
    }
}
// EKSİKLER
// CANAVARLARIN ÖZELLİKLERİ
// BİR BÖLÜMÜ BİTİRDİKTEN SONRA SAFE HOUSE'A GEÇİŞ SAĞLANMASI
// PARA EKLENMESİ (CANAVARLAR ÖLDÜKTEN SONRA)
// MAĞAZAYA GECİSİN SAĞLANMASİ
// BUNLAR YAPILIRSA TEST KISMI
// HATALARIN GİDERİLMESİ