package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Delete {
    public static void main(String[] args) throws IOException {
       // List<String> delete = new ArrayList<>("asdsad", "asdd");
        BufferedReader file_reader3 = new BufferedReader(new FileReader("client.txt"));
        String file_str = file_reader3.readLine();
        Stream<String> lines = file_reader3.lines();
        lines.collect(Collectors.toList());
        lines.forEach(s -> System.out.println(s));
        String s = "asdasd + " + "\n" + " asdd LLLLllla" + "\n" + " asdDDDDDDDlla" + "\n" + " aSSSSSlla";
        List<String> all_cl = new ArrayList<String>(Arrays.asList(s.split("\n")));
        System.out.println(all_cl.get(3));
/*
        List<String> myList = new ArrayList<String>(Arrays.asList(s.split(" ")));
        myList.remove(0);
       //System.out.println( myList.get(0));
        //delete.remove(0);
        HashMap<UUID, Client> mda = new HashMap<UUID, Client>();
        Client stas = new Client("stas", 230);
        mda.put(stas.uuid, stas);
        System.out.println(mda);
        FileWriter writer = new FileWriter("notes3.txt", false);
        writer.write("Salam");
        writer.write("\n");
        writer.write("Salam");
        writer.flush();
       // FileReader reader = new FileReader("notes3.txt");
       // String sam = String.valueOf(reader.read());
        BufferedReader reader = new BufferedReader(new FileReader("notes3.txt"));
        String salam = reader.readLine();
        System.out.println(salam);
        int[] sam = {1,2,3};
        System.out.println(sam[1]);

        //System.out.println(delete.get(0));

 */
    }
}
