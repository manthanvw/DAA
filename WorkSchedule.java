
    /*You are working in a factory, your task is schedule the works.
You will be given set of works each having Id,deadline and profit earned by 
completing that work.
And you will be given number of slots available. 
Schedule the works by which you will get maximum profit, and the work can not 
execute beyond its deadline.
Remember that only a single task will be executed at a time, and each work can 
occupy one slot only.

Input format: an integer n
              n number of rows, each row has three space seperated integer 
              values (id, deadline and profit)
			  an integer T (no.of units of time) 
output format:list of integers (as per allotted slots)
              An integer (Total profit earned)
Example 1:
10
1 9 15
2 2 2
3 5 18
4 7 1
5 4 25
6 2 20
7 5 8
8 7 10
9 4 12
10 3 5
15
output = [7, 6, 9, 5, 3, 4, 8, 1]
109
Explanation :
If we choose tasks 1, 3, 4, 5, 6, 7, 8, and 9, 
we can achieve a maximum profit of 109. 
Note that task 2 and task 10 are left out.

Tasks	Deadlines	Profit (Maximum first)
5		4			25
6		2			20
3		5			18
1		9			15
9		4			12
8		7			10
7		5			8
10		3			5
2		2			2
4		7			1

Example 2:
input = 10
1 9 15
2 2 2
3 5 18
4 7 1
5 4 25
6 2 20
7 5 8
8 7 10
9 4 12
10 3 5
5
output =[9, 6, 1, 5, 3]
90

*/
import java.util.*;
// Data structure to store job details. Each job has an identifier,
// a deadline, and profit associated with it.
class Job
{
	public int taskId, deadline, profit;
	public Job(int taskId, int deadline, int profit)
	{
		this.taskId = taskId;
		this.deadline = deadline;
		this.profit = profit;
	}
	public String toString(){
	    return "["+this.taskId+","+this.deadline+","+this.profit+"]";
	}
}
public class WorkSchedule
{
	public static void scheduleJobs(List<Job> jobs, int T)
	{
		//Write Your Code here
		int slots=-1;
		int netProfit=0;
		for(Job i:jobs) slots = Math.max(i.deadline-1,slots);
		int n = Math.min(slots,T);
		int ans[] = new int[n];
		Collections.sort(jobs,(a,b)->{
		    return b.profit-a.profit;
		});
		for(Job i : jobs){
			int dl = i.deadline;
			while(dl>n) dl--;
			if(ans[dl-1]==0){
				ans[dl-1] = i.taskId;
				netProfit+=i.profit;
			}
			else{
				for(int j=dl-1;j>-1;j--){
					if(ans[j]==0){
						ans[j] = i.taskId;
						netProfit+=i.profit;
						break;
					}
				}
			}
		}
		System.out.println(Arrays.toString(ans));
		System.out.println(netProfit);
		
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Job> jobs = new ArrayList<>();
		for(int i=0;i<n;i++)
			jobs.add(new Job(sc.nextInt(),sc.nextInt(),sc.nextInt()));
		final int T = sc.nextInt();
		scheduleJobs(jobs, T);
		sc.close();
	}
}
