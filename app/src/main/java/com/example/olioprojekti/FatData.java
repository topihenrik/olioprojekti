package com.example.olioprojekti;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FatData {
    File log = new File("log.txt");

    public void method(){
        try{

            if(!log.exists()){
                System.out.println("Made a new file.");
                try {
                    log.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                PrintWriter out = new PrintWriter(new FileWriter(log,true));
                out.append("apina");
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Makes a "log.txt file",
    // if one does not already exist and then writes to the file.
    // it doesn't overwrite the existing log

}
