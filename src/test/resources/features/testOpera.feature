Feature: Complete and submit the vehicle insurance form on Opera

  Scenario: Successfully complete and submit the form in Opera
    Given i am on the website

    # Step 1: Enter Vehicle Data
    When I fill in the vehicle data:
      | Field                          | Value                      |
      | Make                           | Ford                      |
      | Engine Performance             | 90                        |
      | Date of Manufacture            | 12/03/2020               |
      | Number of Seats                | 5                         |
      | Fuel Type                      | Petrol                    |
      | List Price                     | 5000                      |
      | License Plate Number           | KTY4678                   |
      | Annual Mileage                 | 5000                      |
    And I click the "Next" button with id "nextenterinsurancedata"

    # Step 2: Enter Insurant Data
    When I fill in the insurant data:
      | Field                          | Value                      |
      | First Name                     | John                      |
      | Last Name                      | Whitehorse                |
      | Date of Birth                  | 09/12/1980               |
      | Gender                         | Male                      |
      | Street Address                  | 1600 Fake Street         |
      | Country                        | United States             |
      | Zip Code                       | 94043                     |
      | City                           | Mountain View             |
      | Occupation                     | Selfemployed              |
      | Hobbies                        | Skydiving                 |
      | Website                        | www.johnwhitehorseshoes.com |
    And I click the "Next" button with id "nextenterproductdata"

    # Step 3: Enter Product Data
    When I fill in the product data:
      | Field                          | Value                      |
      | Start Date                     | 12/01/2024               |
      | Insurance Sum                  | 30000000                  |
      | Merit Rating                   | Bonus 7                   |
      | Damage Insurance               | Full Coverage             |
      | Optional Products              | Legal Defense Insurance    |
      | Courtesy Car                   | Yes                       |
    And I click the "Next" button with id "nextselectpriceoption"

    # Step 4: Select Price Option
    When I select the "Platinum" option
    And I click the "Next" button with id "nextsendquote"

    # Step 5: Send Quote
    When I fill in the contact data:
      | Field                          | Value                      |
      | E-Mail                         | test@example.us           |
      | Phone                          | 6019521325                |
      | Username                       | johnw                     |
      | Password                       | John123                   |
      | Confirm Password               | John123                   |
    And I click the "Send" button with id "sendemail"

    # Step 6: Verify message and user
    Then I should see the message "Sending e-mail success!" on screen
