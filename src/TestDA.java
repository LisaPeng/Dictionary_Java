import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mingtao on 1/5/16.
 */
public class TestDA {
    public static void main(String [] args) {
        DA da = new DA();
        Word word = new Word("a1", "2", "3");
        System.out.println("add 'a1' once: " + da.add(word));
        System.out.println("add 'a1' twice: " + da.add(word));
        ArrayList<Word> arrayList = da.output();
        for (Word w: arrayList) {
            System.out.println(w.getWord());
            System.out.println(w.getMeaning());
            System.out.println(w.getExample());
        }
        System.out.println(da.del("a2"));
        System.out.println(da.del("a1"));
        ArrayList<Word> arrayList1 = da.output();
        for (Word w: arrayList1) {
            System.out.println(w.getWord());
            System.out.println(w.getMeaning());
            System.out.println(w.getExample());
        }
        da.terminate();
    }
}
