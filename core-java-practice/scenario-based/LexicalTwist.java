package scnerio_based;

import java.util.*;

public class LexicalTwist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String w1 = sc.nextLine().trim();

        System.out.println("Enter the second word");
        String w2 = sc.nextLine().trim();

       
        if (w1.contains(" ")) {
            System.out.println(w1 + " is an invalid word");
            return;
        }
        if (w2.contains(" ")) {
            System.out.println(w2 + " is an invalid word");
            return;
        }

        //Check reverse condition 
        String rev = new StringBuilder(w1).reverse().toString();

        if (rev.equalsIgnoreCase(w2)) {
            String transformed = rev.toLowerCase();

            transformed = transformed.replace('a', '@');
            transformed = transformed.replace('e', '@');
            transformed = transformed.replace('i', '@');
            transformed = transformed.replace('o', '@');
            transformed = transformed.replace('u', '@');
            
            System.out.println(transformed);
        } else {
            String combined = (w1 + w2).toUpperCase();

            int vowels = 0, consonants = 0;
            char [] arr = combined.toCharArray();
            for (char c : arr) {
                if (Character.isLetter(c)) {
                    if(c=='A'|| c=='E' || c=='I' || c=='O' || c=='U') vowels++;
                    else consonants++;
                }
            }
            
            if (vowels > consonants) {
                String result = "";
                boolean check = false;
                for (char c : arr) {
                    if (c=='A'|| c=='E' || c=='I' || c=='O' || c=='U') {
                    	check=false;
                        for(int i=0;i<result.length();i++) {
                        	if(c==result.indexOf(i))check = true;
                        }
                        if(!check)result+=c;
                        if (result.length() == 2) break;
                    }
                }
                System.out.println(result);
            } else if (consonants > vowels) {
            
            	String result = "";
                boolean check = false;
                for (char c : arr) {
                    if (c!='A'&& c!='E' && c!='I' && c!='O' && c!='U') {
                    	check=false;
                        for(int i=0;i<result.length();i++) {
                        	if(c==result.indexOf(i))check = true;
                        }
                        if(!check)result+=c;
                        if (result.length() == 2) break;
                    }
                }
                System.out.println(result);
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }
    }
}
