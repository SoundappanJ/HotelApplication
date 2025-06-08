//package enums;
//
//import org.openqa.selenium.By;
//
//public enum CHECKINOUTENUM {
//
//    SELECT_CHECK_IN(By.xpath("//input[@id='datepick_in']"),"Give Check-IN"),
//    SELECT_CHECK_OUT(By.id("datepick_out"),"Give Check-OUT"),
//    ERROR_CHECK_IN(By.id("checkin_span"),"Error Message for checkin"),
//    ERROR_CHECK_OUT(By.id("checkout_span"),"Error Message for checkOut"),
//    ERROR_MINUS_CHECK_IN(By.xpath("//span[@id='checkin_span' and contains(text(),'Check-In Date should be either Today or Later Date')]"),"Error Message for checkin");
//    private final By locator;
//    private final String descp;
//    CHECKINOUTENUM(By locator, String descp) {
//        this.locator= locator;
//        this.descp=descp;
//    }
//    public By getlocator(){
//        return locator;
//    }
//}
