import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {
    @BeforeEach
    void setup(){
        System.out.println("@BeforeEach executed");

    }
    @Test
    public void TestMinus() {
        System.out.println("======TEST TWO EXECUTED=======");
        //assertEquals( 6 , main.Minus());
    }
}
