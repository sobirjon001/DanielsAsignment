@wip
Feature: 2. Students unit-conversion problems test against Mock API server

  Scenario Outline:
    Given Student input numerical value "<Input Numerical Value>"
    And Student input unit of measure as "<Input Unit of Measure>"
    And Student input target unit of measure as "<Target Unit of Measure>"
    And Student input his response as "<Student Response>"
    Then Application output should be "<Output>" from Mock API for <num> test

    Examples: Example scenarios (not exhaustive):
      | num | Input Numerical Value | Input Unit of Measure | Target Unit of Measure | Student Response | Output    |
      | 1   | 84.2                  | Fahrenheit            | Rankine                | 543.87           | correct   |
      | 2   | 317.33                | Kelvin                | Fahrenheit             | 111.554          | incorrect |
      | 3   | 6.5                   | Fahrenheit            | Rankine                | dog              | correct   |
      | 4   | 136.1                 | dogcow                | Celsius                | 45.32            | invalid   |