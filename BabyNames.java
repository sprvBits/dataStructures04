import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

/**
 * A class that reads from the file containing the name of the male and female babies and uses map to store the name 
 * of the respective gender to link the name with the rank of the name and the number of time the name has occured. Using map
 * makes it easier to get the information about the name easily by storing the name as the key and the infomation about the name as
 * lock. This class contains the necessary method to display the top names, unisex names, names based on the rank, and information
 * based on a particular name by reading the queries file to display the result requested in the queries file.
*/
public class BabyNames

{ 
   //creating two maps: one for the name of male babies and another for the name of female babies
   Map<String, Babies> maleMap = new HashMap <String, Babies>();
   Map<String, Babies> femaleMap = new HashMap <String, Babies>();
  
   /**
   *  The BabyNames constructor reads the file containing all the names and creates object of the babies for each of male and female names.It then 
   *  puts each of the male and female names and then maps the respective name to the object of the name that includes the name itself, the number
   *  of occurence and the rank, so that there is a mapping of each name to its respective information.
   *  @param filename The file which contains the list of of names with the rank and the number of occurence.
   */
   public BabyNames(String filename) throws FileNotFoundException
   {
      //creating a scanner object to read through the file
      Scanner in = new Scanner(new File(filename));
      
      //reading the file as long as the file has a next line to read
      while (in.hasNextLine())
      {
         //creating objects for male and female babies
         Babies femaleBaby = new Babies();
         Babies maleBaby = new Babies();
           
         //creating a scanner object to read through each line in the file
         Scanner lineReader = new Scanner(in.nextLine());
         
         //reading through the line as long as there is something to read
         while(lineReader.hasNext())
         {
            //reading the rank and setting the rank for each of the baby object
            String rank = lineReader.next();
            femaleBaby.setRank(rank);
            maleBaby.setRank(rank);
           
           //reading the first name and storing it as the name of a male baby
            maleBaby.setName(lineReader.next());
            String maleName = maleBaby.getName();
           
            //reading and storing the number of times the male baby name has been used
            maleBaby.setNumber(lineReader.next());
            String maleNumber = maleBaby.getNumber();
         
            //reading the second name and storing it as the name of a female baby
            femaleBaby.setName(lineReader.next());
            String femaleName = femaleBaby.getName();
           
           //reading and storing the number of times the female baby name has been used
            femaleBaby.setNumber(lineReader.next());
            String femaleNumber = femaleBaby.getNumber();
         
            //mapping the name of male baby with its object and that of female baby with its object
            maleMap.put(maleName, maleBaby);
            femaleMap.put(femaleName, femaleBaby);
         }
      
      }
   }     

   /**
   *  The nameInformation method with takes a name as its argument and then based on the name iterates through the map
   *  to get the respective information of the name.
   *  @param name The name whose information will be displayed by the method.
   *  @return The detailed information about the name including its rank and numbe rof occurrence.
   */
   private String nameInformation(String name)
   {
      String output = "";
      
      //creating a keySet for male and female maps so that we can read through each of them
      Set<String> keySet1 = maleMap.keySet();
      Set<String> keySet2 = femaleMap.keySet();
      
      //if the name in the argument is in the list of male names, then malename is displayed
      if(maleMap.containsKey(name))
      {
         output += maleMap.get(name).maleString();
      }
      
      //if the name in the argument is in the list of fmale names, then malename is displayed
      if(femaleMap.containsKey(name))
      {
         output += femaleMap.get(name).femaleString();
      }
      
      //if the name is in neither of the maps, then NOT FOUND is displayed
      if(!maleMap.containsKey(name) && !femaleMap.containsKey(name))
      {
         output = "NAME: " + name + " NOT FOUND";
      }
       
      //returning the output        
      return output;
   }
      
