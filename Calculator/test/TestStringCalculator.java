import org.junit.*;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class TestStringCalculator {

    private StringCalculator calc;
    private Random rand;

    @Before
    public void setUp() throws Exception {
        calc = new StringCalculator();
        rand = new Random();
    }

    @Test
    public void testEmptyCalculator() throws Exception {
        assertTrue(calc.isEmpty());
    }

    @Test
    public void testEmptyAdd() throws Exception {
        assertEquals(0, calc.add(""));
    }

    @Test
    public void testAddOne() throws Exception {
        assertEquals(1, calc.add("1"));
    }

    @Test
    public void testAddTwo() throws Exception {
        assertEquals(3, calc.add("1,2"));
    }

    @Test
    public void testAddMultiple() throws Exception {
        for (int ii = 0; ii < 1000; ii++) {
            StringBuilder request = new StringBuilder();
            int sum = 0;
            for (int jj = 0; jj <= ii; jj++) {
                int val = rand.nextInt(100000);
                request.append(val).append(",");
                sum+= val;
            }
            assertEquals(sum, calc.add(request.substring(0, request.length() - 1)));
        }
    }

    @Test
    public void testAddWithNewLineSeparator() throws Exception {
        assertEquals(6, calc.add("1,2\n3"));
    }

    @Test
    public void testAddMultipleWithDifferentSeparators() throws Exception {
        for (int ii = 0; ii < 1000; ii++) {
            StringBuilder request = new StringBuilder();
            int sum = 0;
            for (int jj = 0; jj <= ii; jj++) {
                int val = rand.nextInt(100000);
                request.append(val);
                sum+= val;
                if (jj != ii) {
                    if (rand.nextBoolean()) {
                        request.append(",");
                    } else {
                        request.append("\n");
                    }
                }
            }
            assertEquals(sum, calc.add(request.toString()));
        }
    }

    @Test (expected = RuntimeException.class)
    public void testOneNegativeNumber() throws Exception {
        calc.add("-1");
    }

    @Test
    public void testAddMultipleWithDifferentSeparatorsAndNegatives() throws Exception {
        for (int ii = 100; ii < 1000; ii++) {
            try {
                singleTestOfNegativesInList(ii);
            } catch (Exception e) {
                assertEquals(RuntimeException.class, e.getClass());
            }

        }
    }

    private void singleTestOfNegativesInList(int ii) {
        StringBuilder request = new StringBuilder();
        int sum = 0;
        for (int jj = 100; jj <= ii; jj++) {
            int val = rand.nextInt(100000);
            if (rand.nextBoolean()) {
                val = val * -1;
            }
            request.append(val);
            sum += val;
            if (jj != ii) {
                if (rand.nextBoolean()) {
                    request.append(",");
                } else {
                    request.append("\n");
                }
            }

        }
        assertEquals(sum, calc.add(request.toString()));
    }
}
