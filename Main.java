import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class asgmt2 {

@SuppressWarnings("resource")
public static void main(String[] args) throws IOException{
	
		Scanner scanner = new Scanner(System.in); //scanner
		
		System.out.print("Please input the file name you would like to create a BST for: ");
		String fileName = scanner.nextLine(); //file to be opened
		
		File in = new File (fileName); //checking if file exists
		if(!in.exists()) { //if not found
			System.out.println();
			System.out.println("File not found, terminating. . .");
			System.exit(0); // terminating
		}
		
		System.out.println();
	    System.out.println("Processing. . .");
	    System.out.println();
	    byte[] fileC = Files.readAllBytes(Paths.get(fileName)); //reading all bytes from the file "fileName" and storing them into a byte array - Paths.get() (path of file) 
	    String data = new String (fileC); //bytes -> String
	    String[] input = data.replaceAll("[\\W&&[^']]" , " ").replaceAll("'","").toLowerCase().split("\\s+");
	    
	    BinarySearchTree tree = new BinarySearchTree();
	   
	    for(int a=0; input.length>a; a++) { //going through
			  tree.insert(input[a]);}

		System.out.println("-----------------------------------------------"); //displaying info gathered by methods in BST class
	    System.out.println("> Total number of words in "+ fileName + " = " + tree.numberOfWords(tree.root));
	    System.out.println("> Total number of unique words in " + fileName + " = " + tree.UniqueWords(tree.root));
	    System.out.println("> The word(s) which occur(s) most often and the number of times that it/they occur(s):");
	    System.out.println("-----------------------------------------------");
	    tree.printR(tree.root, tree.highestF(tree.root));
	    System.out.println("-----------------------------------------------");
	    
	    while(true) {
	    	
	    	System.out.print("\n\n> Enter the word you are looking for in " + fileName + " or 'T' to choose a traversal method or 'E' to exit: ");
		    String find = scanner.next();
	   
		    if(find.equals("T") || find.equals("t")) {//go to traversal in next loop
		    	break;
		    }
		    else if(find.equals("E") || find.equals("e")) {// exit
		    	System.out.println("\nProgram terminating. . .");
		    	System.exit(0);
		    }
		    else {
		    	tree.searchN(find, tree.root); //search
		    }
	   }
	    
	    while(true) {
	    	System.out.println("\n\n-----------------------------------------------");
	    	System.out.print("> Enter the BST traversal method (1=IN-ORDER, 2=PRE-ORDER, 3=POST-ORDER, 4=EXIT) for "+ fileName+ ": ");
	    	int traversalO = scanner.nextInt();
	    	
	    	while(traversalO<1 || traversalO>4) { //makes sure in range
	    		System.out.println("Invalid entry! Enter the BST traversal method (1=IN-ORDER, 2=PRE-ORDER, 3=POST-ORDER, 4=EXIT) for "+ fileName +":");
	    		traversalO = scanner.nextInt();
	    	}
	    	
	    	if(traversalO==1) { //in
	    		System.out.print("IN-ORDER output: ");
	    		tree.inOrder(tree.root);
	    	}
	    	if(traversalO==2) {//pre
	    		System.out.print("PRE-ORDER output: ");
	    		tree.preOrder(tree.root);
	    	}
	    	if(traversalO==3) {//post
	    		System.out.print("POST-ORDER output: ");
	    		tree.postOrder(tree.root);
	    	}
	    	if(traversalO==4) {//exit
	    		System.out.println("\nProgram terminating. . .");
		    	System.exit(0);
	    	}
	    	
	    }
	    
		}
	}
	

	
