public class EmployeeController {
    private Employee model;
    private EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view){
        this.model = model;
        this.view = view;
    }

    // setters
    public void setEmployeeName(String name){
        model.setName(name);
    }

    public void setEmployeeSurName(String surName){
        model.setSurName(surName);
    }

    public void setEmployeeID(String ID){
        model.setID(ID);
    }

    public void setEmployeeAddress(String address){
        model.setAddress(address);
    }

    public void setEmployeePhone(int phone){
        model.setPhone(phone);
    }

    // getters
    public String getEmployeeName(){
        return model.getName();
    }

    public String getEmployeeSurName(){
        return model.getSurName();
    }

    public String setEmployeeID(){
        return model.getID();
    }

    public String setEmployeeAddress(){
        return model.getAddress();
    }

    public int setEmployeePhone(){
        return model.getPhone();
    }

    public void updateView() {
        view.printEmployeeDetails(model.getName(), model.getSurName(), model.getAddress(), model.getPhone(), model.getID());
    }

    public void printNameSurnameID() {
        view.printEmployeeDetails(model.getName(), model.getSurName(), model.getAddress(), model.getPhone(), model.getID());
    }

    public void printAddress() {
        view.printEmployeeDetails(model.getName(), model.getSurName(), model.getAddress(), model.getPhone(), model.getID());
    }

    public void printPhoneNumber() {
        view.printEmployeeDetails(model.getName(), model.getSurName(), model.getAddress(), model.getPhone(), model.getID());
    }
}

