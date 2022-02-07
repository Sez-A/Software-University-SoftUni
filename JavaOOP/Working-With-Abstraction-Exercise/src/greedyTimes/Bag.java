package greedyTimes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private long capacity;
    private Gold gold;
    private List<Gem> gems;
    private List<Cash> cash;

    public Bag(long quantity) {
        this.capacity = quantity;
        this.gems = new ArrayList<>();
        this.cash = new ArrayList<>();
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        if (capacity > this.capacity || capacity < 0) {
            throw new IllegalArgumentException("No space for more items");
        }
        this.capacity = capacity;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    public List<Gem> getGems() {
        return gems;
    }

    public List<Cash> getCash() {
        return cash;
    }


    public long allGemsQuantity() {
        long sum = 0L;
        for (Gem gem : gems) {
            sum += gem.getQuantity();
        }
        return sum;
    }

    public long allCash() {
        long sum = 0L;
        for (Cash cash : cash) {
            sum += cash.getQuantity();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (gold != null) {
            sb.append(String.format("<Gold> $%d", gold.getQuantity())).append(System.lineSeparator());
            sb.append(String.format("##Gold - %d", gold.getQuantity())).append(System.lineSeparator());
        }


        if (this.gems.size() > 0) {
            sb.append(String.format("<Gem> $%d", this.allGemsQuantity())).append(System.lineSeparator());

            List<Gem> sortedGems = this.gems.stream().sorted((g1, g2) -> {
                int result = g2.getName().compareTo(g1.getName());
                if (result == 0)
                    result = Long.compare(g1.getQuantity(), g2.getQuantity());

                return result;
            }).collect(Collectors.toList());

            for (Gem sortedGem : sortedGems) {
                sb.append(String.format("##%s - %d", sortedGem.getName(),
                        sortedGem.getQuantity())).append(System.lineSeparator());
            }
        }

        if (this.cash.size() > 0) {
            List<Cash> sortedCash = this.cash.stream().sorted((c1, c2) -> {
                int result = c2.getName().compareTo(c1.getName());
                if (result == 0)
                    result = Long.compare(c1.getQuantity(), c2.getQuantity());

                return result;
            }).collect(Collectors.toList());


            sb.append(String.format("<Cash> $%d", this.allCash()))
                    .append(System.lineSeparator());
            for (Cash sortedMoney : sortedCash) {
                sb.append(String.format("##%s - %d", sortedMoney.getName(),
                        sortedMoney.getQuantity())).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }


    public void decreaseCapacity(long amount) {
        this.setCapacity(this.getCapacity() - amount);
    }

}
