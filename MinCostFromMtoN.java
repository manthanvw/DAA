/*
Given a cost matrix cost[][] and a position (M, N) in cost[][], 
write a function that returns cost of minimum cost path to reach (M, N) from (0, 0). 
Each cell of the matrix represents a cost to traverse through that cell. 
The total cost of a path to reach (M, N) is the sum of all the costs on that path 
(including both source and destination). You can only traverse down, 
right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), 
cells (i+1, j), (i, j+1), and (i+1, j+1) can be traversed. 

Note: You may assume that all costs are positive integers.
input format : two integers no.of rows and columns say r and c
               enter r*c number of positive integers r*c
			   enter destination cell values
output format : an integer
Example 1:
input =3
3
1 2 3
4 8 2
1 5 3
2 1
output= 10

Example 2
input=3
3
1 2 3
4 8 2
1 5 3
2 2
output=8

Example 3
input=3
3
1 2 3
4 8 2
1 5 3
1 1
output=9

*/