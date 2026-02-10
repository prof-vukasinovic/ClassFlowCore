package com.eidd;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.io.FileWriter;
import java.util.Scanner;

public class RemarqueToolKit{
    private static String DataFile = "src/main/resources/dataRemarques.txt";
    private static int remarqueIdCounter = initCounter();
    

    private static int initCounter() {
        File f = new File(DataFile);
        if (!f.exists()) return 0;
        int count = 0;
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
        } catch (FileNotFoundException e) {
            return 0;
        }
        return count;
    }

    private static int readData(String intitule) {
        try{
            Scanner scanner = new Scanner(new java.io.File(DataFile));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split("=");
                if(parts.length == 2 && parts[0].equals(intitule)){
                    scanner.close();
                    return Integer.parseInt(parts[1]);
                }
            }
            scanner.close();
            return -1;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return -1;
        }
    }
    private static int writeData(String intitule, int id) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DataFile, true))) {
            writer.println(intitule + "=" + id);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
    }

    public static int getNewRemarqueId(String intitule) throws IOException {
        int id=readData(simplifier(intitule));
        if(id==-2){
            throw new IOException("Le fichier data n'a pas pu etre lu");
        }
        if(id==-1){
            if(writeData(simplifier(intitule),remarqueIdCounter)==-2){
                throw new IOException("Le fichier data n'a pas pu etre lu");
            }
            return remarqueIdCounter++;
        }
        return id;
    }

    private static String simplifier(String texte) {
        String temp = Normalizer.normalize(texte, Normalizer.Form.NFD);
        temp = temp.replaceAll("\\p{M}", "");
        temp = temp.toLowerCase();
        temp = temp.replaceAll("[^a-z0-9]", "");
        return temp;
    }
    public static void reinitCounter() {
        remarqueIdCounter = initCounter();
    }
    public static void changeDataFile(String newDataFile) {
        DataFile = newDataFile;
        reinitCounter();
    }
}
