package VideoLessons.ch3;

abstract class User8 implements Lesson9 {
    private long fullId;
    private String login;
    private String password;

    User8(long id, String log, String pass) {
        fullId = id;
        login = log;
        password = pass;
    }

//    void setFullId (long fID) {fullId = fID;}
//    void setLogin (String log) {login = log;}
//    void setPassword (String pass) {password = pass;}

    long getFullId () {return fullId;}
    String getLogin () {return login;}
    String  getPassword () {return password;}

    public abstract void showUserInfo();
}

class UserSocial8 extends User8 {
    private String name;
    private int age;

    UserSocial8 (long id, String log, String pass, String name, int age){
        super(id,log,pass);
        this.name = name;
        this.age = age;
    }

//    void setName (String name) {this.name = name;}
//    void setAge (int age) {this.age = age;}

    private String getName () {return name;}
    private int getAge () {return age;}

    public void showUserInfo() {
        System.out.println("\nUser info: " +
                "\nid <" + getFullId() + "> " +
                "\nLogin <" + getLogin() + "> " +
                "\nPassword <" + getPassword() + ">" +
                "\nName <" + getName() + ">" +
                "\nAge <" + getAge() + ">\n");
    }

}

class WebMaster8 extends User8 {
    private String webAdres;

    WebMaster8(long id, String log, String pass, String webAdress){
        super(id,log,pass);
        this.webAdres = webAdress;
    }

//    void setWebAdress (String webAdress) {this.webAdres = webAdress;}

    private String getWebAdress () {return webAdres;}

    public void showUserInfo() {
        System.out.println("\nUser info: " +
                "\nid <" + getFullId() + "> " +
                "\nLogin <" + getLogin() + "> " +
                "\nPassword <" + getPassword() + ">" +
                "\nWebSite <" + getWebAdress() + ">\n");
    }
}

public class Lesson8 {
    public static void main(String[] args) {
        UserSocial8 p1 = new UserSocial8(1888,
                "Man98",
                "pampam992",
                "Vic",
                42);
        WebMaster8 p2 = new WebMaster8(9400,
                "powSing92_chAllzZz",
                "szghsSDGGdsg324dsgG",
                "https://github.com/ajefts");

        p1.showUserInfo();
        p2.showUserInfo();
    }
}
