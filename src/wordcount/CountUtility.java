/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wordcount;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Masoud
 */
public class CountUtility {
    private String fileName;
    private Set<Schema> schemaList = new HashSet<Schema>();
    private List<String> wordList = new ArrayList<String>();
    List<Schema> schemaListCopy = new ArrayList<Schema>();
    Map<String,Integer> wordMap = new HashMap<String,Integer>();
    private String[] split;
    
    public CountUtility(String fileName){
        this.fileName = fileName;
    }
    
    public void loadFile() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = br.readLine())!=null){
            split = line.split("\\s+");
            for (String i:split){
                wordList.add(i);
            }
        }

        System.out.println("List size: "+wordList.size());
        insertSchema(wordList);
    }
    
    public void insertSchema(List<String> list){
        for (String word:list){
            int count =0;
            for (String w:list){
                if (word.equals(w)){
                    count+=1;
                }
            }
            wordMap.put(word, count);
        }

        Iterator mapIt = wordMap.entrySet().iterator();
        while(mapIt.hasNext()){
            Map.Entry pairs = (Map.Entry)mapIt.next();
            System.out.println(pairs.getKey()+" = "+pairs.getValue());
            Schema schema = new Schema();
            schema.setCount((Integer)pairs.getValue());
            schema.setWord((String)pairs.getKey());
            schemaListCopy.add(schema);
            
            mapIt.remove();
        }
        Collections.sort(schemaListCopy,Collections.reverseOrder());
        for (Schema entity:schemaListCopy){
            System.out.println("*********Word is: "+entity.getWord());
            System.out.println("*********Count is: "+entity.getCount());
        }
        
        
    }
}
