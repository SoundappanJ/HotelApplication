package enums;

public enum RoomTypeEnum {
    STANDARD("Standard"),
    DOUBLE("Double"),
    DELUXE("Deluxe"),
    SUPER_DELUXE("Super Deluxe");

    private final String roomType;

    RoomTypeEnum(String roomType){
        this.roomType=roomType;
    }
    public String getroomtype(){
        return roomType;
    }

}
