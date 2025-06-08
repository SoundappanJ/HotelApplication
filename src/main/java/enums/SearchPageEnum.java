package enums;

import org.openqa.selenium.By;

public enum SearchPageEnum {
    CLICK_SEARCH_PAGE(By.xpath("//a[normalize-space()='Search Hotel']"),"Clcik the Search page"),
    SELECT_LOCATION_DROPDOWN(By.name("location"),"Select Location"),
    SELECT_HOTEL_DROPDOWN(By.name("hotels"),"Select Hotels"),
    SELECT_ROOM_TYPE(By.name("room_type"),"Select Room Type"),
    SELECT_TOTAL_ROOMS(By.name("room_nos"),"Select Number of Rooms"),
    SELECT_CHECK_IN(By.name("datepick_in"),"Give Check-IN"),
    SELECT_CHECK_OUT(By.name("datepick_out"),"Give Check-OUT"),
    CLICK_SUBMIT(By.xpath("//input[@name='Submit']"),"Click Submit"),
    CLICK_RESET(By.xpath("//input[@name='Reset']"),"Click Reset"),
    ERROR_CHECK_IN(By.xpath("//span[contains(text(),'Check-In Date shall be before')]"),"Error Message for checkin"),
//    ERROR_MINUS_CHECK_IN(By.xpath("//span[@id='checkin_span' and contains(text(),'Check-In Date should be either Today or Later Date')]"),"Error Message for checkin"),
//    SELECT_NO_ADULT(By.xpath("//select[@id='adult_room']"),"Select the no of adult"),
//    SELECT_NO_CHILD(By.xpath("//select[@id='child_room']"),"Select the no of children"),
//    GET_DISPLAY_LOC(By.xpath("//input[@id='location_0'] "),"Displayed Location"),
//    GET_DISPLAYED_CHECKIN_DATE(By.xpath("//input[@id='arr_date_0']"),"Displayed Check in date"),
//    GET_DISPLAYED_CHECKOUT_DATE(By.xpath("//input[@id='dep_date_0']"),"Displayed Check out date"),
//    GET_DISPLAYED_TOTAL_ROOMS(By.xpath("//input[@id='rooms_0']"),"Displayed Total rooms"),
//    GET_DISPALYED_ROOMTYPE(By.xpath("//input[@id='room_type_0']"),"Displayed Room Type"),
//    CLICK_CONTINUE(By.xpath("//input[@id='continue']"),"Click Continue"),
//    SELECT_HOTEL_RADIO_BUTTON(By.xpath("//input[@type='radio' and @id='radiobutton_0']"),
//            "Select Hotel for booking"),
//    PRICE_PER_NIGHT_OT(By.xpath("//input[@id='price_night_0']"),"Price per night"),
//    TOTAL_DAYS_OT(By.xpath("//input[@id='no_days_0']"),"Total Days"),
//    TOTAL_ROOMS_OT(By.xpath("//input[@id='rooms_0']"),"Total Rooms"),
     ERROR_MINUS_CHECK_IN(By.xpath("//span[contains(text(),'Check-In Date should be either Today or Later Date')]"), "Error Message for checkin"),

    SELECT_NO_ADULT(By.xpath("//select[@name='adult_room']"), "Select the no of adult"),

    SELECT_NO_CHILD(By.xpath("//select[@name='child_room']"), "Select the no of children"),

    GET_DISPLAY_LOC(By.xpath("//input[@name='location_0']"), "Displayed Location"),

    GET_DISPLAYED_CHECKIN_DATE(By.xpath("//input[@name='arr_date_0']"), "Displayed Check in date"),

    GET_DISPLAYED_CHECKOUT_DATE(By.xpath("//input[@name='dep_date_0']"), "Displayed Check out date"),

    GET_DISPLAYED_TOTAL_ROOMS(By.xpath("//input[@name='rooms_0']"), "Displayed Total rooms"),

    GET_DISPALYED_ROOMTYPE(By.xpath("//input[@name='room_type_0']"), "Displayed Room Type"),

    CLICK_CONTINUE(By.xpath("//input[@name='continue']"), "Click Continue"),

    SELECT_HOTEL_RADIO_BUTTON(By.xpath("//input[@name='radiobutton_0' and @type='radio']"), "Select Hotel for booking"),

    PRICE_PER_NIGHT_OT(By.xpath("//input[@name='price_night_0']"), "Price per night"),

    TOTAL_DAYS_OT(By.xpath("//input[@name='no_days_0']"), "Total Days"),

    TOTAL_ROOMS_OT(By.xpath("//input[@name='rooms_0']"), "Total Rooms"),

