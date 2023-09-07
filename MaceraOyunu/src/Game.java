import java.util.Scanner;
import AboutGame.Player;
import AboutGame.Characters.Okcu;
import AboutGame.Characters.Person;
import AboutGame.Characters.Samuray;
import AboutGame.Characters.Sovalye;
import AboutGame.Location.Location;
import AboutGame.Location.BattleLoc.Cave;
import AboutGame.Location.BattleLoc.Forest;
import AboutGame.Location.BattleLoc.River;
import AboutGame.Location.NormalLoc.SafeHouse;
import AboutGame.Location.NormalLoc.ToolStore;


import static java.lang.System.*;

public class Game {

    Person person;
    public String name;
    Location location;
    Player player = new Player();

    public void start(Scanner scanner) {
        out.println("Adinizi giriniz: ");
        String name = scanner.nextLine();

        player.setName(name);

        selectChar(scanner);

        person.print();

    }

    public void selectChar(Scanner scanner) {
            System.out.println("""
                    Girdiğiniz ID'ye göre bir karakter seçilecek.
                    1- Samuray
                    2- Okçu
                    3-Şovalye
                    """);
            int karakterSecimi = scanner.nextInt();
            if (karakterSecimi > 0 && karakterSecimi < 4) {
                switch (karakterSecimi) {
                    case 1 -> {
                        person = new Samuray();
                        player.setId(karakterSecimi);
                        player.setHealth(person.getHealth());
                        player.setDamage(person.getDamage());
                        player.setMoney(person.getMoney());
                        out.println("Artik samuray karakterine sahipsin.");
                    }
                    case 2 -> {
                        person = new Okcu();
                        player.setId(karakterSecimi);
                        player.setHealth(person.getHealth());
                        player.setDamage(person.getDamage());
                        player.setMoney(person.getMoney());
                        out.println("Artik okcu karakterine sahipsin.");
                    }
                    case 3 -> {
                        person = new Sovalye();
                        player.setId(karakterSecimi);
                        player.setHealth(person.getHealth());
                        player.setDamage(person.getDamage());
                        player.setMoney(person.getMoney());
                        out.println("Artik sovalye karakterine sahipsin.");
                    }
                }
            } else {
                out.println("Verilenlere uygun bir islem seciniz.");
            }
        }


    public void printPlace() {

        out.println("Nereye gitmek istersin?");
        out
                .println("1-) Mağaza\nBurada paranla silah ve zirh satin alabilirsin.Gücünü artirmak icin önemlidir.");
        out.println(
                "2-) Orman\nZombilere verdigin hasarla ganimet ve 'food' toplayacaksin. Baslangic icin uygundur.");
        out.println(
                "3-) Magara\n Vampirlere verdigin hasarla ganimet ve 'firewood' toplayacaksin. Orta seviyedir.");
        out.println(
                "4-) Nehir\nAyilara verdigin hasarla ganimet ve 'water' toplayacaksin. Digerlerine göre daha zordur.");
        out.println("5-) Safe House\n Burası güvenli bölge! Can yenilenir.");
        out.println("6-) EXIT");
    }

    public void selectPlace(Scanner scanner) {
        printPlace();
        out.print("Yer seçimin: " );
        int yerSecimi = scanner.nextInt();
        while(true) {
            switch (yerSecimi) {
                case 1 -> {
                    location = new ToolStore(player, name);
                    location.onLocation();
                    out.println("Menu aktariliyor... ");
                    selectPlace(scanner);
                }
                case 2 -> {
                    if (!this.player.getInventory().getFood()) {
                        location = new Forest(player);
                        location.onLocation();
                        out.println("Odul kazandin! 'Food'");
                        selectPlace(scanner);

                    } else {
                        out.println("Envantere sahip oldugun icin bu odaya giremezsin.");
                        selectPlace(scanner);
                    }
                }
                case 3 -> {
                    if (!this.player.getInventory().getFirewood()) {
                        location = new Cave(player);
                        location.onLocation();
                        out.println("Odul kazandin! 'Firewood'");
                        selectPlace(scanner);
                    } else {
                        out.println("Envantere sahip oldugun icin bu odaya giremezsin.");
                        selectPlace(scanner);
                    }
                }
                case 4 -> {
                    if (!this.player.getInventory().getWater()) {
                        location = new River(player);
                        location.onLocation();
                        out.println("Odul kazandin! 'Water'");
                        selectPlace(scanner);
                    } else {
                        out.println("Envantere sahip oldugun icin bu odaya giremezsin.");
                        selectPlace(scanner);
                    }
                }
                case 5 -> {
                    location = new SafeHouse(player,name);
                    location.onLocation();
                    selectPlace(scanner);
                }
                case 6 -> {
                    out.println("Oyundan çikis yaptin.");
                    exit(0);
                }
                default -> {
                    out.println("Gecersiz! Otomatik olarak Safe House'a atandin.");
                    location = new SafeHouse(player,name);
                    location.onLocation();
                    selectPlace(scanner);
                }
            }
        }
    }
}

