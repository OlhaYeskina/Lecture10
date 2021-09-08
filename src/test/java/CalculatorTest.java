import com.epam.olha_yeskina.java.lection10.Calculator;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void addingEmptyStringCheck(){
        Calculator c = new Calculator();
        Assert.assertEquals(3,c.addition(1,2));
        //assertEquals(3,c.addition(1,2));
    }

    @Test
    public void addingOneValueCheck(){
        Calculator c = new Calculator();
        assertEquals(1,c.division(1,0));
    }

        }
