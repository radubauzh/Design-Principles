public class Main {
    public static void main(String args[]){
        //Example
        //CentralOffice co = CentralOffice.getInstance();
        CentralOfficeComposite co = CentralOfficeComposite.getInstance();
        CityOfficeComposite sg = new CityOfficeComposite("city office of St. Gallen");
        CityOfficeComposite zh = new CityOfficeComposite("city office of Zurich");
        NormalBakeries bak1 = new NormalBakeries("Bakery Crunchy Norm", "Holestreet 12", 9000, "St. Gallen");
        BreadBakeries bak2 = new BreadBakeries("Bakery Crunchy Bread", "Herestreet 23", 9000, "St. Gallen");
        SweetBakeries bak3 = new SweetBakeries("Bakery Sweety", "Langstreet 1", 8000, "Zurich");

        co.add(sg);
        co.add(zh);
        sg.add(bak1);
        sg.add(bak2);
        zh.add(bak3);

        co.printAllOffices();

        //Part 2:
        Menue a = bak3.getChocolate(bak3.getCream(bak3.getChocolate(bak3.getCake())));
        System.out.println(a.getPrice());
        Menue b = bak2.getCheese(bak2.getHam(bak2.getTomatoes(bak2.getSandwich())));
        System.out.println(b.getPrice());

        // Part 3:
        Menue c = bak1.getCheese(bak2.getTomatoes(bak1.getHam(bak1.getSandwich()))); //sollte Fehler kommen?
        System.out.println(c.getPrice());


    }
}