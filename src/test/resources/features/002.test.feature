Feature: 1. Students unit-conversion problems test

  Scenario Outline:
  Given Student input numerical value "<Input Numerical Value>"
  And Student input unit of measure as "<Input Unit of Measure>"
  And Student input target unit of measure as "<Target Unit of Measure>"
  And Student input his response as "<Student Response>"
  Then Application output should be "<Output>"

    Examples: Example scenarios (not exhaustive):
      | Input Numerical Value | Input Unit of Measure | Target Unit of Measure | Student Response | Output    |
      | 84.2                  | Fahrenheit            | Rankine                | 543.87           | correct   |
      | 317.33                | Kelvin                | Fahrenheit             | 111.554          | incorrect |
      | 6.5                   | Fahrenheit            | Rankine                | dog              | incorrect |
      | 136.1                 | dogcow                | Celsius                | 45.32            | invalid   |