import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by saurabh on 2/9/16.
 */
public class Scrabble {

    private static Scrabble instance = null;
    private List<Character> list;
    private final int MAX_LETTERS_IN_BOX = 50;

    private static List userList;


    private Scrabble() {
        list = new LinkedList();
        instance.populateList();
    }

    private static class SingletonHelper {
        private static final Scrabble INSTANCE = new Scrabble();
    }

    public static synchronized Scrabble getInstance(int requiredLetters) {

        instance = SingletonHelper.INSTANCE;
        userList = instance.getScrabbleLetters(requiredLetters);

        return instance;
    }


    private void populateList() {
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random random = new Random();
        for (int i = 0; i < MAX_LETTERS_IN_BOX; i++) {
            list.add(alphabets.charAt(random.nextInt(26)));
        }
    }


    private  List getScrabbleLetters(int requiredLetters) {
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
