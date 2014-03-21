/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordcount;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Masoud
 */
public class WordCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter file address: ");
        String fileName = reader.nextLine();
        CountUtility util = new CountUtility(fileName);
        util.loadFile();
    }
    
}
