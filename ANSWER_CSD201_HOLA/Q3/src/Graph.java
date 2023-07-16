/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------
public class Graph {
  int [][] a; int n;
  char v[];
  int deg[];
  Graph() {
    v = "ABCDEFGHIJKLMNOP".toCharArray();
    deg = new int[20];
    a = new int[20][20];
    n = 0;
   }

  void loadData(int k) {  //do not edit this function
    RandomAccessFile f;int i,j,x;
    String s;StringTokenizer t;
    a = new int[20][20];
    try {
     f = new RandomAccessFile("data.txt","r");
     for(i=0;i<k;i++) f.readLine();
     s = f.readLine();s = s.trim();
     n = Integer.parseInt(s);
     for(i=0;i<n;i++) {
       s = f.readLine();s = s.trim();
       t = new StringTokenizer(s);
       for(j=0;j<n;j++) { 
         x = Integer.parseInt(t.nextToken().trim());
         a[i][j] = x;
        }
       }
     f.close();
     }
    catch(Exception e) {}

   }

  void dispAdj() {
    int i,j;
    for(i=0;i<n;i++) {
      System.out.println();
      for(j=0;j<n;j++)
        System.out.printf("%4d",a[i][j]);
     }
   }

  void fvisit(int i, RandomAccessFile f) throws Exception {
    f.writeBytes("  "+v[i]);
   }

 void fdispAdj(RandomAccessFile f) throws Exception { 
    int i,j;
    f.writeBytes("n = "+n+"\r\n");
    for(i=0;i<n;i++) {
      f.writeBytes("\r\n");
      for(j=0;j<n;j++)  f.writeBytes("  " + a[i][j]);
     }
    f.writeBytes("\r\n");
   }

  void breadth(boolean [] en, int i, RandomAccessFile f) throws Exception {
    Queue q = new Queue();
    int r,j;
    q.enqueue(i); en[i]=true;
    while(!q.isEmpty()) {
      r = q.dequeue();
      fvisit(r,f);
      for(j=0;j<n;j++) {
        if(!en[j] && a[r][j]>0) {
         q.enqueue(j);en[j]=true;
        }
       }
     }
   }

  void breadth(int  k, RandomAccessFile f) throws Exception {
    boolean [] en = new boolean[20];
    int i;
    for(i=0;i<n;i++) en[i]=false;
    breadth(en,k,f);
    for(i=0;i<n;i++) 
      if(!en[i]) breadth(en,i,f);
   }

 void depth(boolean [] visited,int k, RandomAccessFile f) throws Exception {
    fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++) {
      if(!visited[i] && a[k][i]>0) depth(visited,i,f);
     }
   }
  void depth(int k, RandomAccessFile f) throws Exception {
    boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth(visited,i,f);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void f1() throws Exception {
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    breadth(4,f);
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

      breadthf1(4, f);
    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }
  
  int countf1 = 0;
  void breadthf1(boolean [] en, int i, RandomAccessFile f) throws Exception {
    Queue q = new Queue();
    int r,j;
    q.enqueue(i); en[i]=true;
    while(!q.isEmpty()) {
      r = q.dequeue();
      countf1++;
      if(countf1 >= 2 && countf1 <= 7) {
            fvisit(r,f);
      }
      for(j=0;j<n;j++) {
        if(!en[j] && a[r][j]>0) {
         q.enqueue(j);en[j]=true;
        }
       }
     }
   }

  void breadthf1(int  k, RandomAccessFile f) throws Exception {
    boolean [] en = new boolean[20];
    int i;
    for(i=0;i<n;i++) en[i]=false;
    breadthf1(en,k,f);
    for(i=0;i<n;i++) 
      if(!en[i]) breadthf1(en,i,f);
   }

//=================================================================================================
  void f2() throws Exception {
    loadData(12);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f2.txt 
      //  and statement f.writeBytes(" " + k); to write  variable k to the file f2.txt  
      dijkstraf2line1(0, 6, f);
      dijkstraf2line2(0, 6, f);
      Dijstraline3(2, 5, f);
    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }

    void dijkstraf2line1(int fro, int to, RandomAccessFile f) throws Exception {
        int INF = 999; 
        boolean[] S = new boolean[n]; 
        int[] d = new int[n]; 
        int[] p = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        ArrayList<Integer> ss = new ArrayList<>(); 
        S[fro] = true;
        ss.add(fro);
        
        int k, t;
        while (true) {
            k = -1;
            t = INF;
            for (int i = 0; i < n; i++) {
                if (S[i] == true) continue;
                if (d[i] < t) {
                    k = i;
                    t = d[i];
                }
            }
            if (k == -1) return;            
            S[k] = true; 
            ss.add(k);
            if (k == to) break;
            for (int i = 0; i < n; i++) {
                if (S[i] == true) continue;
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        Stack s = new Stack(); 
        int x = to;
        while (true) {
            s.push(x);
            if (x == fro) break;
            x = p[x]; 
        }
        
        ArrayList<Integer> pp = new ArrayList<>();  
        while (!s.isEmpty()) { 
            x = s.pop();
            pp.add(x);
        }

        for (int i = ss.size()-4; i < ss.size(); i++) 
         f.writeBytes(v[ss.get(i)]+" ");
        f.writeBytes("\r\n");
    }
         
    void dijkstraf2line2(int fro, int to, RandomAccessFile f) throws Exception {
        int INF = 999; 
        boolean[] S = new boolean[n]; 
        int[] d = new int[n]; 
        int[] p = new int[n]; 
        
        for (int i = 0; i < n; i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        ArrayList<Integer> ss = new ArrayList<>(); 
        S[fro] = true;
        ss.add(fro);
        
        int k, t;
        while (true) {
            k = -1;
            t = INF;
            for (int i = 0; i < n; i++) {
                if (S[i] == true) continue;
                if (d[i] < t) {
                    k = i;
                    t = d[i];
                }
            }
            if (k == -1) return;            
            S[k] = true; 
            ss.add(k);
            if (k == to) break;
            for (int i = 0; i < n; i++) {
                if (S[i] == true) continue;
                if (d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        Stack s = new Stack(); 
        int x = to;
        while (true) {
            s.push(x);
            if (x == fro) break;
            x = p[x]; 
        }
        
        ArrayList<Integer> pp = new ArrayList<>();  
        while (!s.isEmpty()) { 
            x = s.pop();
            pp.add(x);
        }

        for (int i = ss.size()-4; i < ss.size(); i++) 
            f.writeBytes(d[ss.get(i)]+" ");
            f.writeBytes("\r\n");
    }
    
    void Dijstraline3(int from, int to, RandomAccessFile f) throws Exception {
        int dis[] = new int[n];
        boolean selected[] = new boolean[n];
        int path[] = new int[n];
        for (int i = 0; i < n; i++) {
            selected[i] = false;
            dis[i] = a[from][i];
            path[i] = from;
        }
        selected[from] = true;
        int sel = from;
        for (int k = 1; k < n; k++) {
            int min = 99;
            for (int i = 0; i < n; i++) {
                if (!selected[i] && dis[i] < min) {
                    min = dis[i];
                    sel = i;
                }
            }
            selected[sel] = true;
            for (int i = 0; i < n; i++) {
                if (!selected[i] && dis[i] > dis[sel] + a[sel][i]) {
                    dis[i] = dis[sel] + a[sel][i];
                    path[i] = sel;
                }
            }
        }
        int j = path[to];
        String s = v[to]+"";
        while (j != from){
            s = v[j]+" "+s;
            j = path[j];
        }
         s = v[from]+" "+s;
        f.writeBytes(s);
        f.writeBytes("\n");

    }
 
}
