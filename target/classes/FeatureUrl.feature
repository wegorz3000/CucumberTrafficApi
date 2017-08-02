Feature: To test Traffic Api

Scenario: Check output is validated when there are all good inputs
Given I will send request to URL in Place
Then I will check status code equals 200 in Place
And I will check response is not empty in Place

Scenario: Check output is validated when there are all good inputs in NY
Given I will send request to URL in NY
Then I will check status code equals 200 in NY
And I will check response is not empty in NY

