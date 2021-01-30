import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    static Vehicle mini = new MicroCar();
    static Customer ueli = new Customer();
    static Vehicle family = new FamilyCar();


    /**
     * tests if a ride gives the right output and can handle null
     *
     */
    @Test
    void ride() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ueli.ride(mini);
        String expectedOutput = "Micro Car; 1 small luggage; normal speed; 12 CHF/h\n";
        assertEquals(expectedOutput, outContent.toString());


        Assertions.assertThrows(AssertionError.class, () ->{
             ueli.ride(null);
        });


        ByteArrayOutputStream outContentF = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContentF));
        ueli.ride(family);
        String expectedOutputF = "Family Car; 2 small and 2 large bags; normal speed; 15 CHF/h\n";
        assertEquals(expectedOutputF, outContentF.toString());
    }
}