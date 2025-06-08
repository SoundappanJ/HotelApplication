package enums;

import org.openqa.selenium.By;

public enum TotalRoomsEnum {

    SELECT_ONE("1 - One",1),
    SELECT_TWO("2 - Two",2),
    SELECT_THREE("3 - Three",3),
    SELECT_FOUR("4 - Four",4),
    SELECT_FIVE("5 - Five",5),
    SELECT_SIX("6 - Six",6),
    SELECT_SEVEN("7 - Seven",7),
    SELECT_EIGHT("8 - Eight",8),
    SELECT_NINE("9 - Nine",9),
    SELECT_TEN("10 - Ten",10);
    private final String totalrooms;
    private final int totalroomvalue;
    TotalRoomsEnum(String totalrooms,int totalroomvalue){
        this.totalrooms=totalrooms;
        this.totalroomvalue=totalroomvalue;
    }
    public String getTotalRooms(){
        return totalrooms;
    }
    public int getTotalroomvalue(){
        return totalroomvalue;
    }
}
