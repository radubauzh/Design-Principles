public class Main_Chief extends Employees {
    public Main_Chief(String name, String surName, int ID, Customers[] customerlist){
        boolean valid = checkInputEmployee(ID);
        if(valid){
            setName(name);
            setSurName(surName);
            setID(ID);
            setCustomerlist(customerlist);
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

    /**
     * downgrading customer from platinum to gold
     * @param customerID id of customer that needs to be downgraded using customer list
     */
    public void downgradePlatinumToGold(int customerID) {
        for (int i = 0; i < getCustomerlist().length; i++) {
            if (getCustomerlist()[i].getID() == customerID && getCustomerlist()[i].getCustomerLevel()=="Platinum customer") {
                getCustomerlist()[i].setCustomerLevel("Golden customer");
            }
        }
    }

    /**
     * downgrading customer from platinum to regular
     * @param customerID id of customer that needs to be downgraded using customer list
     */
    public void downgradePlatinumToRegular(int customerID) {
        for (int i = 0; i < getCustomerlist().length; i++) {
            if (getCustomerlist()[i].getID() == customerID && getCustomerlist()[i].getCustomerLevel()=="Platinum customer") {
                getCustomerlist()[i].setCustomerLevel("Regular customer");
            }
        }
    }


}
