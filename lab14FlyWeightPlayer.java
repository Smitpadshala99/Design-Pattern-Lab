import java.util.*;

// Find popular weapon among players
// Right play area has which type of players in major
// Approximate memory consumption

class PlayerFlyWeight{
	String type;
	String colorCode;
    String task;

	public PlayerFlyWeight(String t, String c, String task){
        System.out.println("PlayerFlyWeight Object created!!!");
		type = t;
		colorCode = c;
        this.task = task; 
	}
}

class Player{
    // String type;
    // String colorCode;
    // String task;
    PlayerFlyWeight pfw;    //Reference is address so long type so 8-bit
    String weapon;
    int x;
    int y;
    public Player(PlayerFlyWeight pfw){
        this.pfw = pfw;
    }
    public Player(PlayerFlyWeight pfw, String weapon, int x, int y){
        this.pfw = pfw;
        this.weapon = weapon;
        this.x = x;
        this.y = y;
        System.out.println("Player Type - " + pfw.type + "Spawn at position X : " + x +  "and Y : " + y);
    }
    public void respawn(String weapon, int x, int y){
        this.weapon = weapon;
        this.x = x;
        this.y = y;
        System.out.println("Player Type - " + pfw.type + "ReSpawn at position X : " + x +  "and Y : " + y);
    }
    //go on mission function bussiness method
}

class PlayerFactory{
		
	Map<String, PlayerFlyWeight> mp = new HashMap<String, PlayerFlyWeight>();
	PlayerFlyWeight pfw = null;
	public PlayerFlyWeight spawnPlayer(String type){
		
		if(mp.containsKey(type))
			pfw = mp.get(type);
		else{
			if(type.equalsIgnoreCase("Terrorist")){
				pfw = new PlayerFlyWeight("Terrorist", "Red", "Plant Bomb");
			}else if(type.equalsIgnoreCase("Counter-terrorist"))
				pfw = new PlayerFlyWeight("Counter-terrorist", "Blue", "Defuse Bomb");
			else
				System.out.println("Player-Type not available!!");
			mp.put(type,pfw);
			
		}	
		return pfw;	
	}
}

public class lab14FlyWeightPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int n = sc.nextInt();
        PlayerFactory playerFactory = new PlayerFactory();

        Random random = new Random();
		//For loop for N times
        String[] types = {"Terrorist","Counter-terrorist"};
        String[] weapons = {"Bazuka","AK-47","M4A1-S","Desert-Eagle","SSG 08","Glock-18","M249","R8 Revolver", "Knife"};
        //int[] count = {0,0,0,0,0,0,0,0,0};
        Integer []count = new Integer[weapons.length]; 
        
        /* Map<String, Integer> weapons = new HashMap<String, Integer>();
        for(int i=0; i<w.length; i++){
            weapons.put(w[i],0);
        } */

        //"Smoke Grenade", "Explosive Grenade", "Flashbang",
        String type,weapon;
        Player[] players = new Player[n];
        for(int i=0; i<n; i++){            
            type = types[random.nextInt(types.length)];
            int index = random.nextInt(weapons.length);
            weapon = weapons[index];
            count[index]++;
            players[i] = new Player(playerFactory.spawnPlayer(type),weapon,random.nextInt(0,100),random.nextInt(0,100));
        }
        int maxCount = Collections.max(Arrays.asList(count));
        System.out.println("Most popular weapon player: ");
    }
}
