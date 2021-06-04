// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.lang.*;
import java.util.*;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        int count=0;
        List<Integer> listOFEmployees=null;
        while(count<=days){
            //System.out.println("Its very Difficult");
            listOFEmployees = new ArrayList<Integer>();
            listOFEmployees.add(0);
            for(int i=1;i<=states.length-2;i++){
                if(states[i-1]==states[i+1]){
                    listOFEmployees.add(0);
                }else{
                    listOFEmployees.add(1);
                }
            }
            listOFEmployees.add(0);
            if(count!=days){
                states = listOFEmployees.stream().mapToInt(i -> i).toArray();
                //states=listOFEmployees.stream().MatoIntoArray();
            }
            count++;
            // WRITE YOUR CODE HERE
        }
        return listOFEmployees;
    }
    // METHOD SIGNATURE ENDS
   /* public static void main(String[] args) {

    }*/

}