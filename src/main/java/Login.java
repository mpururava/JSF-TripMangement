import jdbc.ConnectionDb;
import pojo.UserPOJO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Scanner;
import rest.rest;
@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID=1L;

    private ConnectionDb dbConnector = ConnectionDb.getInstance();

    private UserPOJO userPOJO;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    rest rest =new rest();
    private String password;

    public String userLogin() {
        boolean userlogin = false;
        System.out.println("Enter Login Details:");


        try {
            String sql = "SELECT * FROM user_details WHERE user_login_id='" + userName + "' AND user_password='" + password + "';";
            ResultSet loginset = this.dbConnector.selectQuery(sql);
            this.userPOJO = new UserPOJO();

            while(loginset.next()) {
                return "/hello.xhtml";
            }
        }catch (Exception var7)
        {
            System.out.println(var7);
        }

        return "/login.html";
    }
}
