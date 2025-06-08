package pages;

import TestData.TestData;
import core.DriverManager;
import core.Listener;
import enums.*;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.NewlyGeneratedOrderId;
import utils.PageUtil;

import static core.DriverManager.getDriver;
import static core.DriverManager.quitDriver;

@Listeners(Listener.class)
public class HotelApplicationPageTest {
    WebDriver driver;
    LoginPage login;
    SearchHotelPage search;
    BookedItineraryPage booked;

    @BeforeTest
    public void startTest() {
        driver = getDriver();
        driver.get("https://adactinhotelapp.com/");
        login=PageFactory.initElements(getDriver(),LoginPage.class);
        search=PageFactory.initElements(getDriver(),SearchHotelPage.class);
        booked=PageFactory.initElements(getDriver(), BookedItineraryPage.class);
}
    @Test(priority  =1)
    @Description("TC-101 To verify valid login details")
    public void TC_101_verifyValidLogin() {
        System.out.println("===== TC_101 To verify valid login details=====");
        //Step1: Launch Application
        stepLog("Launch Adactin Hotel Web Application");
         //Step 2: Login
    stepLog("Login Page");
        System.out.println("->Enter Login credentials");
    Assert.assertTrue(login.isPageLoaded(), "URL not Loaded");
    Assert.assertTrue(login.LoginCredentials(), "Invalid Login Credentials");
    Assert.assertTrue(login.LoginSuccess(), "Login Failed");

        System.out.println("===== TC_101 completed successfully =====");

}

    @Test(priority = 3)
    @Description("TC - 102 To verify whether the check-out date field accepts a later date than check-in date.")

    public void TC_102_verifyCheckoutAfterCheckinDate() {
        System.out.println("===== TC_102: To verify whether the check-out date field accepts a later date than check-in date.=====");
        //Step 6: Enter check-in-date later than the check-out-date field as in test data.
        //Check-in-date:
        //today + 7 date
        //Checkout date:today+5 date
        // Step 5: Verify error message is shown

        stepLog("checkIn and checkout error Plus");
        System.out.println("->Enter invalid later check-in than check-out dates");
        boolean isErrorDisplayed = search.GiveCheckIN_CheckOUT_PLUS();
        Assert.assertTrue(isErrorDisplayed, "Expected error message not displayed");

        System.out.println("===== TC_102 completed successfully =====");
         }
    @Test(priority = 4)
    @Description("TC-103 To check if error is date field is in the past")
    public void TC_103_verifyErrorForPastCheckInDate(){
        System.out.println("====TC_103: To check if error is date field is in the past.====");
        // Step 4: Enter check-in date as today - 5 and check-out as today - 3
        stepLog("Enter past check-in and check-out dates");

        // Step 5: Verify error message is shown
        stepLog("checkin and checkout error minus");
        boolean isErrorDisplayed=search.getCheckIN_CheckOUT_MINUS();
        Assert.assertTrue(isErrorDisplayed,"Error message not displayed");

        System.out.println("===== TC_103 completed successfully =====");

    }



