-- 1️⃣ Display top 5 highest salary earners in each department
SELECT dept_id, emp_name, salary
FROM employees e
WHERE (
    SELECT COUNT(*) 
    FROM employees e2
    WHERE e2.dept_id = e.dept_id AND e2.salary > e.salary
) < 5
ORDER BY dept_id, salary DESC;

-- 2️⃣ Stored Function: getWorkingDays
DELIMITER //
CREATE FUNCTION getWorkingDays(join_date DATE)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE working_days INT;
    SET working_days = DATEDIFF(CURDATE(), join_date);
    RETURN working_days;
END //
DELIMITER ;

-- 3️⃣ Stored Procedure: Update salary based on working days
DELIMITER //
CREATE PROCEDURE updateSalary(IN emp_id INT)
BEGIN
    DECLARE days INT;
    DECLARE rise DECIMAL(10,2);

    SELECT getWorkingDays(join_date) INTO days FROM employees WHERE id = emp_id;

    IF days > 365 THEN
        SET rise = 0.10; -- 10% hike
    ELSEIF days > 180 THEN
        SET rise = 0.05; -- 5% hike
    ELSE
        SET rise = 0.02; -- 2% hike
    END IF;

    UPDATE employees 
    SET salary = salary + (salary * rise)
    WHERE id = emp_id;
END //
DELIMITER ;