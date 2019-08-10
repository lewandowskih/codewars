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
        if ( intervalSize * j < elemIndex && elemIndex <= intervalSize * (j+1)){
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
