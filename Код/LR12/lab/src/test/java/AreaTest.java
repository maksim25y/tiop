import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import variant14.Area;

import static org.junit.jupiter.api.Assertions.*;

public class AreaTest {

    private static Area area;

    @BeforeAll
    static void setUp() {
        area = new Area(5);
    }

    @Test
    void inArea() {
        assertTrue(area.isPointInArea(0, 0));
        assertTrue(area.isPointInArea(0, 5));
        assertTrue(area.isPointInArea(0, -5));
        assertTrue(area.isPointInArea(-5, 0));
        assertTrue(area.isPointInArea(5, 0));
        assertTrue(area.isPointInArea(-1,1));
        assertTrue(area.isPointInArea(1, -1));
    }

    @Test
    void notInArea() {
        assertFalse(area.isPointInArea(50, 50));
        assertFalse(area.isPointInArea(-5, 5));
        assertFalse(area.isPointInArea(5, -5));
        assertFalse(area.isPointInArea(-4, 1));
    }
}
