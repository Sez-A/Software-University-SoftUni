package mySingletonDemo;

import java.util.ArrayList;
import java.util.List;

public class Database {
    List<String> repository;

    public Database() {
        this.repository = new ArrayList<>();
    }

    public void addData(String data) {
        this.repository.add(data);
    }


}
