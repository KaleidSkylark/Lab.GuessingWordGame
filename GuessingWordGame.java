import java.nio.file.*;
import java.io.*;
import java.util.*;


public class GuessingGame {
        static String filename = "F:\\words.txt";
        static Path path = Paths.get (filename.toString ());
    public static void main (String[] args) {
        String[] tArray = new String[100];
        String nArray[];
        Random rnd = new Random () ;
        Scanner s = new Scanner (System.in);
        int counter = 0;
        String hideword;
        String displayword;
        
        try{
            InputStream input = Files.newInputStream (path);
            BufferedReader reader = new BufferedReader (new InputStreamReader (input));

            String word = null;

            while ( (word=reader.readLine ()) != null) {
                tArray[counter] = word;
                ++counter;
            }

            nArray = new String[counter];
            nArray = tArray;

            hideword = nArray[rnd.nextInt (counter)];
            displayword = hideword;

            for (int x=0;x<hideword.length () ; x++) {
                displayword = displayword.replace (displayword.charAt (rnd.nextInt (displayword.length ())),'?');
            }
            boolean isTrue=true;
            boolean found = false;
            do {
                System.out.print ("Welcome to Guessing Game 2");
                System.out.println ("\n" + displayword.toUpperCase() + "\n");
                System.out.print ("Enter word or letter : ");
                String guess = s.nextLine ();
                if (guess.length () > 1) {
                   if (guess.equalsIgnoreCase (hideword) ) {
                        System.out.println ("Congrats! You got it!");
                        System.exit (0);
                    }else{
                        System.out.println ("Nice try! Bleeh!");
                    }
                }else{
                    found = false;
                    for (int x=0;x<hideword.length () ; x++) {
                        if (guess.equalsIgnoreCase (String.valueOf(hideword.charAt (x)))) {
                            displayword = displayword.substring (0, x) + guess + displayword.substring (x+1);
                            found =true;
                        }
                    }
                }
                if(found==true) {
                    System.out.println (guess.toUpperCase () + "\nLetter is found!");
                }else {
                    System.out.println (guess.toUpperCase () +"\nWrong letter!");
                }
            } while (isTrue);

            }
            catch (IOException ex){ 
                System.out.println ("Error reading file!");   

            }
}
}
