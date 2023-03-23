import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Find populer weapon among player
// Right play area has which type of players
// Approximate memory consumption 

// class Player{

//     String type;
//     String colorCode;
//     String task;

//     String weapon;
//     int x;
//     int y;

// }

class PlayerFlyWeight{
    String type;
    String color;
    String task;

    public PlayerFlyWeight(String t, String c, String ta){
        type = t;
        color = c;
        task = ta;
    }
    }
    
    class Player{
    PlayerFlyWeight pf;
    int x;
    int y;
    String weapon;
    
    public Player(PlayerFlyWeight p, int x, int y, String w){
        System.out.print("Player created!!!");
        pf = p;
        this.x = x;
        this.y = y;
        weapon = w;
    }
    
    public void GeneratePlayer(int x, int y){
        this.x = x;
        this.y = y;
        System.out.print("\tPlayer type - "+pf.type+"\twith weapon - "+weapon+"\tgenerated at (x, y) : ("+x+", "+y+")\n");
    }
    }
    
    class PlayerFactory{
    Map<String, PlayerFlyWeight> mp = new HashMap<String, PlayerFlyWeight>();
    PlayerFlyWeight pf = null;
    public PlayerFlyWeight createPlayer(String type){
    if(mp.containsKey(type))
    pf = mp.get(type);
    else{
    if(type.equalsIgnoreCase("Policeman")){
    pf = new PlayerFlyWeight("Police", "Green", "Protection");
    } else if(type.equalsIgnoreCase("Terrorist")){
    pf = new PlayerFlyWeight("Terrorist", "Black","Theft");
    } else{
    System.out.println("Player-type not available");
    }
    mp.put(type, pf);
    }
    String[] WeaponList = new String[] {"AK-47", "M16", "Glock", "Shotgun", "Sniper", "Pistol", "Bomb"};
    Random random = new Random();
    String randomWeapon = WeaponList[random.nextInt(WeaponList.length)];
    return new PlayerFlyWeight(pf.type, pf.color, pf.task + " with "+randomWeapon);
    }
}
    
    public class lab14_FlyWeight_game {
    public static void main(String[] args) {
    PlayerFactory factory = new PlayerFactory();
    List<Player> border = new ArrayList<Player>();
    String[] Playerlist = new String[] {"Policeman", "Terrorist"};
    Random random = new Random();
    Scanner sc= new Scanner(System.in);

        System.out.println("Enter number of Players you want: ");
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            PlayerFlyWeight pfw = factory.createPlayer(Playerlist[random.nextInt(Playerlist.length)]);
            int a =random.nextInt(-10,10);
            int b =random.nextInt(-10,10);
            Player player = new Player(pfw, a, b, pfw.task.substring(pfw.task.lastIndexOf("with")+5));
            player.GeneratePlayer(a, b);
            border.add(player);
        }
    
        Map<String, Integer> weaponCount = new HashMap<String, Integer>();
        Map<String, Integer> typeCount = new HashMap<String, Integer>();
        for(Player player : border){
            String weapon = player.weapon;
            if(weaponCount.containsKey(weapon)){
                weaponCount.put(weapon, weaponCount.get(weapon)+1);
            } else {
                weaponCount.put(weapon, 1);
            }
            if(player.x > 0){
                String type = player.pf.type;
                if(typeCount.containsKey(type)){
                    typeCount.put(type, typeCount.get(type)+1);
                } else {
                    typeCount.put(type, 1);
                }
            }
        }
    
        int maxCount = 0;
        String popularWeapon = "";
        int typeCnt = 0;
        String populerType = "";
        for(Map.Entry<String, Integer> entry : weaponCount.entrySet()){
            String weapon = entry.getKey();
            int count = entry.getValue();
            if(count > maxCount){
                maxCount = count;
                popularWeapon = weapon;
            }
        }
        System.out.println("The most popular weapon among players is: "+popularWeapon+" and "+"number of player: " + maxCount);
    
        for(Map.Entry<String, Integer> entry : typeCount.entrySet()){
            String type = entry.getKey();
            int count = entry.getValue();
            typeCnt = count;
            populerType = type;
        }
        System.out.println("Types of players and their count in the right side: "+populerType+" and "+"number of player: "+ typeCnt);

        //Approx memory consumption
        //Taking Strings as 8-bits and int as 4- bits and reference of PlayerFlyWeight as 8-bit
        //so each player has memory of reference of PlayerFlyWeight, weapon, x, y
        //i.e.  = 8+8+4+4 = 24-bits
        System.out.println("Approximate Memory Consumption: "+(24*border.size()));
        // get the runtime instance
        Runtime runtime = Runtime.getRuntime();

        // calculate the memory consumption
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();

        // print the approximate memory consumption
        System.out.println("Approximate memory consumption: " + usedMemory + " bytes");

                
        int no = n; // number of players
        int k = 2; // number of player types
        int m = 7; // number of weapons

        long totalMemory = 24L; // PlayerFlyWeight object
        totalMemory += 32L; // Player object
        totalMemory += 24L + 4L + 32L * no; // ArrayList<Player> border
        totalMemory += 24L + 12L + 36L * k; // HashMap<String, PlayerFlyWeight> mp
        totalMemory += 24L + 12L + 36L * m; // HashMap<String, Integer> weaponCount
        totalMemory += 24L + 12L + 36L * k; // HashMap<String, Integer> typeCount

        System.out.println("Approximate memory consumption: " + totalMemory + " bytes");
    }
}












/* 

int (primitive): 4 bytes
String (object): 24 bytes (16 bytes object header + 4 bytes for length + 4 bytes reference to char array)
List (object): 24 bytes (16 bytes object header + 8 bytes for ArrayList instance variables)
Map (object): 24 bytes (16 bytes object header + 8 bytes for HashMap instance variables)
PlayerFlyWeight (object): 24 bytes (16 bytes object header + 8 bytes for 2 String references)
Player (object): 32 bytes (16 bytes object header + 8 bytes for PlayerFlyWeight reference + 8 bytes for 2 int variables + 4 bytes reference to String)
Based on this estimate, we can calculate the memory usage for different parts of the program:

PlayerFlyWeight object: 24 bytes
Player object: 32 bytes
ArrayList<Player> border: 24 bytes (ArrayList object) + 4 bytes (int size) + 32 bytes (Player object) * n (number of players)
HashMap<String, PlayerFlyWeight> mp: 24 bytes (HashMap object) + 12 bytes (int size + int threshold) + 36 bytes (3 Entry objects) * k (number of unique player types)
HashMap<String, Integer> weaponCount: 24 bytes (HashMap object) + 12 bytes (int size + int threshold) + 36 bytes (3 Entry objects) * m (number of unique weapons)
HashMap<String, Integer> typeCount: 24 bytes (HashMap object) + 12 bytes (int size + int threshold) + 36 bytes (3 Entry objects) * k (number of unique player types)
To print the total memory consumption, we can sum up the memory usage of each component:

int n = ...; // number of players
int k = 2; // number of player types
int m = 7; // number of weapons

long totalMemory = 24L; // PlayerFlyWeight object
totalMemory += 32L; // Player object
totalMemory += 24L + 4L + 32L * n; // ArrayList<Player> border
totalMemory += 24L + 12L + 36L * k; // HashMap<String, PlayerFlyWeight> mp
totalMemory += 24L + 12L + 36L * m; // HashMap<String, Integer> weaponCount
totalMemory += 24L + 12L + 36L * k; // HashMap<String, Integer> typeCount

System.out.println("Approximate memory consumption: " + totalMemory + " bytes");
 */