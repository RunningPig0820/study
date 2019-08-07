package taosha.definitionParser.bean;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhangMin
 * @Date 2019/2/25 15:17
 * @Version 1.0
 **/
public class User {
    private String id;
    private String userName;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
