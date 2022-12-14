@Calculator
 Feature: Проверка функционала простейшего калькулятора

 Scenario Outline: Находим сумму двух чисел с помощью самописного Java-калькулятора
   Given Даны два числа <x> и <y>
   Then Вычисляем сумму двух чисел
   When Результат должен быть равен <total>

     Examples:

       | x | y | total |
       | 4 | 5 | 9     |
       | 3 | 3 | 6     |
       | 1 | 7 | 8     |
       | 0 | 0 | 0     |