   /**
   *  The unisexName method reads through both the male and female maps and if there is a common name between them
   *  it displays those names.
   *  @return The names that are common in both the male and female babies.
   */ 
   private String unisexName()
   {  String unisex = "";
      boolean flag = false;
      
      //creating a keySet for male and female maps so that we can read through each of them.
      Set<String> keySet1 = maleMap.keySet();
      Set<String> keySet2 = femaleMap.keySet();
      
      //going through each key of the maleMap i.e. going through each male baby names
      for (String key1 : keySet1)
      {
         String maleName = key1;
         
         //going through each key of the femaleMap i.e. going through each female baby names
         for (String key2 : keySet2)
         {
            String femaleName = key2;
              
            //comapring one male baby name with each of the female baby names and if there is a match, then storing the name as unisex 
            if(maleName.equals(femaleName))
            {
               unisex += femaleName + " ";
               flag = true;
            }
              
         }
      }
       
      //if no common names were found, the unisex value becomes "NONE"  
      if(flag == false)
      {
         unisex = "NONE";
      }
      
      //returning the value of unisex
      return unisex;
   }
     
   /**
   *  The rankInformation method gives the name of both the male and female babies with the number of theor occurence based
   *  on its argument which is the rank of those respective names.
   *  @param rank The rank of the names of male and female babies.
   *  @return The name and number of occurrence of the name for both male and female babies of the given rank.
   */    
   private String rankInformation(String rank)       
   {
      //creating string to store information about the male and female of the given rank
      String femaleOutput = "";
      String maleOutput = "";
      
      //creating the set of keys for the male babies and going through each male objects
      Set<String> keySet1 = maleMap.keySet();
      for(String key: keySet1)          
      {
         //if the key (male name) is mapped to the object with the given rank, then the information associated with that rank is shown
         if(maleMap.get(key).getRank().equals(rank))
         {
            maleOutput = nameInformation(maleMap.get(key).getName());
         }
      }
      
      //creating the set of keys for the male babies and going through each male objects
      Set<String> keySet2 = femaleMap.keySet();
      for(String key: keySet2)
      {
         //if the key (male name) is mapped to the object with the given rank, then the information associated with that rank is shown   
         if(femaleMap.get(key).getRank().equals(rank))
         {
            femaleOutput = nameInformation(femaleMap.get(key).getName());
         }
      }
       
      //returning the value of th output i.e. the female and male information associated with the given rank     
      return maleOutput + "\n" + femaleOutput;
         
   }
     
   /**
   *  The topNames method shows all the male and female babies whose percentage of occurence in their respective categories
   *  is at least the given argument of percent. It displays all the male and female names whose occurence is more than than  
   *  the given percent multiplied by the total number of the male and female babies respectively. It also displays the percentage 
   *  of time each of the given name has occured; this value of percent is more than the given argument.
   *  @param percent The number of percentage of the occurence of male and female babies.
   *  @return The names whose percentage is higher than the given percent and their respective percentage. 
   */    
   public String topNames(String percent)
   {
      double totalMale = 0;
      String maleOutput = "TOP MALE NAMES: ";
      
      //converting the string argument into double
      double percentage = (Double.parseDouble(percent));
      
      //creating the set of keys for the male babies and going through each male objects and calculating the total number of male babies
      Set<String> keySet1 = maleMap.keySet();           
      boolean flagMale = false;
      for(String key: keySet1)
      {
         //converting the number of times of occurence of each name into a double from string 
         double maleNumber = Double.parseDouble(maleMap.get(key).getNumber().replace(",", ""));
         
         //calculating the toal number of male babies
         totalMale += maleNumber;        
      }
      
      //going through each male name to see if the given name has the required percentage of the argument     
      for(String key: keySet1)
      {
         //converting the number of times of occurence of each name into a double from string 
         double maleNumber = Double.parseDouble(maleMap.get(key).getNumber().replace(",", ""));
               
         //if the number of male babies is more than the number given by the percentage of the argument, then storing the name and its percetage in the toal of male babies
         if(maleNumber > (percentage*totalMale/100))
         {
            maleOutput += String.format("%s%.2f%s", maleMap.get(key).getName()+ " (" , (maleNumber/totalMale)*100 , "%)") + "," ;
            flagMale = true;           
         }
      
      }
      
      maleOutput = maleOutput.substring(0, maleOutput.length()-1);
       
      //creating the set of keys for the female babies and going through each female objects and calculating the total number of female babies    
      Set<String> keySet2 = femaleMap.keySet();
      boolean flagFemale = false;
      double totalFemale = 0;
      String femaleOutput = "TOP FEMALE NAMES: ";
      
       //going through each male name to see if the given name has the required percentage of the argument
      for(String key: keySet2)
      {    
         //converting the number of times of occurence of each name into a double from string 
         double femaleNumber = Double.parseDouble(femaleMap.get(key).getNumber().replace(",", ""));
         
         //calculating the toal number of female babies
         totalFemale +=femaleNumber;      
      }
      
      //going through each female name to see if the given name has the required percentage of the argument 
      for(String key: keySet2)
      {    
         double femaleNumber = Double.parseDouble(femaleMap.get(key).getNumber().replace(",", ""));
         
         //if the number of female babies is more than the number given by the percentage of the argument, then storing the name and its percetage in the toal of female babies 
         if(femaleNumber > ((percentage*totalFemale)/100))
         {
            femaleOutput += String.format("%s%.2f%s", femaleMap.get(key).getName()+ " (" , (femaleNumber/totalFemale)*100 , "%)") + "," ;
            flagFemale = true; 
         }
      }
   
      femaleOutput = femaleOutput.substring(0, femaleOutput.length()-1);
      
      //if any of the female name doesn't have as much percent as indicated in the argument "NONE" is displayed
      if(flagFemale == false)
      {
         femaleOutput += "NONE";
      }
            
       //if any of the male name doesn't have as much percent as indicated in the argument "NONE" is displayed
      if(flagMale == false)
      {
         maleOutput += "NONE";
      }
       
      //returning the qualified names with their respective percentage     
      return maleOutput + "\n"  + femaleOutput;
   }
   
