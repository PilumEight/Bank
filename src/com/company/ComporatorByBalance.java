package com.company;

import java.util.Comparator;

public class ComporatorByBalance implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        {
            // отнимает balance и получаем результат в переменную flag
            int flag = o1.balance - o2.balance;

            // если получили 0, то сортируем по имени
            if(flag == 0) flag = o1.name.compareTo(o2.name);
            return flag;
        }
    }

    @Override
    public Comparator<Client> reversed() {
        return null;
    }
}
