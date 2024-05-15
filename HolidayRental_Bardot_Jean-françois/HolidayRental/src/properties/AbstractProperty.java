package properties;

import holidayrental.Rent;
import java.util.Objects;
import locations.AbstractLocation;
/**
 * Abstract property class. No abstract methods by the "is" methods should be
 * correctly implemented in extending classes.
 */
public abstract class AbstractProperty {
    public static final double MIN_PRICE = 1.00;
    public static final double MAX_PRICE = 10000.00;
    private final double price;
    private final String description;
    private AbstractLocation location=null;
    private Rent currentRent = null;

    public boolean isAppartment() {
        return false;
    }

    public boolean isCabin() {
        return false;
    }

    public boolean isHouse() {
        return false;
    }

    public AbstractProperty(double price, String description) {
        this.price = price;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String type = "";
        if (isCabin()) {
            type += "Cabin: ";
        }
        if (isHouse()) {
            type += "House: ";
        }
        if (isAppartment()) {
            type += "Appartment: ";
        }
        return type + "price=" + price + ", description=" + description;
    }

    @Override
    public int hashCode() {
        return this.description.hashCode()+(int)Math.round(this.price*100); // FAIT
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
        final AbstractProperty other =(AbstractProperty) obj;
        if(this.description!=other.description){
            return false;
        }
        if(this.price!=other.price){
            return false;
        }
        return true; // FAIT
    }

    public void setLocation(AbstractLocation location) {
        this.location=location;
    }
    public void setRent(Rent newRent) {
        currentRent = newRent;
    }
    public void endRent() {
        // TODO
    }
    public Rent getRent() {
        return currentRent;
    }
    public boolean available() {
        return currentRent==null;
    }

    public AbstractLocation getLocation(){
        return location;
    }
}