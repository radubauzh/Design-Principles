public class EmployeeView {
    public void printEmployeeDetails(String employeeName, String employeeSurName, String employeeAddress, int employeePhone, String employeeID){
        System.out.println("Employee: ");
        System.out.println("Name: " + employeeName);
        System.out.println("Surame: " + employeeSurName);
        System.out.println("Address: " + employeeAddress);
        System.out.println("Phone: " + employeePhone);
        System.out.println("ID: " + employeeID);
    }

    public void printNameSurnameID(String employeeName, String employeeSurName, String employeeID){
        System.out.println("Name: " + employeeName + ", Surname; " + employeeSurName + ", ID: " + employeeID);
    }

    public void printAddress(String employeeAddress){
        System.out.println("Address: " + employeeAddress);
    }

    public void printPhoneNumber(int employeePhone){
        System.out.println("Phone: " + employeePhone);
    }
}


