import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
public class TestQues {
    static PolyUnit p1 = new PolyUnit(2, 4); 
    static PolyUnit p2 = new PolyUnit(4, 2);
    static Poly a = new Poly(new PolyUnit[]{p1,p2});
    static Poly b = new Poly(new PolyUnit[]{p2,p1});
    
    @Test
    public void testEvaluate(){
        assertEquals(48.00, (double)a.evaluate(2));
        assertEquals(6.00, (double)b.evaluate(1));
    }
    
    @Test
    public void testDegree(){
        assertEquals(4, a.degree());
        assertEquals(4, b.degree());
    }

    @Test
    public void testSum(){
        Poly sum = Poly.addPoly(b, a); 
        Poly temp = new Poly(new PolyUnit[]{new PolyUnit(4, 4),new PolyUnit(8, 2)}); 
        for(int i = 0; i<temp.expression.length; i++){
            assertEquals(sum.expression[i].power, temp.expression[i].power);
            assertEquals(sum.expression[i].coffecient, temp.expression[i].coffecient);
        }
    }
    
    @Test
    public void testMultiply(){
        Poly multiply = Poly.multiplyPoly(b, a); 
        Poly temp = new Poly(new PolyUnit[]{new PolyUnit(4, 8),new PolyUnit(16, 6),new PolyUnit(16,4)}); 
        for(int i = 0; i<temp.expression.length; i++){
            assertEquals(multiply.expression[i].power, temp.expression[i].power);
            assertEquals(multiply.expression[i].coffecient, temp.expression[i].coffecient);
        }
    }
}
