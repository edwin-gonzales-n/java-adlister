public class Config {

//    private String Driver = "com.mysql.jdbc.Driver";
//    static final String DATABASE_URL = "jdbc:mysql://localhost/employees";
    private String url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    private String user = "adlister_admin";
    private String password = "admin123";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
