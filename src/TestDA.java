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
        System.out.println("add '1' once: " + da.add(word));
        System.out.println("add '1' twice: " + da.add(word));
        ArrayList<Word> arrayList = da.output();
        for (Word w: arrayList) {
            System.out.println(w.getWord());
            System.out.println(w.getMeaning());
            System.out.println(w.getExample());
        }
        System.out.println(da.del("2"));
        System.out.println(da.del("1"));
        ArrayList<Word> arrayList1 = da.output();
        for (Word w: arrayList1) {
            System.out.println(w.getWord());
            System.out.println(w.getMeaning());
            System.out.println(w.getExample());
        }
        da.terminate();
    }
}
