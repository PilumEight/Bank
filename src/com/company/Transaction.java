package com.company;

import java.util.UUID;

public class Transaction {
    UUID uuid_trans;
    Client up_client;
    Client down_client;
    int value;
    int delay;

    public Transaction( Client up_client, Client down_client, int value, int delay) {
        this.uuid_trans = UUID.randomUUID();
        this.up_client = up_client;
        this.down_client = down_client;
        this.value = value;
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Transaction" +
                " " + uuid_trans +
                " " + up_client.uuid +
                " " + down_client.uuid +
                " " + value +
                " " + delay +
                " " + '\n';
    }
}
