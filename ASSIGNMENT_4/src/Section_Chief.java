public class Section_Chief extends Employees {
    private String city;

    public Section_Chief(String name, String surName, int ID, Customers[] customerlist, String city){
        boolean valid = checkInputEmployee(ID);
        if(valid){
            setName(name);
            setSurName(surName);
            setID(ID);
            setCustomerlist(customerlist);
            this.city = city;
        }
        else{
            throw new AssertionError();
        }
    }


    /**
     * downgrading customer from gold to regular
     * @param customerID id of customer that needs to be downgraded using customer list
     */
    public void downgradeGoldToRegular(int customerID) {
        for (int i = 0; i < getCustomerlist().length; i++) {
            if (getCustomerlist()[i].getID() == customerID && getCustomerlist()[i].getCustomerLevel()=="Golden customer") {
                getCustomerlist()[i].setCustomerLevel("Regular customer");
            }
        }
    }

    /**
     * upgrading customer from gold to platinum
     * @param customerID id of customer that needs to be upgraded using customer list
     */
    public void upgradeGoldToPlatinum(int customerID) {
        for (int i = 0; i < getCustomerlist().length; i++) {
            if (getCustomerlist()[i].getID() == customerID && getCustomerlist()[i].getCustomerLevel()=="Golden customer") {
                getCustomerlist()[i].setCustomerLevel("Platinum customer");
            }
        }
    }


}
