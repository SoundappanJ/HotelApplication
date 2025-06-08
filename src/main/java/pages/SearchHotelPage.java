package pages;

import TestData.TestData;
import core.DriverManager;
import enums.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ConfigReaderUtil;
import utils.NewlyGeneratedOrderId;
import utils.PageUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SearchHotelPage {
    WebDriver driver;
    BookedItineraryPage booked;

    public SearchHotelPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean ClickSearch(){
        System.out.println("Click Search");
        WebElement search = PageUtil.waitForClickability(DriverManager.getDriver(),SearchPageEnum.CLICK_SEARCH_PAGE.getLocator(), Timeout.TEN_SEC);
        search.click();
        return true;

    }

    public boolean SelectLoaction(LocationEnum locationEnum) {
        System.out.println("Select The Location");
        WebElement Location = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_LOCATION_DROPDOWN.getLocator(), Timeout.TEN_SEC);
        Select select = new Select(Location);
        select.selectByVisibleText(locationEnum.getLocation());

        // Verify the selected option
        String selectedText = select.getFirstSelectedOption().getText();
        System.out.println("SelectedText: " + selectedText);
        return selectedText.equals(locationEnum.getLocation());
        //  return true;
    }
    public String getSelectedLocation() {
        WebElement location = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_LOCATION_DROPDOWN.getLocator(), Timeout.TEN_SEC);
        Select locationSelect = new Select(location);
        return locationSelect.getFirstSelectedOption().getText();
    }


    public boolean SelectHotel(HotelEnum hotelEnum) {
        System.out.println("Select the Hotel");
        WebElement Hotel = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_HOTEL_DROPDOWN.getLocator(), Timeout.TEN_SEC);
        Select select = new Select(Hotel);
        select.selectByVisibleText(hotelEnum.getHotel());
        String selectedText = select.getFirstSelectedOption().getText();
        System.out.println("SelectedText: " + selectedText);
        return selectedText.equals(hotelEnum.getHotel());
    }

    public String getSelectedHotelName() {
        WebElement Hotel = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_HOTEL_DROPDOWN.getLocator(), Timeout.TEN_SEC);
        Select hotelSelect = new Select(Hotel);
        return hotelSelect.getFirstSelectedOption().getText();
    }


    public boolean SelectRoomType(RoomTypeEnum roomTypeEnum) {
        System.out.println("Select the Room Type");
        WebElement roomType = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_ROOM_TYPE.getLocator(), Timeout.TEN_SEC);
        Select select = new Select(roomType);
        select.selectByVisibleText(roomTypeEnum.getroomtype());
        String selectedText = select.getFirstSelectedOption().getText();
        System.out.println("Selected Text: " + selectedText);
        return selectedText.equals(roomTypeEnum.getroomtype());
    }
    public String getSelectedHotelRoomType() {
        WebElement roomtype = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_ROOM_TYPE.getLocator(), Timeout.TEN_SEC);
        Select roomtypeSelect = new Select(roomtype);
        return roomtypeSelect.getFirstSelectedOption().getText();
    }


    public boolean SelectTotalRooms(TotalRoomsEnum totalRoomsEnum) {
        System.out.println("Select Total Rooms");
        WebElement totalroom = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_TOTAL_ROOMS.getLocator(), Timeout.TEN_SEC);
        Select select = new Select(totalroom);
        select.selectByVisibleText(totalRoomsEnum.getTotalRooms());
        String selectedText = select.getFirstSelectedOption().getText();
        System.out.println("Selected Text: " + selectedText);
        return selectedText.equals(totalRoomsEnum.getTotalRooms());
    }
    public String getSelectedTotalRooms() {
        WebElement totalrooms = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_TOTAL_ROOMS.getLocator(), Timeout.TEN_SEC);
        Select totalroomselect = new Select(totalrooms);
        return totalroomselect.getFirstSelectedOption().getText();
    }


    public boolean GiveCheckIN_CheckOUT_PLUS() {

        //CHECK IN DATE
        System.out.println("Give Check-IN Date");
        WebElement checkin = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.SELECT_CHECK_IN.getLocator(), Timeout.TEN_SEC);
        checkin.clear();
        LocalDate today = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String checkIn = today.plusDays(7).format(format);
        checkin.sendKeys(checkIn);
        System.out.println("checkIN Date :" + checkIn);

        //CHECK OUT DATE
        System.out.println("Give Check-OUT Date");
        WebElement checkout = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.SELECT_CHECK_OUT.getLocator(), Timeout.TEN_SEC);
        checkout.clear();
        String checkOut = today.plusDays(5).format(format);
        checkout.sendKeys(checkOut);
        System.out.println("checkOUT Date :" + checkOut);
        WebElement clicksubmit = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.CLICK_SUBMIT.getLocator(), Timeout.TEN_SEC);
        clicksubmit.click();


        //Error message
        WebElement errormessage = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.ERROR_CHECK_IN.getLocator(), Timeout.TEN_SEC);
        String Error = errormessage.getText();
        System.out.println("Error Message: " + Error);
        return Error.contains("Check-In Date shall be before than Check-Out Date");
    }

    public boolean getCheckIN_CheckOUT_MINUS() {
        // Check-IN
        System.out.println("GIVE CHECKIN date");
        WebElement checkin = PageUtil.waitForVisibility(
                DriverManager.getDriver(),
                SearchPageEnum.SELECT_CHECK_IN.getLocator(),
                Timeout.TEN_SEC
        );
        checkin.clear();

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String checkInDate = today.minusDays(5).format(formatter);
        System.out.println("Check In Date: " + checkInDate);
        checkin.sendKeys(checkInDate);

        // Check-OUT
        System.out.println("Give CHECK OUT Date");
        WebElement checkout = PageUtil.waitForVisibility(
                DriverManager.getDriver(),
                SearchPageEnum.SELECT_CHECK_OUT.getLocator(),
                Timeout.TEN_SEC
        );
        checkout.clear();
        String checkOutDate = today.minusDays(3).format(formatter);
        System.out.println("Check Out Date: " + checkOutDate);
        checkout.sendKeys(checkOutDate);
        WebElement clicksubmit = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.CLICK_SUBMIT.getLocator(), Timeout.TEN_SEC);
        clicksubmit.click();


        // Verify Error Message
        System.out.println("Checking error message...");
        WebElement errorElement = PageUtil.waitForVisibility(
                DriverManager.getDriver(),
                SearchPageEnum.ERROR_MINUS_CHECK_IN.getLocator(),
                Timeout.TEN_SEC
        );
        String errorMsg = errorElement.getText();
        System.out.println("Error Message: " + errorMsg);
        return errorMsg.contains("Check-In Date should be either Today or Later Date");
    }

    public boolean SelectTotalAdult(TotalAdultEnum totalAdultEnum) {
        System.out.println("Select the Total Adult");
        WebElement totaladult = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_NO_ADULT.getLocator(), Timeout.TEN_SEC);
        Select select = new Select(totaladult);
        select.selectByVisibleText(totalAdultEnum.getlocator());
        String selectedoption = select.getFirstSelectedOption().getText();
        System.out.println("Selected option:" + selectedoption);
        return selectedoption.equals(totalAdultEnum.getlocator());

    }

    public String getSelectedTotalAdult() {
        WebElement totalAdult = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_NO_ADULT.getLocator(), Timeout.TEN_SEC);
        Select totalAdultSelect = new Select(totalAdult);
        return totalAdultSelect.getFirstSelectedOption().getText();
    }


    public boolean SelectTotalChild(TotalChildEnum totalChildEnum) {
        System.out.println("Select the Total Child");
        WebElement totalchild = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.SELECT_NO_CHILD.getLocator(), Timeout.TEN_SEC);
        Select select = new Select(totalchild);
        select.selectByVisibleText(totalChildEnum.getlocator());
        String Selectedoption = select.getFirstSelectedOption().getText();
        WebElement clicksubmit = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.CLICK_SUBMIT.getLocator(), Timeout.TEN_SEC);
        clicksubmit.click();

        SearchPageEnum.CLICK_SUBMIT.getLocator();
        System.out.println("Selected option: " + Selectedoption);
        return Selectedoption.equals(totalChildEnum.getlocator());
    }

    public String getSelectedTotalChild() {
        WebElement TotalChild = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.SELECT_NO_CHILD.getLocator(), Timeout.TEN_SEC);
        Select ChildSelect = new Select(TotalChild);
        return ChildSelect.getFirstSelectedOption().getText();
    }



    public String checkinDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String Checkin = today.format(formatter);
        return Checkin;
    }

    public String CheckOut() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String CheckOut = today.plusDays(1).format(formatter);
        return CheckOut;
    }

    public boolean ClickSearchButton() {
        WebElement clicksubmit = PageUtil.waitForClickability(DriverManager.getDriver(), SearchPageEnum.CLICK_SUBMIT.getLocator(), Timeout.TEN_SEC);
        clicksubmit.click();
        return true;
    }

    public boolean isDisplayedLocationSameAsSelected(LocationEnum expectedLocation) {
        System.out.println("Verifying that displayed location matches selected location...");

        WebElement checkin = PageUtil.waitForVisibility(
                DriverManager.getDriver(),
                SearchPageEnum.SELECT_CHECK_IN.getLocator(),
                Timeout.TEN_SEC
        );

        String expectedCheckinDate = checkinDate();
        checkin.clear();
        checkin.sendKeys(expectedCheckinDate);


        WebElement checkout = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.SELECT_CHECK_OUT.getLocator(), Timeout.TEN_SEC);
        String expectedCheckOutDate = CheckOut();
        checkout.clear();
        checkout.sendKeys(expectedCheckOutDate);

        ClickSearchButton();


        // Get the displayed location value from the Select Hotel page
        WebElement displayedLocationElement = PageUtil.waitForVisibility(
                DriverManager.getDriver(),
                SearchPageEnum.GET_DISPLAY_LOC.getLocator(),
                Timeout.TEN_SEC
        );
        String displayedLocation = displayedLocationElement.getAttribute("value").trim();

        // Get the selected location in dropdown
        System.out.println("Expected Location: " + expectedLocation.getLocation());
        System.out.println("Displayed Location in hotel section: " + displayedLocation);

        // Compare both with the expected location
        return displayedLocation.equals(expectedLocation.getLocation());
    }

    public boolean verifyDisplayedCheckIn(SearchPageEnum searchPageEnum) {
        System.out.println("Verify Displayed Check_in");


        WebElement displayedCheckInElement = PageUtil.waitForVisibility(
                DriverManager.getDriver(),
                SearchPageEnum.GET_DISPLAYED_CHECKIN_DATE.getLocator(),
                Timeout.TEN_SEC
        );

        String displayedCheckinDate = displayedCheckInElement.getAttribute("value").trim();
        String Expecteddate = checkinDate();
        System.out.println("Expected Checkin Date: " + Expecteddate);
        System.out.println("Displayed Checkin Date: " + displayedCheckinDate);

        return displayedCheckinDate.equals(Expecteddate);
    }

    public boolean verifyDisplayedCheckout(SearchPageEnum searchPageEnum) {
        System.out.println("Verify Displayed Check out Date");

        WebElement dispalyedCheckoutelement = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.GET_DISPLAYED_CHECKOUT_DATE.getLocator(), Timeout.TEN_SEC);
        String displayedCheckoutDate = dispalyedCheckoutelement.getAttribute("value").trim();
        String ExpectedDate = CheckOut();
        System.out.println("Expected CheckOut Date: " + ExpectedDate);
        System.out.println("Displayed Checkout Date: " + displayedCheckoutDate);

        return displayedCheckoutDate.equals(ExpectedDate);
    }

    public boolean verifyTotalrooms(TotalRoomsEnum totalRoomsEnum) {
        System.out.println("verify no of rooms Displayed");
        WebElement dispalyedTotalrooms = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.GET_DISPLAYED_TOTAL_ROOMS.getLocator(), Timeout.TEN_SEC);
        String displayedTotalrooms = dispalyedTotalrooms.getAttribute("value").trim();

        String expectedTotalRooms = totalRoomsEnum.getTotalRooms().trim();                    // e.g., "1 - One"

        // Extract only the numeric part using split or regex
        String displayedNumber = displayedTotalrooms.split(" ")[0];
        String expectedNumber = expectedTotalRooms.split(" ")[0];

        System.out.println("Expected Total no of rooms: " + expectedNumber + " Rooms");
        System.out.println("Displayed Total no of rooms: " + displayedNumber + " Rooms");
        return displayedNumber.equals(expectedNumber);
    }

    public boolean verifyRoomType(RoomTypeEnum roomTypeEnum) {
        System.out.println("verify Displayed Room Type");
        WebElement displayedRoomTypeElement = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.GET_DISPALYED_ROOMTYPE.getLocator(), Timeout.TEN_SEC);
        String displayedroomtype = displayedRoomTypeElement.getAttribute("value").trim();
        System.out.println("Expected Room type: " + roomTypeEnum.getroomtype());
        System.out.println("Displayed Room Type: " + displayedroomtype);
        return displayedroomtype.equals(roomTypeEnum.getroomtype());
    }

    public boolean clcikcontinue() {
        WebElement clickContinue = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.CLICK_CONTINUE.getLocator(), Timeout.TEN_SEC);
        clickContinue.click();
        return true;
    }

    public boolean clcikHotelAndContiue() {
        WebElement clickHotel = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.SELECT_HOTEL_RADIO_BUTTON.getLocator(), Timeout.TEN_SEC);
        clickHotel.click();
        clcikcontinue();
        return true;
    }

    public boolean Calculateprice(SearchPageEnum searchPageEnum) {

        //price per night
        WebElement pricepernight = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.PRICE_PER_NIGHT_OT.getLocator(), Timeout.TEN_SEC);
        String priceText = pricepernight.getAttribute("value");
        int priceNumberOnly = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
        System.out.println("Price per night: " + priceNumberOnly);

        //no of rooms
        WebElement totalRoomseElement = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.TOTAL_ROOMS_OT.getLocator(), Timeout.TEN_SEC);
        String totalrooms = totalRoomseElement.getAttribute("value").trim();
        int totalRooms = Integer.parseInt(totalrooms.replaceAll("[^0-9]", ""));
        System.out.println("Total Rooms: " + totalRooms);


        //no of days
        WebElement totaldaysElement = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.TOTAL_DAYS_OT.getLocator(), Timeout.TEN_SEC);
        String totaldays = totaldaysElement.getAttribute("value").trim();
        int totalDays = Integer.parseInt(totaldays.replaceAll("[^0-9]", ""));
        System.out.println("Total Days: " + totalDays);


        // Calculated price (excluding GST)
        int expectedTotalPrice = priceNumberOnly * totalRooms * totalDays;
        System.out.println("Expected Total Price (No GST): AUD $" + expectedTotalPrice);
        //click hotel and continue
        clcikHotelAndContiue();

        //Total price
        WebElement totalpriceElement = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.TOATAL_PRICE.getLocator(), Timeout.TEN_SEC);
        String total_price = totalpriceElement.getAttribute("value");
        int totalpriceonly = Integer.parseInt(total_price.replaceAll("[^0-9]", ""));
        System.out.println("Total Price(NO GST): " + "AUD $" + totalpriceonly);

        boolean result = (totalpriceonly == expectedTotalPrice);
        return result;

    }

    public boolean logoutSuccess() {
        System.out.println("click log out button");
        //hotelname
        WebElement logoutpressed = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.CLICKLOGOUT.getLocator(), Timeout.TEN_SEC);
        logoutpressed.click();
        System.out.println("clicked log out button");
        System.out.println("verify log out success");
        WebElement logoutsucess = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.LOGOUTSUCCESS.getLocator(), Timeout.TEN_SEC);
        //log out success message
        String actualMessage = logoutsucess.getText().trim();
        String expectedMessage = "You have successfully logged out. Click here to login again"; // update this based on your app's actual message

        System.out.println("Logged out successfully message: " + actualMessage);
        System.out.println("Logged out successfully message " + expectedMessage);
        return actualMessage.equals(expectedMessage);
    }

    public boolean totalBilledPrice() {
        System.out.println("Billed Total price");

        //price per night
        WebElement pricepernight = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.PRICE_PER_NIGHT.getLocator(), Timeout.TEN_SEC);
        String priceText = pricepernight.getAttribute("value");
        Double priceNumberOnly = Double.parseDouble(priceText.replaceAll("[^0-9]", ""));
        System.out.println("Price per night: " + priceNumberOnly);

        //no of rooms
        WebElement totalRoomseElement = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.TOTAL_ROOMS.getLocator(), Timeout.TEN_SEC);
        String totalrooms = totalRoomseElement.getAttribute("value").trim();
        Double totalRooms = Double.parseDouble(totalrooms.replaceAll("[^0-9]", ""));
        System.out.println("Total Rooms: " + totalRooms);


        //no of days
        WebElement totaldaysElement = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.TOTAL_DAYS.getLocator(), Timeout.TEN_SEC);
        String totaldays = totaldaysElement.getAttribute("value").trim();
        Double totalDays = Double.parseDouble(totaldays.replaceAll("[^0-9]", ""));
        System.out.println("Total Days: " + totalDays);

        //GST
        WebElement GSTElement = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.GST_PRICE.getLocator(), Timeout.TEN_SEC);

        // Calculated price (excluding GST)
        Double expectedTotalPrice = (priceNumberOnly * totalRooms * totalDays);
        double gstprice = (double) (expectedTotalPrice * 0.10);
        double totalbilledprice = expectedTotalPrice + gstprice;
        System.out.println("Expected Total Price (With GST): AUD $" + totalbilledprice);

        //Total Billed price
        WebElement billedpriceelemet = PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.TOTAL_BILLED_PRICE.getLocator(), Timeout.TEN_SEC);
        String billedpirce = billedpriceelemet.getAttribute("value").trim();
        String cleanedPrice = billedpirce.replaceAll("[^0-9.]", "");
        double Totalprice = Double.parseDouble(cleanedPrice);

        System.out.println("Actual Billed price: " + "AUD $" + Totalprice);
        boolean result = Totalprice == totalbilledprice;
        return result;
    }

    public boolean verifyNewandPreviousPage() {
        System.out.println("verify Selected Details");

        SearchPageEnum[] filedValidate={
                SearchPageEnum.HOTEL_NAME,
                SearchPageEnum.LOCATION_NAME,
                SearchPageEnum.ROOM_TYPE,
                SearchPageEnum.TOTAL_ROOMS,
                SearchPageEnum.TOTAL_DAYS,
                SearchPageEnum.PRICE_PER_NIGHT,
                SearchPageEnum.TOATAL_PRICE
        };
        boolean allmatch=true;
        for(SearchPageEnum searchPageEnum:filedValidate){
            WebElement element=PageUtil.waitForVisibility(DriverManager.getDriver(),searchPageEnum.getLocator(),Timeout.TEN_SEC);

        String displayed=element.getAttribute("value").trim();
            String expectedValue = TestData.getExpectedValue(searchPageEnum.getDescp());

            System.out.println("Validating: " + searchPageEnum.getDescp());
            System.out.println("Expected: " + expectedValue + " | Displayed: " + displayed);

            if (!displayed.equalsIgnoreCase(expectedValue)) {
                System.out.println("Mismatch found in: " + searchPageEnum.getDescp());
                allmatch = false;
            }
        }
        return allmatch;
    }

    public boolean checkBilledDetails(){
        System.out.println("verify final Billed price");

        SearchPageEnum[] fieldvalidate={
                    SearchPageEnum.TOATAL_PRICE,SearchPageEnum.GST_PRICE,SearchPageEnum.TOTAL_BILLED_PRICE

        } ;
        boolean allmatch=true;
        for(SearchPageEnum searchPageEnum:fieldvalidate){
            WebElement element=PageUtil.waitForVisibility(DriverManager.getDriver(),searchPageEnum.getLocator(),Timeout.TEN_SEC);

            String displayed=element.getAttribute("value").trim();
            String expected=TestData.getExpectedValue(searchPageEnum.getDescp());
            System.out.println("Validating: "+searchPageEnum.getDescp());
            System.out.println("Expected: "+ expected+"|Displayed:"+displayed);
            if(!displayed.equalsIgnoreCase(expected)){
                System.out.println("Mismatch found in "+searchPageEnum.getDescp());
                allmatch =false;
            }

        }
        return allmatch;
    }

    public boolean verifySelectedandDisplayedData(String hotel, String roomType, int noOfRooms,
                                                  String checkIn, String checkOut,
                                                  int noOfAdults, int noOfChildren) {

        System.out.println("Verifying Selected and Displayed Data...");

        String expectedHotel = TestData.getExpectedValue("hotel name");

        String expectedRoomType = TestData.getExpectedValue("room type");

        String expectedNoOfRooms = TestData.getExpectedValue("selected rooms");

        String expectedCheckIn = TestData.getExpectedValue("check in");

        String expectedCheckOut = TestData.getExpectedValue("check out");

        String expectedNoOfAdults = TestData.getExpectedValue("total adults");

        String expectedNoOfChildren =TestData.getExpectedValue("total child");

        // Logs
        System.out.println("Expected Hotel: " + expectedHotel + " | Displayed: " + hotel);
        System.out.println("Expected Room Type: " + expectedRoomType + " | Displayed: " + roomType);
        System.out.println("Expected No. of Rooms: " + expectedNoOfRooms + " | Displayed: " + noOfRooms);
        System.out.println("Expected Check-In: " + expectedCheckIn + " | Displayed: " + checkIn);
        System.out.println("Expected Check-Out: " + expectedCheckOut + " | Displayed: " + checkOut);
        System.out.println("Expected Adults: " + expectedNoOfAdults + " | Displayed: " + noOfAdults);
        System.out.println("Expected Children: " + expectedNoOfChildren + " | Displayed: " + noOfChildren);

        // Assertions
        Assert.assertEquals(expectedHotel, hotel, "Hotel mismatch");
        Assert.assertEquals(expectedRoomType, roomType, "Room Type mismatch");
        Assert.assertEquals(expectedNoOfRooms, String.valueOf(noOfRooms), "No of Rooms mismatch");
        Assert.assertEquals(expectedCheckIn, checkIn, "Check-In date mismatch");
        Assert.assertEquals(expectedCheckOut, checkOut, "Check-Out date mismatch");
        Assert.assertEquals(expectedNoOfAdults, String.valueOf(noOfAdults), "No of Adults mismatch");
        Assert.assertEquals(expectedNoOfChildren, String.valueOf(noOfChildren), "No of Children mismatch");

        return true;
    }

    public String firstname(){
        WebElement firstname=PageUtil.waitForVisibility(DriverManager.getDriver(),SearchPageEnum.FIRST_NAME.getLocator(), Timeout.TEN_SEC);
        String value=ConfigReaderUtil.get("firstname");
        firstname.sendKeys(value);
        return value;

    }
    public String lastname() {
        WebElement lastname = PageUtil.waitForVisibility(
                DriverManager.getDriver(),
                SearchPageEnum.LAST_NAME.getLocator(),
                Timeout.TEN_SEC
        );

        String lastNameValue = ConfigReaderUtil.get("lastname");
        if (lastNameValue == null || lastNameValue.trim().isEmpty()) {
            throw new IllegalArgumentException("Config value for 'lastname' is null or empty");
        }

        lastname.sendKeys(lastNameValue);
        return lastNameValue;
    }
    public String address(){
        WebElement address=PageUtil.waitForVisibility(DriverManager.getDriver(),SearchPageEnum.BILLING_ADDRESS.getLocator(), Timeout.TEN_SEC);
        String value=ConfigReaderUtil.get("Billing_address");
        address.sendKeys(value);
        return value;
    }

    public String credicardno(){
        WebElement cardno=PageUtil.waitForVisibility(DriverManager.getDriver(),SearchPageEnum.CREDIT_CARD.getLocator(), Timeout.TEN_SEC);
        String value=ConfigReaderUtil.get("credit_card_no");
        cardno.sendKeys(value);
        return value;

    }

    public boolean cardType(){
        WebElement cardtype=PageUtil.waitForVisibility(DriverManager.getDriver(),SearchPageEnum.CREDIT_CARD_TYPE.getLocator(),Timeout.TEN_SEC);
        Select select=new Select(cardtype);
        String expectedcardtype=CreditcardTypeEnum.AMEX.getCardType();
        select.selectByVisibleText(expectedcardtype);
        System.out.println("Selected card type: "+   expectedcardtype);
        return true;

    }

    public boolean expiryMonth(){
        WebElement expiryMonth=PageUtil.waitForVisibility(DriverManager.getDriver(),SearchPageEnum.EXPIRY_DATE_MONTH.getLocator(), Timeout.TEN_SEC);
        Select selectMonth=new Select(expiryMonth);
        String expectedmonth=ExpiryMonthEnum.APR.getMonth();
        selectMonth.selectByVisibleText(expectedmonth);
        System.out.println("Expiry Month: "+expectedmonth);
        return true;

    }

    public boolean expiryYear(){
        WebElement expiryYear=PageUtil.waitForVisibility(DriverManager.getDriver(), SearchPageEnum.EXPIRY_DATE_YEAR.getLocator(), Timeout.TEN_SEC);
        Select selectyear=new Select(expiryYear);
        String expectedyear=expiryYearEnum.Y27.getYear();
        selectyear.selectByVisibleText(expectedyear);
        System.out.println("Expiry Year: "+expectedyear);
        return true ;

    }

    public String cvvNo(){
        WebElement cvvno=PageUtil.waitForVisibility(DriverManager.getDriver(),SearchPageEnum.CVV_NO.getLocator(), Timeout.TEN_SEC);
        String value=ConfigReaderUtil.get("cvv_no");
        cvvno.sendKeys(value);
        return value;

    }

    public boolean clickBook(){
        WebElement click=PageUtil.waitForVisibility(DriverManager.getDriver(),SearchPageEnum.CLICK_BOOK_NOW.getLocator(),Timeout.TEN_SEC);
        click.click();
        return true;

    }

    public boolean BookHotel(){
        System.out.println("Verify Order number generated after booking");
        //Enter firstname
        firstname();
        //Enter lastname

        lastname();
        //enter address
        address();
        //credit card no
        credicardno();

        //select card type
        cardType();

        //Select expiry month
        expiryMonth();
        //Select expiry year
        expiryYear();

        //Enter Cvv number
        cvvNo();

        //click book now
        clickBook();

        //verify orderid
        verifyorderId();


        return true;

    }

    public boolean verifyorderId(){
        WebElement verifyOrderId=PageUtil.waitForVisibility(DriverManager.getDriver(),SearchPageEnum.VERIFY_ORDER_ID.getLocator(), Timeout.TEN_SEC);


        String generatedOrderId = verifyOrderId.getAttribute("value").trim();
        NewlyGeneratedOrderId.setNewOrderId(generatedOrderId);String orderId=verifyOrderId.getAttribute("value").trim();
        if(generatedOrderId!=null){
            System.out.println("order Id successfully generated");
        }else{
            System.out.println("order id not generated");
        }
        System.out.println("order id: "+orderId);
        boolean result=verifyOrderId.isDisplayed();
        return result;
    }
    public  String BookedorderId(){
        WebElement verifyOrderId=PageUtil.waitForVisibility(DriverManager.getDriver(),SearchPageEnum.VERIFY_ORDER_ID.getLocator(), Timeout.TEN_SEC);


        String generatedOrderId = verifyOrderId.getAttribute("value").trim();
        NewlyGeneratedOrderId.setNewOrderId(generatedOrderId);
       // String orderId=verifyOrderId.getAttribute("value").trim();
        if(generatedOrderId!=null){
            System.out.println("order Id successfully generated");
        }else{
            System.out.println("order id not generated");
        }
        System.out.println("order id: "+generatedOrderId);

        return generatedOrderId;

    }




    }






