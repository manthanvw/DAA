/*
Now a days, everyone is used to type the words in short-forms,
A short-form can be created by replacing non-intersected substrings 
and non-adjacent substrings with their respective lengths.

e.g., elite can be written as follows:
    - e3e (by replacing lit with 3), 
    - el2e (by replacing it with 2), 
	- 1l1t1 (by replacing e,i,e, with 1,1,1)
    - 3t1 (by replacing eli and e with 3 and 1), etc.
	and can't be written as follows:
	- 22e (by replacing el and it with 2 and 2)
	- 32 (by replacing eli and te with  3 and 2)

You will be given a word.
Your task is to find all possible short-forms of the given word, 
and print them as a list of lexicographic order.


Input Format:
-------------
A string W, the word.

Output Format:
--------------
Print the list of possible short-forms of W in lexographic order. 


Sample Input-1:
---------------
kmit

Sample Output-1:
----------------
[1m1t, 1m2, 1mi1, 1mit, 2i1, 2it, 3t, 4, k1i1, k1it, k2t, k3, km1t, km2, kmi1, kmit]


Sample Input-2:
---------------
cse

Sample Output-2:
----------------
[1s1, 1se, 2e, 3, c1e, c2, cs1, cse]

*/

import java.util.*;
class GenerateAbbreviations 
{
	public List<String> makeShortcutWords(String word)
	{   
        List<String> ans = new ArrayList<>();
        int n = word.length();
        StringBuilder sb = new StringBuilder();
        backtrack(ans,sb,word,0,n);
        Collections.sort(ans);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k)
	{
        String x = builder.toString();
        int n = x.length();
        if(i == k && !ans.contains(x)) ans.add(x);
        else if(i < k){
            char c = word.charAt(i);
            if(i == 0){
                builder.append("1");
                backtrack(ans, builder, word, i + 1, k);
                builder.delete(0, 1);
            }
            else if(i > 0){
                char nc = x.charAt(n - 1);
                if(nc - '1' <= 8){
                    int y = Integer.parseInt("" + nc) + 1;
                    builder.delete(n - 1, n);
                    builder.append("" + y);
                    backtrack(ans, builder, word, i + 1, k);
                    builder.delete(n - 1, n);
                    builder.append(nc);
                }
                else{
                    builder.append("1");
                    backtrack(ans, builder, word, i + 1, k);
                    builder.delete(n, n + 1);
                }
            }
            builder.append(c);
            backtrack(ans, builder, word, i + 1, k);
            builder.delete(n, n + 1);
        }
    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		System.out.println(new GenerateAbbreviations().makeShortcutWords(s));
        sc.close();
	}
}