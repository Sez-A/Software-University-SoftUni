package barracksWars.data;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;

import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {

    private Map<String, Integer> amountOfUnits;

    public UnitRepository() {
        this.amountOfUnits = new TreeMap<>();
    }

    public void addUnit(Unit unit) {
        String unitType = unit.getClass().getSimpleName();
        if (!this.amountOfUnits.containsKey(unitType)) {
            this.amountOfUnits.put(unitType, 0);
        }

        int newAmount = this.amountOfUnits.get(unitType) + 1;
        this.amountOfUnits.put(unitType, newAmount);
    }

    public String getStatistics() {
        StringBuilder statBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
            String formatedEntry =
                    String.format("%s -> %d%n", entry.getKey(), entry.getValue());
            statBuilder.append(formatedEntry);
        }
        statBuilder.setLength(
                statBuilder.length() - System.lineSeparator().length());

        return statBuilder.toString();
    }

    public void removeUnit(String unitType) throws Exception {
        // TODO: implement for problem 4
        if (amountOfUnits.containsKey(unitType) && amountOfUnits.get(unitType) > 0) {
            /* TODO: 3.12.2021 г. As this code takes 0/100 in judge
                 with only one change which was adding amountOfUnits.get(unitType) > 0 in If statement
                   code starts to takes 100/100 Power of OOP  */
            amountOfUnits.put(unitType, amountOfUnits.get(unitType) - 1);
            throw new Exception(unitType + " retired!");
        }
        throw new Exception("No such units in repository.");
    }
}
