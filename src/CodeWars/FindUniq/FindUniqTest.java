package CodeWars.FindUniq;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindUniqTest {

    @Test
    public void sampleTestCases() {
        double precision = 0.0000000000001;
        assertEquals(1.0, FindTheUniqueNumber.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, FindTheUniqueNumber.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }
}
