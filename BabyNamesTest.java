import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;
import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
public class BabyNamesTest
/**
   Program to test the basic functionality of the BabyNames class.
*/
{
   public static void main(String [] args) throws FileNotFoundException
	{
      BabyNames popular = new BabyNames("aa.txt");
      String results = popular.processQueries("queries.txt");
      System.out.println(results);
	}
}