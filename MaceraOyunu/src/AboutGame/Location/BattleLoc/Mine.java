package AboutGame.Location.BattleLoc;

import AboutGame.Envanter.Silahlar.Kılıç;
import AboutGame.Envanter.Silahlar.Silah;
import AboutGame.Envanter.Silahlar.Tabanca;
import AboutGame.Envanter.Silahlar.Tufek;
import AboutGame.Envanter.Zırhlar.Agir;
import AboutGame.Envanter.Zırhlar.Hafif;
import AboutGame.Envanter.Zırhlar.Orta;
import AboutGame.Envanter.Zırhlar.Zirh;
import AboutGame.Monsters.Snake;
import AboutGame.Player;

import java.util.Random;

public class Mine extends  BattleLoc{
    Silah silah;
    Zirh zirh;
    int chance;
    Random random;

    public Mine(Player player) {
        super(player, "Maden", new Snake());
    }

    public int chanceNumber(){
        random = new Random();
        return random.nextInt(100);
    }
    @Override
    public void addItem() {
        chance = chanceNumber();
        if(chance <= 15){
            int chanceTwo = chanceNumber();
            if(chanceTwo >= 50){
                silah  = new Tabanca();
                this.player.getInventory().setWeaponDamage(silah.getDamage());
                this.player.setDamage(this.player.getDamage() + silah.getDamage());
                System.out.println("Tabanca kazandin.");
            }
            else if(chanceTwo >= 15 && chanceTwo <=30){
                silah  = new Kılıç();
                this.player.getInventory().setWeaponDamage(silah.getDamage());
                this.player.setDamage(this.player.getDamage() + silah.getDamage());
                System.out.println("Kılıç kazandin.");
            }
            else if(chanceTwo <= 15){
                silah  = new Tufek();
                this.player.getInventory().setWeaponDamage(silah.getDamage());
                this.player.setDamage(this.player.getDamage() + silah.getDamage());
                System.out.println("Tufek kazandin.");
            }
        }else if(chance >= 15 && chance <= 30){
            int chanceTwo = chanceNumber();
            if(chanceTwo >= 50){
                zirh  = new Hafif();
                this.player.getInventory().setArmorDefence(zirh.getDefence());
                this.player.setDamage(this.player.getDamage() + zirh.getDefence());
                System.out.println("Hafif zırh kazandin.");
            }
            else if(chanceTwo >= 15 && chanceTwo <=30){
                zirh  = new Orta();
                this.player.getInventory().setArmorDefence(zirh.getDefence());
                this.player.setDamage(this.player.getDamage() + zirh.getDefence());
                System.out.println("Orta zırh kazandin.");
            }
            else if(chanceTwo <= 15){
                zirh  = new Agir();
                this.player.getInventory().setArmorDefence(zirh.getDefence());
                this.player.setDamage(this.player.getDamage() + zirh.getDefence());
                System.out.println("Ağır zırh kazandin.");
            }
        }if(chance >= 30 && chance <= 75){
            int chanceTwo = chanceNumber();
            if(chanceTwo >= 50){
                this.player.setMoney(this.player.getMoney() + 1);
                System.out.println("1 adet para kazandin.");
            }
            else if(chanceTwo >= 15 && chanceTwo <=30){
                this.player.setMoney(this.player.getMoney() + 3);
                System.out.println("1 adet para kazandin.");
            }
            else if(chanceTwo <= 15){
                this.player.setMoney(this.player.getMoney() + 5);
                System.out.println("1 adet para kazandin.");
            }
        }else{
            System.out.println("Maalesef herhangi bir şey kazanamadın.");
        }
    }
}
