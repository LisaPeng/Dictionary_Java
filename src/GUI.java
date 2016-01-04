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
        DictionaryFrame df = new DictionaryFrame();
        df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        df.setVisible(true);
    }


}
class DictionaryFrame extends JFrame
{
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

    public DictionaryFrame()
    {   //三个容器和一个主面板
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

        final Word[] words=new Word[3];
        words[0]=new Word("abandon","vt.丢弃；放弃，抛弃");
        words[1]=new Word("baby","n.婴儿；孩子气的人");
        words[2]=new Word("cabbage","n.洋白菜，卷心菜");

        for(Word w: words)
        {
            System.out.println(w.word+"  "+w.meaning);
        }

        jb1.addActionListener(new ActionListener(){
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
                        jtf2.setText("查无此词");
                    }
                }
            }
        });

        add(jp);
        setSize(400,700);
        setLocation(200,200);
        setTitle("My Dictionary");
    }
}
