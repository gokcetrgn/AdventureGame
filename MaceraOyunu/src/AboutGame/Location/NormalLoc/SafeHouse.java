package AboutGame.Location.NormalLoc;

import AboutGame.Characters.Person;

public class SafeHouse extends NormalLoc {
    Person person;
    boolean onLocation;
    
    @Override
    public boolean onLocation(boolean onLocation) {
        return this.onLocation = onLocation;
    }

    public void recover(){
        if(onLocation == true){
            person.setHealth(100);
        }
    }
    public void place(){
        if(onLocation == true){
            System.out.println("Nereye gitmek istersin?");
            System.out.println("1-) Mağaza\nBurada paranla silah ve zirh satin alabilirsin.Gücünü artirmak icin önemlidir.");
            System.out.println("2-) Orman\nZombilere verdigin hasarla ganimet ve 'food' toplayacaksin. Baslangic icin uygundur.");
            System.out.println("3-) Magara\n Vampirlere verdigin hasarla ganimet ve 'firewood' toplayacaksin. Orta seviyedir.");
            System.out.println("4-) Nehir\nAyilara verdigin hasarla ganimet ve 'water' toplayacaksin. Digerlerine göre daha zordur.");
        }
    }
    
}
