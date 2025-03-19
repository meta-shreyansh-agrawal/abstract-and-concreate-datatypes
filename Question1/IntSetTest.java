package Question1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Test;

public class IntSetTest {
    @Test
    public void testConstructor() {
        boolean[] arr = new boolean[1000];
        assertDoesNotThrow(() -> new IntSet(arr));
        assertThrows(IllegalArgumentException.class, () -> new IntSet(arr));
    }

    @Test
    public void testIsMember() {
        boolean[] arr = new boolean[1000];
        arr[5] = true;
        IntSet set = new IntSet(arr);

        assertTrue(set.isMember(5));
    }

    @Test
    public void testSize() {
        boolean[] arr = new boolean[1000];
        arr[2] = true;
        arr[5] = true;
        arr[999] = true;
        IntSet set = new IntSet(arr);

        assertEquals(3, set.size());
    }

    @Test
    public void testIsSubSet() {
        boolean[] arr1 = new boolean[1000];
        arr1[2] = true;
        arr1[5] = true;
        arr1[10] = true;
        IntSet set1 = new IntSet(arr1);

        boolean[] arr2 = new boolean[1000];
        arr2[5] = true;
        IntSet set2 = new IntSet(arr2);

        assertTrue(set1.isSubSet(set2));
    }

    @Test
    public void testGetComplementSet() {
        boolean[] arr = new boolean[1000];
        arr[2] = true;
        arr[5] = true;
        IntSet set = new IntSet(arr);

        IntSet complementSet = set.getComplementSet();
        assertFalse(complementSet.isMember(2));
        assertFalse(complementSet.isMember(5));
        assertTrue(complementSet.isMember(3));
    }

    @Test
    public void testUnion() {
        boolean[] arr1 = new boolean[1000];
        arr1[1] = true;
        arr1[5] = true;
        IntSet set1 = new IntSet(arr1);

        boolean[] arr2 = new boolean[1000];
        arr2[2] = true;
        arr2[5] = true;
        IntSet set2 = new IntSet(arr2);

        IntSet unionSet = set1.union(set2);

        assertTrue(unionSet.isMember(1));
        assertTrue(unionSet.isMember(2));
        assertTrue(unionSet.isMember(5));
        assertFalse(unionSet.isMember(3));
    }
}