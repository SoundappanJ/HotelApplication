package enums;

import org.openqa.selenium.By;

public enum Timeout {
    FIVE_SEC(3),
    TEN_SEC(10),
    FIFTEEN_SEC(15),
    TWENTY_SEC(20),
    THIRTY_SEC(30);
    private  long sec;

    Timeout(long sec) {
        this.sec=sec;
    }
    public long getSeconds(){
        return sec;
    }
}
