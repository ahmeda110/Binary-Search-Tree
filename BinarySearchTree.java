/*
 * this class creates a BST. It also includes many functions/methods
 * which provide many different type of information regarding the tree
 */
public class BinarySearchTree {

  public void inOrder(Node n) { //Prints tree in-order (bonus)

    if (n == null)
      return;

    inOrder(n.leftChild);
    System.out.print(n.word + " ");
    inOrder(n.rightChild); //recursive
  }

  public void preOrder(Node n) { //Prints the tree pre-order (bonus)

    if (n == null)
      return;

    System.out.print(n.word + " ");
    preOrder(n.leftChild);
    preOrder(n.rightChild); //recursive
  }

  public void postOrder(Node n) { //Prints the tree post-order (bonus)

    if (n == null)
      return;

    postOrder(n.leftChild);
    postOrder(n.rightChild); //recursive
    System.out.print(n.word + " ");
  }

  public void insert(String w) { // this method inserts the words provided to tree

    Node current = root, prev = null;

    if (root != null) {
      do {
        prev = current;

        if (w.compareTo(current.word) == 0) {
          current.frequency++;
          break;
        } else if (w.compareTo(current.word) > 0) {
          current = current.rightChild;
          if (current == null) {
            prev.rightChild = new Node(w);
            break;
          }
        } else if (w.compareTo(current.word) < 0) {
          current = current.leftChild;

          if (current == null) {
            prev.leftChild = new Node(w);
            break;
          }
        }
      } while (true);
    } else {
      root = new Node(w);
    }
  }

  public int numberOfWords(Node root) { //recursive method which returns the total number of words in the BST

    int ctr = 1;

    if (root.rightChild != null) {
      ctr += numberOfWords(root.rightChild);
    }

    if (root.leftChild != null) {
      ctr += numberOfWords(root.leftChild);
    }

    return ctr;
  }

  public int UniqueWords(Node n) { //recursive method which returns the number of unique words in the BST

    int ctr = 0;

    if (n.frequency == 1)
      ctr++;

    if (n.rightChild != null) {
      ctr += UniqueWords(n.rightChild);
    }

    if (n.leftChild != null) {
      ctr += UniqueWords(n.leftChild);
    }

    return ctr;
  }

  public int highestF(Node n) { // this method finds the highest frequency in the BST

    if (n == null) {
      return 0;
    } else {
      int leftF = highestF(n.leftChild), rightF = highestF(n.rightChild), largest = n.frequency;

      if (largest < rightF) {
        largest = rightF;
      }
      if (largest < leftF) {
        largest = leftF;
      }

      return largest;
    }
  }

  void printR(Node n, int f) { //recursive method that prints the nodes with its corresponding frequency

    if (n.frequency == f) {
      System.out.println(n.word + " = " + n.frequency + " times");
    }
    if (n.rightChild != null) {
      printR(n.rightChild, f);
    }
    if (n.leftChild != null) {
      printR(n.leftChild, f);
    }
  }

  public void searchN(String s, Node n) { //recursive method which performs a binary search

    if (n == null) {
      System.out.print("\nWord not found!");
      return;
    }

    if (s.compareTo(n.word) == 0 || n == null) {
      if (s.compareTo(n.word) == 0 && n != null) {
        System.out.print("\nFound! '" + s + "' appears " + n.frequency + " times in this file.");
      }
    } else if (s.compareTo(n.word) > 0) {
      searchN(s, n.rightChild);
    } else {
      searchN(s, n.leftChild);
    }
  }

  class Node { // Node implementation for this BST

    public Node leftChild; //left points to left node
    public Node rightChild; //right points to right node
    public String word; //holds String type word
    public int frequency; //holds frequency of the word

    public Node(String w) { //Node constructor
      leftChild = null;
      rightChild = null;
      word = w;
      frequency = 1;
    }
  }

  Node root; //Root points to root node in the BST
}
