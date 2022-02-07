
package greedyTimes.services;

import greedyTimes.Cash;

public interface CashService {

    boolean containsCash(String name);

    Cash findCashByName(String name);
}
