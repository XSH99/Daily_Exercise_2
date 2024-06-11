package Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestingClass {



    @BeforeAll
    public static void init(){
        System.out.println("Star before all");
    }

    @org.junit.Test
    @Test
    public void testPerson() {
        String name = "shumukh";
        int age = 23;
        String address = "Riyadh";

        String actual = "Name: " + name + ", Age: " + age + ", Address: " + address;
        String expected = "Name: shumukh, Age: 23, Address: Riyadh";
        Assertions.assertEquals(expected, actual);
    }

}
