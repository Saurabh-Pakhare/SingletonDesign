import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by saurabh on 6/9/16.
 */
public class ScrabbleTest {
    Scrabble s1;
    Scrabble s2;
    Scrabble s3;

    @Before
    public void setUp() throws Exception {

        s2=Scrabble.getInstance(4);
        s3=Scrabble.getInstance(10);
        //s3.getScrabbleLetters();
    }

    @Test
    public void isShouldCheckEqualityOfInstances() throws Exception {

        assertEquals(s2,s3);
    }


    @Test (expected = IllegalArgumentException.class)
    public void itShouldThrowIllegalArgumentException() throws Exception{
        //s2.getMyList();
        s2=Scrabble.getInstance(5);
    }

    @Test
    public void itShouldSuccessfullyReturnLetters() throws Exception{
        System.out.println("Hurray! Start playing with these letters.");
        System.out.println(s2.getMyList());

    }

}