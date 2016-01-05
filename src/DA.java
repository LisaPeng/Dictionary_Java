import java.sql.*;
import java.util.ArrayList;

/**
 * Created by mingtao on 1/5/16.
 */
public class DA {
    static Connection conn;
    static Statement statement;


    /**
     * 建表方法,每次启动都会执行，如果没有表，则创建。
     */
    public static void createTables() {
        PreparedStatement preparedStatement;
        String sql =
            "create table Word(spelling varchar(32) not null, meaning varchar(128) not null, sentence varchar(256)" +
                    " not null, primary key (spelling))";
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println();
        }
    }

    public static Connection initialize() {
        createTables();
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/dictionary?" +
                    "user=hust&password=diaodiaodiao");

            statement = conn.createStatement();         //??
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

    //关闭连接
    public static void terminate() {
        try {
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static boolean add(Word word) {
        String spelling, meaning, sentence;
        spelling = word.getWord();
        meaning = word.getMeaning();
        sentence = word.getExample();
        String sql = "INSERT INTO Word(spelling, meaning, sentence) VALUES ("+spelling+","+meaning+","+sentence+")";
        try{
            statement.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println("sql执行错误: " + e);
        }
        return false;
    }

    public static void del() {

    }

    public static void update() {

    }

    public static ArrayList<Word> output() {
        String spelling, meaning, sentence;
        ArrayList<Word> arrayList = new ArrayList<>();

        String sql = "SELECT * FROM Word";

        try {
            ResultSet rs = statement.executeQuery(sql);
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
