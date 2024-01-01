/*
Telangana Government has passed a new G.O to Telangana police for safety of 
Telangana people. 
In this regard he announced new Vehicles to be released for all the stations 
working for this mission especially.
Here we have a 2D mesh, there are P police officers and V vehicles, with P<=V.
Each police officer and vehicle is a 2D coordinate on this mesh.
Here the government has assigned a unique vehicle to each police officer.

Now create a method which prints the minimum possible sum of distances between 
each police officer and their assigned vehicle.

Here the distance is between police officer Pi and vehicle Vi assigned to him.
And distance between Pi, Vi is calculated as follows: 
|Pi.x - Vi.x| + |Pi.y - Vi.y|


Input Format:
-------------
Line-1: Two integers P and V, number of police officers and vehicles.
Next P lines: Two space separated integers co-ordinates of Police officers.
Next V lines: Two space separated integers co-ordinates of Vehicles.

Output Format:
--------------
Print an integer, the minimum possible sum of distances.


Sample Input-1:
---------------
3 3
0 1		// co-ordinates of police
1 2
1 3
4 5		// co-ordinates of vehicles
2 5
3 6

Sample Output-1:
----------------
17


Sample Input-2:
---------------
2 2
0 0		// co-ordinates of police
2 1
1 2		// co-ordinates of vehicles
3 3

Sample Output-2:
----------------
6

*/

import java.util.*;

class CampusBikes 
{
	int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] officers, int[][] bikes) 
	{
        backtrack(new boolean[bikes.length], 0, officers, bikes, 0);
        return min;
    }
    
    void backtrack(boolean[] visited, int i, int[][] officers, int[][] bikes, int distance)
	{
        if(i==officers.length){
            min = Math.min(min,distance);
            return;
        }
        // int officer[] = officers[i];
        for(int j=0;j<bikes.length;j++){
            if(! visited[j]){
                visited[j] = true;
                int dist = calcdist(i,j,officers,bikes);
                backtrack(visited,i+1,officers,bikes,distance+dist);
                visited[j] = false;
                
            }
        }
        
    }
    
    int calcdist(int i, int j, int[][] officers, int[][] bikes)
	{
		return Math.abs(officers[i][0]-bikes[j][0])+Math.abs(officers[i][1]-bikes[j][1]);
    }	
	
	public static void main(String[] args) 
	{ 
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int bikes[][]=new int[n][2];
		int men[][]=new int[m][2];
		for(int i=0;i<m;i++){
			men[i][0]=sc.nextInt();
			men[i][1]=sc.nextInt();
		}
		for(int i=0;i<n;i++){
			bikes[i][0]=sc.nextInt();
			bikes[i][1]=sc.nextInt();
		}
		System.out.println(new CampusBikes().assignBikes(men,bikes)); 
        sc.close();
	}
}