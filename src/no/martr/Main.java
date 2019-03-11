package no.martr;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //oppretter filreferanse og tomt tre.
        File file = new File("src/no/martr/sample.txt");
        BinarySearchTree BST = new BinarySearchTree();

        //oppretter scanner med fil som input
        Scanner input = null;
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //bruker delimiter til å splitte opp i enkeltord
        input.useDelimiter("\\W+");

        //hvert ord legges til i treet
        while (input.hasNext()) {
            BST.insert(input.next().toUpperCase());
        }

        //traverserer inorder for å skrive ut alfabetisk
        BST.inorder(BST.root);


    }
}
