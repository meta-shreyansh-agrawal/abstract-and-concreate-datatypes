
public class Assignment {
    public static void main(String[] args) {
        PolyUnit p1 = new PolyUnit(2, 4); 
        PolyUnit p2 = new PolyUnit(4, 2); 
        PolyUnit[] arr1 = {p1,p2}; 
        PolyUnit[] arr2 = {p2,p1}; 
        Poly a = new Poly(arr1);
        Poly b = new Poly(arr2);
        Poly c = Poly.addPoly(a, b); 
        Poly d = Poly.multiplyPoly(b, a); 
        for(PolyUnit i: a.expression){
            System.out.println("coff: "+i.coffecient+"power: "+i.power); 
        }
        System.out.println("--------------");
        for(PolyUnit i: b.expression){
            System.out.println("coff: "+i.coffecient+"power: "+i.power); 
        }
        System.out.println("--------------");
        for(PolyUnit i: c.expression){
            System.out.println("coff: "+i.coffecient+"power: "+i.power); 
        }
        System.out.println("--------------");
        for(PolyUnit i: d.expression){
            System.out.println("coff: "+i.coffecient+"power: "+i.power); 
        }
        System.out.println("--------------");
    }
}
