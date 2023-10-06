package com.techelevator.util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class TELog {
    public static void log(String message) {
        try(PrintWriter writer = new PrintWriter(new FileWriter("logs/search.log", true))){
            writer.println(message);
        }
        catch (IOException e){
            throw new TELogException("Error writing to file: " + e.getMessage());
        }
    }
}
