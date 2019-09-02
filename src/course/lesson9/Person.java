package course.lesson9;

enum Profession {
    GENERAL(1),
    COLONEL(2),
    MAJOR(3),
    CAPTAIN(4),
    LIEUTENANT(5),
    OFFICER(6),
    SERGEANT(7),
    CORPORAL(8),
    PRIVATE(9);

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