    @Test(priority = 5)
    @Description("TC_104: To verify whether locations in Select Hotel page are displayed according to the location Selected in Search Hotel")
    public void TC_104_verifyLocationInSelectHotelMatchesSearchLocation(){
        System.out.println("====TC_104: To verify whether locations in Select Hotel page are displayed according to the location Selected in Search Hotel====");
        //Step 3: select location, hotel, roomtypes, total rooms,
        stepLog("Select location, Hotel, room type, total rooms");
        //Location
        boolean isSelectedL = search.SelectLoaction(LocationEnum.SYDNEY);
        System.out.println("Is Sydney Selected " + isSelectedL);
        Assert.assertTrue(isSelectedL, "Sydney Location Not selected");

        //Hotel
        boolean isSelectedH=search.SelectHotel(HotelEnum.HOTEL_CREEK);
        System.out.println("Is Creek Hotel Selected"+isSelectedH);
        Assert.assertTrue(isSelectedH,"Hotel Creek not Selected");

        //RoomType
        boolean isSelectedRT=search.SelectRoomType(RoomTypeEnum.STANDARD);
        System.out.println("Is Standard room type selected "+isSelectedRT);
        Assert.assertTrue(isSelectedRT,"Room Type not Selected ");

        //TotalRooms
        boolean isSelectedTR= search.SelectTotalRooms(TotalRoomsEnum.SELECT_TWO);
        System.out.println("Is One Room is Selected "+isSelectedTR);
        Assert.assertTrue(isSelectedTR,"One room not Selected");

        //Total Adult
        boolean isSelectedTA= search.SelectTotalAdult(TotalAdultEnum.SELECT_ONE);
        System.out.println("Is One Adult is Selected: "+isSelectedTA);
        Assert.assertTrue(isSelectedTA,"More than one adult is selected or adult not selected");


        //ToatlChild
        boolean isSelected=search.SelectTotalChild(TotalChildEnum.SELECT_DEFAULT);
        System.out.println("Is child Selected :"+isSelected);
        Assert.assertTrue(isSelected,"No child is selected");


        //Step 4: Click Search Button
        stepLog(" Click Search button");
        Assert.assertTrue(search.ClickSearchButton());



        //Step 5:Verify that hotel displayed is the same as selected in search Hotel form.
        Assert.assertTrue(search.isDisplayedLocationSameAsSelected(LocationEnum.SYDNEY),
                "Displayed location does not match selected location");

        System.out.println("===== TC_104 completed successfully =====");

    }

    @Test(priority = 6)
    @Description("TC_105: To verify date and Check Out date are being displayed in Select Hotel Page according to the dates selected in search Hotel.")
    public void TC_105_verifyDisplayedDatesInSelectHotel() {
//step 11:Verify that check-in-date and check-out-dates are the same as selected in search hotel form.
        System.out.println("====TC_105: To verify date and Check Out date are being displayed in Select Hotel Page according to the dates selected in search Hotel.====");
        stepLog("checkindate");
        Assert.assertTrue(search.verifyDisplayedCheckIn(SearchPageEnum.SELECT_CHECK_IN),"Checkin Date Mismatch");

        stepLog("checkOutdate");
        Assert.assertTrue(search.verifyDisplayedCheckout(SearchPageEnum.SELECT_CHECK_OUT),"Checkout Date Mismatch");

        System.out.println("===== TC_105 completed successfully =====");
    }
//To verify whether no. of rooms entry in Select Hotel page is same as the Number of rooms selected in search hotel page
    @Test(priority = 7)
    @Description("TC_106: To verify whether no. of rooms entry in Select Hotel page is same as the Number of rooms selected in search hotel page")
    public void TC_106_TestNumberOfRoomsSelectedMatches() {
        System.out.println("====TC_106: To verify whether no. of rooms entry in Select Hotel page is same as the Number of rooms selected in search hotel page.====");
        stepLog("verify selected and Displayed Total Rooms");
        //Step 11:  Verify that no. of rooms reflected according to the no. of rooms selected in search hotel page
        Assert.assertTrue(search.verifyTotalrooms(TotalRoomsEnum.SELECT_TWO),"Mismatch of total rooms data");

        System.out.println("===== TC_106 completed successfully =====");
    }

    //To verify whether Room Type in Select Hotel page is same as Room type selected in search hotel page
    @Test(priority = 8)
    @Description("TC_107: To verify whether Room Type in Select Hotel page is same as Room type selected in search hotel page")
    public void TC_107_TestRoomTypeSelectedMatches()
    {
        System.out.println("====TC_107: To verify whether Room Type in Select Hotel page is same as Room type selected in search hotel page====");
        stepLog("verify selected and displayed room type");
        //Step 11: Verify that room type reflected is the same as selected in search hotel page.
        Assert.assertTrue(search.verifyRoomType(RoomTypeEnum.STANDARD),"Missmatch of total room type data");

        System.out.println("===== TC_107 completed successfully =====");
    }

