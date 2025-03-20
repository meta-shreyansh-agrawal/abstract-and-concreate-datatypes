public final class PolyUnit {
    int coffecient; 
    int power; 

    PolyUnit(int coffecient,int power)throws IllegalArgumentException{
        if(power < 0)throw new IllegalArgumentException("Enter non-negative power");
        this.coffecient = coffecient; 
        this.power = power; 
    }
}