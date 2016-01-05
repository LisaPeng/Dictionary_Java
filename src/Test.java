/**
 * Created by lisa on 15-12-28.
 */

public class Test {
    public static void main(String [] args){
       Word word = new Word("hello","vdusib","hello world");
        Word word2 = new Word("world","dwsgbf","hello world");
        DA da = new DA();
        da.createTables();
        Tree tree =  new Tree(da);
        tree.add(word);
            System.out.println(tree.find("hello").getWord());
        //tree.delete("hello");
        System.out.println(tree.find("hello"));
        System.out.println(tree.change("hello",word2));
        System.out.println(tree.find("hello"));
        System.out.println(tree.find("world"));
    }
}
