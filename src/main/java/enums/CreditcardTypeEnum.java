package enums;

public enum CreditcardTypeEnum {
    DEFAULT("- Select Credit Card Type -"),
    AMEX("American Express"),
    VISA("VISA"),
    MAST("Master Card"),
    OTHR("Other");
private final String cardType;
    CreditcardTypeEnum(String cardType) {
        this.cardType=cardType;
    }
    public String getCardType(){
    return cardType;
    }
}
