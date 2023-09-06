package AboutGame.Location.NormalLoc;

import java.util.Scanner;

import AboutGame.Inventory;
import AboutGame.Player;
import AboutGame.Envanter.Silahlar.Silah;
import AboutGame.Envanter.Zırhlar.Zirh;
import AboutGame.Location.Location;

public class ToolStore extends Location {
    Silah silah = new Silah();
    Zirh zirh = new Zirh();
    boolean location;
    int envanterSecimi;
    int silahSecimi;
    int zirhSecimi;

    Inventory inventory = new Inventory();
    Player player = new Player();
    SafeHouse safeHouse;

    @Override
    public boolean onLocation(boolean location) {
        return this.location = location;

    }

    public void menu() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hos geldin!\n" +
                    " Silah icin 1\n" +
                    "Zirh icin 2\n" +
                    "Cikmak icin 3\n");

            envanterSecimi = scanner.nextInt();
            if (envanterSecimi == 1) {
                System.out.println("Silah ID giriniz:\n " +
                        "1- Tabanca (25)\n" +
                        "2-Kiliç (35)\n" +
                        "3-Tüfek (45)\n");
                silahSecimi = scanner.nextInt();
                buy();

            } else if (envanterSecimi == 2) {
                System.out.println("Zirh ID giriniz:\n " +
                        "1- Hafif (15)\n" +
                        "2-Orta (25)\n" +
                        "3-Agir (40)\n");
                zirhSecimi = scanner.nextInt();
                buy();

            } else if (envanterSecimi == 3) {
                System.out.println("Otomatik olarak safe area'ya isinlaniyorsunuz.");
                onLocation(false);
                safeHouse.onLocation(true);
            } else {
                System.out.println("Yanlis karakter girdiniz.");
            }
        }
    }

    public void buy() {
        if (silahSecimi == 1) {
            silah.setId(silahSecimi);
            player.setMoney(player.getMoney() - silah.getMoney());
            player.setDamage(player.getDamage() + player.getInventory().getWeaponDamage());

        }
        if (zirhSecimi == 1) {
            zirh.setId(zirhSecimi);
            player.setMoney(player.getMoney() - zirh.getMoney());
            player.setDamage(player.getDamage() + player.getInventory().getArmorDefence());
        }

    }

}
