import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RangeTests {

    @Test
    public void testGetSharedRange() {
        Range range1 = new Range(5, 15);
        Range range2 = new Range(15, 20);
        Range range3 = new Range(1, 5);
        Range range4 = new Range(2, 4);

        Range sharedRange1 = range1.getSharedRange(range2);
        assertNotNull(sharedRange1);

        Range sharedRange2 = range1.getSharedRange(range3);
        assertNotNull(sharedRange2);

        Range sharedRange3 = range1.getSharedRange(range4);
        assertNull(sharedRange3);
    }
}
