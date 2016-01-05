import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mingtao on 1/5/16.
 */
public class TestDA {
    public static void main(String [] args) {
        DA da = new DA();
        Word word = new Word("1", "2", "3");
        da.add(word);
        ArrayList<Word> arrayList = da.output();
        for (Word w: arrayList) {
            System.out.println(w.getWord());
            System.out.println(w.getMeaning());
            System.out.println(w.getExample());
        }
    }
}
