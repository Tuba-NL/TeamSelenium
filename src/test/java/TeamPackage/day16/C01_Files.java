package TeamPackage.day16;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_Files extends TestBase {
    @Test
    public void Test01() {

        // 1.Class : FileDownloadTest Method : downloadTestExist


        // 2.https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");


        // 3.b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//*[.='b10 all test cases, code.docx']")).click();
        wait(2);

        // 4.Dosyanın başarıyla indirilip indirilmediğini test edelim
        // "C:\Users\gebruiker\Downloads\b10 all test cases, code.docx"

        //  1-) Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\gebruiker\\Downloads\\b10 all test cases, code.docx")));
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "/Downloads/b10 all test cases, code.docx";
        String dosyaYolu = farkliKisim + ortakKisim;
        wait(2);
        //2-)  Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        File file = new File(dosyaYolu);
        //3-)
        Assert.assertTrue(file.exists());
    }
}