    @Test(priority = 9)
    @Description("TC-108: To verify whether the total price (excl.GST) is calculated as “price per night * no. of nights* no of rooms”.")
    public void TC_108_verifyTotalPriceCalculation()
    {
        System.out.println("====TC_108: To verify whether the total price (excl.GST) is calculated as “price per night * no. of nights* no of rooms”.");
        stepLog("Verify Total Price Excluding GST");

        //step 12: Verify the total price(excl GST) is being calculated as (price-per-night*no-of-rooms*no-of-days)
        Assert.assertTrue(search.Calculateprice(SearchPageEnum.TOATAL_PRICE),"mismatch of total price data");

        System.out.println("===== TC_108 completed successfully =====");
    }

    @Test(priority = 19)
    @Description("TC-109: To verify when pressed, logout button logs out from the application.")
    public void TC_109_verifyLogoutFunctionality()
    {
        System.out.println("====TC_109: To verify when pressed, logout button logs out from the application.====");
        stepLog(" verify Logout Functionality");
        //step 13: Check the details, click on logout and verify if we have logged out from the application
        Assert.assertTrue(search.logoutSuccess(),"Logged out unsuccessfull");

        System.out.println("===== TC_109 completed successfully =====");
    }

    @Test(priority = 10)
    @Description("TC-110: To check correct total price is Being Calculated as “price per night*no of days*no of rooms in Book a hotel Page")
    public void TC_110_verifyTotalPriceCalculation() {
        System.out.println("====TC_110: To check correct total price is Being Calculated as “price per night*no of days*no of rooms in Book a hotel Page====");
        stepLog("verify Billing price including GST");
        Assert.assertTrue(search.totalBilledPrice(),"Missmatch of billed price and displayed price");
        System.out.println("===== TC_110 completed successfully =====");
    }


    @Test(priority = 11)
    @Description("Tc-111: To check Hotel name, Location, room type, Total Day, price per")
    public void TC_111_verifyHotelDetailsDisplay()
    {
        System.out.println("==== TC_111: To check Hotel name, Location, room type, Total Day, price per====");
        stepLog("verify entered details");

        boolean result = search.verifyNewandPreviousPage();
        Assert.assertTrue(result, "One or more displayed values do not match expected test data.");

        System.out.println("===== TC_111 completed successfully =====");
    }

    @Test(priority = 12)
    @Description("TC_112: To check correct Final billed price is Total Price + 10% Total price in Book a Hotel page")
    public void TC_112_testFinalBilledPriceCalculation()
    {
        System.out.println("TC_112: To check correct Final billed price is Total Price + 10% Total price in Book a Hotel page ");
        stepLog("verify  Final Billed price");

        boolean result=search.checkBilledDetails();
        Assert.assertTrue(result,"Displayed value mismatch");

        System.out.println("===== TC_112 completed successfully =====");
    }

    @Test(priority = 2)
    @Description("To verify whether the data displayed is same as the selected data in Book hotel page")
    public void TC_113_verifyDisplayedDataMatchesSelectedData()
    {
        System.out.println("===== TC_113: Verify selected and displayed booking data =====");

        stepLog("verify Displayed and selected text are same");

        // --- Expected values from enums or methods ---
        String actualHotel = HotelEnum.HOTEL_CREEK.getHotel();


        String actualRoomType = RoomTypeEnum.STANDARD.getroomtype();


        int actualNoOfRooms = TotalRoomsEnum.SELECT_TWO.getTotalroomvalue();


        String actualCheckIn = search.checkinDate();  // e.g., DateUtil.getTodayDate()


        String actualCheckOut = search.CheckOut();    // e.g., DateUtil.getFutureDate(1)


        int actualNoOfAdults = TotalAdultEnum.SELECT_ONE.getValue();  // If locator returns value


        int actualNoOfChildren = TotalChildEnum.SELECT_DEFAULT.getValue();  // Usually "0"


        // --- Final verification on Book Hotel page ---
        search.verifySelectedandDisplayedData(
                actualHotel,
                actualRoomType,
                actualNoOfRooms,
                actualCheckIn,
                actualCheckOut,
                actualNoOfAdults,
                actualNoOfChildren
        );

        System.out.println("===== TC_113 completed successfully =====");
    }

