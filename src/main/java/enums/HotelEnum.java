package enums;

import core.DriverManager;
import org.openqa.selenium.WebElement;
import utils.PageUtil;

public enum HotelEnum {
    HOTEL_CREEK("Hotel Creek"),
    HOTEL_SUNSHINE("Hotel Sunshine"),
    HOTEL_HERVEY("Hotel Hervey"),
    HOTEL_CORNICE("Hotel Cornice");
    private final String hotel;

    HotelEnum(String hotel){
        this.hotel=hotel;
    }
    public String getHotel(){
        return hotel;
    }
}

