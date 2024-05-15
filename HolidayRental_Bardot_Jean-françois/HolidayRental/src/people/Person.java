package people;

import holidayrental.Rent;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import properties.AbstractProperty;

/**
 * A simple person class identified by name.
 */
public class Person {
    private final String name;
    private final Set<Rent> rentHistory;
    public Person(String name) {
        this.name = name;
        rentHistory = new HashSet<>();
    }
    
    public void addRent(Rent newRent) {
        // TODO
    }

    @Override
    public int hashCode() {
        return this.name.hashCode(); // FAIT
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }
        if (obj==null) {
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        final Person other =(Person)obj;
        if(this.name!=other.name){
            return false;
        }
        return true; // FAIT
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
    
}
