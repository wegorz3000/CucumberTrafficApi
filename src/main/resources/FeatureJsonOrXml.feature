Feature: Checking response as Xml and response as Json

Scenario: Check output is validated when there are Xml response
Given I will send "xml" request to URL
Then I will check status code equals 200
And I will check response has xml response
And I will check response is not empty

Scenario: Check output is validated when there are Json response
Given I will send "json" request to URL
Then I will check status code equals 200
And I will check response has json response
And I will check response is not empty
