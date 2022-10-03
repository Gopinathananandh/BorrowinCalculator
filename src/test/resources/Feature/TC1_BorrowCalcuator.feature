Feature: Verifying Borrow Calculator In ANZ Page

  Scenario Outline: Verifying Borrow Calculator details with Valid  Credential
    Given User is on How much could I borrow calculator page
    And User should perform borrowing estimate by select all fields "<numberOfDependents>","<yourAnnualIncome>","<yourAnnualOtherIncome>","<monthlyLivingExpenses>","<currentHomeLoanMonthlyRepayment>", "<otherLoanMonthlyRepayment>", "<otherMonthlyCommitments>", and "<totalCreditCardLimits>"
    Then User should verify success message "$479,000" after borrowing estimate

    Examples: 
      | numberOfDependents | yourAnnualIncome | yourAnnualOtherIncome | monthlyLivingExpenses | currentHomeLoanMonthlyRepayment | otherLoanMonthlyRepayment | otherMonthlyCommitments | totalCreditCardLimits |
      |                  0 |            80000 |                 10000 |                   500 |                               0 |                       100 |                       0 |                 10000 |

  Scenario Outline: Verifying Resert Btn
    And User should click the start over to resert the value

  Scenario Outline: Verifying Borrow Calculator details with Invalid Credential
    Given User is on How much could I borrow calculator page
    And User should perform borrowing estimate by entering only "<monthlyLivingExpenses>"
    Then User should verify warning message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500." after borrowing estimate

    Examples: 
      | monthlyLivingExpenses |
      |                     1 |
