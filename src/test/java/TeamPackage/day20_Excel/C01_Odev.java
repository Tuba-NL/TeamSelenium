package TeamPackage.day20_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_Odev {

    // Excel dosyasından veri okuyabilmemiz icin;
    // 1- Dosya yolunu alırız.
    // String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";
    // 2- Capitals dosyasını bizim sistemimize getirmeliyiz.Dosyayı okuyabilmek icin akısa almalıyız.
    // FileInputStream fis = new FileInputStream(dosyaYolu);
    // 3- Dosyayı workbook'a atamalıyız. Java ortamında bir excel dosyası olusturmalıyız.
    // Workbook workbook = WorkbookFactory.create(fis);


    @Test
    public void Test01() throws IOException {


    //ODEV1
        String dosyaYolu = "src/test/java/TeamPackage/excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

         //1.satirdaki 2.hucreye gidelim ve yazdiralim

        String satir1Sutun2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("satir1Sutun2 = " + satir1Sutun2);


        //2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
        String satir2Sutun4 = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        System.out.println("satir2Sutun4 = " + satir2Sutun4);
        Assert.assertEquals("Kabil",satir2Sutun4);

        //Satir sayisini bulalim
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("satirSayisi = " + satirSayisi);

        //Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("kullanilanSatirSayisi = " + kullanilanSatirSayisi);

        //Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String,String> ulkeBaskent = new HashMap<>();

        for (int i = 0; i <= satirSayisi ; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            ulkeBaskent.put(key,value);
          //  System.out.println(key+"/"+value);

        }
        System.out.println(ulkeBaskent);



    }

    @Test
    public void Test02() throws IOException {
        //ODEV2

        String dosyaYolu = "src/test/java/TeamPackage/excel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);


        //Adimlari takip ederek 1.satira kadar gidelim 5.hucreye yeni bir cell olusturalim
        //Olusturdugumuz hucreye "Nufus" yazdiralim
        //2.satir nufus kolonuna 1500000 yazdiralim
        //10.satir nufus kolonuna 250000 yazdiralim
        //15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");




        //Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);


        //Dosyayi kapatalim
        fos.close();
        workbook.close();
    }
}