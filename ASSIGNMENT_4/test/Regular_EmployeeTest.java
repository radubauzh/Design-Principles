import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Regular_EmployeeTest {

    static Customers hans = new Customers("Hans", "Meier", 44, 123456, 8000, 23244567, 192837465, 123, "12/21", "Regular customer");
    static Customers Max = new Customers("Max", "Mueller", 44, 38473874, 8000, 2355648, 192837465, 123, "12/21", "Regular customer");
    static Customers[] liste = {hans, Max};
    static Regular_Employee tim = new Regular_Employee("Tim", "Keller", 245252, liste);

    /**
     *tests if class can handle wrong parameters when constructing
     */
    @Test
    void invalidClassParameter() {
        Assertions.assertThrows(AssertionError.class, () ->{
            Regular_Employee jonas = new Regular_Employee("Jonas", "Manfred", 245252, liste);
        });

    }

}