Feature: Get Test with default input

Scenario: Check result of wrong app_id - status code 400

Given I will set request body from template
When I set query parameters:
|app_id|99DtaMYpnxA9pNcmsnbj|
|app_code|F5LQw-YKN02C00SQ3y2TFg|
|minjamfactor|0|
And I will set "GET" request
And I will set "GET" request with "URL"

Then I will validate status code is "400"
And I will validate body not contains "pilkarzyki"
And I will validate response header contains "Content-Length"