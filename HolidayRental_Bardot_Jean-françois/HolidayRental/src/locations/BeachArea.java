package locations;

import properties.AbstractProperty;

public class BeachArea extends AbstractLocation {

 public BeachArea(String description) {
        super(description);
    }

    @Override
    public boolean test(AbstractProperty t) {
        return t.isHouse() || t.isAppartment();
    }

    @Override
    public boolean isBeach() {
        return true;
    }
}
