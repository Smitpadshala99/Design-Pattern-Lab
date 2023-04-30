import java.util.ArrayList;
import java.util.List;

class OriginatorObject{
    private int temperature;
    private int volume;

    public OriginatorObject(int t, int v){
        temperature = t;
        volume = v;
    }

    public void setTemperature(int t) {
        temperature = t;
    }
    public void setVolume(int v) {
        volume = v;
    }
    public int getTemperature() {
        return temperature;
    }
    public int getVolume() {
        return volume;
    }

    public MementoObject saveOriginatorObjectSate(){
        return new MementoObject(temperature, volume);
    }

    public void restoreOriginatorObjectState(MementoObject m){
        temperature = m.getTemperature();
        volume = m.getVolume();
    }
    public void operatorMachine(){
        System.out.println("Machine operating with temperature :"+temperature+" and volume: "+volume);
    }
}


class MementoObject{
    private int temperature;
    private int volume;

    public MementoObject(int t, int v){
        temperature = t;
        volume = v;
    }
    public int getTemperature() {
        return temperature;
    }
    public int getVolume() {
        return volume;
    }
}

class CareTakerObject{
    List<MementoObject> lm = new ArrayList<MementoObject>();
    public void addMementoObject(MementoObject m){
        lm.add(m);
    }

    public MementoObject getMementoObject(int i){
        return lm.get(i);
    }
}

public class memento_dp{
    public static void main(String[] args) {
        OriginatorObject o1  = new OriginatorObject(20, 10);   
        CareTakerObject c1 = new CareTakerObject();    
        o1.operatorMachine();
        c1.addMementoObject(o1.saveOriginatorObjectSate());

        o1.setTemperature(27);
        o1.setVolume(30);
        o1.operatorMachine();
        c1.addMementoObject(o1.saveOriginatorObjectSate());

        o1.setTemperature(37);
        o1.setVolume(50);
        o1.operatorMachine();
        c1.addMementoObject(o1.saveOriginatorObjectSate());

        // Restoring the previous state
        o1.restoreOriginatorObjectState(c1.getMementoObject(0));
        o1.operatorMachine();
    }
}
