
import java.util.*;
public class Prim2
{

    Pair[] near; //the Near array
    List<Integer> v; // the intialized empty set of vertices
    List<Edge> e; // the intialized empty set of edges
    int[][] am; // the adjacency matrix filled with weights of the edges
    public int cost = 0; // holds the cost for each MST
    /**
     * constructor that takes in the set of vertices and the adjacency matrix
     * initializes the neccessary data structures
     */
    public Prim2( ArrayList<Integer> v, int[][] a)
    {
        near = new Pair[v.size()];
        this.v = v;
        e = new ArrayList<Edge>();
        am = a;
    }

    /**
     * Prim's algorithm
     */

    public int prim2()
    {

        near[0] = new Pair(v.get(0), 0); 

        for( int j = 1; j < v.size(); j++)
        {
            near[j] = new Pair(v.get(0), am[0][j]);
        }

        int min = getMin2(near);
        e.add( new Edge(v.get(0), min));
        //System.out.println("( " + v.get(0) + ", " + min + " )");
        cost  = cost + near[min].getWeight();

        for( int i = 0; i< v.size()-2; i++)
        {
            repopulateNear( min, near);
            min = getMin2(near);
            e.add( new Edge(min, near[min].getVertex()));
            cost  = cost + near[min].getWeight();
            //System.out.println( "( " + min + ", " + near[min].getVertex() + " )" );
        }
        return cost;

    }

    /**
     * in a given array, returns the index of the least weighted Edge
     */
    public int getMin2( Pair[] p)
    {
        int[] ans = new int[p.length];
        for( int i = 0; i< ans.length; i++)
        {
            ans[i] = p[i].getWeight();    
        }
        Arrays.sort(ans);
        int min = 0;
        int j = 0;
        while( min <= 0 && j < v.size() )
        {
            min = ans[j];
            j++;
        }
        for( int k = 0; k< p.length; k++)
        {
            if( p[k].getWeight() == min )
            {
                return k;
            }
        }
        return -1;
    }

    /**
     * updates the Near array
     */
    public void repopulateNear( int m, Pair[] n)
    {
        n[m] = new Pair(0, 0);
        for( int i = 0; i < n.length; i++)
        {
            if( n[i].getWeight() != 0)
            {
                if ( am[m][i] < n[i].getWeight()  && am[m][i] != -1)
                {
                    n[i] = new Pair( m, am[m][i]); 
                }
                if( n[i].getWeight() == -1 )
                {
                    n[i] = new Pair( m, am[m][i]);   
                }
            }
        }
    }
}
