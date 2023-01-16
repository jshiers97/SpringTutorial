package chapter02;

import chapter02.service.SearchEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
//class that provides Spring features useful in testing. makes this class
//"Managed" by Spring. So spring loads the configuration, loads the test itself
// look for a configuration element that can be assigned to SearchEngine, assigns
//that elements reference to the engine attribute, runs the tests
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import static chapter02.model.DocumentType.PDF;
import static org.testng.Assert.*;

@ContextConfiguration(classes={TestConfiguration.class})
public class MyDocumentsSpringTest extends AbstractTestNGSpringContextTests {
    // this will look for a class instance that fulfills the type requirements in the
    //available configuration and injects that reference
    @Autowired
    SearchEngine engine;

    @Test
    public void testFindByType(){
        var documents = engine.findByType(PDF);
        assertNotNull(documents);
        assertEquals(documents.size(), 1);
        assertEquals(PDF.name, documents.get(0).getType().name);
    }

    @Test
    public void testListAll(){
        var documents = engine.listAll();
        assertNotNull(documents);

    }
}
