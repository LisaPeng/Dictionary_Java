/**
 * Created by lisa on 15-12-28.
 */
public class Tree {

    private TreeNode root;
    private TreeNode cursor;

    //构建一棵树
    public void build(Word array[])
    {
        for(int i = 0;i<array.length;i++){
            this.add(array[i]);
        }
    }

    //增加单词功能
    public void add(Word word)
    {

    }

    //删除单词功能
    public void delect()
    {

    }

    //查找单词功能
    public void find()
    {

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
    }



}
