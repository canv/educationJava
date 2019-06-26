package VideoLessons.ch3;


//Lesson10

public class Anonymous {
    public static void main(String[] args) {
        User8 testAnonymous = new User8(
                1000001,
                "WeAreLegion",
                "4o4_N0tF0und") {
            @Override
            public void showUserInfo() {
                System.out.println("\nUser info: " +
                        "\nid <" + getFullId() + "> " +
                        "\nLogin <" + getLogin() + "> " +
                        "\nPassword <" + getPassword() + ">");
            }
        };

        testAnonymous.showUserInfo();
    }

}