    @Test(priority = 13)
    @Description("TC_114: Verify Order number is generated in booking confirmation page")
    public void TC_114_verifyOrderNumberGenerated()
    {
        System.out.println("===== TC_114: Verify selected and displayed booking data =====");

        stepLog("verify booking confirmation");
        boolean reesult=search.BookHotel();
        Assert.assertTrue(reesult,"Order ID not Generated");

        System.out.println("===== TC_114 completed successfully =====");

    }

    @Test(priority = 17)
    @Description("TC_115: To verify whether the booked itinerary details are not editable.")
    public void TC_115_verifyBookedItineraryDetailsNotEditable()
    {
        System.out.println("===== TC_115: To verify whether the booked itinerary details are not editable. =====");
        stepLog("verify text not editable");
        boolean result=booked.verifyPageNotEditable();
        Assert.assertTrue(result,"Text not editable");
        System.out.println("===== TC_115 completed successfully =====");
    }


    @Test(priority = 16)
    @Description("TC_116: Verify booked itinerary details match the booking data")
    public void TC_116_verifyBookedItineraryReflectsCorrectBookingDetails()
    {
        System.out.println("===== TC_116: Verify booked itinerary details match booking =====");

        // Get expected values from test data
        String expectedOrderId = TestData.getExpectedValue("order id");
        String expectedHotelName = TestData.getExpectedValue("hotel name");
        String expectedLocation = TestData.getExpectedValue("location");
        String expectedNoOfRooms = TestData.getExpectedValue("total rooms");
        String expectedFirstName = TestData.getExpectedValue("first name");
        String expectedArrDate = TestData.getExpectedValue("arrival date");
        String expectedDepDate = TestData.getExpectedValue("departure date");
        String expectedRoomType = TestData.getExpectedValue("room type");
        String expectedPricePerNight = TestData.getExpectedValue("price per night");
        String expectedTotalPrice = TestData.getExpectedValue("price");

        // Perform verification
        boolean result = booked.verifyTableData(expectedOrderId,
                expectedHotelName,
                expectedLocation,
                expectedNoOfRooms,
                expectedFirstName,
                expectedArrDate,
                expectedDepDate,
                expectedRoomType,
                expectedPricePerNight,
                expectedTotalPrice);

        // Important: this assertion must not be commented out
        Assert.assertTrue(result, "Booked itinerary details verification failed for order ID: " + expectedOrderId);

        System.out.println("===== TC_116 completed successfully =====");
    }
    @Test(priority=17)
    @Description("TC-117: To check whether search order id query is working and displaying the relevant details")
    public void TC_117_verifySearchOrderIdDisplaysRelevantDetails() {
        System.out.println("====TC-117: To check whether search order id query is working and displaying the relevant details====");
        stepLog("verify search field");

        String orderId = TestData.getExpectedValue("order Id");
        // Replace with dynamically picked or pre-saved ID

        // Step 4: Enter the order ID in the search box and click 'Go'
        booked.searchOrderId(orderId);

        // Step 5: Verify that booking details are displayed
        boolean isDisplayed = booked.isBookingRowDisplayed(orderId);
        Assert.assertTrue(isDisplayed, "Booking details not displayed for Order ID: " + orderId);
        System.out.println("===== TC_117 completed successfully =====");
    }


