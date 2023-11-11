import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityTest {

    @Test
    void getAllMathematicsNames() {
        Year year = new Year();
        Quarter q2 = new Quarter();
        Quarter q3 = new Quarter();

        q2.addCourse(new Course("Calculus", "Calc", "CSE1200"));
        q2.addCourse(new Course("Algorithms and Data Structure", "ADS", "CSE1305"));
        q3.addCourse(new Course("Linear Algebra", "LinAlg", "CSE1205"));

        year.setQuarter(0, new Quarter());
        year.setQuarter(1, q2);
        year.setQuarter(2, q3);
        year.setQuarter(3, new Quarter());

        assertEquals(List.of("Calculus", "Linear Algebra"), UniversityApplication.getAllMathematicsCourseNames(year));
    }

}
