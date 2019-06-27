package CodeWars;


class Fighter {
    private String name;
    private int health, damagePerAttack;

    Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }

    static String declareWinner(
            Fighter fighter1,
            Fighter fighter2,
            String firstAttacker) {

        int count;

        if (firstAttacker.equals(fighter1.name)) {
            fighter2.health -= fighter1.damagePerAttack;
            count = 2;
        } else {
            fighter1.health -= fighter2.damagePerAttack;
            count = 1;
        }

        do {
            if (count % 2 != 0) {
                fighter2.health -= fighter1.damagePerAttack;
                count++;
                if (fighter2.health <= 0) break;

            } else {
                fighter1.health -= fighter2.damagePerAttack;
                count++;
                if (fighter1.health <= 0) break;
            }
        } while (count < 20);

        if (fighter1.health > fighter2.health)return fighter1.name;
        else return fighter2.name;
    }

//        // best variant
//        Fighter a = fighter1, b = fighter2;
//        if (firstAttacker.equals(fighter2.name)) {
//            a = fighter2;
//            b = fighter1;
//        }
//        while (true) {
//            if ((b.health -= a.damagePerAttack) <= 0) return a.name;  // a wins
//            if ((a.health -= b.damagePerAttack) <= 0) return b.name;  // b wins
//        }
//    }
}


public class TwoFightersOneWinner {
    public static void main(String[] args) {

        System.out.println(Fighter.declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Lew"));
        System.out.println(Fighter.declareWinner(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4), "Harry"));
        System.out.println(Fighter.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harry"));
        System.out.println(Fighter.declareWinner(new Fighter("Harald", 20, 5), new Fighter("Harry", 5, 4), "Harald"));
        System.out.println(Fighter.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Jerry"));
        System.out.println(Fighter.declareWinner(new Fighter("Jerry", 30, 3), new Fighter("Harald", 20, 5), "Harald"));

    }
}
