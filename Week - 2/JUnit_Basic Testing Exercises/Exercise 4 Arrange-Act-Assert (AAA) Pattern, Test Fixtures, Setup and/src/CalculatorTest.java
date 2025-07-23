import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CalculatorTest {

    private Calculator calculator;

    // Setup method - runs before each test
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Setup: Calculator object created");
    }

    // Teardown method - runs after each test
    @AfterEach
    public void tearDown() {
        calculator = null;
        System.out.println("Teardown: Calculator object cleared");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int a = 10;
        int b = 4;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(6, result);
    }

    @Test
    public void testMultiplication() {
        // Arrange
        int a = 4;
        int b = 5;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        assertEquals(20, result);
    }

    @Test
    public void testDivision() {
        // Arrange
        int a = 10;
        int b = 2;

        // Act
        int result = calculator.divide(a, b);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testDivisionByZero() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act & Assert
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(a, b);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
