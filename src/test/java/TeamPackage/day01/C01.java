package TeamPackage.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class C01 {

    public static void main(String[] args) {
        System.setProperty("chromeDriver","src/resource/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();// Pencereyi buyutuyor.
        driver.get("https://google.com");




    }

}
