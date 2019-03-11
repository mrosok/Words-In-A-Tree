package no.martr;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //oppretter filreferanse og tom liste
        File file = new File("src/no/martr/sample.txt");
        ArrayList<String> words = new ArrayList<String>();

        //oppretter scanner med fil som input
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //bruker delimiter til å splitte opp i enkeltord
        input.useDelimiter("\\W+");

        //hvert ord legges til i listen
        while (input.hasNext()) {
            words.add(input.next().toUpperCase());
        }

        //oppretter binært søketre og fyller det med ordene
        BinarySearchTree BST = new BinarySearchTree();
        for (String word: words) {
            BST.insert(word);
        }

        //traverserer inorder for å skrive ut alfabetisk
        BST.inorder(BST.root);


    }
}
