/*
Write an efficient algorithm to check if two binary trees are identical or not. Two binary trees are identical if they have identical structure and their contents are also the same.
input format : integer number n( number of nodes)
               n number of integers
			   integer number m(number of nodes)
			   m number of integers
output format : boolean value true or false
sample case 1:
input =7
2 1 1 -1 3 -1 3
7
2 1 1 -1 3 -1 3
output=True
sample case 2:
input:7
2 1 1 -1 3 -1 3
7
2 1 1 -1 3 3 -1
output=False

*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Node {
    int key;
    Node left = null, right = null;
    Node(int key) {
        this.key = key;
    }
}
 class IdenticalTrees {
     
     // Recursive function to check if two given binary trees are identical or not
    public static boolean isIdentical(Node x, Node y) 
    {
        //Write Code Here
        if(x==y) return true;
        if((x!=null && y!=null) && (x.key ==y.key)){
                return isIdentical(x.left,y.left) && isIdentical(x.right,y.right);
        }
        return false;
    }
     
    // Function to construct a binary tree from an integer array using BFS
    public static Node constructTreeFromArray(int[] arr) 
    {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(arr[0]);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();
            int leftValue = arr[i++];
            if (leftValue != -1) {
                current.left = new Node(leftValue);
                queue.add(current.left);
            }
            if (i < arr.length) {
                int rightValue = arr[i++];
                if (rightValue != -1) {
                    current.right = new Node(rightValue);
                    queue.add(current.right);
                }
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size1 = scanner.nextInt();
        int[] arr1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            arr1[i] = scanner.nextInt();
        }
        Node x = constructTreeFromArray(arr1);
        int size2 = scanner.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = scanner.nextInt();
        }
        Node y = constructTreeFromArray(arr2);
        scanner.close();
        if (isIdentical(x, y)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

