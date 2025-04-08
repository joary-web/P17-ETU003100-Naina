
import java.sql.*;

public class Utildb {
    public String url="jdbc:mysql://localhost:3306/db_s2_ETU003100";
    public String user="ETU003100";
    public String password="Xwx2YcZV";

//     public Utildb(String url, String user, String password){
// this.url=url;
// this.user=user;
// this.password=password;
//     }

    //getter
    public String getUrl() {
        return this.url;
    }
    public String getUser() {
        return this.user;
    }
    public String getPassword() {
        return this.password;
    }

    //setter
    public void setUrl(String url) {
        this.url=url;
    }
    public void setUser(String user) {
        this.user=user;
    }
    public void setPassword(String password) {
        this.password=password;
    }

    public Connection ConnectToDb() {
        try{
            Connection MaConnexion=DriverManager.getConnection(this.getUrl(),this.getUser(),this.getPassword());
            if(MaConnexion==null){System.out.println("not connected");} else {System.out.println("connected");}
            return MaConnexion;
        }catch(Exception e){System.out.println(e);return null;}
    }
}
