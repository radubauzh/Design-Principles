import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Main_ChiefTest {
    static Customers a = new Customers("Anna", "Maria", 34, 334, 30000, 7292, 8292, 7888, "12/22", "Golden customer");
    static Customers b = new Customers("Berni", "Hoho", 34, 8293, 40000, 1263900, 344,234, "12/22", "Platinum customer");
    static Customers[] listeee = {a,b};
    static Main_Chief c = new Main_Chief("Chefe", "Barti", 739255, listeee);

    /**
     *tests if class can handle wrong parameters when constructing
     */
    @Test
    void invalidClassParameter(){
        Assertions.assertThrows(AssertionError.class, () ->{
            Main_Chief jounas = new Main_Chief("Jonas", "Manfred", 739255, listeee);
        });
    }

    /**
     *tests downgrade from gold to regular
     */
    @Test
    void downgradeGoldToRegular() {
        c.downgradeGoldToRegular(a.getID());
        assertEquals(a.getCustomerLevel(),"Regular customer");
        c.upgradeRegularToGold(a.getID());
    }

    /**
     *tests upgrade from gold to platinum
     */
    @Test
    void upgradeGoldToPlatinum() {
        c.upgradeGoldToPlatinum(a.getID());
        assertEquals(a.getCustomerLevel(), "Platinum customer");
    }

    /**
     *tests downgrade from platinum to gold
     */
    @Test
    void downgradePlatinumToGold() {
        c.downgradePlatinumToGold(a.getID());
        assertEquals(a.getCustomerLevel(), "Golden customer");
    }

    /**
     *tests downgrade from platinum to regular
     */
    @Test
    void downgradePlatinumToRegular() {
        c.downgradePlatinumToRegular(b.getID());
        assertEquals(b.getCustomerLevel(), "Regular customer");
    }
}