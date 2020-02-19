// Iqtedar Alizai TY2 Assignment 1

package topstreamingartist;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class TopStreamingArtist {

    public static void main(String[] args) {

        try {
            // We created the file to open the excel sheet
            File file = new File("regional-global-weekly-2020-01-17--2020-01-24.csv");
            // Reads the file input 
            Scanner reader = new Scanner(file);
            reader.nextLine(); // reading the next line 
            reader.nextLine(); // reading the next line
            // The array list is going to hold the artist object 
            ArrayList<Artist> lst = new ArrayList<>(); 
            while(reader.hasNext()) {
                
                // stores the next line of the file 
                String line = reader.nextLine();
                String[] track = line.split(",");  // splits by comma 
                Artist artist = new Artist(track[2]); // creates a new artist object 
                boolean found = false; 
                Artist foundArtist = null; 
                
                // we are using a enhanced for loop which makes it go through our list
                for(Artist a : lst) {
                    System.out.println(a);
                    if(a.getName().equals(track[2].replace("\"", ""))) // gets rid of quotation marks in the csv
                    {
                        found = true;
                        foundArtist = a;
                        break;
                    }
                }
                if(found) {
                    foundArtist.increment();   // The if else statements makes it where it increments the artist instead of repeating it 
                } else {
                    lst.add(artist);
                }
                // divider 
                System.out.println("--------------------------------------------------------");
                System.out.println("Sorting Artist");
                System.out.println("--------------------------------------------------------");
                
                // constructs a list containing Strings 
                LinkedList<String> linkedlist = new LinkedList<>();
                
                // we use another enhance loop to add the artists name to the link list
                for(Artist a : lst) {
                    String name = a.getName();
                    linkedlist.add(name);
                }
                
                // sorts the artists in the linked list 
                Collections.sort(linkedlist);
                
                for(String s : linkedlist) {
                    System.out.println(s);
                }    
             
            }
            reader.close(); // closes scanner file 
            
        } catch (IOException e) {  // catches any IO exceptions 
            e.printStackTrace();  
        }

    }

}

class Artist {

    private String name;
    private int numOfTracks;

    public Artist(String name) {

        this.name = name.replace("\"", "");
        this.numOfTracks = 1;
    }
        
    //Getter methods
    public String getName() {
        return name;
    }

    public int getNumOfTracks() {
        return numOfTracks;
    }

    public void increment() {
        numOfTracks++;
    }

    public String toString() {
        return name + " " + numOfTracks;
    }

}
       
 }
    
}
