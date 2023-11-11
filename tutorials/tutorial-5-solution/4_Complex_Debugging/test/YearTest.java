import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YearTest {

    @Test
    void getAllCourses() {
        Year year = new Year();
        Quarter q2 = new Quarter();
        Quarter q3 = new Quarter();

        Course calc = new Course("Calculus", "Calc", "CSE1200");
        Course ads = new Course("Algorithms and Data Structure", "ADS", "CSE1305");
        Course linalg = new Course("Linear Algebra", "LinAlg", "CSE1205");

        q2.addCourse(calc);
        q2.addCourse(ads);
        q3.addCourse(linalg);

        year.setQuarter(0, new Quarter());
        year.setQuarter(1, q2);
        year.setQuarter(2, q3);
        year.setQuarter(3, new Quarter());

        assertEquals(List.of(calc, ads, linalg), year.getAllCourses());
    }

}
