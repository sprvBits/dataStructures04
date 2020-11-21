/**
  *A class that stores information about babies like the names, the rank of the names, and the number of times each name is used
  */
public class Babies
{
   //creating instance varivale for the name, its rank, and its occurrence number
   private String name;
   private String number;
   private String rank;
   
   /**
   *  The setName method sets the name of the baby.
   *  @param n The baby name.
   */
   public void setName(String n)
   {
      name = n;
   }
   
   /**
   *  The setNumber method sets the umber of time a name has occured.
   *  @param nu The number of times a name has occured.
   */
   public void setNumber(String nu)
   {
      number = nu;
      
   }
   
   /**
   *  The setRank method sets the rank of the given name.
   *  @param r The rank of the given name. 
   */  
   public void setRank(String r)
   {
      rank = r;
   }

   /**
   *  The getName method returns the name of the baby.
   *  @return The baby name.
   */
   public String getName()
   {
      return name;
   }
   
   /**
   *  The getNumber method returns the number of time a name has occured.
   *  @return the number of times each number has occured.
   */
   public String getNumber()
   {
      return number;
   
   }
   
    /**
   *  The getRank method returns the rank of the given name.
   *  @returnThe rank of the given name. 
   */ 
   public String getRank()
   {
      return rank;
   }
  
   /**
   *  The maleString method returns the information about a male baby name.
   *  @param The information about male baby name.
   */  
  public String maleString()
  {
      return "NAME: " + name + " (MALE)  " + "  RANK: " + rank + "  BIRTHS: " + number;
  }
  
  /**
   *  The femaleString method returns the information about a female baby name.
   *  @param The information about female baby name.
   */ 
  public String femaleString()
  {
      return "NAME: " + name + " (FEMALE)  " + "  RANK: " + rank + "  BIRTHS: " + number;
  }
  

}
