package Question1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class TestQues {
    static IntSet set; 

    @BeforeAll static void setup(){
        boolean temp[] = new boolean[1000]; 
        temp[2] = true;     
        temp[7] = true;     
        temp[34] = true;     
        temp[28] = true;     
        temp[8] = true;     
        temp[11] = true;     
        temp[9] = true;  
        set = new IntSet(temp);    
    }

    @Test
    public void testSize(){
        assertEquals(7, set.size());
    }
}