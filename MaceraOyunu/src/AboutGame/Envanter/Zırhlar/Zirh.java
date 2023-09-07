package AboutGame.Envanter.Zırhlar;

public class Zirh {
    private int id;
    private String name;
    private int defence;
    private int money;
    public Zirh(int id,String name, int defence, int money) {
        this.id = id;
        this.name = name;
        this.defence = defence;
        this.money = money;
    }public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDefence() {
        return defence;
    }
    public void setDefence(int defence)
    { this.defence = defence;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    
}
