package greedyTimes.serviceImpl;


import greedyTimes.Cash;
import greedyTimes.services.CashService;

import java.util.List;

public class CashServiceImpl implements CashService {
    private List<Cash> cash;

    public CashServiceImpl(List<Cash> cash) {
        this.cash = cash;
    }

    @Override
    public boolean containsCash(String name) {
        for (Cash cash : cash) {
            if (cash.getName().equals(name))
                return true;
        }
        return false;
    }

    @Override
    public Cash findCashByName(String name) {
        for (Cash cash : cash) {
            if (cash.getName().equals(name))
                return cash;
        }
        return null;
    }
}
