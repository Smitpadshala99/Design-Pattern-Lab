// import java.util.HashMap;
// import java.util.Map;

// class Owner implements Cloneable{
//     private String Name;
//     private String mobileNo;
//     public Owner(String name, String mobileNo) {
//         Name=name;
//         this.mobileNo=mobileNo;
//     }
//     public String getName() {
//         return Name;
//     }
//     public void setName(String name) {
//         Name = name;
//     }
//     public String getMobileNo() {
//         return mobileNo;
//     }
//     public void setMobileNo(String mobileNo) {
//         this.mobileNo = mobileNo;
//     }
//     public Object clone(){
//         Object clone = null;
//         try{
//             clone = super.clone();
//         } catch(CloneNotSupportedException e){
//             e.printStackTrace();
//         }
//         return clone;
//     }
//     @Override
//     public String toString() {
//         return "Name: "+Name+"\tMobile no: "+mobileNo;
//     }
// }

// abstract class House implements Cloneable{

//     protected int House_no;
//     protected long House_price;
//     protected int House_area;
//     protected String HouseType;
//     protected Owner owner;
//     // abstract void addHouse();
//     public void setHouse_no(int house_no) {
//         House_no = house_no;
//     }
//     public void getHouse_area(int House_area) {
//         this.House_area = House_area;
//     }
//     public void setHouse_price(long house_price) {
//         House_price = house_price;
//     }
//     public int getHouse_no() {
//         return House_no;
//     }
//     public int getHouse_area() {
//         return House_area;
//     }
//     public long getHouse_price() {
//         return House_price;
//     }
//     public String getHouseType() {
//         return HouseType;
//     }
//     public void setHouseType(String HouseType) {
//         this.HouseType = HouseType;
//     }
//     public Object clone(){
//         Object clone = null;
//         // Owner owner = new Owner(owner.getName(), owner.getMobileNo());
//         try{
//             clone = super.clone();
//             // clone.owner = owner.clone(); 
//         } catch(CloneNotSupportedException e){
//             e.printStackTrace();
//         }
//         return clone;
//     }
//     @Override
//     public String toString() {
//         return "House NO: "+House_no+"\tprice: "+House_price+"\tarea: "+House_area+"\ttype: "+HouseType;
//     }
// }


// class BHK2 extends House{
//     protected int ParkingCharge;
//     public int getParkingCharge() {
//         return ParkingCharge;
//     }
//     public void setParkingCharge(int parkingCharge) {
//         ParkingCharge = parkingCharge;
//     }
//     // public BHK2(){
//     //     this.HouseType="TWO BHK";
//     //     House_no=101;
//     //     House_price=6500000;
//     //     House_area=245;
//     //     ParkingCharge=1000;
//     // }
//     // @Override
//     // void addHouse() {
//     //     System.out.println("TWO BHK HOUSE");
//     // }
//     @Override
//     public String toString() {
//         return super.toString()+"\tParking charge: "+ParkingCharge;
//     }
// }

// class BHK3 extends House{
//     protected int furnitureCharge;
//     public int getFurnitureCharge() {
//         return furnitureCharge;
//     }
//     public void setFurnitureCharge(int furnitureCharge) {
//         this.furnitureCharge = furnitureCharge;
//     }
//     // public BHK3(){
//     //     this.HouseType="THREE BHK";
//     //     House_no=201;
//     //     House_price=12500000;
//     //     House_area=375;
//     //     furnitureCharge=2000000;
//     // }
//     // @Override
//     // void addHouse() {
//     //     System.out.println("THREE BHK HOUSE");
//     // }
//     @Override
//     public String toString() {
//         return super.toString()+"\tFurniture Charge: "+furnitureCharge;
//     }
// }

// class SampleHouse {
//         private static Map<String, House> houseMap = new HashMap<String, House>();

//         static {
//             houseMap.put("BHK2", new BHK2());
//             houseMap.put("BHK3", new BHK3());
//         }

//         public static House getHouse(String type) {
//             return (House) houseMap.get(type).clone();
//         }
// }

// public class lab6_deepcopyhouse {
//     public static void main(String[] args) throws CloneNotSupportedException{
//         SampleHouse sampleHouse = new SampleHouse();

//         House bhk2 = sampleHouse.getHouse("BHK2");
//         bhk2.setHouse_no(1);
//         bhk2.setHouse_price(5000000);
//         bhk2.getHouse_area(1000);
//         bhk2.setHouseType("BHK2");
//         ((BHK2) bhk2).setParkingCharge(5000);

//         House bhk3 = sampleHouse.getHouse("BHK3");
//         bhk3.setHouse_no(2);
//         bhk3.setHouse_price(7000000);
//         bhk3.getHouse_area(1200);
//         bhk3.setHouseType("BHK3");
//         ((BHK3) bhk3).setFurnitureCharge(10000);

//         System.out.println(bhk2);
//         System.out.println(bhk3);
//     }
// }




import java.util.Objects;

public class lab6_deepcopyhouse {
    public static void main(String[] args) throws CloneNotSupportedException {
        Owner owner = new Owner("John Doe", 1234567890);
        House house = new BHK3(1, 200000, 1000, "BHK3", owner, 1000);
        House houseClone = (House) house.clone();
        houseClone.getOwner().setName("Jane Doe");
        System.out.println("Original House: " + house);
        System.out.println("Cloned House: " + houseClone);
    }
}

abstract class House implements Cloneable {
    private int houseNo;
    private double price;
    private double area;
    private String type;
    private Owner owner;

    public House(int houseNo, double price, double area, String type, Owner owner) {
        this.houseNo = houseNo;
        this.price = price;
        this.area = area;
        this.type = type;
        this.owner = owner;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public double getPrice() {
        return price;
    }

    public double getArea() {
        return area;
    }

    public String getType() {
        return type;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "HouseNo: " + houseNo + ", Price: " + price + ", Area: " + area + ", Type: " + type + ", Owner: " + owner;
    }
}

class BHK2 extends House {
    private double parkingCharge;

    public BHK2(int houseNo, double price, double area, String type, Owner owner, double parkingCharge) {
        super(houseNo, price, area, type, owner);
        this.parkingCharge = parkingCharge;
    }

    public double getParkingCharge() {
        return parkingCharge;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        BHK2 bhk2 = (BHK2) super.clone();
        // bhk2.owner = (Owner) owner.clone();
        return bhk2;
    }

    @Override
    public String toString() {
        return super.toString() + ", ParkingCharge: " + parkingCharge;
    }
}

class BHK3 extends House {
    private double furnitureCharge;

    public BHK3(int houseNo, double price, double area, String type, Owner owner, double furnitureCharge) {
        super(houseNo, price, area, type, owner);
        this.furnitureCharge = furnitureCharge;
    }

    public double getFurnitureCharge() {
        return furnitureCharge;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        BHK3 bhk3 = (BHK3) super.clone();
        // bhk3.owner = (Owner) owner.clone();
        return bhk3;
    }

    @Override
    public String toString() {
        return super.toString() + ", FurnitureCharge: " + furnitureCharge;
    }
}

class Owner implements Cloneable {
    private String name;
    private long mobileNo;

    public Owner(String name, long mobileNo) {
        this.name = name;
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return mobileNo == owner.mobileNo &&
        name.equals(owner.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobileNo);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", MobileNo: " + mobileNo;
    }
}
