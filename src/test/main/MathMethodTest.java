package test.main;

import static org.junit.Assert.*;

import main.MathMethod;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * MathMethod Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 1, 2017</pre>
 */
public class MathMethodTest {
    MathMethod math = new MathMethod();

    @Before
    public void before() throws Exception {
        math.clear();
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: add(int s)
     */
    @Test
    public void testAdd() throws Exception {
        math.add(3);
        math.add(2);
        assertEquals(5,math.getResult());
    }

    /**
     * Method: minus(int s)
     */
    @Test(timeout = 1000)
    public void testMinus() throws Exception {
        math.add(10);
        math.minus(2);
        assertEquals(8,math.getResult());
    }

    /**
     * Method: time(int s)
     */
    @Ignore("Not yet implement")
    @Test
    public void testTime() throws Exception {

    }

    /**
     * Method: divide(int s)
     */
    @Test
    public void testDivide() throws Exception {
        math.add(10);
        math.divide(2);
        assertEquals(5,math.getResult());
    }

    /**
     * Method: getResult()
     */
    @Test
    public void testGetResult() throws Exception {
    }


} 
