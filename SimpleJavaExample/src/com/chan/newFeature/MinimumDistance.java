package com.chan.newFeature;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDistance {

public static void main(String[] args) {
int distance  = checkDistance();
System.out.println(distance);
}

private static int checkDistance() {
int m =3;
int n =3;
int matrix[][] = {{1,0,0},{1,0,0},{1,9,1}};
Boolean visitedMat[][] = new Boolean[m][n];
for(int i=0;i<matrix.length;i++){
for(int j=0; j<matrix[i].length;j++){
if(matrix[i][j] == 0){
visitedMat[i][j]=true;
}
else{
visitedMat[i][j]=false;
}
}
}
Queue<Distance> disQueue = new LinkedList<>();
Distance s = new Distance(0, 0, 0);
visitedMat[0][0] =true;
disQueue.add(s);
while(!disQueue.isEmpty()){
Distance cell = disQueue.poll();
int i = cell.row;
int j = cell.col;
int dist = cell.dist;
if(matrix[i][j] == 9){
return dist;
}
// for left cell
if(j-1 >= 0 && visitedMat[i][j-1]==false){
disQueue.add(new Distance(i, j-1, dist+1));
visitedMat[i][j-1]=true;
}
//for right cell
if(j+1 < n && visitedMat[i][j+1]==false){
disQueue.add(new Distance(i, j+1, dist+1));
visitedMat[i][j+1]=true;
}
//for up cell
if(i- 1 >= 0 && visitedMat[i- 1][j]==false){
disQueue.add(new Distance(i-1, j, dist+1));
visitedMat[i- 1][j]=true;
}
//for down cell
if(i+1 < m && visitedMat[i+1][j]==false){
disQueue.add(new Distance(i+1, j, dist+1));
visitedMat[i+ 1][j]=true;
}
}

for(int i=0;i<matrix.length;i++){
for(int j=0; j<matrix[i].length;j++){
System.out.println(visitedMat[i][j]);
}	
}
return -1;
}
}

class Distance{
int row;
int col;
int dist;
public Distance(int row, int col, int dist) {
super();
this.row = row;
this.col = col;
this.dist = dist;
}

}
