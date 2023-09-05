package AboutGame.Envanter.Zırhlar;

public class Zirh {
    private int id;
    private String name;
    private int defence;
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
            this.name = "Hafif";
        }else if(id == 2){
            this.name = "Orta";
        }else if(id == 3){
            this.name = "Ağir";
        }
    }
    public int getDefence() {
        return defence;
    }
    public void setDefence() {
        if(id == 1){
            this.defence = 1;
        }else if(id == 2){
            this.defence = 3;
        }else if(id == 3){
            this.defence = 5;
        }
    }
    public int getMoney() {
        return money;
    }
    public void setMoney() {
        if(id == 1){
            this.money = 15;
        }else if(id == 2){
            this.money = 25;
        }else if(id == 3){
            this.money = 40;
        }
    }

    
}
