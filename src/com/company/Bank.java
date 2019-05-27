package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bank {

     public List<Client> clients = new ArrayList<>();
     //public HashMap<UUID, Client> clients = new HashMap<UUID, Client>();
     public List<Transaction> transactions = new ArrayList<>();
    private int number_tr;

    public  Client addClient(Client cl) {
        clients.add(cl);
        System.out.println(cl);
        return cl;
    }

    public void setFileClients(){
        try {
            FileWriter writer = new FileWriter("client.txt", true);
            clients.forEach(client -> {
                try {
                    writer.write(client.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public void getFileClients(int number_tr) throws IOException {

        BufferedReader file_reader = new BufferedReader(new FileReader("client.txt"));
        Stream<String> lines = file_reader.lines();
        List<String> strings = lines.collect(Collectors.toUnmodifiableList());
        //List<String> all_cl = new ArrayList<String>(Arrays.asList(file_str.split("\n")));
        //all_cl.forEach(s -> System.out.println(s));
        String our_string = strings.get(number_tr);
        List<String> str_params = new ArrayList<String>(Arrays.asList(our_string.split(" ")));
        int balance = Integer.parseInt(str_params.get(3));
        clients.add(new Client(str_params.get(2), balance));
    }

    public boolean getFileTransactions(int number_tr) throws IOException {
        BufferedReader file_reader = new BufferedReader(new FileReader("notes3.txt"));
        Stream<String> lines = file_reader.lines();
        List<String> file_str = lines.collect(Collectors.toUnmodifiableList());
        //List<String> all_tr = new ArrayList<String>(Arrays.asList(file_str.split("\n")));
        String our_string = file_str.get(number_tr);
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

    public void printClients(){
        clients.forEach(System.out::println);
    }


// СОРТИРОВКА ПО БАЛАНСУ И ИМЕНИ
    public void sortClients(){
        clients.sort(new ComporatorByBalance());
        clients.forEach(System.out::println);
    }

    //СОРТИРОВКА ПО БАЛАНСУ
    /*
    public void sortbyBalance(){
        clients.sort(new ComporatorByBalance());
        clients.forEach(System.out::println);
    }
     */
    //СОРТИРОВКА ПО ИМЕНИ
    public void sortbyName(){
        clients.sort(new ComporatorByName());
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


    public boolean addTransaction(Transaction tr)  throws CustomerNotFoundException{
        if (clients.contains(tr.up_client) & clients.contains(tr.up_client)){
            if (tr.up_client.balance >= tr.value) {
                transactions.add(tr);
                System.out.println(tr);
                return true;
            } else {
                System.out.println("Недостаточно средств");
                return false;
            }
        }
        else {
            throw new CustomerNotFoundException();
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
