import java.util.HashMap;
import java.util.Map;

abstract class House implements Cloneable{

    protected int House_no;
    protected long House_price;
    protected int House_area;
    protected String HouseType;

    // abstract void addHouse();
    public void setHouse_no(int house_no) {
        House_no = house_no;
    }
    public void getHouse_area(int House_area) {
        this.House_area = House_area;
    }
    public void setHouse_price(long house_price) {
        House_price = house_price;
    }
    public int getHouse_no() {
        return House_no;
    }
    public int getHouse_area() {
        return House_area;
    }
    public long getHouse_price() {
        return House_price;
    }
    public String getHouseType() {
        return HouseType;
    }
    public void setHouseType(String HouseType) {
        this.HouseType = HouseType;
    }
    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        } catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
    @Override
    public String toString() {
        return "House NO: "+House_no+"\tprice: "+House_price+"\tarea: "+House_area+"\ttype: "+HouseType;
    }
}


class BHK2 extends House{
    protected int ParkingCharge;
    public int getParkingCharge() {
        return ParkingCharge;
    }
    public void setParkingCharge(int parkingCharge) {
        ParkingCharge = parkingCharge;
    }
    // public BHK2(){
    //     this.HouseType="TWO BHK";
    //     House_no=101;
    //     House_price=6500000;
    //     House_area=245;
    //     ParkingCharge=1000;
    // }
    // @Override
    // void addHouse() {
    //     System.out.println("TWO BHK HOUSE");
    // }
    @Override
    public String toString() {
        return super.toString()+"\tParking charge: "+ParkingCharge;
    }
}

class BHK3 extends House{
    protected int furnitureCharge;
    public int getFurnitureCharge() {
        return furnitureCharge;
    }
    public void setFurnitureCharge(int furnitureCharge) {
        this.furnitureCharge = furnitureCharge;
    }
    // public BHK3(){
    //     this.HouseType="THREE BHK";
    //     House_no=201;
    //     House_price=12500000;
    //     House_area=375;
    //     furnitureCharge=2000000;
    // }
    // @Override
    // void addHouse() {
    //     System.out.println("THREE BHK HOUSE");
    // }
    @Override
    public String toString() {
        return super.toString()+"\tFurniture Charge: "+furnitureCharge;
    }
}

class SampleHouse {
        private static Map<String, House> houseMap = new HashMap<String, House>();

        static {
            houseMap.put("BHK2", new BHK2());
            houseMap.put("BHK3", new BHK3());
        }

        public static House getHouse(String type) {
            return (House) houseMap.get(type).clone();
        }
}

public class lab6_prototype {
    public static void main(String[] args) throws CloneNotSupportedException{
        SampleHouse sampleHouse = new SampleHouse();

        House bhk2 = sampleHouse.getHouse("BHK2");
        bhk2.setHouse_no(1);
        bhk2.setHouse_price(5000000);
        bhk2.getHouse_area(1000);
        bhk2.setHouseType("BHK2");
        ((BHK2) bhk2).setParkingCharge(5000);

        House bhk3 = sampleHouse.getHouse("BHK3");
        bhk3.setHouse_no(2);
        bhk3.setHouse_price(7000000);
        bhk3.getHouse_area(1200);
        bhk3.setHouseType("BHK3");
        ((BHK3) bhk3).setFurnitureCharge(10000);

        System.out.println(bhk2);
        System.out.println(bhk3);
    }
}
