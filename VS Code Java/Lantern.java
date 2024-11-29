import java.util.*;

public class Lantern {

    private static String playerName;
    private static int health = 100;
    private static int attackPower = 15;
    private static int potionCount = 3;
    private static int gold = 50;
    private static String currentLocation = "Village";
    private static List<String> inventory = new ArrayList<>();
    private static Map<String, String[]> map = new HashMap<>();
    private static Random random = new Random();

    public static void main(String[] args) {
        setupMap();
        greetPlayer();
        gameLoop();
    }

    private static void setupMap() {
        map.put("Village", new String[] { "Forest", "Blacksmith", "Inn" });
        map.put("Forest", new String[] { "Village", "Cave" });
        map.put("Blacksmith", new String[] { "Village" });
        map.put("Inn", new String[] { "Village" });
        map.put("Cave", new String[] { "Forest" });
    }

    private static void greetPlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your character's name: ");
        playerName = scanner.nextLine();
        System.out.println("Welcome, " + playerName + "! Your adventure begins in the " + currentLocation + ".");
    }

    private static void gameLoop() {
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);
        while (playing) {
            System.out.println("\nYou are currently in: " + currentLocation);
            System.out.println("Choose an action: (move, explore, rest, inventory, status, quit)");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "move":
                    move();
                    break;
                case "explore":
                    explore();
                    break;
                case "rest":
                    rest();
                    break;
                case "inventory":
                    checkInventory();
                    break;
                case "status":
                    displayStatus();
                    break;
                case "quit":
                    playing = false;
                    System.out.println("Thank you for playing, " + playerName + "!");
                    break;
                default:
                    System.out.println("Invalid action. Try again.");
                    break;
            }
        }
    }

    private static void move() {
        String[] destinations = map.get(currentLocation);
        System.out.println("Where would you like to go?");
        for (int i = 0; i < destinations.length; i++) {
            System.out.println((i + 1) + ". " + destinations[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= destinations.length) {
            currentLocation = destinations[choice - 1];
            System.out.println("You travel to the " + currentLocation + ".");
        } else {
            System.out.println("Invalid destination.");
        }
    }

    private static void explore() {
        System.out.println("You start exploring the " + currentLocation + ".");
        if (random.nextInt(100) < 50) {
            encounterEnemy();
        } else {
            findLoot();
        }
    }

    private static void encounterEnemy() {
        System.out.println("A wild Goblin appears!");
        String[] options = { "Fight", "Flee" };
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            fight();
        } else {
            System.out.println("You fled back to the " + currentLocation + ".");
        }
    }

    private static void fight() {
        int enemyHealth = 50;
        while (enemyHealth > 0 && health > 0) {
            System.out.println("\nYour Health: " + health);
            System.out.println("Goblin's Health: " + enemyHealth);
            System.out.println("Choose an action: (attack, use potion, flee)");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine().toLowerCase();

            switch (action) {
                case "attack":
                    int playerDamage = random.nextInt(attackPower);
                    int enemyDamage = random.nextInt(10);
                    System.out.println("You dealt " + playerDamage + " damage to the Goblin!");
                    enemyHealth -= playerDamage;
                    System.out.println("The Goblin hit you for " + enemyDamage + " damage!");
                    health -= enemyDamage;
                    break;
                case "use potion":
                    usePotion();
                    break;
                case "flee":
                    System.out.println("You fled back to the " + currentLocation + ".");
                    return;
                default:
                    System.out.println("Invalid action.");
                    break;
            }
        }

        if (health <= 0) {
            System.out.println("You have been defeated...");
        } else {
            System.out.println("You defeated the Goblin!");
            gold += 20;
        }
    }

    private static void usePotion() {
        if (potionCount > 0) {
            health += 30;
            potionCount--;
            System.out.println("You used a potion and restored 30 health. Potions left: " + potionCount);
        } else {
            System.out.println("You have no potions left!");
        }
    }

    private static void findLoot() {
        System.out.println("You found a chest with 50 gold!");
        gold += 50;
    }

    private static void rest() {
        System.out.println("You rest at the " + currentLocation + " and restore 20 health.");
        health += 20;
        if (health > 100)
            health = 100;
    }

    private static void checkInventory() {
        System.out.println("\n=== Inventory ===");
        System.out.println("Gold: " + gold);
        System.out.println("Health: " + health);
        System.out.println("Potions: " + potionCount);
        System.out.println("Inventory: " + (inventory.isEmpty() ? "Empty" : inventory.toString()));
    }

    private static void displayStatus() {
        System.out.println("\n=== Player Status ===");
        System.out.println("Name: " + playerName);
        System.out.println("Health: " + health);
        System.out.println("Attack Power: " + attackPower);
        System.out.println("Gold: " + gold);
        System.out.println("Current Location: " + currentLocation);




































































































































































   amigo






















































































































































































































































































































































































        //line fucking breaks










































































































        System.out.println("Hitais");

    }
}
