package com.stepdefinition;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.base.BaseClass;
import com.pages.BorrowCalPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TC1_BorrowinCalculatorStepdefin extends BaseClass {

	BorrowCalPage borrow = new BorrowCalPage();

	@Given("User is on How much could I borrow calculator page")
	public void user_is_on_How_much_could_I_borrow_calculator_page() {
		getUrl("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	}

	@Given("User should perform borrowing estimate by select all fields {string},{string},{string},{string},{string}, {string}, {string}, and {string}")
	public void user_should_perform_borrowing_estimate_by_select_all_fields_and(String depends, String income,
			String otherincome, String expence, String loanrepay, String otherloanrepay, String commitments,
			String creditlimit) {
		borrow.borrowCalculatorWithAllfield(depends, income, otherincome, expence, loanrepay, otherloanrepay,
				commitments, creditlimit);

	}

	@Then("User should verify success message {string} after borrowing estimate")
	public void user_should_verify_success_message_after_borrowing_estimate(String expected) {
		WebElement amount = borrow.getAmount();
		String text = amount.getText();
		Assert.assertEquals(text, expected, "Verify Estimate Amount");

		borrow.startOver();
	}

	@Given("User should perform borrowing estimate by entering only {string}")
	public void user_should_perform_borrowing_estimate_by_entering_only(String string) {
		borrow.borrowCalculatorWithLivingExpence(string);

	}

	@Then("User should verify warning message {string} after borrowing estimate")
	public void user_should_verify_warning_message_after_borrowing_estimate(String expected) {
		WebElement warning = borrow.getWarning();
		String text = warning.getText();
		Assert.assertEquals(text, expected, "Verify Warning message");
	}

}
