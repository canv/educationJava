package pack6ch;

class Bw {
    private String str;

    Bw(String str) {
        this.str = str;
    }

    void backward(int index) {
        if (index != str.length() - 1) backward(index + 1);
        //В данном примере рекурсия просто остчитывает
        //с начала (index = 0)  до конца слова (str.length() - 1))
        //а затем просто возвращает в обратном, что свойственно рекурсии, виде
        System.out.print(str.charAt(index));
    }
}

public class Backwards {
    public static void main(String[] args) {
        Bw s = new Bw("This is a better variant");
        s.backward(0);
    }
}
