import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class JobTest {

    private String streetName;
    private int streetNr;
    private String zipCode;
    private String city;
    private int jobNumber;
    private Address location;
    private String description;
    private List<Equipment> requireEquipment;
    private Date plannedDate;
    private Equipment equipment1;
    private Job job1;

    @BeforeEach
    void setup() {
        streetName = "Spermezeu";
        streetNr = 69;
        zipCode = "420";
        city = "Trebuci";
        location = new Address(streetName, streetNr, zipCode, city);
        jobNumber = 69;
        description = "Da la buci";
        equipment1 = new ConcreteMixer("pula mare");
        requireEquipment = new ArrayList<Equipment>();
        requireEquipment.add(equipment1);
        plannedDate = new Date(69, 69, 420);
        job1 = new Job(location, description, requireEquipment, plannedDate);

    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(location, job1.getLocation());
        assertEquals(description, job1.getDescription());
        assertEquals(requireEquipment, job1.getRequireEquipment());
        assertEquals(plannedDate, job1.getPlannedDate());
    }

    @Test
    void testToString() {
        System.out.println(job1);
    }

    @Test
    void testEquals() {
        Job job2 = new Job(location, description, requireEquipment, plannedDate);
        Job job3 = new Job(new Address("random", 0, "random", "random"), description, requireEquipment, plannedDate);
        Job job4 = new Job(location, description, new ArrayList<>(), plannedDate);
        Job job5 = new Job(location, description, requireEquipment, new Date(0 ,0, 0));
        assertEquals(job1, job1);
        assertEquals(job1, job2);
        assertNotEquals(job1, job3);
        assertNotEquals(job1, job4);
        assertNotEquals(job1, job5);

    }
}