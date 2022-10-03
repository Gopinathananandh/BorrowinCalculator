package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BorrowCalPage extends BaseClass{

	/**
	 * @creationDate 03/10/2022
	 * @Description Default Constructor PageFactory
	 */
	public BorrowCalPage() {
		PageFactory.initElements(driver, this);

	}
	
	/**
	 * @creationDate 03/10/2022
	 * @Description Locators and Getter Method Maintained Here
	 */
	@FindBy(xpath="//label[@for='application_type_single']")
	private WebElement applicationType;
	
	@FindBy(xpath="//select[@title='Number of dependants']")
	private WebElement depends;
	
	@FindBy(xpath="//label[@for='borrow_type_home']")
	private WebElement propertyliketobuy;
	
	@FindBy(xpath="//input[@aria-labelledby='q2q1']")
	private WebElement anualIncome;
	
	@FindBy(xpath="//input[@aria-labelledby='q2q2']")
	private WebElement anualOtherIncome;
	
	
	@FindBy(id="expenses")
	private WebElement monthlyExpenses;
	
	@FindBy(id="homeloans")
	private WebElement loanMonthlyRepay;
	
	@FindBy(id="otherloans")
	private WebElement otherLoanMonthlyRepay;
	
	
	@FindBy(xpath="//input[@aria-labelledby='q3q4']")
	private WebElement monthlyCommitments;
	
	@FindBy(id="credit")
	private WebElement creditLimit;
	
	@FindBy(id="btnBorrowCalculater")
	private WebElement calculate;
	
	@FindBy(xpath="(//span[@class='icon icon_restart'])[1]")
	private WebElement startOver;
	
	@FindBy(id="borrowResultTextAmount")
	private WebElement amount;
	
	@FindBy(xpath="//div[contains(text(),'the details')]")
	private WebElement warning;

	public WebElement getApplicationType() {
		return applicationType;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getWarning() {
		return warning;
	}

	public WebElement getDepends() {
		return depends;
	}

	public WebElement getPropertyliketobuy() {
		return propertyliketobuy;
	}

	public WebElement getAnualIncome() {
		return anualIncome;
	}

	public WebElement getAnualOtherIncome() {
		return anualOtherIncome;
	}

	public WebElement getMonthlyExpenses() {
		return monthlyExpenses;
	}

	public WebElement getLoanMonthlyRepay() {
		return loanMonthlyRepay;
	}

	public WebElement getOtherLoanMonthlyRepay() {
		return otherLoanMonthlyRepay;
	}

	public WebElement getMonthlyCommitments() {
		return monthlyCommitments;
	}

	public WebElement getCreditLimit() {
		return creditLimit;
	}

	public WebElement getCalculate() {
		return calculate;
	}

	public WebElement getStartOver() {
		return startOver;
	}
	
	
	public void borrowCalculatorWithAllfield(String depends,String income,String otherincome,String expence,String loanrepay,String otherloanrepay,String commitments,String creditlimit ) {
	
	click(getApplicationType());
	SelectByText(getDepends(), depends);
	click(getPropertyliketobuy());
	sendKeys(getAnualIncome(), income);
	sendKeys(getAnualOtherIncome(), otherincome);
	sendKeys(getMonthlyExpenses(), expence);
	sendKeys(getLoanMonthlyRepay(), loanrepay);
	sendKeys(getOtherLoanMonthlyRepay(), otherloanrepay);
	sendKeys(getMonthlyCommitments(), commitments);
	sendKeys(getCreditLimit(), creditlimit);
	click(getCalculate());
	
	
}
	
	public void borrowCalculatorWithLivingExpence(String expence) {
		sendKeys(getMonthlyExpenses(), expence);	
		click(getCalculate());
	}
	
	public void startOver() {
		click(getStartOver());
	}}