    @Test(priority = 14)
    @Description("TC_118: Verify all the details of newly generated order number in booked itinerary page are correct and match with data during booking. ")
    public void TC_118_verifyNewOrderDetailsMatchBooking()
    {
        System.out.println("====TC_118: Verify all the details of newly generated order number in booked itinerary page are correct and match with data during booking.====");
        stepLog("verify Generated id match selected details");
        String generatedOrderId = NewlyGeneratedOrderId.setNewOrderId(search.BookedorderId());

        System.out.println("Generated Order ID: " + generatedOrderId);
        String expectedHotelName = TestData.getExpectedValue("hotel name");
        String expectedLocation = TestData.getExpectedValue("location");
        String expectedNoOfRooms = TestData.getExpectedValue("total rooms");
        String expectedFirstName = TestData.getExpectedValue("first name");
        String expectedArrDate = TestData.getExpectedValue("check in");
        String expectedDepDate = TestData.getExpectedValue("check out");
        String expectedRoomType = TestData.getExpectedValue("room type");
        String expectedPricePerNight = TestData.getExpectedValue("price per night");
        String expectedTotalPrice = TestData.getExpectedValue("price");


        boolean result=booked.verifyBookedData(generatedOrderId,expectedHotelName,expectedLocation,expectedNoOfRooms,expectedFirstName,expectedArrDate,expectedDepDate,expectedRoomType,expectedPricePerNight,expectedTotalPrice);{
            Assert.assertTrue(result, "Booked itinerary details verification failed for order ID: " + generatedOrderId);

            System.out.println("===== TC_118 completed successfully =====");

        }


    }
    @Test(priority = 18)
    @Description("TC_119: To verify that the order gets cancelled after click on Cancel order number link")
    public void TC_119_verifyOrderCancellation()
    {
        System.out.println("===TC_119: To verify that the order gets cancelled after click on Cancel order number link===");
        stepLog("Verify Booking Cancelled");
        String generatedOrderId = NewlyGeneratedOrderId.getNewOrderId();
        System.out.println("Generated Order ID: " + generatedOrderId);

        boolean clickCancel= booked.ClickCancel(generatedOrderId);
        Assert.assertTrue(clickCancel,"Clcik Cancel failed");

        // Step 8: Verify the order is not present anymore
        booked.searchOrderId(generatedOrderId);


        boolean isOrderStillPresent = PageUtil.isElementPresent(driver,
                By.xpath("//input[starts-with(@name,'order_id_') and @value='" + generatedOrderId + "']"));

        Assert.assertFalse(isOrderStillPresent, " Order was not cancelled. Still visible in itinerary.");
        System.out.println(" Order ID " + generatedOrderId + " successfully cancelled and removed from itinerary.");
    }

