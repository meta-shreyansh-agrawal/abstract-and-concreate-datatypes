package Question1;
import java.lang.Math;
public class IntSet {
    private final boolean arr[]; 
    int maxSize; 
    /**
     * @param arr input boolean array to set if the number is in set or not
     * @throws IllegalArgumentException when input array is not of size 1000
     */
    IntSet(boolean arr[])throws IllegalArgumentException{
        if(arr.length>1000)throw new IllegalArgumentException("Enter array of valid size");
        this.maxSize = arr.length; 
        this.arr = arr;  
    }

    /**
     * @param x number which we need to check if present in set or not
     * @return boolean for number is present or not
     * @throws IllegalArgumentException when x is below 1 or above 1000
     */
    public boolean isMember(int x)throws IllegalArgumentException{
        if(x<0||x>maxSize)throw new IllegalArgumentException("Set can have number between 1 to "+maxSize);
        return this.arr[x-1];
    }

    /**
     * @return number of elements present in set
     */
    public int size(){
        int size = 0; 
        for(int i = 0; i<maxSize;i++)if(this.arr[i])size++; 
        return size; 
    }

    /**
     * @param s set which is need to be checked if it is subset of main set
     * @return if s is subset or not
     */
    public boolean isSubSet(IntSet s){
        if(s.maxSize>maxSize)throw new IllegalArgumentException("Subset can't be greater than set"); 
        for(int i = 0;i<maxSize;i++)if(s.arr[i]&&!this.arr[i])return false; 
        return true; 
    }

    /**
     * @return complement set of main set
     */
    public IntSet getComplementSet(){
        boolean []newArr = new boolean[1000]; 
        for(int i = 0;i<maxSize;i++)newArr[i] = !(this.arr[i]); 
        return new IntSet(newArr);  
    }
    
    /**
     * @param s new set to take union 
     * @return union set of main and s
     */
    public IntSet union(IntSet s){
        boolean []newArr = new boolean[1000]; 
        for(int i = 0;i<Math.min(maxSize,s.maxSize);i++)if(this.arr[i]||s.arr[i])newArr[i]=true; 
        if(maxSize>s.maxSize){
            for(int i = s.maxSize; i<maxSize;i++)if(this.arr[i])newArr[i] = true; 
        }else{
            for(int i = maxSize;i<s.maxSize;i++)if(s.arr[i])newArr[i]=true; 
        }
        return new IntSet(newArr);
    }
}