package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {
        List<String> some = Arrays.asList("hello wha u gonna do".split(" "));
        some.forEach(System.out::println);
        Bank alpha = new Bank();
        Client jora = new Client("Jora", 100);
        Client sanya = new Client("Sanya", 100);
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (s.equals("exit")){
            System.exit(1);
        }
        String salam = "salam";
        String[] hel = s.split(" ");
        if (hel[0].equals("print")){
            alpha.sortClients();
        }
        else {
            alpha.sortClients();
        }
        System.out.println(hel[0]);
        System.out.println("Мы считали с клавиатуры эту строку:");
        System.out.println(s);
        //Scanner scan = new Scanner(System.in);


    }
}
