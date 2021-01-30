import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {

    static Customers hans = new Customers("Hans", "Meier", 44, 123456, 8000, 323242, 192837465, 123, "12/21", "Regular customer");
    static Customers Max = new Customers("Max", "Mueller", 44, 38473874, 8000, 432424, 192837465, 123, "12/21", "Platinum customer");
    static Customers nlister = new Customers("Nlister", "Rister", 22, 38473874, 8000, 777, 192837465, 123, "12/21", "Regular customer");
    static Customers[] liste = {hans, Max};
    static Regular_Employee tim = new Regular_Employee("Tim", "Keller", 122341, liste);

    /**
     *tests if class can handle ids without crashing but instead returning booleans
     */
    @Test
    void checkInputEmployee() {
        assertTrue(Employees.checkInputEmployee(74829));
        assertFalse(Employees.checkInputEmployee(122341));
    }

    @Test
    void setName() {
        tim.setName("Kim");
        assertEquals(tim.getName(), "Kim");
        tim.setName("Tim");
    }

    @Test
    void setSurName() {
        tim.setSurName("Leller");
        assertEquals(tim.getSurName(), "Leller");
        tim.setSurName("Keller");
    }

    @Test
    void setID() {
        tim.setID(1223411);
        assertEquals(tim.getID(), 1223411);
        tim.setID(122341);
    }

    @Test
    void setCustomerlist() {
        assertEquals(tim.getCustomerlist().length, 2);
        Customers[] liste2 = {hans};
        tim.setCustomerlist(liste2);
        assertEquals(tim.getCustomerlist().length, 1);
        tim.setCustomerlist(liste);
    }

    @Test
    void getName() {
        assertEquals(tim.getName(), "Tim");
    }

    @Test
    void getSurName() {
        assertEquals(tim.getSurName(), "Keller");

    }

    @Test
    void getID() {
        assertEquals(tim.getID(), 122341);
    }

    @Test
    void getCustomerlist() {
        assertEquals(tim.getCustomerlist(), liste);
    }

    /**
     *tests upgrade from regular to gold
     */
    @Test
    void upgradeRegularToGold() {
        tim.upgradeRegularToGold(hans.getID());
        assertEquals(hans.getCustomerLevel(), "Golden customer");
        tim.upgradeRegularToGold(nlister.getID());
        assertEquals(nlister.getCustomerLevel(), "Regular customer"); //Not in his customer list
        tim.upgradeRegularToGold(Max.getID());
        assertEquals(Max.getCustomerLevel(), "Platinum customer");


    }
}