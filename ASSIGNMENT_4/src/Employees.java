public abstract class Employees implements People {

    private String name;
    private String surName;
    private int ID;
    private Customers[] customerlist;

    //Checker
    //VLLT NO CUSTOMERLIST CHEKE LOH! Denn aber bide technician en separate test mache UND in People public boolean checkInputEmployee();
    // ifuehere UND static wegloh!
    /**
     * checks if customer id is not used yet
     * @param id of customer to be created
     * @return boolean that says if id is not used yet
     */
    public static boolean checkInputEmployee(int id){
        if(idList.contains(id)){
            return false;
        }
        else{
            return true;
        }
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public void setID(int ID) {
        this.ID = ID;
        idList.add(ID); //adding the id to the list

    }
    public void setCustomerlist(Customers[] customerlist) {
        this.customerlist = customerlist;
    }

    //Getter
    public String getName(){
        return name;
    }
    public String getSurName(){
        return surName;
    }
    public int getID(){
        return ID;
    }
    public Customers[] getCustomerlist() {
        return customerlist;
    }

    /**
     * upgrading customer from regular to gold
     * @param customerID id of customer that needs to be upgraded using customer list
     */
    public void upgradeRegularToGold(int customerID){
        for (int i=0; i < customerlist.length; i++){
            if (customerlist[i].getID()==customerID && customerlist[i].getCustomerLevel()=="Regular customer"){
                customerlist[i].setCustomerLevel("Golden customer");
            }
        }

    }
}