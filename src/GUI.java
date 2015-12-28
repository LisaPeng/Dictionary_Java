import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lisa on 15-12-28.
 */


/*
public class GUI {
    //查询界面
    public class Dictionary {
        public static void main(String[] args) {
            DictionaryFrame df=new DictionaryFrame();
            df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            df.setVisible(true);
        }

    }

    class DictionaryFrame extends JFrame
    {
        JPanel dpanel=null;
        JTextField jtf=null;
        JTextArea jta=null;
        JScrollPane jsp=null;
        JButton jb=null;
        public DictionaryFrame()
        {
            jtf=new JTextField(25);
            jta=new JTextArea();
            jsp=new JScrollPane(jta);
            jb=new JButton("查询");

            final Word[] words=new Word[3];
            words[0]=new Word("abandon","vt.丢弃；放弃，抛弃");
            words[1]=new Word("baby","n.婴儿；孩子气的人");
            words[2]=new Word("cabbage","n.洋白菜，卷心菜");

            for(Word w: words)
            {
                System.out.println(w.word+"  "+w.meaning);
            }

            jb.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    jta.setText(null);
                    String m=jtf.getText();
                    System.out.println(m);
                    for(int i=0;i<words.length;i++)
                    {
                        if(m.equals(words[i].word))
                        {
                            jta.setText(words[i].meaning);
                            System.out.println(words[i].meaning);
                        }else{
                            jta.setText("查无此词");
                        }
                    }
                }

            });

            dpanel =new JPanel();
            dpanel.setLayout(new GridLayout(2,1));
            JPanel jp=new JPanel();

            dpanel.add(jp);

            jp.add(jtf);
            jp.add(jb);
            dpanel.add(jsp);

            add(dpanel);
            setSize(400,300);
            setLocation(200,200);
            setTitle("My Dictionary");
        }
    }
}
*/
