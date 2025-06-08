package enums;

public enum TotalChildEnum {
    SELECT_DEFAULT("- Select Children per Room -",0),
    SELECT_ONE("1 - One",1),
    SELECT_TWO("2 - Two",2),
    SELECT_THREE("3 - Three",3),
    SELECT_FOUR("4 - Four",4);

    private final String locator;
    private final int value;
    TotalChildEnum(String locator,int value){
        this.locator= locator;
        this.value=value;
    }
    public String getlocator(){
        return locator;
    }
    public int getValue(){
        return value;
    }
}
