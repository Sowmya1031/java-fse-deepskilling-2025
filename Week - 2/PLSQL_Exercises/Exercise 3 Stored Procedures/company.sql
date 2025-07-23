-- 1. Procedure to process monthly interest
DELIMITER $$

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'Savings';
END $$

-- 2. Procedure to update employee bonus
CREATE PROCEDURE UpdateEmployeeBonus(
    IN dept_id INT,
    IN bonus_percent DECIMAL(5,2)
)
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * (bonus_percent / 100))
    WHERE DepartmentID = dept_id;
END $$

-- 3. Procedure to transfer funds between accounts
CREATE PROCEDURE TransferFunds(
    IN fromAcc INT,
    IN toAcc INT,
    IN amount DECIMAL(10,2)
)
BEGIN
    DECLARE fromBalance DECIMAL(10,2);

    -- Check balance
    SELECT Balance INTO fromBalance FROM Accounts WHERE AccountID = fromAcc;

    IF fromBalance >= amount THEN
        UPDATE Accounts SET Balance = Balance - amount WHERE AccountID = fromAcc;
        UPDATE Accounts SET Balance = Balance + amount WHERE AccountID = toAcc;
    ELSE
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient balance in source account';
    END IF;
END $$

DELIMITER ;
