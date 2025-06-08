package enums;

public enum LocationEnum {
    SYDNEY("Sydney"),

    MELBOURNE("Melbourne"),

    PERTH("Perth");

    private final String  location;

    LocationEnum(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
