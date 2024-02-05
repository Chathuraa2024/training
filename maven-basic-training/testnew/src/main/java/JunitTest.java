import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class JunitTest {

    @Test
    void testSquare() {
        SquareOfIntiger squareOfIntiger = new SquareOfIntiger();
        assertEquals(25,squareOfIntiger.square(1));
        assertEquals(0,squareOfIntiger.square(3));
        assertEquals(144,squareOfIntiger.square(12));

    }
}
