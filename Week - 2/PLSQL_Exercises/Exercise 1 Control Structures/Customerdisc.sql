SET SERVEROUTPUT ON;

BEGIN
    -- Scenario 1: Apply 1% discount to interest rates for customers above 60
    FOR rec IN (
        SELECT l.LoanID, l.InterestRate, c.Age
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
    ) LOOP
        IF rec.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = rec.InterestRate - 1
            WHERE LoanID = rec.LoanID;
        END IF;
    END LOOP;

    -- Scenario 2: Set IsVIP to 'Y' for balance over 10,000
    FOR rec IN (
        SELECT CustomerID, Balance FROM Customers
    ) LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    -- Scenario 3: Print reminders for loans due in next 30 days
    FOR rec IN (
        SELECT l.LoanID, c.Name, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan ' || rec.LoanID || 
            ' for ' || rec.Name || 
            ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY')
        );
    END LOOP;

    COMMIT;
END;
/
