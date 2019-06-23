package VideoLessons.ch3;

class UserSocial extends User {
    private String name;
    private int age;

    UserSocial (long id, String log, String pass, String name, int age){
        super(id,log,pass);
        this.name = name;
        this.age = age;
    }

    void setName (String name) {this.name = name;}
    void setAge (int age) {this.age = age;}

    String getName () {return name;}
    int getAge () {return age;}

}

class WebMaster extends User {
    private String webAdres;

    WebMaster(long id, String log, String pass, String webAdress){
        super(id,log,pass);
        this.webAdres = webAdress;
    }

    void setWebAdress (String webAdress) {this.webAdres = webAdress;}

    String getWebAdress () {return webAdres;}
}

public class Lesson6 {
    public static void main(String[] args) {
        UserSocial p1 = new UserSocial(1888,
                "Man98",
                "pampam992",
                "Vic",
                42);
        WebMaster p2 = new WebMaster(9400,
                "powSing92_chAllzZz",
                "szghsSDGGdsg324dsgG",
                "https://github.com/ajefts");


        System.out.println("\nUser info: " +
                "\nid <" + p1.getFullId() + "> " +
                "\nLogin <" + p1.getLogin() + "> " +
                "\nPassword <" + p1.getPassword() + ">" +
                "\nName <" + p1.getName() + ">" +
                "\nAge <" + p1.getAge() + ">\n");

        System.out.println("\nUser info: " +
                "\nid <" + p2.getFullId() + "> " +
                "\nLogin <" + p2.getLogin() + "> " +
                "\nPassword <" + p2.getPassword() + ">" +
                "\nWebSite <" + p2.getWebAdress() + ">\n");
    }
}
