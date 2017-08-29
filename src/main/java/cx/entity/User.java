package cx.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-8-24.
 */
public class User implements Serializable{

    private int id;

    private  String username;

    private String chinaName;

    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getChinaName() {
        return chinaName;
    }

    public void setChinaName(String chinaName) {
        this.chinaName = chinaName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", chinaName='" + chinaName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
