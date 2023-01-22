package chapter03;

import chapter03.service.*;
import org.testng.annotations.Test;

//There are no tests in this class, so we need to tell TestNG to include the class in its lists of tests.
@Test
public class MyDocsJavaTest implements MyDocsBaseTest{
     SearchEngine engine= new StaticSearchEngine(true);

     @Override
    public SearchEngine getEngine(){
         return engine;
     }


}
