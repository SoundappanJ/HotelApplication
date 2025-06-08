package enums;

public enum expiryYearEnum {
    DEFAULT("- Select Year -"),
    Y11("2011"),
    Y12("2012"),
    Y13("2013"),
    Y14("2014"),
    Y15("2015"),
    Y16("2016"),
    Y17("2017"),
    Y18("2018"),
    Y19("2019"),
    Y20("2020"),
    Y21("2021"),
    Y22("2022"),
    Y23("2023"),
    Y24("2024"),
    Y25("2025"),
    Y26("2026"),
    Y27("2027"),
    Y28("2028"),
    Y29("2029"),
    Y30("2030"),
    ;
private final String year;
    expiryYearEnum(String Year) {
        this.year=Year;
    }
    public String getYear(){
        return year;
    }
}
