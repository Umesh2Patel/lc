package frequentlyasked;

import org.apache.bcel.generic.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class apex {

    private static java.io.File File;

    // take screen in java
    public static void main(String[] args) throws IOException {

//       File file = ((TakesScreenshot)driver).getScreenshotAs(OutputTYpe.FILE);

        FileUtils.copyFile(File, new File("image location .jpeg"));

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        BufferedReader br = new BufferedReader(new FileReader(file));
//        String st;
//        while((st = br.readLine())!= null)
//            System.out.println(st);
//
//        String str= "word";
//        String result = "";
//        char[] ca = str.toCharArray();
//        for(char c: ca){
//            result = c+ result;
//        }
//        System.out.println(result);
//
//        Select dropdown = new Select(driver.findElement(By.id("id")));
//        dropdown.selectByVisibleText("4");
//        dropdown.selectByIndex(1);
//        dropdown.selectByValue();




    }

}
