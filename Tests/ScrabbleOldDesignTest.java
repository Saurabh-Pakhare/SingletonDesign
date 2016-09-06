import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by saurabh on 6/9/16.
 */
public class ScrabbleOldDesignTest {
    ScrabbleOldDesign s1;
    ScrabbleOldDesign s2;
    ScrabbleOldDesign s3;

    @Before
    public void setUp() throws Exception {

        s2=ScrabbleOldDesign.getInstance(50);
        // s3=Scrabble.getInstance();
        //s3.getScrabbleLetters();
    }

    @Test
    public void isShouldCheckEqualityOfInstances() throws Exception {

        assertEquals(s2,s3);
    }


    @Test (expected = IllegalArgumentException.class)
    public void itShouldThrowIllegalArgumentException() throws Exception{

        s2=ScrabbleOldDesign.getInstance(5);
    }

    @Test
    public void itShouldSuccessfullyReturnLetters() throws Exception{
        System.out.println("Hurray! Start playing with these letters.");
        System.out.println(s2.getMyList());
        System.out.println(s2.getMyList());


    }

}