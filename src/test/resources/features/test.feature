@Calculator
 Feature: Calculator
Scenario Outline: вычисляем сумму двух чисел
    Given Даны два числа <x> и <y>
    Then Вычисляем сумму двух чисел
    When Результат должен быть равен <total>


  Examples:
    | x | y | total |
    | 1 | 3 | 4     |