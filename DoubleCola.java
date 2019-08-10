/*
Description:

Sheldon, Leonard, Penny, Rajesh and Howard are in the queue for a "Double Cola" drink vending machine; there are no other people in the queue. The first one in the queue (Sheldon) buys a can, drinks it and doubles! The resulting two Sheldons go to the end of the queue. Then the next in the queue (Leonard) buys a can, drinks it and gets to the end of the queue as two Leonards, and so on.

For example, Penny drinks the third can of cola and the queue will look like this:

Rajesh, Howard, Sheldon, Sheldon, Leonard, Leonard, Penny, Penny

Write a program that will return the name of the person who will drink the n-th cola.
Input

The input data consist of an array which contains at least 1 name, and single integer n which may go as high as the biggest number your language of choice supports (if there's such limit, of course).
Output / Examples

Return the single line — the name of the person who drinks the n-th can of cola. The cans are numbered starting from 1.

string[] names = new string[] { "Sheldon", "Leonard", "Penny", "Rajesh", "Howard" };
Line.WhoIsNext(names, 1) == "Sheldon"
Line.WhoIsNext(names, 52) == "Penny"
Line.WhoIsNext(names, 7230702951) == "Leonard"

Algorithms
Mathematics
Numbers
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Line {
   public static String WhoIsNext(String[] names, int n) {
     int size = names.length;
     int sum = 0;
     int component = size;
     while (sum < n){
       sum += component;
       component *= 2;
      }
      component /= 2;
      sum -= component;
      int elemIndex = n - sum;
    
      int j = 0;
      int intervalSize = component/size;
      while(j < size){
        if (intervalSize * j < elemIndex && elemIndex <= intervalSize * (j+1)){
          return names[j];
        }
        j++;
    }
    
    return "";//unreachable
   }
   
   
   /* //correct, but inefficient
        List<String> queue = new ArrayList(Arrays.asList(names));
        for(int i = 0; i < n; i++){
          String currentPerson = queue.remove(0);
          if (i + 1 == n) return currentPerson;
          queue.add(currentPerson);
          queue.add(currentPerson);
        }
        return ""; // this should not be reachable
      }
   */
}
