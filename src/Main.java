

public class Main {
    public static void main(String[] args) {
        long sq = 676;
        double egg;

//        sq = ((Math.sqrt(sq)%2) == 0)
//
//        if ((Math.sqrt(sq) % 1) == 0)
//            System.out.println(Math.sqrt(sq));
//
//        for (int i = 2; i < ((sq/2)+1); i++) {
//
        egg = ((Math.sqrt(sq) % 1) == 0) ?
                ((Math.sqrt(sq)+1) * ((Math.sqrt(sq)+1))) :
                -1;

                 System.out.println((int)egg);
//
//
//            }
//        }
        }
    }
