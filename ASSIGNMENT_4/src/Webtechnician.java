public class Webtechnician implements People {


    private String name;
    private String surName;
    private int ID;

    public Webtechnician(String name, String surName, int ID){
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
     *method for website fixing
     */
    public void fixWebsite(){
        // Kai Ahnig wieso mer do try and catch mache mue!!!!
        try {
            Thread.sleep(30000);
            System.out.print("reparations complete");
        } catch (InterruptedException e) {
            System.out.print("reparations complete");
        }

    }

}
