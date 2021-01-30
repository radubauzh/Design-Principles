import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WebtechnicianTest {

    static Webtechnician giorgio = new Webtechnician("Giorgio", "Hosa", 74201451);

    /**
     *tests if class can handle wrong parameters when constructing
     */
    @Test
    void invalidClassParameter() {
        Assertions.assertThrows(AssertionError.class, () ->{
            Webtechnician boris = new Webtechnician("Boris", "Jonson", 74201451);
        });
    }

    @Test
    void getName() {
        assertEquals(giorgio.getName(),"Giorgio");
    }

    @Test
    void getSurName() {
        assertEquals(giorgio.getSurName(), "Hosa");
    }

    @Test
    void getID() {
        assertEquals(giorgio.getID(), 74201451);
    }


    /**
     *simulates website fixing and compares return of fixWebsite() with string
     */
    @Test
    void fixWebsite() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        giorgio.fixWebsite();
        String expectedOutput = "reparations complete";
        assertEquals(expectedOutput, outContent.toString());
    }
}