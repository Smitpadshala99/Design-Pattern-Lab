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
        System.out.println("Player Spawn at position (x,y) : (" + x +","+ y +")  with Weapon : " + weapon + "  Player Type - " + pfw.type );
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

public class lab14_flyweightplayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        int n = sc.nextInt();
        PlayerFactory playerFactory = new PlayerFactory();

        Random random = new Random();
		//For loop for N times
        String[] types = {"Terrorist","Counter-terrorist"};
        String[] weapons = {"Bazuka","AK-47","M4A1-S","Desert-Eagle","SSG 08","Glock-18","M249","R8 Revolver", "Knife"};
        Integer[] count = {0,0,0,0,0,0,0,0,0};
        //Integer []count = new Integer[weapons.length]; 
        
        /* Map<String, Integer> weapons = new HashMap<String, Integer>();
        for(int i=0; i<w.length; i++){
            weapons.put(w[i],0);
        } */

        //"Smoke Grenade", "Explosive Grenade", "Flashbang",
        String type,weapon;
        //Player[] players = new Player[n];
        List<Player> map = new ArrayList<Player>();
        for(int i=0; i<n; i++){            
            type = types[random.nextInt(types.length)];
            Integer index = random.nextInt(weapons.length);
            weapon = weapons[index];
            count[index]++;
            map.add(new Player(playerFactory.spawnPlayer(type),weapon,random.nextInt(-100,100),random.nextInt(-100,100)));
        }
        int maxCount = Collections.max(Arrays.asList(count));
        int maxi = Arrays.asList(count).indexOf(maxCount);;
        
        System.out.println("\nMost popular weapon player: "+weapons[maxi]);

        int numOfTerroristPlayersOnRight = 0;
        int numOfCounterTerroristPlayersOnRight = 0;
        for(int i=0; i<map.size(); i++){
            if(map.get(i).x <= 0){
                if(map.get(i).pfw.type.equalsIgnoreCase("Terrorist")){
                    numOfTerroristPlayersOnRight++;
                }
                else{
                    numOfCounterTerroristPlayersOnRight++;
                }
            }
        }
        if(numOfCounterTerroristPlayersOnRight > numOfTerroristPlayersOnRight){
            System.out.println("Right play area has Counter-Terrorist players in major.");
        }
        else if(numOfCounterTerroristPlayersOnRight < numOfTerroristPlayersOnRight){
            System.out.println("Right play area has Terrorist players in major.");
        }
        else if(numOfCounterTerroristPlayersOnRight == numOfTerroristPlayersOnRight){
            System.out.println("Right play area has both players in same amount.");
        }
        else{
            System.out.println("No players on right side");
        }

        //Approx memory consumption
        //Taking Strings as 8-bits and int as 4- bits and reference of PlayerFlyWeight as 8-bit
        //so each player has memory of reference of PlayerFlyWeight, weapon, x, y
        //i.e.  = 8+8+4+4 = 24-bits
        System.out.println("Approximate Memory Consumption: "+(24*map.size()));
    }
}
