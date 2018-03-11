/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import static impl.HandlerImplTest.array;
import static impl.HandlerImplTest.hand;
import interfaces.Actor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
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

    @Test
    public void test_getLongestName() throws Exception {
        // Given
        String longestName = hand.getLongestName(array);

        // Then
        assertThat(longestName, comparesEqualTo("Leonardo DiCaprio"));
    }

    @Test
    public void test_getOldestAge() throws Exception {
        // Given
        int longestName = hand.getOldestAge(array);

        // Then
        assertThat(longestName, is(greaterThanOrEqualTo(61)));
    }

}
