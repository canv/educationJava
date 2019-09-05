package course.lesson9;

import java.util.HashSet;
import java.util.Set;

abstract class CitySectors implements CitySet{
    private String name;
    private int length;
    private int width;
    private Set<Damage> damage;

    CitySectors(String name, int length, int width) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.damage = new HashSet<>();
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getLength() {
        return length;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public Set<Damage> getDamage() {

        return damage;
    }
    @Override
    public void addDamage(int length, int width){
        damage.add(new Damage(length,width));
    }
}

class Park extends CitySectors {
    Park(String name, int length, int width) {
        super(name, length, width);
    }
}
class Street extends CitySectors {
    Street(String name, int length, int width) {
        super(name, length, width);
    }
}
class LivingDistrict extends CitySectors {
    LivingDistrict(String name, int length, int width) {
        super(name, length, width);
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