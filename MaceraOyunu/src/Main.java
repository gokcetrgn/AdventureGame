import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Oyuna baslamak icin 1 Oyundan ayrilmak icin 2");

        int secim = scanner.nextInt();
        while(secim == 1){
            game.start();
            secim = scanner.nextInt();
            if(secim == 2){
                System.out.println("Oyun sonlandirildi.");
                break;
            }
        }
        scanner.close();
    }       
}
