import java.util.*;
public class Kruskal
{   /**
     * Class for Kruskal's Algorithm
     */

    /**
     * List of type Edge to hold the edges read from an adjacency matricx
     */
    ArrayList<Edge> edges;
    /**
     * matrix to hold a copy of the given adjacency matrix
     */
    int[][] copy;
    /**
     * The set of vertices corresponding to the adjacency matrix
     */
    Set<Integer> vertices;
    /**
     * List of edges included in the MST of the adjacency matrix's graph
     */
    ArrayList<Edge> mste;
    /**
     * Holds the list of edges in a array data structure
     */
    Edge[] as;
    /**
     * Constructor for objects of class Kruskal that takes in the adjacency matrix and initialized neccessary data structures
     */
    public Kruskal(int[][] adj)
    {
        copy = new int[adj[0].length][adj[0].length];
        for( int i = 0; i< adj[0].length; i++)
        {
            for( int j = 0; j< adj[0].length; j++)
            {
                copy[i][j] = adj[i][j];
            }
        }
        edges = new ArrayList<Edge>();
        mste = new ArrayList<Edge>();
        vertices = new HashSet<Integer>();
        edges = getEdgeListFromAdjMatrix(adj);  
        as = new Edge[edges.size()];
    }

    /**
     * Turns the list of Edges into a array
     */

    public void asArray2()
    {

        for( int i = 0; i < as.length; i++)
        {
            as[i] = new Edge(edges.get(i).getA(), edges.get(i).getB(), edges.get(i).getEdgeWeight());
        }

    }

    /**
     * Sorting the edges in increasing weight and saving the result
     */
    public void sort2()
    {
        as = heapSort(as); 
    }

    /**
     * initializes the Edge[] for Kruskal's algorithm
     */
    public void init()
    {
        asArray2();
        sort2();
    }

    /**
     * implementation of Kruskal's algorithm that provides the MST in the form of a set of Edges
     */

    public int kruskal()
    {
        int[] roots = new int[copy[0].length];
        int cost = 0;
        for(int j = 0; j< copy[0].length; j++)
        {
            roots[j] = j;
        }
        while(vertices.size() != copy[0].length)
        {
            for( int k = 0; k < as.length; k++)
            {
                int first = find(roots, as[k].getA());
                int second = find(roots, as[k].getB());
                if( first != second)
                {
                    vertices.add(as[k].getA());
                    vertices.add(as[k].getB());
                    mste.add(as[k]);    
                    System.out.println("( " + as[k].getA() + ", " + as[k].getB() + " )");
                    cost = cost + copy[as[k].getA()][as[k].getB()];
                }
                if( first < second)
                {
                    roots[second] = first;    
                }
                else
                {
                    roots[first] = second; 
                }

            }
        }
        return cost;

    }

    /**
     * check to see if there adding an Edge e will create a cycle
     */
    public int find( int[] r, int x)
    {
        int i = x;
        while( r[i] != i)
        {
            i = r[i];
        }
        return i;

    }

    /**
     * returns a list of Edges read from the given adjacency matrix
     */
    public ArrayList<Edge> getEdgeListFromAdjMatrix( int[][] a )
    {

        for( int i = 0; i < a[0].length; i++)
        {
            for( int j = 0; j < a[0].length; j++)
            {
                if( a[i][j] != 0 && a[i][j] != -1)
                {
                    edges.add( new Edge( i,j, a[i][j] ));
                    a[i][j] = 0;
                    a[j][i] = 0;
                }
            }
        }
        
        return edges;
    }

    /**
     * helper method for heapSort
     */

    private void heapify(Edge[] arr, int i, int total)
    {
        int left = i*2;
        int right= left+ 1;
        int g = i;
        if (left <= total && arr[left].getEdgeWeight() > arr[g].getEdgeWeight())
        {
            g = left;
        }
        if (right <= total && arr[right].getEdgeWeight() > arr[g].getEdgeWeight()) 
        {
            g = right;
        }
        if (g != i) 
        {
            Edge tmp = arr[i];
            arr[i] = arr[g];
            arr[g] = tmp;
            heapify(arr, g, total);
        }
    }

    /**
     * heapSort
     */
    public Edge[] heapSort(Edge[] arr)
    {
        int total = arr.length - 1;
        for (int i = total / 2; i >= 0; i--)
        {
            heapify(arr, i, total);
        }
        for(int i = total; i > 0; i--) {

            Edge tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            total--;
            heapify(arr, 0, total);
        }
        return arr;
    }
}
