package locations;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

import people.Person;
import properties.AbstractProperty;

/**
 * Abstract location class, must be extended by classes providing the correct
 * predicate implementation (test returns true whenever the property is
 * INCOMPATIBLE with the location) and suitable value for "is" methods.
 */
public abstract class AbstractLocation {
    private final String description;
    private final Set<AbstractProperty> properties;
    public AbstractLocation(String description) {
        this.description = description;
        properties = new HashSet<>();
    }

    public Set<AbstractProperty> getProperties() {
        return new HashSet<>(properties);
    }
    


    public boolean addProperty(AbstractProperty property) {
        properties.removeIf(new Incompatible());
        this.properties.add(property);
        property.setLocation(this);
        return true; // Fait
    }
    @Override
    public int hashCode() {
        return this.description.hashCode(); // FAIT
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
        final AbstractLocation other =(AbstractLocation) obj;
        if(this.description!=other.description){
            return false;
        }
        return true; // FAIT
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String type = "";
        if (isBeach()) {
            type += "Beach ";
        }
        if (isCity()) {
            type += "City ";
        }
        if (isForest()) {
            type += "Forest ";
        }
        return type+"location: " + description;
    }
    
    public boolean isBeach() { return false; }
    public boolean isCity() { return false; }
    public boolean isForest() { return false; }
}