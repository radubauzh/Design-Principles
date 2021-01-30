import java.util.ArrayList;
import java.util.List;

public class CentralOfficeComposite extends Component {
    //singleton
    private static CentralOfficeComposite uniqueInstance;

    //private because we cannot create a instance outside of this class
    private CentralOfficeComposite (){}

    /**
     * Checks if there is already an instance of this class. If there is not then it creates one --> Singleton
     * @return CentralOffice
     */
    public static CentralOfficeComposite getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new CentralOfficeComposite ();
        }
        return uniqueInstance;
    }


    /**
     * adds a CityOffice to the List or throws a AssertionError
     * @param CityOfficeComposite
     */
    public void add(CityOfficeComposite comp){
        if (addChecker(comp)){
            throw new AssertionError();
        }
        else{
            allOfficesList.add(comp);
        }
    }

    /**
     * prints out all Offices and their bakeries
     */
    public void printAllOffices(){
        for(int i = 0; i<allOfficesList.size(); i++){
            if(i==allOfficesList.size()-1){
                System.out.print(allOfficesList.get(i).getName()+", ");
                allOfficesList.get(i).printAllBakeriesNames(1);
            }
            else{
                System.out.print(allOfficesList.get(i).getName()+", ");
                allOfficesList.get(i).printAllBakeriesNames(0);
            }
        }

    }

    /**
     * makes checks for CityOfficeComposite 
     * @param CityOfficeComposite
     * @return Boolean if it is true it will be an AssertionError later
     */
    private Boolean addChecker(CityOfficeComposite  comp){
        for(int i = 0; i<allOfficesList.size(); i++){
            if (allOfficesList.get(i).getName().equals(comp.getName())){
                return true;
            }
        }
        if (allOfficesList.contains(comp)){
            return true;
        }
        else{
            return false;
        }
    }

}