    @Test(priority = 20)
    @Description("TC_120: To verify Title of every Page reflects what the page objective is. For example Title of Search Hotel page should have “Search Hotel”")
    public void TC_120_verifyPageTitle()
    {
        System.out.println("TC_120: To verify Title of every Page reflects what the page objective is. For example Title of Search Hotel page should have “Search Hotel”");
        stepLog("verify titles and functionality");
        //Launch Url
        System.out.println("=====Launch Application URL====");
        driver.get("https://adactinhotelapp.com/");
        System.out.println("====URL loaded Successfully====");
        //Enter Login Details
        stepLog(" Login Details");
        System.out.println("====Enter Login Credentials and click Login====");
        login.LoginCredentials();
        System.out.println("====Login successfully and redirected to Search Hotel Page====");

        stepLog("Search Hotel Page Title After Login");
        System.out.println("====Verify Title====");
        System.out.println("->Title After Login");
        String actualTitleHome= driver.getTitle();
        System.out.println("Actual Title after Login: "+actualTitleHome);
        Assert.assertTrue(actualTitleHome.contains("Search Hotel"),"Title Mismatch After the login");
        System.out.println("====Title Verified Successfully====");

        //verify functionality of the redirected page(Search Hotel)

        stepLog("Click Search Hotel and verify Title and Functionality");
        System.out.println("====Verify Title After Redirection====");
        System.out.println("->Click Search Hotel");
        search.ClickSearch();
        //verify title of ReLoaded Page(Search Hotel)
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title after navigating: " + actualTitle);
        Assert.assertTrue(actualTitle.contains("Search Hotel"),
                "Title Mismatch: Expected to contain 'Search Hotel' but was: " + actualTitle);
        System.out.println("==Title Verified Successfully==");
        //verify Functionality
        System.out.println("==Verify Search Hotel Page Functionality==");
        Assert.assertTrue(driver.findElement(SearchPageEnum.SELECT_LOCATION_DROPDOWN.getLocator()).isDisplayed(),"Location Selecting Drop Down not present");
        System.out.println("Location Dropdown verified");
        Assert.assertTrue(driver.findElement(SearchPageEnum.SELECT_HOTEL_DROPDOWN.getLocator()).isDisplayed(),"HOTEL Selecting Drop Down not present");
        System.out.println("Hotel Dropdown verified");
        Assert.assertTrue(driver.findElement(SearchPageEnum.SELECT_ROOM_TYPE.getLocator()).isDisplayed(),"Rppm type  Selecting Drop Down not present");
        System.out.println("Room Type Dropdown verified");
        Assert.assertTrue(driver.findElement(SearchPageEnum.SELECT_TOTAL_ROOMS.getLocator()).isDisplayed(),"Total rooms Selecting Drop Down not present");
        System.out.println("Total Rooms Dropdown verified");
        Assert.assertTrue(driver.findElement(SearchPageEnum.SELECT_CHECK_IN.getLocator()).isDisplayed(),"Check in Text Box not present");
        System.out.println("Check In verified");
        Assert.assertTrue(driver.findElement(SearchPageEnum.SELECT_CHECK_OUT.getLocator()).isDisplayed(),"Check out Text Box not present");
        System.out.println("Check Out verified");
        Assert.assertTrue(driver.findElement(SearchPageEnum.SELECT_NO_ADULT.getLocator()).isDisplayed(),"Number of Adult Selecting Drop Down not present");
        System.out.println("Number of adult  Dropdown verified");
        Assert.assertTrue(driver.findElement(SearchPageEnum.SELECT_NO_CHILD.getLocator()).isDisplayed(),"Number of Children Selecting Drop Down not present");
        System.out.println("Number of Child Dropdown verified");
        Assert.assertTrue(driver.findElement(SearchPageEnum.CLICK_SUBMIT.getLocator()).isDisplayed(),"Click Continue button not Displayed");
        System.out.println("Submit Button Displayed");
        Assert.assertTrue(driver.findElement(SearchPageEnum.CLICK_SUBMIT.getLocator()).isDisplayed(),"Click Continue button not Displayed");
        System.out.println("Submit Button Displayed");
        System.out.println("==== Title And Functionality Verified Successfully after Redirection==== ");


        //Click Book Itinerary page
        stepLog("Click Book Itinerary Page and Verify its Functionality");
        System.out.println("====Verify Title and Functionality====");
        System.out.println("->Click the Book Itinerary Page ");
        booked.clickBookItineraryPage();
        String actualTitles = driver.getTitle();
        System.out.println("Actual Title after navigating: " + actualTitles);
        Assert.assertTrue(actualTitles.contains("Select Hotel"),
                "Title Mismatch: Expected to contain 'Booked Itinerary' but was: " + actualTitles);
        System.out.println("==== Title verified Successfully====");
        //Verify Functionality
        System.out.println("====verify Booked itinerary Page Functionality====");
        Assert.assertTrue(driver.findElement(BookedItineraryEnum.BOOKED_ORDER_ID.getLocator()).isDisplayed(),"Booked order id not displayed");
        String actual_orderId=driver.findElement(BookedItineraryEnum.BOOKED_ORDER_ID.getLocator()).getAttribute("value");
        System.out.println("_>Order Id:"+actual_orderId);
        System.out.println("====Booked Itinerary Page Functionality verified Successfully====");
        //click logout

        stepLog("Click Logout and Verify Title and Functionality");
        System.out.println("====click the logout====");
        WebElement logout=PageUtil.waitForClickability(DriverManager.getDriver(),SearchPageEnum.CLICKLOGOUT.getLocator(), Timeout.TEN_SEC);
        logout.click();
        String actualTitlee=driver.getTitle();
        System.out.println("Actual title: "+actualTitlee);
        Assert.assertTrue(actualTitlee.contains("Logout"),"Mismatch of the Log out title");
        System.out.println("====Logged Out Successfully====");

    }

    public void stepLog(String text){
        System.out.println("\n***"+text.toUpperCase()+"***\n");
    }


    @AfterTest
    public void EndTest(){
        quitDriver();
    }
}