package VideoLessons.ch3;

import java.io.PrintWriter;

abstract class User12{
    static PrintWriter consoleOut = new PrintWriter(System.out, true);
    private long fullId;
    private String login;
    private String password;
    private boolean origin = true;

    User12(long id, String log, String pass) {
        fullId = id;
        login = log;
        password = pass;
    }

    public abstract String toString();

    boolean getOrinin() {
        return origin;
    }
    long getFullId () {return fullId;}
    String getLogin () {return login;}
    String  getPassword () {return password;}

    void notOrigin() {
        this.origin = false;
    }
}

class UserSocial12 extends User12 implements Cloneable {
    private String name;
    private int age;


    UserSocial12 (long id, String log, String pass, String name, int age){
        super(id,log,pass);
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return  "\nUser info: " +
                "\nid <" + getFullId() + "> " +
                "\nLogin <" + getLogin() + "> " +
                "\nPassword <" + getPassword() + ">" +
                "\nName <" + name + ">" +
                "\nAge <" + age + ">" +
                "\nOriginal <" + getOrinin() + ">\n";
    }

    public UserSocial12 clone(){
        UserSocial12 p1 = new UserSocial12(getFullId(), getLogin(), getPassword(), name, age);
        p1.notOrigin();
        return p1;
    }
}

class WebMaster12 extends User12 implements Cloneable{
    private String webAddress;

    WebMaster12(long id, String log, String pass, String webAdress) {
        super(id, log, pass);
        this.webAddress = webAdress;
    }

    public String toString() {
        return  "\nUser info: " +
                "\nid <" + getFullId() + "> " +
                "\nLogin <" + getLogin() + "> " +
                "\nPassword <" + getPassword() + ">" +
                "\nWebSite <" + webAddress + ">" +
                "\nOriginal <" + getOrinin() + ">\n";
    }

    public WebMaster12 clone(){
        WebMaster12 p2 = new WebMaster12(getFullId(), getLogin(), getPassword(),webAddress);
        User12.consoleOut.println("\n\nAttention noticed attempting to clone the master account!\n\n");
        p2.webAddress = "*****";
        p2.notOrigin();
        return p2;
    }
}

public class Lesson12 {
    public static void main(String[] args) {
        UserSocial12 p1 = new UserSocial12(
                1888,
                "Man98",
                "pampam992",
                "Vic",
                42);

        WebMaster12 p2 = new WebMaster12(
                9400,
                "powSing92_chAllzZz",
                "szghsSDGGdsg324dsgG",
                "https://github.com/ajefts");

        User12.consoleOut.println(p1);
        UserSocial12 p1clone = p1.clone();
        User12.consoleOut.println(p1clone);

        User12.consoleOut.println(p2);
        WebMaster12 p2clone = p2.clone();
        User12.consoleOut.println(p2clone);
    }
}
