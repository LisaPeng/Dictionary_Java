import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lisa on 15-12-28.
 */



public class GUI {
    //查询界面
    public static void main(String[] args) {
        Tree tree = new Tree();
        DictionaryFrame df = new DictionaryFrame(tree);
        df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        df.setVisible(true);
    }


}
class DictionaryFrame extends JFrame
{
    //所有组件的初始化
    JPanel jp=null;
    JTextField jtf=null;
    JPanel jp2=null;
    JPanel jp3=null;

    JButton jb1=null;
    JButton jb2=null;
    JButton jb3=null;
    JButton jb4=null;

    JTextField jtf2=null;
    JTextField jtf3=null;
    JTextField jtf4=null;
    JButton jb5=null;

    public DictionaryFrame(final Tree tree)
    {
        //三个容器和一个主面板
        jtf=new JTextField(30);

        jp2=new JPanel();
        jp2.setLayout(new GridLayout(1,4));
        jb1=new JButton("查询");
        jb2=new JButton("增加");
        jb3=new JButton("删除");
        jb4=new JButton("修改");
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);

        jp3=new JPanel();
        jp3.setLayout(new BoxLayout(jp3, BoxLayout.Y_AXIS));
        jtf2=new JTextField(30);
        jtf3=new JTextField(30);
        jtf4=new JTextField(30);
        jb5=new JButton("保存");
        jp3.add(jtf2);
        jp3.add(jtf3);
        jp3.add(jtf4);
        jp3.add(jb5);
        jp3.setSize(300,100);

        jp=new JPanel();
        jp.setLayout(new FlowLayout());
        jp.add(jtf);
        jp.add(jp2);
        jp.add(jp3);

        //查询按钮的响应事件
        jb1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                jtf2.setText(null);
                jtf3.setText(null);
                jtf4.setText(null);
                String m=jtf.getText();
                Word word=tree.find(m);
                if(word!=null){
                    jtf2.setText(word.getWord());
                    jtf3.setText(word.getMeaning());
                    jtf4.setText(word.getExample());
                }
                else
                {
                    jtf2.setText("无法找到该单词，查询失败");
                }
            }
        });

     /*  //增加按钮的响应事件
        jb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jtf2.setText(null);
                String m=jtf.getText();
                System.out.println(m);
                for(int i=0;i<words.length;i++)
                {
                    if(m.equals(words[i].word))
                    {
                        jtf2.setText(words[i].meaning);
                        System.out.println(words[i].meaning);
                    }else{
                        jtf2.setText("无法找到该单词，查询失败");
                    }
                }
            }
        });


       **   //删除按钮的响应事件
        jb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jtf2.setText(null);
                String m=jtf.getText();
                System.out.println(m);
                for(int i=0;i<words.length;i++)
                {
                    if(m.equals(words[i].word))
                    {
                        jtf2.setText(words[i].meaning);
                        System.out.println(words[i].meaning);
                    }else{
                        jtf2.setText("无法找到该单词，查询失败");
                    }
                }
            }
        });

        //修改按钮的响应事件
        jb4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jtf2.setText(null);
                String m=jtf.getText();
                System.out.println(m);
                for(int i=0;i<words.length;i++)
                {
                    if(m.equals(words[i].word))
                    {
                        jtf2.setText(words[i].meaning);
                        System.out.println(words[i].meaning);
                    }else{
                        jtf2.setText("无法找到该单词，查询失败");
                    }
                }
            }
        });

        //确定按钮的响应事件
        jb5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                jtf2.setText(null);
                String m=jtf.getText();
                System.out.println(m);
                for(int i=0;i<words.length;i++)
                {
                    if(m.equals(words[i].word))
                    {
                        jtf2.setText(words[i].meaning);
                        System.out.println(words[i].meaning);
                    }else{
                        jtf2.setText("无法找到该单词，查询失败");
                    }
                }
            }
        });

        ************************/

        add(jp);
        setSize(400,700);
        setLocation(200,200);
        setTitle("My Dictionary");
    }
}
