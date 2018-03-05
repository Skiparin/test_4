/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import static impl.HandlerImplTest.array;
import static impl.HandlerImplTest.hand;
import interfaces.Actor;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicSalaryCalculatorTest {

    public static ArrayList<Actor> array = null;
    public static HandlerImpl hand = null;

    @BeforeEach
    void init() {
        hand = new HandlerImpl();
        ArrayList<Actor> a = new ArrayList<>();
        a.add(new ActorImpl("Tom Hanks", 61));
        a.add(new ActorImpl("Leonardo DiCaprio", 43));
        a.add(new ActorImpl("Tom Cruise", 55));
        a.add(new ActorImpl("Kevin Spacey", 58));
        a.add(new ActorImpl("Johnny Depp", 54));
        a.add(new ActorImpl("Brad Pitt", 54));
        hand.writeToFile(a);
        array = hand.readFromFile();
        System.out.println(array.toString());
    }

    @Test
    public void testGetOldestAge() {
        System.out.println("getOldestAge");
        int expResult = 61;
        int result = hand.getOldestAge(array);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLongestName() {
        System.out.println("getLongestName");
        String expResult = "Leonardo DiCaprio";
        String result = hand.getLongestName(array);
        assertEquals(expResult, result);
    }
}
