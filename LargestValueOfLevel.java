/*
For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
The bulbs are of different voltages, and preparation of tree as follows:
	- The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
	  so on.
	- At level-0: There will be only one bulb as root bulb.,
	- From next level onwards, we can attach atmost two bulbs to left side,
	  and right side of every bulb in previous level.
	- The empty attachements in each level are indicated with -1. 
	(for example: look in hint)

You will be given the root of the X-Mas Tree,
Your task is to findout the bulb with highest voltage in each level.

Implement the class Solution:
1.public List<Integer> maxInEachRow(BinaryTreeNode root): returns the list of integers.

Input Format:
-------------
A single line of space separated integers, voltages of the set of bulbs.

Output Format:
--------------
Print the list of voltages.

Sample Input-1:
---------------
2 4 3 6 4 -1 9

Sample Output-1:
----------------
[2, 4, 9]

Sample Input-2:
---------------
3 4 7 7 3 8 4 

Sample Output-2:
----------------
[3, 4, 8]

*/

import java.util.*;

class BinaryTreeNode
{
	public int data; 
	public BinaryTreeNode left, right; 
	public BinaryTreeNode(int data)
	{
		this.data = data; 
		left = null; 
		right = null; 
	}
}

class Solution 
{
    public List<Integer> largestValues(BinaryTreeNode root) 
	{
        List<Integer> arr = new ArrayList<>();
	    if(root==null) return arr;
        // arr.add(root.data);
        helper(root,arr,0);
        return arr;
    }

    private void helper(BinaryTreeNode root, List<Integer> res, int level)
	{
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while(! q.isEmpty()){
            int val = q.size();
            int max = Integer.MIN_VALUE;
            for (int i=0; i<val;i++){
                BinaryTreeNode node = q.poll();
                if(node == null) continue;
                max = Math.max(max,node.data);
                q.offer(node.left);
                q.offer(node.right);
            } 
            if(max!= Integer.MIN_VALUE) res.add(max);
        }
    }
}

public class LargestValueOfLevel
{
	static BinaryTreeNode root;
	void insert(BinaryTreeNode temp, int key)
    { 
        if (temp == null) {
            temp = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
 
        // Do level order traversal until we find an empty place.
        while (!q.isEmpty()) 
		{
            temp = q.remove();

            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		LargestValueOfLevel ln=new LargestValueOfLevel();
		Solution sol= new Solution();
		
		String str[]=sc.nextLine().split(" ");
		root=new BinaryTreeNode(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			ln.insert(root,Integer.parseInt(str[i]));

		System.out.println(sol.largestValues(root));
        sc.close();
	}
}
