package MainPack;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.gargoylesoftware.htmlunit.javascript.host.Element;
import UIAct.actioner;

import java.io.IOException;
import java.util.HashMap;
import UIAct.actioner;
import com.sun.javafx.print.Units;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;



public class GetdatafromExcel {

public static String testing;
	
	 private static String s = "Sheet1";
	 private static String s1 = "C:\\jenkins_data.xlsx";
	 private static Map<String, String> map = new HashMap<String,String>();

	 //public String get(String testcasename,String columnname) throws IOException {
	 public String get(String testcasename,String columnname) throws IOException {
	 FileInputStream fis;
	 int k =0;
	 try {
	 fis = new FileInputStream(s1);
	 XSSFWorkbook wb = new XSSFWorkbook(fis);
	 XSSFSheet ws = wb.getSheet(s);
	 int rows = ws.getPhysicalNumberOfRows();
	 //System.out.println("Rows no:"+rows);
	 for(int i=0;i<rows;i++){
	 int cols = ws.getRow(0).getPhysicalNumberOfCells();
	 //System.out.println("Columns no:"+rows);
	 for (int j = 0; j < cols; j++) { 
	 if(ws.getRow(i).getCell(j,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", "").
	 equalsIgnoreCase(columnname)){ 
	 k=j;
	 //System.out.println("test check:"+j);
	 }
	 testing = map.put(ws.getRow(i).getCell(0,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0",""),
			 ws.getRow(i).getCell(k,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).toString().replace(".0", ""));
	 }
	 }
	 return (testing);
	 }
	 catch (Exception e){e.printStackTrace(); } 
	 return map.get(testcasename);
	 } 
/*
public static void main(String args[]) throws IOException{
	GetdatafromExcel gdfe = new GetdatafromExcel();
	String tester = gdfe.get("Jenkins login","password");
	System.out.println("testing data is: "+tester);
	
}*/
}
