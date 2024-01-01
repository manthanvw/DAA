/*

Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all unique words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]

Sample Input-3:
---------------
[xyz]a[b,c]
0a1

Sample Output-3:
----------------
[xyzab, xyzac]
*/
import java.util.*;
public class BraceExpression 
{
    static int ind = 0;
	public static  String[] expand(String expr) 
	{
		// write your code here
		ArrayList<ArrayList<String>> arr = new ArrayList<>();
		for (int i=0; i<expr.length(); i++){
		    String res = "";
		    if(expr.charAt(i)=='['){
		        i++;
		        while(expr.charAt(i)!=']'){
		            res+=expr.charAt(i)+"";
		            i++;
		        }
		        String s[] = res.split(",");
		      //  System.out.println(Arrays.toString(s));
		        ArrayList<String> a = new ArrayList<>(Arrays.asList(s));
		        arr.add(a);
		    }
		    else{
		        while(i<expr.length() && expr.charAt(i) != '['){
		            res+=expr.charAt(i)+"";
		            i++;
		        }
		        i--;
		        String s[] = res.split(",");
		        arr.add(new ArrayList<>(Arrays.asList(s)));
		    }
		    res="";
		}
// 		System.out.print(arr.toString());
		int arraySize = 1;
		for (ArrayList<String> i: arr){
		    if(i.size()>1){
		        arraySize*=i.size();
		    }
		} 
        // System.out.print(arraySize);
		String[] s = new String[arraySize];
		helper(arr,s,"",0);
		Arrays.sort(s);
		return s;
    }
    public static void helper(ArrayList<ArrayList<String>> arr, String ans[],String res ,int index){
        if(index>=arr.size()){
            ans[ind] = res;
            ind++;
        }
        else if(arr.get(index).size()>1){
            for(String str:arr.get(index)){
                helper(arr,ans,res+str,index+1);
            }
        }
        else{
            res+=arr.get(index).get(0);
            helper(arr,ans,res,index+1);
            
        }
    }
	public static void main(String args[] ) 
	{
		Scanner sc = new Scanner(System.in);
		String str=sc.next();
		System.out.println(Arrays.deepToString(expand(str)));
        sc.close();
	}	
}
    


