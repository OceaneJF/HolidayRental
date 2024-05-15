package locations;

import properties.AbstractProperty;

public class Incompatible implements Predicate<AbstractProperty>{

    @Override
    public boolean test(AbstractProperty property){
        if (property==null) {
            return true;
        }
            if (property.getLocation().isForest() && property.isAppartment()) {
                return true;
            }
            if (property.getLocation().isCity() && property.isCabin()) {
                return true;
            }
            if (property.getLocation().isBeach() && (property.isAppartment() || property.isHouse())) {
                return true;
            }
            return false;
    }
}
