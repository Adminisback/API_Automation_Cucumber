Feature: Validating place API

  @addPlace @Regression
  Scenario Outline: Verify whether place is being successfully added using AddPlaceAPI
    Given Add place Payload with "<name>", "<address>", "<language>"
    When User calls "addPlaceAPI" with "POST" http request
    Then API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And Verify Place_Id created maps to "<name>" using "getPlaceAPI"

    Examples: 
      | name    | address | language |
      | Shirish | Adawad  | Marathi  |

  # | John    |London   | English   |
  @deletePlace @Regression
  Scenario Outline: Verify if delete functionality is working
    Given DeletePlace payload
    When User calls "deletePlaceAPI" with "POST" http request
    Then API call got success with status code 200
    And "status" in response body is "OK"
