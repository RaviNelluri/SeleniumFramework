package com.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.base.BasePage;
import com.utlis.TestUtils;

public class OpportunitiesPage extends BasePage{
	
	@FindBy(xpath="//div[@title='New']")
	WebElement oppNew_bttn;
	
	
	@FindBy(xpath="//button[@title='Save']")
	WebElement oppSave_bttn;
	
	@FindBy(xpath="//ul[@class='errorsList']/li")
	WebElement oppValidation_info;  
	
	@FindBy(xpath = "//span[text()= 'Opportunity Name']/parent::*//following-sibling::input")
	WebElement oppName_txt;
	
	@FindBy(xpath = "//span[contains(text(),'Account Name')]/parent::label//following-sibling::div//input")
	WebElement accName_txt;
	
	
	@FindBy(xpath = "//span[text()='Contact']/parent::label//following-sibling::div//input")
	WebElement contacts_txt;
	
	@FindBy(xpath = "//span[text()='Close Date']/parent::label/following::input[@type='text'][1]")
	WebElement closedDate_txt;
	
	
	@FindBy(xpath = "//span[text()='Sales Stage']/parent::span/following-sibling::div")
	WebElement salesStage_txt;
	
	@FindBy(xpath = "//span[text()='Probability']/parent::span/following-sibling::div")
	WebElement probability_txt;
	
	@FindBy(xpath = " //h1//lightning-formatted-text")
	WebElement oppTitle;
	
	@FindBy(xpath="//div[@title='Create Quote']")
	WebElement quoteSave_bttn;
public String validationError = "failing on purpose";
	
public OpportunitiesPage()
{
	PageFactory.initElements(driver, this);
		
}
	public void createEmptyOpp() 
	{
		click(oppNew_bttn);
		try {
		Thread.sleep(6000);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		click(oppSave_bttn);
	}
	
	
	public String getErrorText()
	{
		return getText(oppValidation_info);
	}
	
	
	
	
	public String createOpportunity(Map<String, String> testData)
	{
		String opportunityName= TestUtils.getRandomString(8); 
		click(oppNew_bttn);
		try {
			Thread.sleep(6000);
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		sendkeys(getInputTextField("Opportunity Name"), opportunityName);
		selectValueFromLookUpField(accName_txt, testData.get("AccountName"));
		selectValueFromLookUpField(contacts_txt, testData.get("ContactName"));
		sendkeys(closedDate_txt, testData.get("ClosedDate"));	
		selectValueFromSalesForceDropdown(salesStage_txt, testData.get("SalesStage"));
		selectValueFromSalesForceDropdown(probability_txt, testData.get("Probability"));
		click(oppSave_bttn);
		/*
		 * try { Thread.sleep(6000); } catch (Exception e){
		 * System.out.println(e.getMessage()); } click(quoteSave_bttn); try {
		 * Thread.sleep(100000); } catch (Exception e){
		 * System.out.println(e.getMessage()); } //find the outer frame, and use switch
		 * to frame method WebElement containerFrame = driver.findElement(By.
		 * xpath("//div[@class='windowViewMode-normal oneContent active lafPageHost']//div[@class='oneAlohaPage']//*[contains(@title,'accessibility title')]"
		 * )); driver.switchTo().frame(containerFrame);
		 * 
		 * //you are now in frame "ContentContainer", then find the nested frame inside
		 * WebElement contentFrame = driver.findElement(By.id(
		 * "canvas-outer-_:Oracle_CPQ_Cloud:oracle_cpq_oauth_canvas_id"));
		 * driver.switchTo().frame(contentFrame); WebElement content1Frame =
		 * driver.findElement(By.id(
		 * "canvas-inner-_:Oracle_CPQ_Cloud:oracle_cpq_oauth_canvas_id"));
		 * driver.switchTo().frame(content1Frame); WebElement type =
		 * driver.findElement(By.xpath("//div[@id='oj-select-choice-quoteType_t']"));
		 * type.sendKeys(Keys.ENTER);
		 */return opportunityName;
	}
	
	
	public String getOppTitle()
	{
		return getText(oppTitle);
	}
}

