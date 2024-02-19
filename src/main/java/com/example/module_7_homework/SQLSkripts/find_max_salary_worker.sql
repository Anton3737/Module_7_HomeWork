-- Отримуємо працівника з найбільшою зарплатою
SELECT NAME, SALARY
FROM worker
WHERE SALARY = (SELECT max(SALARY) FROM worker);