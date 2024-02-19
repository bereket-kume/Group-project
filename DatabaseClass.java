import java.io.IOException;
import java.sql.*;
public class DatabaseClass {
    public Connection connection;
    public Statement statement;
    public DatabaseClass()throws Exception{
        String url="jdbc.mysql";
        String userName="root";
        String password="root";
        this.connection=DriverManager.getConnection(url,userName,password);
        this.statement=connection.createStatement();    
    }
    public boolean isExist(String Id,String password,String tableName)throws IOException, SQLException{
        String query="select * from (?) where id=(?) and password=(?)";
        PreparedStatement ps=this.connection.prepareStatement(query);
        ps.setString(1,tableName);
        ps.setString(2,Id);
        ps.setString(3,password);
        int rs= ps.executeUpdate(query);
      return rs>0;
    }
    
}
