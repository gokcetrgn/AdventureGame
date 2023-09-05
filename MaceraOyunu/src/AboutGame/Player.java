package AboutGame;

import java.util.Scanner;

import AboutGame.Characters.Person;

public class Player {

    private String name;
    Person person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void selectChar(Person person){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Girdiğiniz ID'ye göre\n" +
            "1- Samuray\n" +
            "2- Okçu\n" +
            "3-Şovalye\n"
            );
            int karakterSecimi = scanner.nextInt();
            if(karakterSecimi > 0 && karakterSecimi < 4){
                switch (karakterSecimi){
                    case 1:
                    person.setId(1);
                    person.setHealth(18);
                    person.setDamage(5);
                    person.setMoney(15);
                    
                    break;
                    case 2:
                    person.setId(2);
                    person.setHealth(21);
                    person.setDamage(7);
                    person.setMoney(20);
                    break;
                    case 3:
                    person.setId(3);
                    person.setHealth(24);
                    person.setDamage(8);
                    person.setMoney(5);
                    break;
                }
     }
     else{
            System.out.println("Verilenlere uygun bir islem seciniz.");
     }
        }
    }
}
