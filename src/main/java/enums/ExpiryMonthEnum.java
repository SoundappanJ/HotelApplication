package enums;

public enum ExpiryMonthEnum {
    DEFAULT("- Select Month -"),
    JAN("January"),
    FEB("February"),
    MAR("March"),
    APR("April"),
    MAY("May"),
    JUN("June"),
    JUL("July"),
    AUG("August"),
    SEP("September"),
    OCT("October"),
    NOV("November"),
    DEC("December");
     private final String month;
    ExpiryMonthEnum(String month) {
        this.month = month;
    }
    public String getMonth(){
        return month;
    }
}
