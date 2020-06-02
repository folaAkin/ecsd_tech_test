Feature: Arrays Challenge


  Scenario Outline: Find index of the array where the sum of integers at the index on the left is equal to the sum of integers on the right.
    Given I am on ecsd home page
    When I clicked on the render challenger button
    And I scroll the page until Arrays Challenge is visible
    And get the array at role <rowNumber>
    Then I get the index of the element that equals the sum of arrays on the left and on  the right

    Examples:
      | rowNumber |
      | 1         |
      | 2         |
      | 3         |

