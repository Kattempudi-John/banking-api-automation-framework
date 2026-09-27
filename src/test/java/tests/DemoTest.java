package tests;

import org.testng.annotations.Test;
import utilities.TestDataGenarator;

public class DemoTest {
    @Test
    public void verifyGeneratedName() {

        String name =
                TestDataGenarator.genarateName();

        System.out.println("Generated Name: " + name);
    }
}
