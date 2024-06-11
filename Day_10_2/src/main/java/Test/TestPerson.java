package Test;

//
////import org.example.Models.Person;
////import org.junit.jupiter.api.*;
//
//import org.junit.jupiter.api.*;
//
//public class TestPerson {
//
//    private Person person;
//
//    @BeforeAll
//    public static void init() {
//        System.out.println("Initializing tests...");
//    }
//
//    @AfterAll
//    public static void clean() {
//        System.out.println("Cleaning up after tests...");
//    }
//
//    @BeforeEach
//    public void createPerson() {
//        person = new Person("John Doe", 30, "123 Main St");
//        System.out.println("Creating person object before each test");
//    }
//
//    @Test
//    public void testPersonCreation() {
//        Assertions.assertEquals("John Doe", person.getName());
//        Assertions.assertEquals(30, person.getAge());
//        Assertions.assertEquals("123 Main St", person.getAddress());
//    }
//
//    @Test
//    public void testAgeValidation() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person("Jane Doe", -1, "456 Elm St"));
//        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person("Jane Doe", 151, "456 Elm St"));
//    }
//
//    @Test
//    public void testToString() {
//        String expected = "Name: John Doe, Age: 30, Address: 123 Main St";
//        Assertions.assertEquals(expected, person.toString());
//    }
//
//    @Test
//    public void testGetDetails() {
//        String expected = "Name: John Doe, Age: 30, Address: 123 Main St";
//        Assertions.assertEquals(expected, person.getDetails());
//    }
//
//    @RepeatedTest(3)
//    public void testRepeated(RepetitionInfo repetitionInfo) {
//        System.out.println("Repetition " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());
//        Assertions.assertTrue(true); // Dummy assertion to demonstrate repeated test
//    }
//}
