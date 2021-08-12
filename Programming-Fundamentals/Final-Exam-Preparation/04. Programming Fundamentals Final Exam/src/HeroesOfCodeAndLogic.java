import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogic {
    public static class Hero {
        private int HP;
        private int MP;

        public int getHP() {
            return HP;
        }

        public int getMP() {
            return MP;
        }

        public void setHP(int HP) {
            if (HP > 100) {
                HP = 100;
            }
            this.HP = HP;
        }

        public void setMP(int MP) {
            if (MP > 200) {
                MP = 200;
            }
            this.MP = MP;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Hero> heroMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");

            String heroName = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);

            if (heroMap.containsKey(heroName)) {
                Hero hero = heroMap.get(heroName);
                hero.setHP(hero.getHP() + hp);
                hero.setMP(hero.getMP() + mp);
            } else {
                Hero hero = new Hero();
                hero.setHP(hp);
                hero.setMP(mp);
                heroMap.put(heroName, hero);
            }
        }

        String command = scan.nextLine();
        while (!command.equals("End")) {
            String[] tokens = command.split(" - ");
            String heroName = tokens[1];
            switch (tokens[0]) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    Hero hero = heroMap.get(heroName);
                    if (hero.getMP() >= neededMP) {
                        hero.setMP(hero.getMP() - neededMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n"
                                , heroName, spellName, hero.getMP());
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n"
                                , heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    Hero heroForAttack = heroMap.get(heroName);
                    heroForAttack.setHP(heroForAttack.getHP() - damage);
                    if (heroForAttack.getHP() <= 0) {
                        System.out.printf("%s has been killed by %s!%n"
                                , heroName, attacker);
                        heroMap.remove(heroName);
                    } else {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                , heroName, damage, attacker, heroForAttack.getHP());
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    Hero heroForRecharge = heroMap.get(heroName);
                    int currentMP = heroForRecharge.getMP();
                    heroForRecharge.setMP(currentMP + amount);
                    if (currentMP + amount > 200) {
                        amount = 200 - currentMP;
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    break;
                case "Heal":
                    int hpAmount = Integer.parseInt(tokens[2]);
                    Hero hero1 = heroMap.get(heroName);
                    int currentHP = hero1.getHP();
                    hero1.setHP(currentHP + hpAmount);
                    if (currentHP + hpAmount > 100) {
                        hpAmount = 100 - currentHP;
                    }
                    System.out.printf("%s healed for %d HP!%n", heroName, hpAmount);
                    break;
            }
            command = scan.nextLine();
        }

        heroMap
                .entrySet()
                .stream()
                .sorted((h1, h2) -> Integer.compare(h2.getValue().getHP(), h1.getValue().getHP()))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.printf("  HP: %d%n", e.getValue().getHP());
                    System.out.printf("  MP: %d%n", e.getValue().getMP());
                });
    }
}
