package TestData;

import utils.Dateutil;

public class TestData {
    public static String getExpectedValue(String key) {
        return switch (key.toLowerCase()) {
            case "hotel name" -> "Hotel Creek";
            case "location name" -> "Sydney";
            case "room type" -> "Standard";
            case "total days" -> "1 Day(s)";
            case "total rooms" -> "2 Room(s)";
            case "price per night" -> "AUD $ 125";
            case "total price without gst"-> "AUD $ 250";
            case "gst price"->"AUD $ 25";
            case "total billed price"->"AUD $ 275";
            case "check in"-> Dateutil.getFormatedDate(0);
            case "check out"->Dateutil.getFormatedDate(1);
            case "selected rooms"->"2";
            case "total adults"->"1";
            case "total child"->"0";
            case "order id"->"95MP9CHG4X";
            case "hotel"->"Hotel Creek";
            case "location"->"Sydney";
            case "first name"->"Arun";
            case "price"->"AUD $ 275";
            case "arrival date"->"04/06/2025";
            case "departure date"->"05/06/2025";
            case "rooms"->"1 Room(s)";
            case "after login title"->"Search Hotel";
            case  "after redirection title"->"Search Hotel";
            case "booked itinerary title"->"Select Hotel";
            case "logout title"->"Logout";
            default -> "";
        };
    }
}
