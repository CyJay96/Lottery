# «Лотерея»

## **Необходимо создать лотерею**

## **Функционал:**

1. Сервис принимает на вход Post-запрос `/lottery/participant`, тело запроса  
   в виде json должно иметь поля (имя, возраст, город) участника;
2. Сервис сохраняет участника в БД;
3. С помощью Get запроса `/lottery/participant` пользователь должен получить  
   список всех участников, которые есть в БД в виде json;
4. С помощью Get запроса `/lottery/start` можно запустить лотерею:
   - При поступлении запроса сервис проверяет количество участников в БД,  
     если участников меньше 2, сервис выдает ошибку;
   - Если игроков 2 или более, тогда  
   1 шаг: сервис должен определить сумму выигрыша (от 1 - 1000 рандом генератор);  
   2 шаг: после чего должен определить победителя (рандом генератор) среди всех  
   участников, которые есть в БД;  
   3 шаг: и вывести его карточку вместе с суммой;  
   4 шаг: после чего должен очистить БД.

## **Пункты повышенной сложности (для выполнения необязательно, но желательно):**
1. В качестве рандом генератора использовать сайт [random.org](https://www.random.org/),  
  пример запроса:
  https://www.random.org/integers/?num=1&min=1&max=998&col=1&base=10&format=plain&rnd=new
2. Создать в БД таблицу с победителями и после розыгрыша лотереи, сохранять победителя и
сумму выигрыша.
3. Get запрос `/lottery/winners` для просмотра списка победителей.
