import java.util.*;

// Mediator Interface
interface ArmyMediator {
    public void send(String message, ArmyTeam sender);
}

// Collegue Class - Army Team
class ArmyTeam {
    private String teamName;
    private ArmyMediator mediator;

    public ArmyTeam(String teamName, ArmyMediator mediator) {
        this.teamName = teamName;
        this.mediator = mediator;
    }

    public void send(String message) {
        System.out.println("[" + teamName + "] Sending message: " + message);
        mediator.send(message, this);
    }

    public void receive(String message) {
        System.out.println("[" + teamName + "] Received message: " + message);
    }
}

// Concrete Mediator Class - Army Commander
class ArmyCommander implements ArmyMediator {
    private List<ArmyTeam> teams = new ArrayList<>();

    public void addTeam(ArmyTeam team) {
        teams.add(team);
    }

    @Override
    public void send(String message, ArmyTeam sender) {
        for (ArmyTeam team : teams) {
            if (team != sender) {
                team.receive(message);
            }
        }
        System.out.println();
    }
}

public class ArmyMediatorExample {
    public static void main(String[] args) {
        // Create mediator (Army Commander)
        ArmyCommander commander = new ArmyCommander();

        // Create army teams
        ArmyTeam team1 = new ArmyTeam("Team1", commander);
        ArmyTeam team2 = new ArmyTeam("Team2", commander);
        ArmyTeam team3 = new ArmyTeam("Team3", commander);

        // Add teams to the mediator (Army Commander)
        commander.addTeam(team1);
        commander.addTeam(team2);
        commander.addTeam(team3);

        // Send messages between army teams
        team1.send("Attack the enemy from the east!");
        team2.send("Hold the defensive line!");
        team3.send("Provide support to team1!");

    }
}