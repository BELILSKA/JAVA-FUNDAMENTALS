package FundamentalsFinalExamPreparation;

import java.util.*;

public class P03HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Hero> heroes = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] heroesInfo = scanner.nextLine().split(" ");
            String name = heroesInfo[0];
            int hitPoints = Integer.parseInt(heroesInfo[1]);
            int manaPoints = Integer.parseInt(heroesInfo[2]);

            Hero hero = new Hero(name, hitPoints, manaPoints);
            heroes.put(name,hero);
        }
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] commandLine = input.split(" - ");
            String command = commandLine[0];
            String heroName = commandLine[1];

            switch (command) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(commandLine[2]);
                    String spellName = commandLine[3];

                    if (heroes.get(heroName).getManaPoints() >= mpNeeded) {
                        int leftMP = heroes.get(heroName).getManaPoints() - mpNeeded;
                        heroes.get(heroName).setManaPoints(leftMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",heroName,spellName,heroes.get(heroName).getManaPoints());
                    }else {
                        System.out.printf("%s does not have enough MP to cast %s!%n",heroName,spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandLine[2]);
                    String attacker = commandLine[3];

                    heroes.get(heroName).setHitPoints(heroes.get(heroName).getHitPoints() - damage);

                    if (heroes.get(heroName).getHitPoints() > 0) {
                        int hpLeft = heroes.get(heroName).getHitPoints();
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName,damage,attacker,hpLeft);
                    }else {
                        heroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n",heroName,attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(commandLine[2]);

                    if (heroes.get(heroName).getManaPoints() + amount > 200) {
                        amount = 200 - heroes.get(heroName).getManaPoints();
                        heroes.get(heroName).setManaPoints(200);
                    }else {
                        heroes.get(heroName).setManaPoints(heroes.get(heroName).getManaPoints() + amount);
                    }
                    System.out.printf("%s recharged for %d MP!%n",heroName,amount);
                    break;
                case "Heal":
                    int amountToHeal = Integer.parseInt(commandLine[2]);

                    if (heroes.get(heroName).getHitPoints() + amountToHeal > 100) {
                        amountToHeal = 100 - heroes.get(heroName).getHitPoints();
                        heroes.get(heroName).setHitPoints(100);
                    }else {
                        heroes.get(heroName).setHitPoints(heroes.get(heroName).getHitPoints() + amountToHeal);
                    }
                    System.out.printf("%s healed for %s HP!%n",heroName,amountToHeal);

                    break;
            }

            input = scanner.nextLine();
        }
        heroes.forEach((k,v)-> System.out.printf("%s%n" +
                "  HP: %d%n" +
                "  MP: %d%n", k,v.getHitPoints(), v.getManaPoints()));

    }
    static class Hero {
        String name;
        int hitPoints;
        int manaPoints;

        public Hero(String name, int hitPoints, int manaPoints) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.manaPoints = manaPoints;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public int getManaPoints() {
            return manaPoints;
        }

        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }

    }
}
