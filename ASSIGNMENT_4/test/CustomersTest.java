import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomersTest {
    static Customers hans = new Customers("Hans", "Meier", 44, 123456, 8000, 789, 192837465, 123, "12/21", "Regular customer");
    static Customers Max = new Customers("Max", "Mueller", 44, 38473874, 8000, 719, 192837465, 123, "12/21", "Regular customer");
    static Customers Tim = new Customers("Tim", "Muster", 12, 69473874, 32000, 454, 792137125, 125, "12/19", "Regular customer");

    /**
     *tests if class can handle wrong parameters when constructing, using different violations
     */
    @Test
    void invalidClassParameter() {
        Assertions.assertThrows(AssertionError.class, () ->{
            Customers willi = new Customers("Willi", "Graf", 150, 837483, 20000, 739, 7382929, 345, "11/23", "Golden Customer");
        });
        Assertions.assertThrows(AssertionError.class, () ->{
            Customers willi = new Customers("Willi", "Graf", 66, 837483, 20000, 789, 7382929, 345, "11/23", "Golden Customer");
        });
        Assertions.assertThrows(AssertionError.class, () ->{
            Customers willi = new Customers("Willi", "Graf", 43, 837483, 20000, 739, 7382929, 345, "11/23", "Golden");
        });
        Assertions.assertThrows(AssertionError.class, () ->{
            Customers willi = new Customers("Willi", "Graf", 33, 837483, 20000, 739, 7382929, 345, "14/23", "Golden Customer");
        });
        Assertions.assertThrows(AssertionError.class, () ->{
            Customers willi = new Customers("Willi", "Graf", 33, 837483, 20000, 739, 7382929, 345, "11/23", "Golden Customer");
        });
    }

    /**
     *tests the checkInputCustomer to see if violations of age, id, expirationDate, customerLevel are correctly recognised as valid or invalid
     */
    @Test
    void checkInputCustomer() {
        assertTrue(hans.checkInputCustomer(34,7891,"10/12", "Regular customer"));

        //ID test
        assertFalse(hans.checkInputCustomer(23, 789,"12/22","Regular customer"));

        //Age test
        assertFalse(hans.checkInputCustomer(-4, 2314,"12/22", "Regular customer"));
        assertFalse(hans.checkInputCustomer(150, 2314,"12/22", "Regular customer"));
        assertTrue(hans.checkInputCustomer(44, 2314,"12/22", "Regular customer"));

        //Expiration Date test
        assertFalse(hans.checkInputCustomer(4, 789342,"1222", "Regular customer"));
        assertTrue(hans.checkInputCustomer(4, 2314,"12/22", "Golden customer"));
        assertTrue(hans.checkInputCustomer(4, 2314,"12/00", "Platinum customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"20/22", "Golden customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"19/22", "Golden customer"));
        assertTrue(hans.checkInputCustomer(4, 2314,"01/27", "Golden customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"13/20", "Golden customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"1B/20", "Golden customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"A3/20", "Golden customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"13/2J", "Golden customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"13/K0", "Golden customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"13L20", "Golden customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"     ", "Golden customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"12/A0", "Golden customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"12/2I", "Golden customer"));

        //customerLevel test
        assertTrue(hans.checkInputCustomer(4, 2314,"12/20", "Golden customer"));
        assertTrue(hans.checkInputCustomer(4, 2314,"12/20", "Regular customer"));
        assertTrue(hans.checkInputCustomer(4, 2314,"12/20", "Platinum customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"12/20", "Platinium customer"));
        assertFalse(hans.checkInputCustomer(4, 2314,"12/20", "Regular"));
        assertFalse(hans.checkInputCustomer(4, 2314,"12/20", "Golden"));
        assertFalse(hans.checkInputCustomer(4, 2314,"12/20", " "));
        assertFalse(hans.checkInputCustomer(4, 2314,"12/20", "Golden customer2"));
    }

    /**
     *tests if credit cards are created correctly
     */
    @Test
    void createCreditCard() {
        //Customers hans = new Customers("Hans", "Meier", 44, 123456, 8000, 769, 192837465, 123, "12/21", "Regular customer");

        CreditCard copyOfHans = new CreditCard("Hans", "Meier", 192837465, 123, "12/21");
        CreditCard randomCard = new CreditCard("Emmy", "Hans", 3213, 987, "03/22");
        assertNotSame(copyOfHans, hans.getC());
        assertEquals(hans.getC().getOwner_name(), copyOfHans.getOwner_name());
        assertEquals(hans.getC().getOwner_surName(), copyOfHans.getOwner_surName());
        assertEquals(hans.getC().getExpirationDate(), copyOfHans.getExpirationDate());
        assertEquals(hans.getC().getSecurityNumber(), copyOfHans.getSecurityNumber());
        assertEquals(hans.getC().getSerialNumber(), copyOfHans.getSerialNumber());


        assertNotEquals(hans.getC().getOwner_name(), randomCard.getOwner_name());
        assertNotEquals(hans.getC().getOwner_surName(), randomCard.getOwner_surName());
        assertNotEquals(hans.getC().getExpirationDate(), randomCard.getExpirationDate());
        assertNotEquals(hans.getC().getSecurityNumber(), randomCard.getSecurityNumber());
        assertNotEquals(hans.getC().getSerialNumber(), randomCard.getSerialNumber());

        assertEquals(hans.getC().getCreditCardType(), "Regular");

    }

    /**
     *tests if customer levels are set correctly
     */
    @Test
    void setCustomerLevel() {
        Customers hans = new Customers("Hans", "Meier", 44, 123456, 8000, 759, 192837465, 123, "12/21", "Regular customer");

        assertEquals(hans.getCustomerLevel(), "Regular customer");
        hans.setCustomerLevel("Golden customer");
        assertEquals(hans.getCustomerLevel(), "Golden customer");
        hans.setCustomerLevel("Platinum customer");
        assertEquals(hans.getCustomerLevel(), "Platinum customer");
        Assertions.assertThrows(AssertionError.class, () ->{
            hans.setCustomerLevel("Platinum");
        });

        hans.setCustomerLevel("Regular customer");

    }


    @Test
    void getName() {
        assertEquals(Max.getName(), "Max");
    }

    @Test
    void getSurName() {
        assertEquals(Max.getSurName(), "Mueller");
    }

    @Test
    void getID() {
        assertEquals(Max.getID(), 719);
    }


    @Test
    void getCustomerLevel() {
        assertEquals(Max.getCustomerLevel(), "Regular customer");
    }

    @Test
    void getAge() {
        assertEquals(Max.getAge(), 44);
    }

    @Test
    void getBankAccountNumber() {
        assertEquals(Max.getBankAccountNumber(), 38473874);
    }

    @Test
    void getSavings() {
        assertEquals(Max.getSavings(), 8000);
    }

    @Test
    void getC() {
        assertEquals(Max.getC().getOwner_name(), "Max");
        assertEquals(Max.getC().getOwner_surName(), "Mueller");
        assertEquals(Max.getC().getSerialNumber(), 192837465);
        assertEquals(Max.getC().getSecurityNumber(), 123);
        assertEquals(Max.getC().getExpirationDate(), "12/21");
    }

    /**
     *tests if depositing works properly, violating negative  or 0 and if adding adds correctly
     */
    @Test
    void depositing() {
        Assertions.assertThrows(AssertionError.class, () ->{
            Max.depositing(-1000);
        });

        Assertions.assertThrows(AssertionError.class, () ->{
            Max.depositing(0);
        });

        Max.depositing(1000);
        assertEquals(Max.getSavings(), 9000);
        Max.withdrawing(1000); // make initial savings 8000 again

    }

    /**
     *tests if withdrawing works properly, violating negative, too big or 0. Also tests a valid withdraw
     */
    @Test
    void withdrawing() {

        Assertions.assertThrows(AssertionError.class, () ->{
            Max.withdrawing(-1000);
        });

        Assertions.assertThrows(AssertionError.class, () ->{
            Max.withdrawing(0);
        });

        Assertions.assertThrows(AssertionError.class, () ->{
            Max.withdrawing(9000);
        });

        Max.withdrawing(1000);
        assertEquals(Max.getSavings(), 7000);
        Max.depositing(1000); // make initial savings 8000 again

    }

    /**
     *tests if transfer works properly, violating negative, too big or 0. Also tests a valid transfer
     */
    @Test
    void bank_transfer() {

        Assertions.assertThrows(AssertionError.class, () ->{
            Max.bank_transfer(-1000);
        });

        Assertions.assertThrows(AssertionError.class, () ->{
            Max.bank_transfer(0);
        });

        Assertions.assertThrows(AssertionError.class, () ->{
            Max.bank_transfer(9000);
        });

        Max.withdrawing(1000);
        assertEquals(Max.getSavings(), 7000);
        Max.depositing(1000); // make initial savings 8000 again
        Max.bank_transfer(4000);
        assertEquals(Max.getSavings(), 4000);
        Max.depositing(4000); // make initial savings 8000 again


    }

    /**
     *tests if payment works properly, violating negative, too big or 0. Also tests a valid payment
     */
    @Test
    void pay_by_card() {

        Assertions.assertThrows(AssertionError.class, () ->{
            Max.pay_by_card(-1000);
        });

        Assertions.assertThrows(AssertionError.class, () ->{
            Max.pay_by_card(3000);
        });

        Assertions.assertThrows(AssertionError.class, () ->{
            Tim.pay_by_card(1000);
        });
        Max.pay_by_card(1000);

    }
}