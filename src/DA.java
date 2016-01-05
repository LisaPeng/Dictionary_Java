import java.sql.*;
import java.util.ArrayList;

public class DA {
    private Connection conn;
    private Statement statement;

    DA() {
        this.initialize();
    }

    /**
     * 建表方法,每如果没有表，则创建。
     * 请在每次运行程序时调用
     */
    public void createTables() {
        PreparedStatement preparedStatement;
        String sql =
            "create table Word(spelling varchar(32) not null, meaning varchar(128) not null, sentence varchar(256)" +
                    " not null, primary key (spelling))";
        try{
            preparedStatement = this.conn.prepareStatement(sql);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 初始化
     */
    public void initialize() {
        try {
            conn = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            statement = conn.createStatement();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    /**
     * 断开连接
     */
    public void terminate() {
        try {
            this.statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * 向数据库中添加一个单词
     * @param word Word类型
     * @return bool类型，当添加成功时为true，否则为false
     */
    public boolean add(Word word) {
        String spelling, meaning, sentence;
        spelling = word.getWord();
        meaning = word.getMeaning();
        sentence = word.getExample();
        String sql = "INSERT INTO Word(spelling, meaning, sentence) VALUES (?,?,?)";
        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, spelling);
            ps.setString(2, meaning);
            ps.setString(3, sentence);
            ps.addBatch();
            ps.executeBatch();
            ps.close();
            return true;
        } catch (Exception e) {
            System.out.println("sql执行错误: " + e);
        }
        return false;
    }

    /**
     * 删除操作
     * @param spelling 指单词的拼写
     * @return bool类型，当删除成功，则为true，否则为false
     */
    public boolean del(String spelling) {
        String sql = "DELETE FROM Word WHERE spelling = '" + spelling +"'";
        try {
            int flag = this.statement.executeUpdate(sql);
            if(flag == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("sql语句执行删除失败");
        }
        return false;
    }

    /**
     * 导出数据库中所有单词，用于构造wordTree
     * @return ArrayList类型，每个元素都是一个Word
     */
    public ArrayList<Word> output() {
        String spelling, meaning, sentence;
        ArrayList<Word> arrayList = new ArrayList<>();

        String sql = "SELECT * FROM Word";

        try {
            ResultSet rs = this.statement.executeQuery(sql);
            while (rs.next()) {
                spelling = rs.getString("spelling");
                meaning = rs.getString("meaning");
                sentence = rs.getString("sentence");
                arrayList.add(new Word(spelling, meaning, sentence));
            }

        } catch (Exception e) {
            System.out.println("sql查询错误：" + e);
        }
        return arrayList;
    }
}
