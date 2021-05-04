import java.util.*;
import java.text.*;
public class kanpsack_ada{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      Random r = new Random();
      System.out.print("Enter the number of items :");
      int item = sc.nextInt();
      double val[][] = new double[item][2];
      int j=0;
      double xi[]= new double[item];
      double xi_new[] = new double [item];
      for(int i=0; i<item; i++){
        // System.out.print("\nEnter the value of item "+(i+1)+" :");
         val[i][0] = r.nextInt(1000-100)+100;
        // System.out.print("\nEnter the weight of item "+(i+1)+" :");
         val[i][1] = r.nextInt(100-10)+10;
         xi[i] = val[i][0]/val[i][1];  //xi=bi/wi
      }
      
      System.out.print("VALUE(bi)   WEIGHT(wi)   bi/wi");
      for(int i=0; i<item;i++){
         System.out.printf("\n"+val[i][0]+ "       "+ val[j][1]+"          "+"%.2f",xi[i]);
         
         if(j<1)
            j++;
         else
            j=2;   
      }
      for(int i =0; i<item;i++){
         xi_new[i] = xi[i];
      }
      
      System.out.print("\nEnter the weight of sack(W) :");
      double W = sc.nextDouble();
      
      sort_sack(val,W,xi,xi_new);
   }
   
   public static void sort_sack(double[][] arr, double W, double[] xi,double[] xi_new){
         sort(xi);
         double total_weight = W;
         double store=0;
         int n =xi.length;
         int[] countnew = new int[n];
         double[] ones = new double[n];
       
         for(int j=0;j<n;j++){
            countnew[j]= find_index(xi_new,xi[n-(j+1)]);
         }   
         for(int i = 0; i<n; i++){
            int j = countnew[i];
            if(arr[j][1]<=W){
               store=store+arr[j][1];
               W=W-arr[j][1];
               ones[j] =1;
            }
            else{
               double rem = store;
               double diff = total_weight-rem;
               store = rem+store;
               double amt = diff/arr[j][1];
               ones[j] = amt;
               break;
            }

            
         }
         System.out.println("\nVALUE(bi)   WEIGHT(wi)   bi/wi     xi      PROFIT");
         double profit=0;
         DecimalFormat df = new DecimalFormat("##0.00");
         
         for(int i =0; i<n;i++){
            int highest_index = countnew[i];
            double bi_wi = Math.round(xi_new[highest_index]*100)/100.0;
            double xii =Math.round(ones[highest_index]*100)/100.0;
            double p = xii*arr[highest_index][0];
            p=Math.round(p*100.0)/100.0;
            profit = Math.round((profit+p)*100.0)/100.0;
            if(bi_wi>=10){
               System.out.printf("\n"+arr[highest_index][0]+ "       "+ arr[highest_index][1]+"         "+df.format(bi_wi)+"    "+df.format(xii)+"      "+p);
            }
            if(bi_wi<10){
               System.out.printf("\n"+arr[highest_index][0]+ "       "+ arr[highest_index][1]+"         "+df.format(bi_wi)+"     "+df.format(xii)+"      "+p);
            }      
            
         }
            System.out.print("\n                                            "+profit);
            System.out.print("\nTHE MAXIMUM PROFIT="+profit);

                          
         
         
         
   }
   
   public static int find_index(double[] xi_new,double highest){
      int n =xi_new.length;
      int count=0;
      int[] final_count = new int[n];
         for(int i=0; i<n;i++){
            if (highest==xi_new[i]){
               break;
            }
            else
               count=count+1;
            

         }   
         
         return count;
   }
   
   public static void sort(double xi[]) { 
        int n = xi.length; 
        for (int i = 1; i < n; ++i) { 
            double key = xi[i]; 
            int j = i - 1; 
            while (j >= 0 && xi[j] > key) { 
                xi[j + 1] = xi[j]; 
                j = j - 1; 
            } 
            xi[j + 1] = key; 
        } 

    } 
}