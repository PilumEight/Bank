package com.company;

import javax.swing.text.html.parser.Parser;
import java.io.*;
import java.util.*;

public class Newmain {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Ya rabotau");
        Bank alpha = new Bank();
        Client jora = new Client("Jora", 100);
        Client sanya = new Client("Sanya", 100);
        Transaction sj = new Transaction(jora,sanya, 50, 0);
        alpha.addClient(jora);
        alpha.addClient(sanya);
        alpha.addTransaction(sj);
        alpha.getTransactions();
        //add-transaction 2755f859-a53f-496c-a0c0-66f610b85d43 3c4f38f8-01ad-4bef-969d-91c73cbf6c52 100 0
        //System.out.println(jora);
        //System.out.println(sanya);
        /*
        Client [] lya = new Client[]{
                new Client("Jora", 100),
                new Client("Sanya", 100),
                new Client("Jora", 100),
                new Client("Sanya", 100),
                new Client("Jora", 100),
                new Client("Sanya", 100),
                new Client("Jora", 100),
                new Client("Sanya", 100),
        };
             for (Client cl: lya
        ) {
            alpha.addClient(cl);
        }
        */
        System.out.println("--------------------------------------");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file_reader = new BufferedReader(new FileReader("notes3.txt"));

        Command[] commands = new Command[]{
                new Command("print") {
                    @Override
                    public void execute(List<String> str_params) {
                        System.out.println("исполняется print");
                        alpha.sortClients();
                    }
                },
                new Command("add-customer") {
                    @Override
                    public void execute(List<String> str_params) {
                        String name = str_params.get(1);
                        int value = Integer.parseInt(str_params.get(2));

                        alpha.addClient(new Client(name, value));

                    }
                },
                new Command("print-customers") {
                    @Override
                    public void execute(List<String> str_params) {
                        alpha.sortClients();
                    }
                },
                new Command("add-transaction") {
                    @Override
                    public void execute(List<String> str_params) {
                        System.out.println("Исполняется add-transaction");
                        HashMap<Integer, Client> loc_clients = new HashMap<Integer, Client>();
                        UUID up_client = UUID.fromString(str_params.get(1));
                        UUID down_client = UUID.fromString(str_params.get(2));
                        for (Client cl : alpha.clients
                        ) {
                            if (cl.uuid.equals(up_client)) {
                                loc_clients.put(1, cl);
                            } else if (cl.uuid.equals(down_client)) {
                                loc_clients.put(2, cl);
                            }
                        }
                        int value = Integer.parseInt(str_params.get(3));
                        int delay = Integer.parseInt(str_params.get(4));
                        alpha.addTransaction(new Transaction(loc_clients.get(1), loc_clients.get(2), value, delay));

                    }
                },
                new Command("print-transactions") {
                    @Override
                    public void execute(List<String> str_params) {
                        alpha.getTransactions();
                    }
                },
                new Command("run-transactions") {
                    @Override
                    public void execute(List<String> str_params) throws InterruptedException {
                        alpha.runTransactions();
                    }
                },
                new Command("exit") {
                    @Override
                    public void execute(List<String> str_params) {
                        System.exit(1);
                    }
                },
                new Command("add-to-file-trans") {
                    @Override
                    public void execute(List<String> str_params) {
                        alpha.setFileTransactions();
                    }
                },
                new Command("get-from-file-trans") {
                    @Override
                    public void execute(List<String> str_params) throws IOException {
                        int number_tr = Integer.parseInt(str_params.get(1));
                        alpha.getFileTransactions(number_tr);
                        //Command command;
                        //command = commands[3];


                    }
                },
                new Command("del-client") {
                    @Override
                    public void execute(List<String> str_params) throws IOException {
                        alpha.delClient(str_params.get(1));
                    }
                }
        };

        List<String> str_commands = new ArrayList<>();
        for (Command command: commands
        ) {
            str_commands.add(command.name);
        }

        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedReader file_reader = new BufferedReader(new FileReader("notes3.txt"));
        while (true) {
            String str = reader.readLine();

            List<String> str_command = new ArrayList<String>(Arrays.asList(str.split(" ")));
            if (!str_commands.contains(str_command.get(0))){
                System.out.println("Unknown command");
                continue;
            }
            System.out.println(str_command.get(0));

            for (Command com : commands
            ) {

                if (str_command.get(0).equals(com.name)) {
                    com.execute(str_command);
                }
            }
           // System.out.println(str_command);
          //  System.out.println(alpha.getTransactions());
        }
/*
        //alpha.delClient(jora.uuid);
        alpha.sortClients();
        String los = "Selim";
        String vegas = "el";
        if (los.contains(vegas)) {
            System.out.println(true);
        }
        List<Client> heh = new ArrayList<>();
        boolean lal = heh.contains(jora);
        System.out.println(lal);

        System.out.println("RABOTA");
        Client semen = new Client("Semen", 120);
        Client jury = new Client("jury", 20);
        Transaction first = new Transaction(semen, jury, 20, 0);
        alpha.addClient(semen);
        alpha.addClient(jury);
        alpha.addTransaction(first);
        alpha.runTransaction();
        List<Transaction> kek = alpha.getTransactions();
        System.out.println(kek);

*/
    }
}
