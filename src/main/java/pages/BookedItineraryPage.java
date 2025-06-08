package pages;

import TestData.TestData;
import enums.BookedItineraryEnum;
import enums.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ConfigReaderUtil;
import utils.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import core.DriverManager;

public class BookedItineraryPage {
    WebDriver driver;
    SearchHotelPage search;
    LoginPage login;

    public BookedItineraryPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean clickBookItineraryPage() {
        System.out.println("Click Book Itinerary Page");
        WebElement click = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.CLICK_BOOKED_ITINERARY.getLocator(), Timeout.TEN_SEC);

        click.click();

        WebElement table = PageUtil.waitForVisibility(
                DriverManager.getDriver(),
                BookedItineraryEnum.BOOKED_TABLE.getLocator(),
                Timeout.TEN_SEC
        );
        return table != null;

    }

    public boolean verifyPageNotEditable() {
        System.out.println("Verify Booked Itinerary page is not editable");

        // Wait for the table element to be visible
        WebElement table = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.TABLE.getLocator(), Timeout.TEN_SEC);

        // Get all rows inside the table (excluding header in tbody)
        List<WebElement> rows = table.findElements(By.cssSelector("tbody tr"));

        for (WebElement row : rows) {
            // Find all text input  inside this row
            List<WebElement> inputs = row.findElements(By.cssSelector("input[type='text']"));

            for (WebElement input : inputs) {
                String originalValue = input.getAttribute("value");

                try {
                    input.clear();
                    input.sendKeys(ConfigReaderUtil.get("demo"));
                } catch (Exception e) {
                    System.out.println("Input not editable , it is read only");
                }

                String newValue = input.getAttribute("value");

                if (!newValue.equals(originalValue)) {
                    System.out.println("Editable input found: " + input.getAttribute("id"));
                    return false;  // Editable text found
                }
            }
        }
        System.out.println("editable input not found");

        return true;
    }

    public boolean verifyTableData(String orderId, String expectedHotelName, String expectedLocation,
                                   String expectedNoOfRooms, String expectedFirstName,
                                   String expectedArrDate, String expectedDepDate,
                                   String expectedRoomType, String expectedPricePerNight, String expectedTotalPrice) {
        System.out.println("verify the table data");

        WebElement actualOrderIdElement = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.BOOKED_ORDER_ID.getLocator(), Timeout.TEN_SEC);
        String actualOrderId = actualOrderIdElement.getAttribute("value").trim();
        WebElement actualHotelNameElement = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.BOOKED_HOTEL.getLocator(), Timeout.TEN_SEC);
        String actualHotelName = actualHotelNameElement.getAttribute("value").trim();
        WebElement actualLocationElement = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.BOOKED_LOCATION_NAME.getLocator(), Timeout.TEN_SEC);
        String actualLocation = actualLocationElement.getAttribute("value").trim();
        WebElement actualNoOfRoomsElement = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.BOOKED_TOTAL_ROOMS.getLocator(), Timeout.TEN_SEC);
        String actualRooms = actualNoOfRoomsElement.getAttribute("value").trim();
        WebElement actualFirstNameElement = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.BOOKED_FIRST_NAME.getLocator(), Timeout.TEN_SEC);
        String actualFirstname = actualFirstNameElement.getAttribute("value").trim();
        WebElement actualArrivalDateElement = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.BOOKED_ARRIVAL_DATE.getLocator(), Timeout.TEN_SEC);
        String actualArrivalDate = actualArrivalDateElement.getAttribute("value").trim();
        WebElement actualDeptDateElement = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.BOOKED_DEP_DATE.getLocator(), Timeout.TEN_SEC);
        String actualDeptDate = actualDeptDateElement.getAttribute("value").trim();
        WebElement actualRoomTypeElement = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.BOOKED_ROOM_TYPE.getLocator(), Timeout.TEN_SEC);
        String actualRoomType = actualRoomTypeElement.getAttribute("value").trim();
        WebElement actualPricePerNightElement = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.BOOKED_PRICE_PER_NIGHT.getLocator(), Timeout.TEN_SEC);
        String actualPricePerNight = actualPricePerNightElement.getAttribute("value").trim();
        WebElement actualTotalPriceElement = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.BOOKED_TOTAL_PRICE.getLocator(), Timeout.TEN_SEC);
        String actualTotalPrice = actualTotalPriceElement.getAttribute("value").trim();
        System.out.println("DISPLAYED: " + actualOrderId + "|EXPECTED: " + orderId);
        System.out.println("DISPLAYED: " + actualHotelName + "|EXPECTED: " + expectedHotelName);
        System.out.println("DISPLAYED: " + actualLocation + "|EXPECTED: " + expectedLocation);
        System.out.println("DISPLAYED: " + actualRooms + "|EXPECTED: " + expectedNoOfRooms);
        System.out.println("DISPLAYED: " + actualFirstname + "|EXPECTED: " + expectedFirstName);
        System.out.println("DISPLAYED :" + actualArrivalDate + "|EXPECTED: " + expectedArrDate);
        System.out.println("DISPLAYED: " + actualDeptDate + "|EXPECTED: " + expectedDepDate);
        System.out.println("DISPLAYED :" + actualRoomType + "|EXPECTED: " + expectedRoomType);
        System.out.println("DISPLAYED :" + actualPricePerNight + "|EXPECTED: " + expectedPricePerNight);
        System.out.println("DISPLAYED :" + actualTotalPrice + "|EXPECTED: " + expectedTotalPrice);


        Assert.assertEquals(actualOrderId, orderId, "order Id Mismatch");
        Assert.assertEquals(actualHotelName, expectedHotelName, "Hotel Name mismatch");
        Assert.assertEquals(actualLocation, expectedLocation, "Location mismatch");
        Assert.assertEquals(actualRooms, expectedNoOfRooms, "No of Rooms mismatch");
        Assert.assertEquals(actualFirstname, expectedFirstName, "First Name mismatch");
        Assert.assertEquals(actualArrivalDate, expectedArrDate, "Arrival Date mismatch");
        Assert.assertEquals(actualDeptDate, expectedDepDate, "Departure Date mismatch");
        Assert.assertEquals(actualRoomType, expectedRoomType, "Room Type mismatch");
        Assert.assertEquals(actualPricePerNight, expectedPricePerNight, "Price per Night mismatch");
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Total Price mismatch");
        return true;


    }

    public boolean searchOrderId(String orderId) {
        try {
            // click Booked Itinerary Page button
            clickBookItineraryPage();

            //    Wait for and enter Order ID
            WebElement searchField = PageUtil.waitForVisibility(
                    DriverManager.getDriver(),
                    BookedItineraryEnum.BOOKED_SEARCH_TEXT.getLocator(),
                    Timeout.TEN_SEC
            );
            searchField.clear();
            searchField.sendKeys(orderId);

            // Click Go button
            WebElement goButton = PageUtil.waitForVisibility(
                    DriverManager.getDriver(),
                    BookedItineraryEnum.CLICK_GO.getLocator(),
                    Timeout.TEN_SEC
            );
            goButton.click();

            // Wait for order ID to appear in results
            By rowLocator = By.xpath("//input[starts-with(@name, 'order_id_') and @value='" + orderId + "']");
            PageUtil.waitForVisibility(DriverManager.getDriver(), rowLocator, Timeout.TEN_SEC);

            //  Return whether the order is found
            return !DriverManager.getDriver().findElements(rowLocator).isEmpty();

        } catch (StaleElementReferenceException e) {
            System.out.println("Stale element encountered, retry logic can be added here: " + e.getMessage());
        } catch (TimeoutException | NoSuchElementException e) {
            System.err.println("Order ID search failed or not found: " + e.getMessage());
        }
        return false;
    }


    public boolean ClickGo() {
        WebElement clickGo = PageUtil.waitForVisibility(DriverManager.getDriver(), BookedItineraryEnum.CLICK_GO.getLocator(), Timeout.TEN_SEC);
        return true;
    }


    public String getGeneratedOrderId() {
        String orderId = String.valueOf(search.verifyorderId());
        System.out.println("Generated Order ID: " + orderId);
        return orderId;
    }



    // Verify booking row is displayed
    public boolean isBookingRowDisplayed(String orderId) {
        try {
            WebElement orderRow = DriverManager.getDriver().findElement(
                    By.xpath("//input[starts-with(@name,'order_id_') and @value='" + orderId + "']")
            );
            return orderRow.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean verifyBookedData(String orderId, String expectedHotelName, String expectedLocation,
                                    String expectedNoOfRooms, String expectedFirstName,
                                    String expectedArrDate, String expectedDepDate,
                                    String expectedRoomType, String expectedPricePerNight, String expectedTotalPrice) {

        clickBookItineraryPage();
        // Search using orderId
        WebElement searchText = PageUtil.waitForVisibility(driver, BookedItineraryEnum.BOOKED_SEARCH_TEXT.getLocator(), Timeout.TEN_SEC);
        searchText.clear();
        searchText.sendKeys(orderId);
        ClickGo();

        try {
            // Wait until the order ID field is visible
            WebElement orderField = PageUtil.waitForVisibility(driver,
                    By.xpath("//input[starts-with(@name,'order_id_') and @value='" + orderId + "']"), Timeout.TEN_SEC);

            // Base XPath to use sibling fields
            String baseXPath = "//input[@value='" + orderId + "']/ancestor::tr";

            // Get all other field values using sibling <td> inputs
            String actualHotelName = driver.findElement(By.xpath(baseXPath + "/td[4]/input")).getAttribute("value").trim();
            String actualLocation = driver.findElement(By.xpath(baseXPath + "/td[5]/input")).getAttribute("value").trim();
            String actualNoOfRooms = driver.findElement(By.xpath(baseXPath + "/td[6]/input")).getAttribute("value").trim();
            String actualFirstName = driver.findElement(By.xpath(baseXPath + "/td[7]/input")).getAttribute("value").trim();
            String actualArrDate = driver.findElement(By.xpath(baseXPath + "/td[9]/input")).getAttribute("value").trim();
            String actualDepDate = driver.findElement(By.xpath(baseXPath + "/td[10]/input")).getAttribute("value").trim();
            String actualRoomType = driver.findElement(By.xpath(baseXPath + "/td[12]/input")).getAttribute("value").trim();
            String actualPricePerNight = driver.findElement(By.xpath(baseXPath + "/td[13]/input")).getAttribute("value").trim();
            String actualTotalPrice = driver.findElement(By.xpath(baseXPath + "/td[14]/input")).getAttribute("value").trim();

            System.out.println(" Found row for Order ID: " + orderId);
            System.out.println("Hotel: " + actualHotelName + " | Location: " + actualLocation + " | Rooms: " + actualNoOfRooms);
            System.out.println("FirstName: " + actualFirstName + " | Arr: " + actualArrDate + " | Dep: " + actualDepDate);
            System.out.println("Room Type: " + actualRoomType + " | Price/Night: " + actualPricePerNight + " | Total: " + actualTotalPrice);


            Assert.assertEquals(actualHotelName, expectedHotelName, " Hotel Name mismatch");
            Assert.assertEquals(actualLocation, expectedLocation, " Location mismatch");
            Assert.assertEquals(actualNoOfRooms, expectedNoOfRooms, " No of Rooms mismatch");
            Assert.assertEquals(actualFirstName, expectedFirstName, " First Name mismatch");
            Assert.assertEquals(actualArrDate, expectedArrDate, " Arrival Date mismatch");
            Assert.assertEquals(actualDepDate, expectedDepDate, " Departure Date mismatch");
            Assert.assertEquals(actualRoomType, expectedRoomType, " Room Type mismatch");
            Assert.assertEquals(actualPricePerNight, expectedPricePerNight, " Price/Night mismatch");
            Assert.assertEquals(actualTotalPrice, expectedTotalPrice, " Total Price mismatch");

            System.out.println(" All booked itinerary details matched for order ID: " + orderId);
            return true;

        } catch (TimeoutException e) {
            System.err.println(" Order ID not found: " + orderId);
        } catch (AssertionError e) {
            System.err.println(" Mismatch found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(" Exception while verifying booked data: " + e.getMessage());
        }

        return false;
    }


    public boolean ClickCancel(String orderId){
        System.out.println("Click Cancel ");

        // Search using orderId
        clickBookItineraryPage();
        WebElement searchText = PageUtil.waitForVisibility(driver, BookedItineraryEnum.BOOKED_SEARCH_TEXT.getLocator(), Timeout.TEN_SEC);
        searchText.clear();
        searchText.sendKeys(orderId);
        ClickGo();

        try{
            WebElement orderField = PageUtil.waitForVisibility(driver,
                    By.xpath("//input[starts-with(@name,'order_id_') and @value='" + orderId + "']"), Timeout.TEN_SEC);
            String baseXPath = "//input[@value='" + orderId + "']/ancestor::tr";
            //input[@value='7Q659I6Y19']/ancestor::tr/td[3]/input
            WebElement cancelButton = PageUtil.waitForClickability(driver,
                    By.xpath(baseXPath + "/td[3]/input"), Timeout.TEN_SEC);
            cancelButton.click();

            WebDriverWait wait= new WebDriverWait(driver,Timeout.TEN_SEC.getSeconds());
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert=driver.switchTo().alert();
            System.out.println("Alert message: "+alert.getText());
            alert.accept();
            System.out.println("Cancelled the Booking ");

        }catch (TimeoutException e) {
            System.err.println(" Timeout while finding elements or waiting for alert.");
        } catch (NoAlertPresentException e) {
            System.err.println(" No alert appeared after clicking Cancel.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    public void  verifyTitleOfEachPage(String expectedPageTitle) {
        System.out.println("verify Title of each page ");

        String actualPageTitle = driver.getTitle();
        Assert.assertTrue(actualPageTitle.contains(expectedPageTitle), "Expected contains " + expectedPageTitle + "but displayed" + actualPageTitle);
    }



    }













