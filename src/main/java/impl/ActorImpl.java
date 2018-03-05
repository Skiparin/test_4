/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import interfaces.Actor;
import java.util.Comparator;

/**
 *
 * @author Og180
 */
public class ActorImpl implements Actor {

    private String name;
    private int age;
    
    public ActorImpl(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    public static Comparator<Actor> ActorAge = new Comparator<Actor>() {

        public int compare(Actor s1, Actor s2) {

            int rollno1 = s1.getAge();
            int rollno2 = s2.getAge();

            return rollno2 - rollno1;
        }
    };

    public static Comparator<Actor> ActorName = new Comparator<Actor>() {

        public int compare(Actor s1, Actor s2) {

            String rollno1 = s1.getName().toUpperCase();
            String rollno2 = s2.getName().toUpperCase();

            return rollno2.length()-rollno1.length();
        }
    };

}
