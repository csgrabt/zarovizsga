package hu.nive.ujratervezes.zarovizsga.digitscounter;
import java.util.ArrayList;
import java.util.List;


public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null) {
            return 0;
        }
        List<Character> result = new ArrayList<>();
        char[] array = s.toCharArray();
        for (Character item : array
        ) {
            if (Character.isDigit(item) && !result.contains(item)) {
                result.add(item);
            }
        }
        return result.size();
    }


}