
public class Pair
{
   /**
    * Class to link the vertex and weight together, used in Prims
    */
   /**
    * Holds the weight
    */
   public int weight;
   /**
    * Holds the vertex
    */
   public int vertex;

    /**
     * Constructor for objects of class Pair
     */
    public Pair(int v, int w)
    {
        weight = w;
        vertex = v;
    }
    /**
     * returns the weight
     */
    public int getWeight()
    {
        return weight;
    }
    /**
     * returns the vertex
     */
    
    public int getVertex()
    {
       return vertex;
    }
}