    /**
   *  The processQueries method reads through the queries file which is its argument and based on the content(query) of the file
   *  displays the information by calling on the other private methods. If Find is read, then the information about the name is shown,
   *  if RANK is read, then information about the rank is shown, if TOP is shown, the name of higher percentage than the indicated 
   *  percent are shown, and if UNISEX is read in the file, all the unisex names are shown.
   *  @param queryFile which contains the queries based on which the information is displayed.
   *  @return The information based on the query read from the file. 
   */  
   public String processQueries(String queryFile) 
   { 
      try
      {
         //creating the scanner to read through the file
         Scanner in = new Scanner(new File(queryFile)); 
         
         //creating a string output which stores the value of information to be dislayed
         String output = "";
         
         //thr file is read and processed as long as there is another line to read through
         while(in.hasNextLine())
         {
            //creating a scanner object to read through each line
            Scanner line = new Scanner(in.nextLine());
            
            //storing the value of the first word of the the line as method
            String method = line.next();
            
            //if the first word is "FIND", then calling the nameInformation method and using the name that comes after FIND to dislay the information about the name
            if(method.equals("FIND"))
            {
               //the information based on the name is concatenated with the output
               output += nameInformation(line.next()) + "\n";
            }
            
            //if the first word is "RANK", then calling the rankInformation method and using the rank that comes after RANK to dislay the information of the rank
            if(method.equals("RANK"))
            {
               //the information based on the rank is concatenated with the output
               output+= rankInformation(line.next())+ "\n";
            }
             
            //if the first word is "UNISEX", then calling the unisexName method to display all the unisex names  
            if(method.equals("UNISEX"))
            {
               //the information of the unisex names is concatenated with the output
               output += "UNISEX NAMES: " + unisexName() +"\n";
            }
            
            //if the first word is "TOP", then calling the topNames method and using the percent that comes after TOP to dislay the information about the names whose percent is higher than the percent of the query 
            if(method.equals("TOP"))
            {
               //the information of the top names is concatenated with the output
               output += topNames(line.next())+ "\n";
            }
               
               
         }
         
         //returning the output
         return output;
      }
      
      //catching any exception should the file not be there               
      catch(FileNotFoundException e)
      {
         System.out.println("File not found");
         return "NOT FOUND";
      }
   
   }               
          
     
}


