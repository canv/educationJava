package course.lesson9;

interface CitySet {
    int getLength();
    int getWidth();
    Damage getDamage();
}

abstract class CitySectors implements CitySet{
    private int id;
    private String name;
    private int length;
    private int width;
    private Damage damage;

    CitySectors(String name, int length, int width, Damage damage) {
        this.id = hashCode() & Integer.MAX_VALUE;
        this.name = name;
        this.length = length;
        this.width = width;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    @Override
    public Damage getDamage() {
        return damage;
    }
    @Override
    public int getLength() {
        return length;
    }
    @Override
    public int getWidth() {
        return width;
    }
}

class Park extends CitySectors {
    Park(String name, int length, int width, Damage damage) {
        super(name, length, width, damage);
    }
}
class Street extends CitySectors {
    Street(String name, int length, int width, Damage damage) {
        super(name, length, width, damage);
    }
}
class LivingDistrict extends CitySectors {
    LivingDistrict(String name, int length, int width, Damage damage) {
        super(name, length, width, damage);
    }
}

class Damage{
    private int length;
    private int width;

    Damage(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }
    int getWidth() {
        return width;
    }
}