Feature: To test API

Scenario: Check output is validated when there are all good inputs in NY
Given I will send request to URL in base
Then I will check status code equals 200 in base
And I will check response is not empty in base
