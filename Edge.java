/**
 * 
 */
public class Edge
{
    /**
     * a and b hold signify the edge
     */
    private int a;
    private int b;
    /**
     * holds the edge weight
     */
    private int edgeWeight;

    /**
     * Constructor for objects of class Edge
     */
    public Edge(int x, int y, int w)
    {
        a = x;
        b = y;
        edgeWeight = w;
    }

    /**
     * Second constructor
     */
    public Edge(int x, int y)
    {
        a = x;
        b = y;

    }

    /**
     * returns a vertex
     */
    public int getA() 
    { 
        return a;  
    }

    /**
     * returns a vertex
     */

    public int getB() 
    { 
        return b;  
    }

    /**
     * returns weight of edge
     */
    public int getEdgeWeight()
    {
        return edgeWeight;
    }

    /**
     * set a vertex to s
     */
    public void setA(int s)
    { 
        a = s; 
    }

    /**
     * set a vertex to s
     */
    public void setB(int s) 
    { 
        b = s; 
    }

    /**
     * set a edgeWeight to n
     */
    public void setEdgeWeight(int n)
    {
        edgeWeight = n;
    }

    /**
     * checks if the two edges are equal
     */

    public boolean equals(Object obj)
    {
        Edge o = (Edge) obj;
        return o.getA() == this.getA() && o.getB() == this.getB(); 
    }

}