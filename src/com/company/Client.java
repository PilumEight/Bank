package com.company;

import java.util.Comparator;
import java.util.UUID;

public class Client implements Comparator<Client> {
    UUID uuid;
    String name;
    int balance;

    public Client(String name, int balance) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }



    @Override
    public int compare(Client o1, Client o2) {
        return 0;
    }
}
