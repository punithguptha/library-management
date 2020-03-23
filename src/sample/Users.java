package sample;

public class Users {
    int uid;
    String username;
    String password;
    int Admin;
    Users(int uid,String username,String password,int Admin){
        this.uid=uid;
        this.username=username;
        this.password=password;
        this.Admin=Admin;
    }

    public int getAdmin() {
        return Admin;
    }

    public int getUid() {
        return uid;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setAdmin(int admin) {
        Admin = admin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
