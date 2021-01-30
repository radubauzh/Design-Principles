public class Backendtechnician implements People{

    private String name;
    private String surName;
    private int ID;

    public Backendtechnician(String name, String surName, int ID){
        boolean valid = Employees.checkInputEmployee(ID);
        if(valid){
            this.name = name;
            this.surName = surName;
            this.ID = ID;
            idList.add(ID); //adding the id to the list
        }
        else{
            throw new AssertionError();
        }
    }

    public String getName(){
        return name;
    }
    public String getSurName(){
        return surName;
    }
    public int getID(){
        return ID;
    }

    /**
     * fixing backend
     * @param TechnicianID id of technician to be fixed
     */
    public void fixBackend(int TechnicianID){
        if (TechnicianID==ID){
            System.out.print("fixed!");
        }
        else{
            throw new AssertionError();
        }
    }


}
