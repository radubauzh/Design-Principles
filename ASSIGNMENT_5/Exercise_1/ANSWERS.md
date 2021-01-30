
# Software Construction - Assigment 4

- Dubach Rafael (18-755-140)
- Hoffmann Felix (14-591-549)
- Wäspi Raphael (18-918-938)

## Composite
The composite design pattern makes it possible to treat a tree structure.
So we thought that the hierarchy with offices and bakeries fits to this pattern although we think that the potential of this pattern cannot be used in this exercise. 

### Implementation
At the top we find the central office which inherits form abstract class Component. 
Component has a list of all city offices which are in the company. 
To add a city office to this list we implemented a method called add().
The same principal is with all city offices and bakeries.
The Bakeries are the leafs in this pattern.
The inhertitance is important because all lists are in the Component.
If we would create something in the main which would not be allowed, then it will throw an AssertionError!
To guarantee that there is only one CentralOffice, we created this class as a Singleton.


## Decorator
The Decorator Design Pattern allows you to  add capabilities to a class.
In this exercise we have to add up the prices of all toppings and the main menue.
The problem is that we do not know the number of toppings.
For this reason we thought that in this case the usage of the Decorator pattern is very suitable. 

### Implementation
Firstly, we need a abstract class which will be the parent of the decorator.
In our case the class Menue is this parent.
The main products (cake and sandwhich) inherit directly from this abstract class.
All the topping inherit form the Menue class through the Toppings abstract class.
Toppings Class is in our case the Decorator.
With this implementation it is possible to create a menue like this:
    
    Menue b = bak2.getCheese(bak2.getHam(bak2.getTomatoes(bak2.getSandwich())));
We could add an unlimited number of toppings to sandwich or cake, if at the end a main product (sandwich or cake) occurs.
If we would create something in the main which would not be allowed, then it will throw an AssertionError!


## Example for Main

    public class Main {
    public static void main(String args[]){
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