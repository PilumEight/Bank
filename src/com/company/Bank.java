package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Bank {

     public List<Client> clients = new ArrayList<>();
     //public HashMap<UUID, Client> clients = new HashMap<UUID, Client>();
     public List<Transaction> transactions = new ArrayList<>();

    public  void addClient(Client cl) {
        clients.add(cl);
        System.out.println(cl);
    }


    public void setFileTransactions(){
        try {
            FileWriter writer = new FileWriter("notes3.txt", true);
            transactions.forEach(transaction -> {
                try {
                    writer.write(transaction.toString());
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean getFileTransactions(int number_tr) throws IOException {
        BufferedReader file_reader = new BufferedReader(new FileReader("notes3.txt"));
        String file_str;
        file_str = file_reader.readLine();
        List<String> all_tr = new ArrayList<String>(Arrays.asList(file_str.split("\n")));
        String our_string = all_tr.get(number_tr);
        List<String> str_params = new ArrayList<String>(Arrays.asList(our_string.split(" ")));
        System.out.println(str_params.get(2));
        UUID up_client = UUID.fromString(str_params.get(2));
        UUID down_client = UUID.fromString(str_params.get(3));
        HashMap<Integer, Client> loc_clients = new HashMap<Integer, Client>();
        for (Client cl : clients
        ) {
            if (cl.uuid.equals(up_client)) {
                loc_clients.put(1, cl);
            } else if (cl.uuid.equals(down_client)) {
                loc_clients.put(2, cl);
            }
        }
        int value = Integer.parseInt(str_params.get(4));
        int delay = Integer.parseInt(str_params.get(5));
        System.out.println(loc_clients.get(1) + " " +  loc_clients.get(2) + " " + value + " " + delay);
        Transaction tr = new Transaction(loc_clients.get(1), loc_clients.get(2), value, delay);

        if (clients.contains(tr.up_client) & clients.contains(tr.up_client)){
            transactions.add(tr);
            System.out.println(tr);
            return true;
        }
        else {
            System.out.println("Транзакция не прошла");
            return false;
        }
    }




    public void sortClients(){
        clients.sort(new ComporatorByBalance());
        clients.forEach(System.out::println);
    }


    public Client delClient(String ident) {
        UUID cl = UUID.fromString(ident);
        for (Client client: clients
             ) {
            if (client.uuid.equals(cl)){
                clients.remove(client);
                return client;

            }

        }
        return null;
    }

    // возвращает
    public List<Client> stringClients(String name) {
        List<Client> loc_clients = new ArrayList<>();
        for (Client cl: clients
             ) {
            if (cl.name.contains(name)) {
                loc_clients.add(cl);
            }

        }
        return loc_clients;
    }


    public void getNameClients(String name) {

    }


    public Client getClient(String ident) {
        UUID uid = UUID.fromString(ident);
        for (Client client: clients

             ) {
            if (client.uuid.equals(uid)){
                return client;
            }
        }
        return null;
    }


    public boolean addTransaction(Transaction tr){
        if (clients.contains(tr.up_client) & clients.contains(tr.up_client)){
            transactions.add(tr);
            System.out.println(tr);
            return true;
        }
        else {
            System.out.println("Транзакция не прошла");
            return false;
        }
    }


    public void getTransactions() {
        System.out.println(transactions);
    }

    public void runTransactions() throws InterruptedException {
        for (Transaction transaction: transactions
             ) {
            transaction.up_client.balance -= transaction.value;
            transaction.down_client.balance += transaction.value;
            Thread.sleep(transaction.delay);
            System.out.println(transaction);

        }
        transactions.clear();


    }



    public static void main(String[] args) {

        System.out.println("mda");

    }
}
