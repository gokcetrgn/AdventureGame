package AboutGame.Monsters;


public class Snake extends Monster {
    public static int snakeDamage = (int) (Math.random() * (6-3)) + 4;
    public Snake(){
    super(4,snakeDamage,12,0);
    }
}