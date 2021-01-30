import java.util.ArrayList;
import java.util.List;

public class CityOfficeComposite extends Component{
    private String name;
    //private List<Bakeries> allBakeriesInCityList = new ArrayList<Bakeries>();

    public CityOfficeComposite(String name){
        this.name = name;
    }

    /**
     * adds a Bakery to the List or throws a AssertionError
     * @param BakeriesLeaf
     */
    public void add(BakeriesLeaf bak){
        if (addChecker(bak)){
            throw new AssertionError();
        }
        else{
            allBakeriesInCityList.add(bak);
        }
    }

    /**
     * prints out all Bakeries
     */
    public void printAllBakeriesNames(int a){
        if (a==1){
            for (int i = 0; i<allBakeriesInCityList.size(); i++){
                if (i==allBakeriesInCityList.size()-1){
                    System.out.println(allBakeriesInCityList.get(i).getName());
                }
                else{
                    System.out.print(allBakeriesInCityList.get(i).getName() + ", ");
                }
            }
        }
        else{
            for (int i = 0; i<allBakeriesInCityList.size(); i++){
                System.out.print(allBakeriesInCityList.get(i).getName() + ", ");
            }
        }
    }

    /**
     * gives the name of this class
     * @return String
     */
    public String getName(){
        return name;
    }

    /**
     * makes checks for the Bakery
     * @param BakeriesLeaf
     * @return Boolean if it is true it will be an AssertionError later
     */
    private Boolean addChecker(BakeriesLeaf bak){
        if(allBakeriesInCityList.isEmpty()){
            return false;
        }
        else if (allBakeriesInCityList.get(0).getCity().equals(bak.getCity())){
            return false;
        }
        else{
            return true;
        }

    }


}