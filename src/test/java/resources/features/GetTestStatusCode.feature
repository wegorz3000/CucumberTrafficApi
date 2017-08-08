Feature: Get Test with default input and app_id is correct

Scenario: Check result of wrong app_id - status code 400

Given I will set request body from template
When I set query parameters:
|app_id|99DtaMYpnxA9pNcmsnbj|
|app_code|F5LQw-YKN02C00SQ3y2TFg|
And I will set "GET" request
#And I will set "GET" request with "https://traffic.cit.api.here.com/traffic/6.2/flow/xml/16/36058/21309?app_id=99DtaMYpnxA9pNcmsnbj&app_code=F5LQw-YKN02C00SQ3y2TFg&"

Then I will validate status code is "200"
And I will validate body not contains "pilkarzyki"
And I will validate response header contains "Content-Length"

#Then Body contains xPath "//ddd/dd/d/[0]" with value "5"

#
#When I set query parameter "app_code" to "{app_code_value}"
#And I set query parameter "app_id" to "{app_id_value}"
#And I set query parameter "max" to "{app_id_value}"
#
#|app_code_value|app_id_value|max_jamfactor_value|
#| dasdasd|dasdasd|3|
#|dsadasd|dasd|2|
#|dsaddas|asdasd|1|
#
