
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public final class Poly{
    final PolyUnit expression[]; 

    Poly(PolyUnit[] expression){
        Arrays.sort(expression,new Comparator<PolyUnit>(){
            @Override
            public int compare(PolyUnit a,PolyUnit b){
                return Integer.compare(b.power, a.power);  
            }
        });  
        ArrayList<PolyUnit> temp = new ArrayList<PolyUnit>(); 
        temp.addAll(Arrays.asList(expression)); 

        temp.removeIf(x->x.power==0);

        for(int i = 1;i<temp.size();i++){
            if(temp.get(i).power == temp.get(i-1).power){
                temp.set(i,new PolyUnit( temp.get(i-1).coffecient+temp.get(i).coffecient, temp.get(i).power)); 
                temp.remove(i-1); 
            }
        }
        PolyUnit[] arr = new PolyUnit[temp.size()];
        arr = temp.toArray(arr); 
        this.expression = arr; 
    }
    
    public static Poly addPoly(Poly p1, Poly p2){
        ArrayList<PolyUnit> sumPoly = new ArrayList<PolyUnit>(); 
        int i = 0; 
        int j = 0; 
        while(i<p1.expression.length&&j<p2.expression.length){
            if(p1.expression[i].power==p2.expression[j].power) 
                sumPoly.add(new PolyUnit(p1.expression[i].coffecient+p2.expression[j++].coffecient,p1.expression[i++].power)); 
            else if(p1.expression[i].power>p2.expression[j].power)
                sumPoly.add(p1.expression[i++]); 
            else sumPoly.add(p2.expression[j++]);
        }
        if(i<p1.expression.length)
            sumPoly.addAll(Arrays.asList(Arrays.copyOfRange(p1.expression, i, p1.expression.length))); 
        else
            sumPoly.addAll(Arrays.asList(Arrays.copyOfRange(p2.expression, j, p2.expression.length))); 
        PolyUnit[] temp = new PolyUnit[sumPoly.size()];
        temp = sumPoly.toArray(temp); 
        Poly ans = new Poly(temp); 
        return ans;
    }

    public static Poly multiplyPoly(Poly p1,Poly p2){
        ArrayList<PolyUnit> list = new ArrayList<>();
        PolyUnit[] a = p1.expression; 
        PolyUnit[] b = p2.expression; 
        for(PolyUnit i: a){
            for(PolyUnit j: b){
                PolyUnit temp  = new PolyUnit(i.coffecient*j.coffecient,i.power+j.power); 
                list.add(temp); 
            }
        }
        PolyUnit[] temp = new PolyUnit[list.size()]; 
        temp = list.toArray(temp); 
        Poly ans = new Poly(temp); 
        return ans; 
    }

    public float evaluate(float value){
        float ans = 0; 
        for(PolyUnit p: this.expression)
            ans += p.coffecient*Math.pow(value, p.power); 
        return ans;
    }

    public int degree(){
        if(this.expression.length == 0)return 0; 
        return this.expression[0].power; 
    }
}