package StepDefinitions;

import org.openqa.selenium.WebDriver;
import WebDriverUtilities.BasePage;
import io.cucumber.java.en.*;

public class StepDefintion {
public WebDriver driver;
BasePage b=new BasePage();
@Given("Launch Browser")
public void launch_browser() {
	b.initializeDriver();
}
@Given("Navigate to FitPeo HomePage")
public void navigate_to_fit_peo_home_page() {
	b.navigateTo("https://www.fitpeo.com/");
}

@Given("Navigate to  Revenue Calculator Page")
public void navigate_to_revenue_calculator_page() {
    b.navigateTo("https://fitpeo.com/revenue-calculator");
}
@Then("revenue calculator slider")
public void revenue_calculator_slider() {
    b.scrollBy(0,111);
    try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
@Then("Adjust the slider to a certain value")
public void adjust_the_slider_to_a_certain_value() {
    b.slider();
}
@Then("Validate the value is updated in text box and enter a new value")
public void validate_the_value_is_updated_in_text_box_and_enter_a_new_value() throws InterruptedException {
    b.SliderTextBox();
}
@Then("Validate the slider is updated")
public void validate_the_slider_is_updated() throws InterruptedException {
    b.Slidervalue();
}

@Then("Select CPT Codes and validate total Recurring Reimbursement")
public void select_cpt_codes_and_validate_total_recurring_reimbursement() throws InterruptedException {
	b.scrollBy(0,600);
	Thread.sleep(5000);
    b.CPTValues();
}

@Then("Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month")
public void verify_that_the_header_displaying_total_recurring_reimbursement_for_all_patients_per_month() {
    b.HeaderValue();
}









}
