import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BackendtechnicianTest {

    static Backendtechnician Mike = new Backendtechnician("Mike", "Meier", 23);

    /**
     *tests if class can handle wrong parameters when constructing
     */
    @Test
    void invalidClassParameter() {
        Assertions.assertThrows(AssertionError.class, () ->{
            Backendtechnician goris = new Backendtechnician("Grois", "Jonson", 23);
        });
    }

    @Test
    void getName() {
        assertEquals(Mike.getName(), "Mike");
    }

    @Test
    void getSurName() {
        assertEquals(Mike.getSurName(), "Meier");
    }

    @Test
    void getID() {
        assertEquals(Mike.getID(), 23);
    }

    /**
     *simulates fixing of website and, additionally, if error is handled correctly
     */
    @Test
    void fixBackend() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Mike.fixBackend(Mike.getID());
        String expectedOutput = "fixed!";
        assertEquals(expectedOutput, outContent.toString());

        Assertions.assertThrows(AssertionError.class, () ->{
            Mike.fixBackend(123452);
        });

    }
}


