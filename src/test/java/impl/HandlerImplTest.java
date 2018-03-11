/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import static impl.BasicSalaryCalculatorTest.array;
import static impl.BasicSalaryCalculatorTest.hand;
import interfaces.Actor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Og180
 */
public class HandlerImplTest {
    
    public static ArrayList<Actor> array = null;
    public static HandlerImpl hand = null;
    public static PrintWriter writer = null;
    public static BufferedReader br = null;
            
    
    public HandlerImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        hand = new HandlerImpl();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("actors", "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BasicSalaryCalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(BasicSalaryCalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("actors"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HandlerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Actor> a = new ArrayList<>();
        a.add(new ActorImpl("Tom Hanks", 61));
        a.add(new ActorImpl("Leonardo DiCaprio", 43));
        a.add(new ActorImpl("Tom Cruise", 55));
        a.add(new ActorImpl("Kevin Spacey", 58));
        a.add(new ActorImpl("Johnny Depp", 54));
        a.add(new ActorImpl("Brad Pitt", 54));
        hand.writeToFile(a, writer);
        array = hand.readFromFile(br);
        System.out.println(array.toString());
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getOldestAge method, of class HandlerImpl.
     */
    @Test
    public void testGetOldestAge() {
        System.out.println("getOldestAge");
        int expResult = 61;
        int result = hand.getOldestAge(array);
        assertEquals(expResult, result);
    }

    /**
     * Test of getLongestName method, of class HandlerImpl.
     */
    @Test
    public void testGetLongestName() {
        System.out.println("getLongestName");
        String expResult = "Leonardo DiCaprio";
        String result = hand.getLongestName(array);
        assertEquals(expResult, result);
    }

    /**
     * Test of sortByAge method, of class HandlerImpl.
     */
    @Test
    public void testSortByAge() {
        System.out.println("sortByAge");
        String expResult = "Tom Hanks";
        ArrayList<Actor> result = hand.sortByAge(array);
        assertEquals(expResult, result.get(0).getName());
    }

    /**
     * Test of sortByName method, of class HandlerImpl.
     */
    @Test
    public void testSortByName() {
        System.out.println("sortByName");
        String expResult = "Leonardo DiCaprio";
        ArrayList<Actor> result = hand.sortByName(array);
        assertEquals(expResult, result.get(0).getName());
    }

    /**
     * Test of readFromFile method, of class HandlerImpl.
     */
    @Test
    public void testReadFromFile() {
        System.out.println("readFromFile");
        ArrayList<Actor> result = hand.readFromFile(br);
        assertEquals("Tom Hanks", result.get(0).getName());
    }

    /**
     * Test of writeToFile method, of class HandlerImpl.
     */
    @Test
    public void testWriteToFile() {
        System.out.println("writeToFile");
        hand.writeToFile(array, writer);
        ArrayList<Actor> result = hand.readFromFile(br);
        assertEquals(array.get(0).getName(),result.get(0).getName());
    }

    /**
     * Test of isOlder method, of class HandlerImpl.
     */
    @Test
    public void testIsOlder() {
        System.out.println("isOlder");
        Actor first = array.get(0);
        Actor second = array.get(1);
        boolean expResult = true;
        boolean result = hand.isOlder(first, second);
        assertEquals(expResult, result);
    }

    /**
     * Test of hasLongerName method, of class HandlerImpl.
     */
    @Test
    public void testHasLongerName() {
        System.out.println("hasLongerName");
        Actor first = array.get(0);
        Actor second = array.get(1);
        boolean expResult = false;
        boolean result = hand.hasLongerName(first, second);
        assertEquals(expResult, result);
    }

    /**
     * Test of getActorsByFirstChar method, of class HandlerImpl.
     */
    @Test
    public void testGetActorsByFirstChar() {
        System.out.println("getActorsByFirstChar");
        char c = 'L';
        HandlerImpl instance = new HandlerImpl();
        String expResult = "Leonardo DiCaprio";
        ArrayList<Actor> result = instance.getActorsByFirstChar(array, c);
        assertEquals(expResult, result.get(0).getName());
    }

    /**
     * Test of getActorsByAge method, of class HandlerImpl.
     */
    @Test
    public void testGetActorsByAge() {
        System.out.println("getActorsByAge");
        int age = 61;
        String expResult = "Tom Hanks";
        ArrayList<Actor> result = hand.getActorsByAge(array, age);
        assertEquals(expResult, result.get(0).getName());
    }
    
}
