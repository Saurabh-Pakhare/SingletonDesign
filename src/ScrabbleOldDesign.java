import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by saurabh on 6/9/16.
 */
public class ScrabbleOldDesign {

    private static ScrabbleOldDesign instance = null;
    private static List<Character> list;
    private static final int MAX_LETTERS_IN_BOX = 50;

    private static List userList;


    private ScrabbleOldDesign() {
        list = new LinkedList();
        instance.populateList();
    }

    public static synchronized ScrabbleOldDesign getInstance(int requiredLetters) {
        if (instance == null) {
            synchronized (ScrabbleOldDesign.class) {
                if (instance == null) {
                    instance = new ScrabbleOldDesign();
                }
            }
        }

        userList = getScrabbleLetters(requiredLetters);
        return instance;

    }


    private static void populateList() {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random random = new Random();
        for (int i = 0; i < MAX_LETTERS_IN_BOX; i++) {
            list.add(alphabets.charAt(random.nextInt(26)));
        }
    }


    private static List getScrabbleLetters(int requiredLetters) {
        List myScrabbleList = new ArrayList();
        Random random = new Random();

        if (requiredLetters > list.size()) {
            throw new IllegalArgumentException("Requested charaters exceeds available characters");
        }

        for (int letter = 0; letter < requiredLetters; letter++) {
            int index = random.nextInt(list.size());
            myScrabbleList.add(list.get(index));
            list.remove(index);
        }

        return myScrabbleList;
    }

    public List getMyList() {
        return userList;
    }
}
