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
import AboutGame.Monsters.Bear;
import AboutGame.Monsters.Vampire;
import AboutGame.Monsters.Zombie;

import static java.lang.System.*;

public class Game {

    Person person;
    Location location;
    Player player = new Player();

    public void start() {
        out.println("Adinizi giriniz: ");
        Scanner scanner = new Scanner(in);

        String name = scanner.nextLine();

        player.setName(name);

        selectChar();

        person.print();

    }

    public void selectChar() {
        try (Scanner scanner = new Scanner(System.in)) {
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
        System.out.println("5-) Safe House\n Burası güvenli bölge! Can yenilenir.");
        out.println("6-) EXIT");
    }

    public void selectPlace() {
        try (Scanner scanner = new Scanner(System.in)) {

            int yerSecimi;

        while (true) {
                printPlace();
                yerSecimi = scanner.nextInt();

                switch (yerSecimi) {
                    case 1 -> {
                        ToolStore toolStore = new ToolStore();
                        toolStore.onLocation(true);
                        out.println("Menu aktariliyor... ");
                        toolStore.menu();
                    }
                    case 2 -> {
                        if (!this.player.getInventory().getFood()) {
                            location = new Forest(new Zombie());
                            location.onLocation(true);
                            out.println("Odul kazandin! 'Food'");
                        } else {
                            out.println("Envantere sahip oldugun icin bu odaya giremezsin.");
                        }
                    }
                    case 3 -> {
                        if (!this.player.getInventory().getFirewood()) {
                            location = new Cave(new Vampire());
                            location.onLocation(true);
                            out.println("Odul kazandin! 'Firewood'");
                        } else {
                            out.println("Envantere sahip oldugun icin bu odaya giremezsin.");
                        }
                    }
                    case 4 -> {
                        if (!this.player.getInventory().getWater()) {
                            location = new River(new Bear());
                            location.onLocation(true);
                            out.println("Odul kazandin! 'Water'");
                        } else {
                            out.println("Envantere sahip oldugun icin bu odaya giremezsin.");
                        }
                    }
                    case 5 -> {
                        location = new SafeHouse(player);
                        location.onLocation(true);
                    }
                    case 6 -> {
                        out.println("Oyundan çikis yaptin.");
                        exit(0);
                    }
                    default -> {
                        out.println("Gecersiz! Otomatik olarak Safe House'a atandin.");
                        location = new SafeHouse(player);
                        location.onLocation(true);
                    }
                }
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