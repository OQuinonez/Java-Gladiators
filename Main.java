import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void healthRage(Gladiator one, Gladiator two){
        System.out.println(one.name + ": " + "Health: " + one.health + " Rage: " + one.rage);
        System.out.println(two.name + ": " + "Health: " + two.health + " Rage: " + two.rage);
    }

    public static void winner(Gladiator one, Gladiator two){
        if(two.is_alive()){
            System.out.println("The Winner is " + one.name);
            System.out.println(two.name + " Better luck next time!");
            System.exit(0);
        }
    }

    public static void battle(Gladiator one, Gladiator two, Integer turn){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Integer result = turn % 2;
            if (result.equals(0)) {
                String move = scanner.nextLine();
                Gladiator attacker = one;
                Gladiator defender = two;
                System.out.println("Choose your move!  " + attacker.name);
                if (move.equals("1")) {
                    attacker.attack(defender);
                    healthRage(attacker, defender);
                    winner(attacker, defender);
                }else if(move.equals("2")){
                    attacker.heal();
                    healthRage(attacker, defender);
                }
                else if(move.equals("3")){
                    attacker.rage();
                    healthRage(attacker, defender);
                }

            }
            else {
                Gladiator attacker = two;
                Gladiator defender = one;
                String move = scanner.nextLine();
                System.out.println("Choose your move!  " + attacker.name);
                if (move.equals("1")) {
                    attacker.attack(defender);
                    healthRage(attacker, defender);
                    winner(attacker, defender);
                }else if(move.equals("2")){
                    attacker.heal();
                    healthRage(attacker, defender);
                }
                else if(move.equals("3")){
                    attacker.rage();
                    healthRage(attacker, defender);
                }
            }
            turn += 1;
        }
    }

    public static void main(String[] args){
        Random rand = new Random();
        int turn = 1;
        int highHit = rand.nextInt(25) + 20;
        int lowHit = rand.nextInt(8) + 3;
        Gladiator player1 = new Gladiator("Ken", 150, 0, rand.nextInt(25) + 20, rand.nextInt(8) + 3);
        Gladiator player2 = new Gladiator("Ryu", 150, 0, rand.nextInt(25) + 20, rand.nextInt(8) + 3);
        System.out.println("Welcome to the Gladiator Game!");
        System.out.println("Press 1 to attack, 2 to heal, and 3 to skip your turn for extra rage.  ");
        System.out.println("Ken you're first");
        healthRage(player1, player2);
        battle(player1, player2, turn);

    }
}
