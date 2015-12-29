/**
 * Created by lisa on 15-12-28.
 */
public class Tree {

    private TreeNode root;
    private TreeNode cursor;

    public Tree() {
        this.root = new TreeNode();
    }

    //构建一棵树
    public void build(Word array[])
    {
        for(int i = 0;i<array.length;i++)
        {
            this.add(array[i]);
        }
    }

    //增加单词功能
    public void add(Word word)
    {
        cursor = root;
        String Str= word.getWord();
        for(int i=0;i<Str.length();i++)
        {
            if(cursor.next[Str.charAt(i)-'a'] == null){
                TreeNode treeNode = new TreeNode();
                cursor.next[Str.charAt(i)-'a'] = treeNode;
            }
            cursor = cursor.next[Str.charAt(i)-'a'];
        }
        cursor.setWord(word);
    }



    //查找单词功能
    public Word find(String a)
    {
        cursor = root;
        for(int i=0;i<a.length();i++)
        {
            if(cursor.next[a.charAt(i)-'a'] != null){
                cursor = cursor.next[a.charAt(i)-'a'];
                //检查字母所对应的数组的索引
            }
            else
            {
                return null;
            }
        }
        return cursor.getWord();
    }

    //删除单词功能
    public boolean delete(String a)
    {
        cursor = root;
        for(int i=0;i<a.length();i++)
        {
            if(cursor.next[a.charAt(i)-'a'] != null){
                cursor = cursor.next[a.charAt(i)-'a'];
            }
            else
            {
                //说明没有找到要删除的路径
                return false;
            }

        }

        //没有找到单词就返回false说明未修改成功
        if(cursor.getWord()==null)
        {
            return false;
        }
        //如果找到单词就删除它并返回true说明修改成功
        cursor.setWord(null);
        return true;
    }

    //修改单词功能
    public Boolean change()
    {
        return false;
    }


    //构建一个节点类
    public class TreeNode{
        private Word word;
        private TreeNode[] next;

        public TreeNode() {
            this.next = new TreeNode[26];
        }

        public void printWord(Word word)
        {
            System.out.println(word.getWord());
            System.out.println(word.getMeaning());
        }




        public Word getWord(){
            return this.word;
        }
        public void setWord(Word word){
            this.word = word;
        }

    }



}
