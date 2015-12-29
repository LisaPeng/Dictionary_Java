/**
 * Created by lisa on 15-12-28.
 */
public class Test {
    public static void main(String [] args){
       Word word = new Word("hello","vdusib");
        Tree tree =  new Tree();
        tree.add(word);
            System.out.println(tree.find("hello").getWord());
        //tree.delete("hello");
        System.out.println(tree.find("hello"));
        System.out.println(tree.delete("hello"));

    }
}
