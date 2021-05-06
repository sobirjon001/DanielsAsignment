package com.daniel.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Map;

public class Json_tests {
  public static void main(String[] args) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      Map<?, ?> map = mapper.readValue(Paths.get("src/main/resources/test.json").toFile(), Map.class);
      for (Map.Entry<?, ?> entry : map.entrySet()) {
        System.out.println("entry.getKey() = " + entry.getKey());
        System.out.println("entry.getValue() = " + entry.getValue());
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

//  public void main1() {
//    Driver.getDriver().get("http://practice.cybertekschool.com/dynamic_loading/2");
//
//    Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver())
//            .withTimeout(Duration.ofSeconds(30))
//            .pollingEvery(Duration.ofSeconds(3))
//            .ignoring(NoSuchElementException.class);
//    WebElement button = wait.until(webDriver ->
//            webDriver.findElement(By.xpath("//button[.='Start']"))
//    );
//    button.click();
//
//    WebElement foo = wait.until(webDriver ->
//            webDriver.findElement(By.xpath("//h4[.='Hello World!']"))
//    );
//    String expected = "Hello World!";
//    Assert.assertEquals(foo.getText(), expected);
//  }
}
