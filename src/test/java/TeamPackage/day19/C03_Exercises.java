package TeamPackage.day19;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Exercises extends TestBase {
    //  1. Launch browser
    //  2. Navigate to url 'http://automationexercise.com'
    //  3. Verify that home page is visible successfully
    //  4. Click on 'Signup / Login' button
    //  5. Verify 'New User Signup!' is visible
    //  6. Enter name and email address
    //  7. Click 'Signup' button
    //  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //  9. Fill details: Title, Name, Email, Password, Date of birth
    //  10. Select checkbox 'Sign up for our newsletter!'
    //  11. Select checkbox 'Receive special offers from our partners!'
    //  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //  13. Click 'Create Account button'
    //  14. Verify that 'ACCOUNT CREATED!' is visible
    //  15. Click 'Continue' button
    //  16. Verify that 'Logged in as username' is visible
    //  17. Click 'Delete Account' button
    //  18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


    @Test
    public void Test01() {
        //1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("(//*[.=' Signup / Login'])[1]")).click();

        // 5. Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newUserSignup.isDisplayed());
        wait(2);

        // 6. Enter name and email address
        // 7. Click 'Signup' button
        WebElement name = driver.findElement(By.xpath("//*[@name='name']"));
        Faker faker = new Faker();
        Actions actions = new Actions(driver);
        actions.click(name).sendKeys(faker.name().fullName()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInformation = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(enterAccountInformation.isDisplayed());

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement title = driver.findElement(By.xpath("(//*[@class='radio'])[2]"));
        actions.click(title).sendKeys(Keys.ENTER).sendKeys(Keys.ENTER).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB).
                sendKeys("10").sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).
                sendKeys("1990").perform();


        // 10. Select checkbox 'Sign up for our newsletter!'
        // 11. Select checkbox 'Receive special offers from our partners!'
        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@class='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@class='checkbox'])[2]"));
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }
        if(!checkBox2.isSelected()){
            checkBox2.click();
        }
        wait(2);

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//*[@id='first_name']"));
        actions.click(firstName).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(faker.company().name()).
                sendKeys(Keys.TAB).sendKeys(faker.address().streetAddress()).
                sendKeys(Keys.TAB).sendKeys(faker.address().buildingNumber()).
                sendKeys(Keys.TAB).sendKeys("United States").
                sendKeys(Keys.TAB).sendKeys(faker.address().state()).
                sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).
                sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).
                sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone()).perform();
                wait(2);


        // 13. Click 'Create Account button'
        WebElement createAccount = driver.findElement(By.xpath("(//*[@type='submit'])[1]"));
        createAccount.click();
        wait(2);

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(accountCreated.isDisplayed());
        wait(2);

        // 15. Click 'Continue' button
        driver.findElement(By.xpath("(//*[.='Continue'])[1]")).click();
        wait(2);




        // 16. Verify that 'Logged in as username' is visible

        // 17. Click 'Delete Account' button
        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    }
}
