package at.fhtw.swen3.persistence.entities;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TruckEntityTest {

    @Test
    void setNumberPlate() {
        TruckEntity truck = new TruckEntity();
        truck.setNumberPlate("77 JVY");
        assertEquals("77 JVY", truck.getNumberPlate());
    }
}
