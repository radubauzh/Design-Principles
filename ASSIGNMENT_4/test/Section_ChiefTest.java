import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Section_ChiefTest {
    static Customers hole = new Customers("Hole", "Hooolll", 44, 123456, 20000, 1849275, 192837465, 123, "12/21", "Golden customer");
    static Customers sole = new Customers("Sole", "Solllll", 44, 38473874, 15000, 3892034, 192837465, 123, "12/21", "Platinum customer");
    static Customers[] liste = {hole, sole};
    static Section_Chief gallo = new Section_Chief("Gallo", "Rallo", 326371, liste, "Bern");

    /**
     *tests if class can handle wrong parameters when constructing
     */
    @Test
    void invalidClassParameter() {
        Assertions.assertThrows(AssertionError.class, () ->{
            Section_Chief jonas = new Section_Chief("Jonas", "Manfred", 326371, liste, "Zuerich");
        });
    }

    /**
     *tests downgrade from gold to regular
     */
    @Test
    void downgradeGoldToRegular() {
        gallo.downgradeGoldToRegular(hole.getID());
        assertEquals(hole.getCustomerLevel(), "Regular customer");
        gallo.upgradeRegularToGold(hole.getID());
        assertEquals(hole.getCustomerLevel(), "Golden customer");
        gallo.downgradeGoldToRegular(sole.getID());
        assertEquals(sole.getCustomerLevel(), "Platinum customer");
    }

    /**
     *tests upgrade from gold to platinum
     */
    @Test
    void upgradeGoldToPlatinum() {
        assertEquals(hole.getCustomerLevel(), "Golden customer");
        gallo.upgradeGoldToPlatinum(hole.getID());
        assertEquals(hole.getCustomerLevel(), "Platinum customer");

    }
}