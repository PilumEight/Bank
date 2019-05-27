package com.company;

import java.util.Comparator;

public class ComporatorByName implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        int flag;
        flag = o1.name.compareTo(o2.name);
        return flag;
    }

    @Override
    public Comparator<Client> reversed() {
        return null;
    }
}
