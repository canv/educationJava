package course.lesson9;

enum Profession {
    General(1),
    Colonel(2),
    Major(3),
    Captain(4),
    Lieutenant(5),
    Officer(6),
    Sergeant(7),
    Corporal(8),
    Private(9);

    private int rank;

    Profession(int rank) {
        this.rank = rank;
    }

    int getRank() {
        return rank;
    }
}

class Person {
    private final Profession military;

    private Person(Profession military) {
        this.military = military;
    }

    Profession getMilitary() {
        return military;
    }

    @Override
    public String toString() {
        return "Person{" +
                "military = " + military +
                '}';
    }

    static class PersonBuilder{
        private Profession military;

        Person build(){
            Person person = new Person(military);
            military = null;
            return person;
        }

        PersonBuilder withMilitary(Profession military) {
            this.military = military;
            return this;
        }
    }
}
