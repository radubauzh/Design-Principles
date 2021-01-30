public class Employee {

    private String name;
    private String surName;
    private String ID;
    private String address;
    private int phone;

    //setters

    public void setName(String name) {
        this.name = name;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }

    // ungenau in der Fragestellung
    public void setID(String ID) {
        if (ID.length() == 8) {
            this.ID = ID;
        } else {
            throw new AssertionError("idk what we should do here");

        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }


    //getters

    public String getName(){
        return name;
    }
    public String getSurName(){
        return surName;
    }
    // int + str, 8 chars
    public String getID(){
        return ID;
    }

    public String getAddress(){
        return address;
    }

    public int getPhone(){
        return phone;
    }

}
