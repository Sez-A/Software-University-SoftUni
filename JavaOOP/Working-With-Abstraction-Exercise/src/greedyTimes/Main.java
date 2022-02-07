package greedyTimes;


import greedyTimes.serviceImpl.CashServiceImpl;
import greedyTimes.serviceImpl.GemServiceImpl;
import greedyTimes.services.CashService;
import greedyTimes.services.GemService;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());

        String[] chest = scanner.nextLine().split("\\s+");


        Bag bag = new Bag(capacity);
        try {
            for (int i = 0; i < chest.length; i += 2) {
                String item = chest[i];
                long quantity = Long.parseLong(chest[i + 1]);

                String itemType = "";

                itemType = getItemType(item, itemType);


                if (itemType.equals("")) {
                    continue;
                } else if (bag.getCapacity() < quantity) {
                    continue;
                }

                GemService gemService = new GemServiceImpl(bag.getGems());
                CashService cashService = new CashServiceImpl(bag.getCash());

               switch (itemType) {
                    case "Gem":
                        if (!gemService.containsGem(item)) {
                            if (bag.getGold() != null) {
                                if (bag.allGemsQuantity() + quantity > bag.getGold().getQuantity()) {
                                    continue;
                                } else {
                                    List<Gem> gems = bag.getGems();
                                    gems.add(new Gem(item, quantity));
                                    bag.setCapacity(bag.getCapacity() - quantity);
                                }
                            }
                        } else if (gemService.findGemByName(item).getQuantity()
                                + quantity > bag.getGold().getQuantity()) {
                            continue;
                        } else {
                            Gem gemByName = gemService.findGemByName(item);
                            gemByName.setQuantity(gemByName.getQuantity() + quantity);
                            bag.setCapacity(bag.getCapacity() - quantity);
                        }
                        break;
                    case "Cash":
                        if (!cashService.containsCash(item)) {
                            if (bag.allCash() + quantity <= bag.allGemsQuantity()) {
                                if (bag.allCash() + quantity <= bag.getGold().getQuantity()) {
                                    List<Cash> cash = bag.getCash();
                                    cash.add(new Cash(item, quantity));
                                    bag.setCapacity(bag.getCapacity() - quantity);
                                }
                                continue;
                            }
                        } else if (cashService.findCashByName(item).getQuantity()
                                + quantity > bag.allGemsQuantity()) {
                            continue;
                        } else {
                            Cash cashByName = cashService.findCashByName(item);
                            cashByName.setQuantity(cashByName.getQuantity() + quantity);
                            bag.setCapacity(bag.getCapacity() - quantity);
                        }
                        break;
                    case "Gold":
                        Gold gold = bag.getGold();
                        if (gold == null) {
                            bag.setGold(new Gold(quantity));
                        } else
                            gold.setQuantity(gold.getQuantity() + quantity);
                        bag.setCapacity(bag.getCapacity() - quantity);
                        break;
                }



//                switch (itemType) {
//                    case "Gem":
//
//                        //false -> true
//                        if (!gemService.containsGem(itemType)) {
//                            if (bag.getGold() != null) {
//                                if (quantity > bag.getGold().getQuantity()) {
//                                    continue;
//                                }
//
//                                //Gem for firstTime
//                                bag.getGems().add(new Gem(item, quantity));
//                                bag.decreaseCapacity(quantity);
//                            } else {
//                                continue;
//                            }
//                        } else if (bag.allGemsQuantity() + quantity > bag.getGold().getQuantity()) {
//                            continue;
//                        } else {
//                            Gem gem = gemService.findGemByName(item);
//                            gem.setQuantity(gem.getQuantity() + quantity);
//                            bag.decreaseCapacity(quantity);
//                        }
//                        break;
//                    case "Cash":
//                        if (!cashService.containsCash(itemType)) {
//                            if (bag.getGems().size() > 0) {
//                                if (bag.allCash() + quantity > bag.allGemsQuantity()) {
//                                    continue;
//                                }
//
//                                bag.getCash().add(new Cash(item, quantity));
//                                bag.decreaseCapacity(quantity);
//                            } else {
//                                continue;
//                            }
//                        } else if (bag.allCash() + quantity > bag.allGemsQuantity()) {
//                            continue;
//                        } else {
//                            Cash cash = cashService.findCashByName(item);
//                            cash.setQuantity(cash.getQuantity() + quantity);
//                            bag.decreaseCapacity(quantity);
//                        }
//                        break;
//                    case "Gold":
//                        if (bag.getGold() == null) {
//                            bag.setGold(new Gold(quantity));
//                        } else {
//                            Gold gold = bag.getGold();
//                            gold.setQuantity(gold.getQuantity() + quantity);
//                            bag.decreaseCapacity(quantity);
//                        }
//                        break;
//                }

            }
        } catch (Exception e) {
            return;
        }

        if (bag.toString().length() > 0) {
            System.out.println(bag);
        }
    }

    private static String getItemType(String item, String itemType) {
        if (item.length() == 3) {
            itemType = "Cash";
        } else if (item.toLowerCase().endsWith("gem")) {
            itemType = "Gem";
        } else if (item.toLowerCase().equals("gold")) {
            itemType = "Gold";
        }
        return itemType;
    }
}
