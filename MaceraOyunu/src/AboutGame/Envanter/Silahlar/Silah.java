package AboutGame.Envanter.Silahlar;

public class Silah {
    private int id;
    private String name;
    private int damage;
    private int money;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName() {
        if(id == 1){
            this.name = "Tabanca";
        }else if(id == 2){
            this.name = "Kiliç";
        }else if(id == 3){
            this.name = "Tüfek";
        }
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage() {
        if(id == 1){
            this.damage = 2;
        }else if(id == 2){
            this.damage = 3;
        }else if(id == 3){
            this.damage = 7;
        }
    }
    public int getMoney() {
        return money;
    }
    public void setMoney() {
        if(id == 1){
            this.money = 25;
        }else if(id == 2){
            this.money = 35;
        }else if(id == 3){
            this.money = 45;
        }
    }
}
