
interface State {
    public void handleState();
}

class State1 implements State{
    public void handleState(){
        System.out.println("Handling State1 - you may go to State2");
    }
}
class State2 implements State{
    public void handleState(){
        System.out.println("Handling State2 - you may go to State3");
    }
}
class State3 implements State{
    public void handleState(){
        System.out.println("Handling State3 - you may go to initial State!");
    }
}

class Context{
    State st;
    public Context(State s){
        st=s;
    }
    public void setSt(State st) {
        this.st = st;
    }
    public State getSt() {
        return st;
    }

    public void perfomAction(){
        st.handleState();
    }
}


public class statepatterndemo {
    public static void main(String[] args) {
        State s1 = new State1();
        State s2 = new State2();
        State s3 = new State3();
        
        Context c1 = new Context(s2);
        c1.perfomAction();

        c1.setSt(s3);
        c1.perfomAction();
    }
}
