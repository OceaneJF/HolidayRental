package properties;

public class House extends AbstractProperty {

    public House(double price, String description) {
        super(price, description);
    }

    @Override
    public boolean isHouse() {
        return true;
    }
    
}
