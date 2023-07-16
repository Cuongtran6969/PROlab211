/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {
   Node root;
   BSTree() {root=null;}
   boolean isEmpty() {
       return(root==null);
      }
   void clear() {
       root=null;
      }
   void visit(Node p) {
      System.out.print("p.info: ");
      if(p != null) System.out.println(p.info + " ");
     }
   void fvisit(Node p, RandomAccessFile f) throws Exception {
      if(p != null) f.writeBytes(p.info + " ");
     }
   void breadth(Node p, RandomAccessFile f) throws Exception {
     if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty()) {
        r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void preOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }

   void loadData(int k) { //do not edit this function
      String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xSea, int xSail, int xPaddle) {
    //You should insert here statements to complete this function
    if(xSea.charAt(0) == 'B') return;
    Boat newCar = new Boat(xSea, xSail, xPaddle);
    Node newNode = new Node(newCar);
    if (isEmpty()) {
            root = newNode;
        } else {
            Node p = root;
            Node par = null;
            while (p != null) {
                par = p;
                if (newNode.info.sail > p.info.sail) {
                    p = p.right;
                } else if (newNode.info.sail < p.info.sail){
                    p = p.left;
                } else {
                   return;
                }
            }
            if (newNode.info.sail < par.info.sail) {
                par.left = newNode;
            } else {
                par.right = newNode;
            }
        }

   }

//Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    inOrder(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  
//=============================================================
 void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/

     breadth2(root, f);

    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }  
   void breadth2(Node p, RandomAccessFile f) throws Exception {
     if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty()) {
        r = q.dequeue();
        if(r.info.paddle > 5) {
         fvisit(r,f);
        }
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
//=============================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
      inOrder3(root, f);

    //------------------------------------------------------------------------------------
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
   int numberofchirdent(Node p){
        if (p.left==null && p.right==null) return 0;
        else if (p.left!=null && p.right==null) return -1;
        else if (p.left==null && p.right!=null) return 1;
        else return 2;
    }
   int counf3 = 0;
   void inOrder3(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      inOrder3(p.left,f);
      if(numberofchirdent(p) == 2 || numberofchirdent(p)  == -1) {
          counf3++;
          if(counf3 == 2) {
              deleteByCopy(p.left);
          }
      }
      inOrder3(p.right,f);
     }
   
   void deleteByCopy(Node x){
        if (isEmpty()) return;
        Node p = root,
             par = null,
             rightmost = root;
        while (p!=null && p!=x){   
            par = p;
            if (p.info.sail > x.info.sail) p = p.left;
            else p = p.right;            
        }
        if (p==null) return;
        
        if (numberofchirdent(p) == 0) {
            if (par == null) {
                 root = null;
                 return;
             }
             if (par.left == p) {
                 par.left = null;
             } else {
                 par.right = null;
             }
             return;
        }
        if (numberofchirdent(p)==1) {
            if (par == null) {
                 root = p.right;
                 return;
             } 
            if (par.left == p){
              par.left=p.right;
            } else {
              par.right=p.right;
            }
            return;
        }
        if (numberofchirdent(p)==-1) {
             if (par == null) {
                 root = p.left;
                 return;
             } 
               if(par.left == p) {
                 par.left = p.left;
               } else {
                 par.right = p.left;
               }
              return;
         }else {
            rightmost = p.left;
            Node parRightmost = p;
            while (rightmost.right != null) {
                parRightmost = rightmost;
                rightmost = rightmost.right;
            }
            p.info.sea = rightmost.info.sea;
            p.info.sail = rightmost.info.sail;
            p.info.paddle = rightmost.info.paddle;
            if (parRightmost.left == rightmost) {
                parRightmost.left = rightmost.left;
            } else {
                parRightmost.right = rightmost.left;
            }
            return;
        }
    }
//=============================================================
 void f4() throws Exception {
    clear();
    loadData(13);;
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(root,f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
 

     inOrderf4(root, f);
    //------------------------------------------------------------------------------------
    breadth(root,f);
    f.writeBytes("\r\n");
    f.close();
   }  
  int countf4 = 0;
   void inOrderf4(Node p, RandomAccessFile f) throws Exception {
      if(p==null) return;
      inOrderf4(p.left,f);
       if (numberofchirdent(p) == 2 || numberofchirdent(p) == -1) {
           countf4++;
           if (countf4 == 2) {
               R_rotate(p.info.sail);
           }
       }
      inOrderf4(p.right,f);
     }
   
   
       void R_rotate(int x) {
        Node i = root, par = i;
        while (i != null && i.info.sail != x) {
            par = i;
            if (i.info.sail > x) {
                i = i.left;
            } else {
                i = i.right;
            }
        }
        if (i == null) {
            return;
        }
        if (i == root) {
            root = R_rotate(i);
        } else {
            if (par.left == i) {
                par.left = R_rotate(i);
            } else {
                par.right = R_rotate(i);
            }
        }
    }

    Node R_rotate(Node p) {
        if (p.left == null) {
            return p;
        }
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return q;
    }
 }
