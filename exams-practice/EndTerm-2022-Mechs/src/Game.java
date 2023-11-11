import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    List<Mech> mechs;
    List<Equipment> equipments;
    Player player;
    int nrBattlesWon;

    public void showMechs() {
        for (Mech mech : mechs) {
            System.out.println(mech + "\n");
        }

    }

    public void showPlayer() {
        System.out.println(player);
    }

    public void fight() {
        Mech mech = mechs.get(nrBattlesWon % mechs.size());

        int initialPlayerHp = player.getStats().getHp();

        Fighter f1;
        Fighter f2;
        if (player.getStats().getSpeed() < mech.getStats().getSpeed()) {
            f1 = mech;
            f2 = player;
        } else {
            f1 = player;
            f2 = mech;
        }

        while (!attack(f1, f2)) {
            Fighter aux = f1;
            f1 = f2;
            f2 = aux;
        }

        if (f1 instanceof Mech) {
            // player won
            player.setHp(initialPlayerHp);

            int id = mech.getLootDropId();
            Equipment equipment = null;
            for (Equipment e : equipments) {
                if (e.getEquipmentId() == id) {
                    equipment = e;
                    break;
                }
            }

            if (equipment == null) {
                return; // TODO
            }

            if (equipment.getCategory().equals("Offensive")) {
                player.setOffensiveEquip(equipment);
            } else {
                player.setDefensiveEquip(equipment);
            }

            nrBattlesWon++;
            System.out.println("You fight against a " + mech.getName()
                    + "... and win! You get a " + equipment + ".\n You have won "
                    + nrBattlesWon + " battles.");
        } else {
            // player lost
            player = new Player();
            System.out.println("You fight against a " + mech.getName()
                    + "... and lost" + ".\n You have won "
                    + nrBattlesWon + " battles.");
            nrBattlesWon = 0;
        }


    }

    // if it kills returns 1
    private boolean attack(Fighter f1, Fighter f2) {
        // 1
        int attack = f1.getStats().getAttack();
        attack += f1.getAttackBonus();

        // 2
        int mul = 1;
        // TODO make more efficient
        for (String s : f1.getStrengths()) {
            if (f1.getWeaknesses().contains(s)) {
                mul = 1; // combat edge case
                break;
            }
            if (f2.getWeaknesses().contains(s)) {
                mul = 2;
            }
        }
        attack *= mul;

        // 3
        int defence = f2.getStats().getDefence();
        defence += f1.getDefenceBonus();
        attack -= defence;

        // 4
        if (attack > 0) {
            f2.decreaseHp(attack);
        }

        return f2.getStats().getHp() <= 0;
    }

    public void write(BufferedWriter output) {
        String s = nrBattlesWon + "\n" +
                (player.getDefensiveEquip() == null ? "null" : player.getDefensiveEquip().toString()) + "\n"
                + (player.getOffensiveEquip() == null ? "null" : player.getOffensiveEquip().toString());

//        System.out.println(s);
        try {
            output.write(s);
            output.close();
        } catch (IOException e) {
            System.out.println("Error writing");
        }
    }

    public void read(Scanner input, Scanner input2) {
        try {
            nrBattlesWon = input2.nextInt();
            input.nextLine(); // skip /n
            Equipment equipment1 = Equipment.read(
                    new Scanner(input.nextLine())
            );
            Equipment equipment2 = Equipment.read(
                    new Scanner(input.nextLine())
            );
            player.setDefensiveEquip(equipment1);
            player.setOffensiveEquip(equipment2);
        } catch (Exception e) {
            System.out.println("No resources/out.txt file");
        }

        mechs = new ArrayList<>();
        equipments = new ArrayList<>();
        player = new Player();
        nrBattlesWon = 0;

        // TODO use regex to separate mech from equip

        int nr = input.nextInt();
        input.nextLine(); // skip /n
        for (int i = 0; i < nr; i++) {
            mechs.add(Mech.read(input));
        }

        nr = input.nextInt();
        input.nextLine(); // skip /n
        for (int i = 0; i < nr; i++) {
            equipments.add(Equipment.read(input));
        }
    }
}
