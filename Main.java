import java.util.*;
public class Main {
    /**
     * Class used to get experimental results. 
     */
    public static void main(String[] args) 
    {
        int vertices = 1000;
        int[][]  arr = populateAdj(vertices, 1);

        long done2 = 0;
        int d2 = 0;
        ArrayList<Integer> v = populateVertices(vertices);

        for( int i = 0; i< 1000; i++)
        {
            int[][] copy = copyMatrix(arr);
            ArrayList<Integer> vv = copyVertices(v);
            Prim2 p = new Prim2(vv,copy);
            long initTime2 = System.currentTimeMillis();
            d2 = p.prim2();

            long finalTime2 = System.currentTimeMillis();
            done2 += (finalTime2 - initTime2);
        }
        System.out.println("Prim:");
        System.out.println("The total time is: " + done2);
        System.out.println("The cost is: " + d2);

        long done = 0;
        int d = 0;

        for( int i = 0; i< 1000; i++)
        {
            int[][] copy2 = copyMatrix(arr);
            Kruskal k = new Kruskal(copy2);
            k.init();
            long initTime = System.currentTimeMillis();
            d = k.kruskal();  

            long finalTime = System.currentTimeMillis();
            done += (finalTime - initTime);
        }
        System.out.println("Kruskal:");
        System.out.println("The total time is: " + done);
        System.out.println("The cost is: " + d);
        System.out.println("---------------------------------------");


    }


    public static void test()
    {
        int[][] a  = new int[6][6];
        a[0][0] = 0;
        a[0][1] = 10;
        a[0][2] = -1;
        a[0][3] = 30;
        a[0][4] = 45;
        a[0][5] = -1;

        a[1][0] = 10;
        a[1][1] = 0;
        a[1][2] = 50;
        a[1][3] = -1;
        a[1][4] = 40;
        a[1][5] = 25;

        a[2][0] = -1;
        a[2][1] = 50;
        a[2][2] = 0;
        a[2][3] = -1;
        a[2][4] = 35;
        a[2][5] = 15;

        a[3][0] = 30;
        a[3][1] = -1;
        a[3][2] = -1;
        a[3][3] = 0;
        a[3][4] = -1;
        a[3][5] = 20;

        a[4][0] = 45;
        a[4][1] = 40;
        a[4][2] = 35;
        a[4][3] = -1;
        a[4][4] = 0;
        a[4][5] = 55;

        a[5][0] = -1;
        a[5][1] = 25;
        a[5][2] = 15;
        a[5][3] = 20;
        a[5][4] = 55;
        a[5][5] = 0;

        Kruskal k = new Kruskal(a);
        System.out.println("-----------------");
        k.init();
        k.kruskal();  

    }

    public static int[][] populateAdj(int v, double percent)
    {
        int[][] a = new int[v][v];

        double totalEdge = (int) ((v)*(v-1)*(.5));
        double density = (int)((percent)*(totalEdge));
        

        int value  = 1;
        int counter = 0;
        Random rand = new Random();
        for( int ii = 0; ii < a[0].length; ii++)
        {
            for( int jj = 0; jj < a[0].length; jj++)
            {
                if( ii != jj)
                {
                    a[ii][jj] = -1;
                }
                else
                {
                    a[ii][jj] = 0;
                }
            }
        }
        int x;
        int y;
        while( counter != density)
        {
            x = rand.nextInt(v);
            y = rand.nextInt(v);
            while( x == y)
            {
                x = rand.nextInt(v);
                y = rand.nextInt(v);
            }
            if( a[x][y] != 0 && a[x][y] == -1)
            {
                a[x][y] = value;
                a[y][x] = value;
                value++;
                counter++;
            }
        }
        return a;
    }

    public static int[][] copyMatrix( int[][] a)
    {
        int[][] re =  new int[a[0].length][a[0].length];
        for( int i = 0; i < a[0].length; i++)
        {
            for( int j = 0; j < a[0].length; j++)
            {
                re[i][j] = a[i][j];
            }
        } 
        return re;
    }

    public static ArrayList<Integer> copyVertices( ArrayList<Integer> a)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for( int i = 0; i< a.size(); i++)
        {
            arr.add(a.get(i));
        }
        return arr;
    }

    public static ArrayList<Integer> populateVertices(int v)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for( int i = 0; i< v; i++)
        {
            arr.add(i);
        }
        return arr;
    }
}