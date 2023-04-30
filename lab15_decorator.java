// Component
abstract class Sandwich {   
    protected String sandwich = "Sandwich";  
   
    // method
    public String getsandwich(){
        return sandwich;
    }

    public abstract float price();
}

// ConcreteComponent
class WhiteBreadSandWich extends Sandwich {
   
    public WhiteBreadSandWich(String sw){
       sandwich = sw;
    }
   
    @Override   
    public float price() {
        return 149.00f;
    }
   
}

// ConcreteComponent
class BrownBreadSandWich extends Sandwich {
   
    public BrownBreadSandWich(String sw){
       sandwich = sw;
    }
   
    @Override
    public float price() {
        return 199.00f;
    }
   
}

// BaseDecorator
abstract class SandWichDecorator extends Sandwich {  
   
    @Override
    public abstract float price();
   
}

// 
class CheeseDecorator extends SandWichDecorator{
    // 
    Sandwich currentSandwich;

    public CheeseDecorator(Sandwich sw){
        currentSandwich = sw;
    }
   
    @Override
    public String getsandwich(){
        return currentSandwich.getsandwich() + " with Cheese";
    }
    @Override
    public float price() {
        return currentSandwich.price() + 99.00f;
    }
   
}

class MayonnaiseDecorator extends SandWichDecorator{
    Sandwich currentSandwich;
   
    public MayonnaiseDecorator(Sandwich sw){
        currentSandwich = sw;
    }
   
    @Override
    public String getsandwich(){
        return currentSandwich.getsandwich() + " with Mayonnaise";
    }
    @Override
    public float price() {
        return currentSandwich.price() + 49.00f;
    }
   
}

public class lab15_decorator {
   
    public static void main(String args[]){
       
        Sandwich mySandwich = new WhiteBreadSandWich("White bread Sandwich");
        System.out.println("Price of "+ mySandwich.getsandwich()+" is "+ mySandwich.price());
       
        //adding extra cheese using Decorator Pattter
        mySandwich = new CheeseDecorator(mySandwich);
        System.out.println("Price of "+ mySandwich.getsandwich()+" is "+ mySandwich.price());
       
        //adding extra Mayonnaise using Decorator Pattter
        mySandwich = new MayonnaiseDecorator(mySandwich);
        System.out.println("Price of "+ mySandwich.getsandwich()+" is "+ mySandwich.price());
    }
}
