import java.util.ArrayList;
import java.util.List;

public abstract class BakeriesLeaf extends Component {
    private String name;
    private String address;
    private int postalCode;
    private String city;


    public BakeriesLeaf(String name, String address, int postalCode, String city){
        if(bakNames.contains(name)){
            throw new AssertionError();
        }
        this.name = name;
        bakNames.add(name);
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
    }

    //getters
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public int getPostalCode(){
        return postalCode;
    }
    public String getCity(){
        return city;
    }
    public List<String> getBakNames() {
        return bakNames;
    }

    /**
     * prints the name of the bakery
     */
    public void printName(){
        System.out.println(name);
    }
}