import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


/**
 *Application to implement Tree-Insert and verify Theorem 12.4. 
 *
 *Program 1 
 *@author Erika Yardumian 
 *@version 5/31/19
 */

public class CollectData {
      // Creates the node class.
   static class Node {
      int key;
      Node left, right, p;
      
      // constructor
      Node(int key) {
         this.key = key;
         left = null;
         right = null;
         p = null;
      }
   }
   static Node root;

   /**
    *Inserts nodes into tree.
    *@param z is TreeInsert.
    *@param key is TreeInsert.
    */
   static void TreeInsert(Node z, int key) {
      
      Node y = null;
      Node x = root;
      while (x != null) {
         y = x;
         if (key < x.key) {
            x = x.left;
         }
         else {
            x = x.right;
         }
      }
      z.p = y;
      if (y == null) {
         root = z;
      }
      else if (key < y.key) {
         y.left = z;    //Tree was empty
      }
      else {
         y.right = z;
      }
   }
   
   /** Driver program that calls insert function. 
     * @param args is main.
     * @throws FileNotFoundException.
     */
   public static void main(String[] args) throws FileNotFoundException {
      File F = new File("Times1.txt");
      PrintWriter printWriter = new PrintWriter(F);
      printWriter.println("HEIGHT" + ", " + "n");
   
      for (int n = 250; n <= 10000; n += 250) {
         double sum_height = 0;
         double average = 0;
      
         for (int j = 1; j <= 10; j++) {
               
            for (int i = 1; i <= n; i++) {
               double P = Math.floor(Math.random() * n) + 1;
               int p = (int) P;
               Node z = new Node(p);
               z.key = p;
               TreeInsert(z, p);
            }
            double h = (Math.log(n) / Math.log(2.0));
            root = null;      //discard tree here
            sum_height += h;            
            average = sum_height / 10;
         }
         printWriter.println(average + ", " + n);
         System.out.println(average + ", " + n);  
      }
      printWriter.close();
   }
}
