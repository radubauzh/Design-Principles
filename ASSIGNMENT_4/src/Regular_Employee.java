public class Regular_Employee extends Employees {
    public Regular_Employee(String name, String surName, int ID, Customers[] customerlist){
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
}
