package AboutGame.Location.NormalLoc;

import java.util.Scanner;

import AboutGame.Envanter.Silahlar.Kılıç;
import AboutGame.Envanter.Silahlar.Tabanca;
import AboutGame.Envanter.Silahlar.Tufek;
import AboutGame.Envanter.Zırhlar.Agir;
import AboutGame.Envanter.Zırhlar.Hafif;
import AboutGame.Envanter.Zırhlar.Orta;
import AboutGame.Inventory;
import AboutGame.Player;
import AboutGame.Envanter.Silahlar.Silah;
import AboutGame.Envanter.Zırhlar.Zirh;
import AboutGame.Location.Location;

public class ToolStore extends Location {
    Silah silah;
    Zirh zirh;
    int envanterSecimi;
    int silahSecimi;
    int zirhSecimi;

    public ToolStore(Player player, String name) {
        super(player, name);
    }
    @Override
    public boolean onLocation() {
        menu(new Scanner(System.in));
        return true;

    }

    public void menu(Scanner scanner) {
        System.out.print("Hos geldin!\nSilah icin 1\nZirh icin 2\n");

            envanterSecimi = scanner.nextInt();
            if (envanterSecimi == 1) {
                System.out.printf("Silah ID giriniz:\n 1- Tabanca (25)\n2-Kiliç (35)\n3-Tüfek (45)\n%n");
                silahSecimi = scanner.nextInt();
                if(silahSecimi == 1){
                    buyGun(new Tabanca());
                }else if(silahSecimi == 2){
                    buyGun(new Kılıç());
                }else if(silahSecimi == 3){
                    buyGun(new Tufek());
                }

            } else if (envanterSecimi == 2) {
                System.out.printf("Zirh ID giriniz:\n1- Hafif (15)\n2-Orta (25)\n3-Agir (40)\n%n");
                zirhSecimi = scanner.nextInt();
                if(zirhSecimi == 1){
                    buyArmor(new Hafif());
                }else if(zirhSecimi == 2){
                    buyArmor(new Orta());
                }else if(zirhSecimi == 3){
                    buyArmor(new Agir());
                }
            }
             else {
                System.out.println("Yanlis karakter girdiniz.");
            }
        }


    public void buyGun(Silah silah) {
            if (this.player.getMoney() >= silah.getMoney()) {
                player.setMoney(player.getMoney() - silah.getMoney());
                System.out.println("Paraniz: " + player.getMoney());
                this.player.getInventory().setWeaponDamage(silah.getDamage());
                this.player.getInventory().setWeaponName(silah.getName());
                this.player.setDamage(this.player.getDamage() + silah.getDamage());
                player.setDamage(player.getDamage() + player.getInventory().getWeaponDamage());

        }else{
                System.out.println("Yeterli paran yok.");
            }
    }
    public void buyArmor(Zirh zirh){
            if(this.player.getMoney() >= zirh.getMoney()){
                this.player.setMoney(this.player.getMoney() - zirh.getMoney());
                System.out.println("Paraniz: " + this.player.getMoney());
                this.player.getInventory().setWeaponDamage(zirh.getDefence());
                this.player.getInventory().setWeaponName(zirh.getName());
                this.player.setDamage(this.player.getDamage() + zirh.getDefence());
                player.setDamage(player.getDamage() + player.getInventory().getArmorDefence());
        }else{
                System.out.println("Yeterli paran yok.");
            }
    }
}
