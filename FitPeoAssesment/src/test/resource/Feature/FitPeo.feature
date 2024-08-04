Feature: Validating FitPeo HomePage
  @FitPeoHomePage
  Scenario: FitPeoHomePage
    Given Launch Browser
    Given Navigate to FitPeo HomePage
    Given Navigate to  Revenue Calculator Page
    Then  revenue calculator slider
    And   Adjust the slider to a certain value
    Then  Validate the value is updated in text box and enter a new value
    And   Validate the slider is updated
    Then  Select CPT Codes and validate total Recurring Reimbursement
    And   Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month
    
