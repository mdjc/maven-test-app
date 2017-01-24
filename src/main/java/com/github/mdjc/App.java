package com.github.mdjc;
import org.slf4j.*;
import java.io.*;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	Properties p = null;
    public static void main( String[] args ) throws Exception
    {
      
	   logger.info("hello maven!");
	  
	   App myApp = new App();
	   myApp.loadResources();
	   
	   logger.info("Retriving property application.name " + myApp.p.getProperty("application.name"));
	   logger.info("Retriving user define property message " + myApp.p.getProperty("myapp.message"));
	   logger.info("Retriving user define property other " + myApp.p.getProperty("myapp.other"));
	   
	   Runnable test = () -> System.out.println("My lambda task");
	  
    }
	
	
	private void loadResources() throws Exception {	   
	   try ( InputStream is = this.getClass().getResourceAsStream("/application.properties");) {
			if (is == null) logger.info("is null");
			p = new Properties(); 
			p.load(is); 
	   }
	}
	
}
