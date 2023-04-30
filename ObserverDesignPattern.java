// make news bulitin like display news according to the time 

import java.util.*;

class SubjectEntity{
    private int numberstate;
    private List<ObserverEntity> lm = new ArrayList<ObserverEntity>();

    public void setNumberstate(int n) {
        numberstate = n;
        notifyAllObserver();
    }

    public int getNumberstate() {
        return numberstate;
    }

    public void registerObserver(ObserverEntity e) {
        lm.add(e);        
    }

    public void UnregisterObserver(ObserverEntity e) {
        lm.remove(e);        
    }

    public void notifyAllObserver() {
        for(ObserverEntity o : lm ){
            o.update();
        }
    }
}

abstract class ObserverEntity{
    SubjectEntity se;
    abstract public void update();
}

class BinaryObserverEntity extends ObserverEntity{

    public BinaryObserverEntity(SubjectEntity e){
        se = e;
        se.registerObserver(this);
    }
    public void update() {
        int n = se.getNumberstate();
        System.out.println("Representing number : " + n + " to binary : "+ Integer.toBinaryString(n));     
    }
    
}
class HexaObserverEntity extends ObserverEntity{

    public HexaObserverEntity(SubjectEntity e){
        se = e;
        se.registerObserver(this);
    }
    public void update() {
        int n = se.getNumberstate();
        System.out.println("Representing number : " + n + " to Hexa : "+ Integer.toHexString(n));     
    }
    
}
class OctalObserverEntity extends ObserverEntity{

    public OctalObserverEntity(SubjectEntity e){
        se = e;
        se.registerObserver(this);
    }
    public void update() {
        int n = se.getNumberstate();
        System.out.println("Representing number : " + n + " to Octal : "+ Integer.toOctalString(n));     
    }
    
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        SubjectEntity se = new SubjectEntity();   
        ObserverEntity o1 = new BinaryObserverEntity(se);
        ObserverEntity o2 = new HexaObserverEntity(se);
        ObserverEntity o3 = new OctalObserverEntity(se);

        // se.registerObserver(o1);  //It is must required
        se.setNumberstate(10);
        se.UnregisterObserver(o2);
        se.setNumberstate(20);
    }
}
