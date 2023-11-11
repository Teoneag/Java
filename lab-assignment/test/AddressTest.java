import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    private String streetName;
    private int streetNr;
    private String zipCode;
    private String city;
    private Address address1;

    @BeforeEach
    void setup() {
        streetName = "Spermezeu";
        streetNr = 69;
        zipCode = "420";
        city = "Trebuci";
        address1 = new Address(streetName, streetNr, zipCode, city);
    }

    @Test
    void constructorAndGettersTest() {
        assertEquals(streetName, address1.street());
        assertEquals(streetNr, address1.number());
        assertEquals(zipCode, address1.zipCode());
        assertEquals(city, address1.city());
    }


    @Test
    void testToString() {
        assertEquals("Address{street='Spermezeu', number=69, zipCode='420', city='Trebuci'}", address1.toString());
    }


    @Test
    void testEquals() {
        Address address2 = new Address(streetName, streetNr, zipCode, city);
        Address address3 = new Address("Random", streetNr, zipCode, city);
        Address address4 = new Address(streetName, 0, zipCode, city);
        Address address5 = new Address(streetName, streetNr, "random", city);
        Address address6 = new Address(streetName, streetNr, zipCode, "random");
        assertEquals(address1, address1);
        assertEquals(address1, address2);
        assertNotEquals(address1, null);
        assertNotEquals(address1, address3);
        assertNotEquals(address1, address4);
        assertNotEquals(address1, address5);
        assertNotEquals(address1, address6);
    }

    @Test
    void testHashCode() {
    }
}