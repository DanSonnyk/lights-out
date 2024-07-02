import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void processCoordinatesScenario01() {
        main.processCoordinates("01");
    }

    @Test
    void processCoordinatesScenario02() {
    }

    @Test
    void processCoordinatesScenario03() {

    }

}