    //BOOK A Hotel Pge Enum

//    HOTEL_NAME(By.xpath("//input[@id='hotel_name_dis']"),"Hotel name"),
//    LOCATION_NAME(By.xpath("//input[@id='location_dis']"),"Location name"),
//    ROOM_TYPE(By.xpath("//input[@id='room_type_dis']"),"Room Type"),
//    PRICE_PER_NIGHT(By.xpath("//input[@id='price_night_dis']"),"Price per night"),
//    TOTAL_DAYS(By.xpath("//input[@id='total_days_dis']"),"Total Days"),
//    TOTAL_ROOMS(By.xpath("//input[@id='room_num_dis']"),"Total Rooms"),
//    TOATAL_PRICE(By.xpath("//input[@id='total_price_dis']"),"Total price without gst"),
//    GST_PRICE(By.xpath("//input[@id='gst_dis']"),"GST Price"),
//    TOTAL_BILLED_PRICE(By.xpath("//input[@id='final_price_dis']"),"Total Billed Price"),
//    CLICKLOGOUT(By.xpath("//a[normalize-space()='Logout']"),"Clcik LogOut"),
//    LOGOUTSUCCESS(By.xpath("//td[@class='reg_success']"),"Log out success message"),
//
//    FIRST_NAME(By.xpath("//input[@id='first_name']")," Firstname"),
//    LAST_NAME(By.xpath("//input[@id='last_name']"),"Lastname"),
//    BILLING_ADDRESS(By.xpath("//textarea[@id='address']"),"Billing Address"),
//    CREDIT_CARD(By.xpath("//input[@id='cc_num']"),"Credit card"),
//    CREDIT_CARD_TYPE(By.xpath("//select[@id='cc_type']"),"Credit card Type"),
//    EXPIRY_DATE_MONTH(By.xpath("//select[@id='cc_exp_month']"),"Expiry Month"),
//    EXPIRY_DATE_YEAR(By.xpath("//select[@id='cc_exp_year']"),"Expiry year"),
//    CVV_NO(By.xpath("//input[@id='cc_cvv']"),"Cvv number"),
//    CLICK_BOOK_NOW(By.xpath("//input[@id='book_now']")," Click book now"),
//    VERIFY_ORDER_ID(By.xpath("//input[@id='order_no']"),"verify order id"),

    HOTEL_NAME(By.xpath("//input[@name='hotel_name_dis']"), "Hotel name"),

    LOCATION_NAME(By.xpath("//input[@name='location_dis']"), "Location name"),

    ROOM_TYPE(By.xpath("//input[@name='room_type_dis']"), "Room Type"),

    PRICE_PER_NIGHT(By.xpath("//input[@name='price_night_dis']"), "Price per night"),

    TOTAL_DAYS(By.xpath("//input[@name='total_days_dis']"), "Total Days"),

    TOTAL_ROOMS(By.xpath("//input[@name='room_num_dis']"), "Total Rooms"),

    TOATAL_PRICE(By.xpath("//input[@name='total_price_dis']"), "Total price without gst"),

    GST_PRICE(By.xpath("//input[@name='gst_dis']"), "GST Price"),

    TOTAL_BILLED_PRICE(By.xpath("//input[@name='final_price_dis']"), "Total Billed Price"),

    CLICKLOGOUT(By.xpath("//a[normalize-space(text())='Logout']"), "Click LogOut"),

    LOGOUTSUCCESS(By.xpath("//td[@class='reg_success']"), "Log out success message"),

    FIRST_NAME(By.xpath("//input[@name='first_name']"), "Firstname"),

    LAST_NAME(By.xpath("//input[@name='last_name']"), "Lastname"),

    BILLING_ADDRESS(By.xpath("//textarea[@name='address']"), "Billing Address"),

    CREDIT_CARD(By.xpath("//input[@name='cc_num']"), "Credit card"),

    CREDIT_CARD_TYPE(By.xpath("//select[@name='cc_type']"), "Credit card Type"),

    EXPIRY_DATE_MONTH(By.xpath("//select[@name='cc_exp_month']"), "Expiry Month"),

    EXPIRY_DATE_YEAR(By.xpath("//select[@name='cc_exp_year']"), "Expiry year"),

    CVV_NO(By.xpath("//input[@name='cc_cvv']"), "CVV number"),

    CLICK_BOOK_NOW(By.xpath("//input[@name='book_now']"), "Click Book Now"),

    VERIFY_ORDER_ID(By.xpath("//input[@name='order_no']"), "Verify order id"),

// Verify Each Title

    LOGINPAGE_TITLE(By.xpath("//td[contains(text(),'Existing User Login')]"),"Login PAge Title"),
    SEARCH_PAGE_TITLE(By.xpath("//td[contains(text(),'Search Hotel')]"), "Search Page Title"),
    SELECT_HOTEL_TITLE(By.xpath("//td[@class='login_title']"), "Select the hotel"),
    BOOK_A_HOTEL_TITLE(By.xpath("//td[normalize-space()='Book A Hotel']"), "Book a Hotel Form"),
    BOOKED_ITERARY_TITLE(By.xpath("//td[contains(text(),'Booked Itinerary')]"),"Booker Iterary Page"),
    CHANGE_PASSWORD_TITLE(By.xpath("//strong[contains(text(),'Change Password')]"),"Change password page"),
    LOG_OUT_TITLE(By.xpath("//a[normalize-space()='Click here to login again']")," Log out page");

    private final By locator;
     private final String descp;
    SearchPageEnum(By locator,String descp) {

        this.locator= locator;
        this.descp=descp;
    }
    public String getDescp(){
        return descp;
    }
    public By getLocator(){

        if(locator!=null){
            return locator;
        }else{
            return null;
        }
    }
}
