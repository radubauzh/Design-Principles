public class MVCPatternDemo {
    public static void main(String[] args) {

        try{
            // part 1
            Employee model  = EmployeeFromDatabase();
            EmployeeView view = new EmployeeView();
            EmployeeController controller = new EmployeeController(model, view);
            // part 2
            controller.printNameSurnameID();

            //update data - part 3
            controller.setEmployeeAddress("Zurich");
            //print part 4
            controller.printAddress();
            //update data - part 5
            controller.setEmployeePhone(666);
            //print part 6
            controller.printPhoneNumber();

        }
        catch (Exception e){
            System.out.println("Model imput invalid");
        }
    }

    private static Employee EmployeeFromDatabase() {
        Employee employee = new Employee();
        employee.setName("Wladimir");
        employee.setSurName("Putin");
        employee.setID("AK47AK47");
        employee.setAddress("Moscow");
        employee.setPhone(420);
        return employee;

    }
}




