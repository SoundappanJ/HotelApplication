package enums;

import org.openqa.selenium.By;

public enum BookedItineraryEnum {
    CLICK_BOOKED_ITINERARY(By.xpath("//a[normalize-space()='Booked Itinerary']"),"Clk Booked Itinerarary"),
    TABLE(By.xpath("//table[@width='100%' and @border='0']"),"Table "),
    BOOKED_ORDER_ID(By.xpath("//input[@name='order_id_1346793']"),"Latest Booked order id"),
    BOOKED_HOTEL(By.xpath("//input[@name='hotel_name_1346793']"),"Latest Booked Hotel name"),
    BOOKED_LOCATION_NAME(By.xpath("//input[@name='location_1346793']"),"Latest Booked Location name"),
    BOOKED_TOTAL_ROOMS(By.xpath("//input[@name='rooms_1346793']"),"Booked total rooms"),
    BOOKED_FIRST_NAME(By.xpath("//input[@name='first_name_1346793']"),"Booked User name"),
    BOOKED_ARRIVAL_DATE(By.xpath("//input[@name='arr_date_1346793']"),"Arrival Date"),
    BOOKED_DEP_DATE(By.xpath("//input[@name='dep_date_1346793']"),"Departure Date"),
    BOOKED_ROOM_TYPE(By.xpath("//input[@name='room_type_1346793']"),"Room type"),
    BOOKED_PRICE_PER_NIGHT(By.xpath("//input[@name='price_night_1346793']"),"Price per night"),
    BOOKED_TOTAL_PRICE(By.xpath("//input[@name='total_price_1346793']"),"Booked Hotel Total price"),

    BOOKED_TABLE(By.cssSelector("#booked_form > table > tbody > tr:nth-child(2)"),"All Table data"),
    BOOKED_SEARCH_TEXT(By.xpath("//input[@id='order_id_text' and contains(@class, 'input_search')]"),"Enter order ID"),
    CLICK_GO(By.xpath("//input[@id='search_hotel_id']"),"Click Go Button");


    private final By locator;
    private final String desp;
    BookedItineraryEnum(By locator, String desp) {
        this.locator=locator;
        this.desp=desp;
    }

    public By getLocator(){

        return locator;
    }
    public String getDesp(){
        return desp;
    }
}
