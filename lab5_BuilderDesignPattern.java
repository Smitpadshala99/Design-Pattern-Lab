
class computer{
    private String HDD;
    private String RAM_size;
    private String Processormake;
    private String ProcessorType;
    private String MoniterSize;
    private String MoniterType;
    private String OSconfigure;
    private String DeviceDriver;
    private String type;

    computer(String type) {
        this.type = type;
    }
    public computer setHDD(String HDD) {
        this.HDD = HDD;
        return this;
    }
    public computer setRAM_size(String RAM_size) {
        this.RAM_size = RAM_size;
        return this;
    }
    public computer setProcessormake(String Processormake) {
        this.Processormake = Processormake;
        return this;
    }
    public computer setProcessorType(String ProcessorType) {
        this.ProcessorType = ProcessorType;
        return this;
    }
    public computer setMoniterSize(String MoniterSize) {
        this.MoniterSize = MoniterSize;
        return this;
    }
    public computer setMoniterType(String MoniterType) {
        this.MoniterType = MoniterType;
        return this;
    }
    public computer setOSconfigure(String OSconfigure) {
        this.OSconfigure = OSconfigure;
        return this;
    }
    public computer setDeviceDriver(String DeviceDriver) {
        this.DeviceDriver = DeviceDriver;
        return this;
    }

    @Override
    public String toString() {
        return "Computer Type:- "+type+"\nHDD-"+HDD+"\tRAM-"+RAM_size+"\tProcessor Maker-"+Processormake+"\tProcessor Type-"+ProcessorType+"\nMoniter Type-"+MoniterType+"\tMoniter Size-"+MoniterSize+"\tOperating System-"+OSconfigure+"\tDevice Driver-"+DeviceDriver;
    }
    // public static void describeComponent() {
    // }
    
}

abstract class ComputerBuilder{
    protected computer comp;
    protected String type;

    public computer getcomp(){
        return comp = new computer(type);
    }
    
    public abstract void buildHDD();
    public abstract void buildRAM_size();
    public abstract void buildProcessor();
    public abstract void buildMoniter();
    public abstract void buildOS();
    public abstract void buildDeviceDriver();
    
}

class PersonalComputer extends ComputerBuilder{
    
    PersonalComputer(){
        super.type = "Personal user computer";
    }
    @Override
    public void buildHDD() {
        comp.setHDD("512 GB");
    }
    @Override
    public void buildRAM_size() {
        comp.setRAM_size("4 GB");
    }
    @Override
    public void buildProcessor() {
        comp.setProcessormake("AMD");
        comp.setProcessorType("Quadcore");
    }
    @Override
    public void buildMoniter() {
        comp.setMoniterSize("24 inch");
        comp.setMoniterType("LCD");
    }
    @Override
    public void buildOS() {
        comp.setOSconfigure("Android");
    }
    @Override
    public void buildDeviceDriver() {
        comp.setDeviceDriver("Hard Drive");
    }

}


class ServerComputer extends ComputerBuilder{
    ServerComputer(){
        super.type = "Server user computer";
    }
    @Override
    public void buildHDD() {
        comp.setHDD("4 TB");
    }
    @Override
    public void buildRAM_size() {
        comp.setRAM_size("16 GB");
    }
    @Override
    public void buildProcessor() {
        comp.setProcessormake("Intel");
        comp.setProcessorType("Core i9 Extreme");
    }
    @Override
    public void buildMoniter() {
        comp.setMoniterSize("32 inch");
        comp.setMoniterType("LED");
    }
    @Override
    public void buildOS() {
        comp.setOSconfigure("Unix");
    }
    @Override
    public void buildDeviceDriver() {
        comp.setDeviceDriver("Virtual device drivers");
    }
}

class ComputerEngineer{
    private ComputerBuilder computerBuilder;
    // public void setComputerBuilder(ComputerBuilder cb){
    //     computerBuilder = cb;
    // }
    // public computer getComputer(){
    //     return computerBuilder.getcomp();
    // }

    public ComputerEngineer(String a){
        if(a.equals("Server")){
            computerBuilder = new ServerComputer(); 
        }
        else if(a.equals("Personal")){
            computerBuilder = new PersonalComputer();

        }
    }
    public computer BuildComputer(){
        computer a =
        computerBuilder.getcomp();
        computerBuilder.buildHDD();
        computerBuilder.buildRAM_size();
        computerBuilder.buildProcessor();
        computerBuilder.buildMoniter();
        computerBuilder.buildOS();
        computerBuilder.buildDeviceDriver();
        System.out.println(a);
        return a;
    }
}

public class lab5_BuilderDesignPattern {
    public static void main(String[] args) {
        ComputerEngineer server = new ComputerEngineer("Server");
        server.BuildComputer();
        ComputerEngineer  personal = new ComputerEngineer("Personal");
        personal.BuildComputer();
    }
}
