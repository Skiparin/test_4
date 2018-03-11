/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import impl.ActorImpl;
import interfaces.Actor;
import interfaces.Handler;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Og180
 */
public class HandlerImpl implements Handler {

    public HandlerImpl(){
        
    }
    
    @Override
    public int getOldestAge(ArrayList<Actor> array) {
        int age = 0;
        for (Actor Actor : array) {
            if (Actor.getAge() > age) {
                age = Actor.getAge();
            }
        }
        return age;
    }

    @Override
    public String getLongestName(ArrayList<Actor> array) {
        String name = "";
        for (Actor Actor : array) {
            if (Actor.getName().length() > name.length()) {
                name = Actor.getName();
            }
        }
        return name;
    }

    @Override
    public ArrayList<Actor> sortByAge(ArrayList<Actor> array) {
        Collections.sort(array, ActorImpl.ActorAge);
        return array;
    }

    @Override
    public ArrayList<Actor> sortByName(ArrayList<Actor> array) {
        Collections.sort(array, ActorImpl.ActorName);
        return array;
    }

    @Override
    public ArrayList<Actor> readFromFile(BufferedReader br) {
        ArrayList<Actor> array = new ArrayList<>();
        try {
            String line = br.readLine();
            while (line != null) {
                String[] stringArray = line.split(",");
                String name = stringArray[0];
                int age = Integer.parseInt(stringArray[1]);
                Actor a = new ActorImpl(name, age);
                array.add(a);
                line = br.readLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(HandlerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(HandlerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return array;
    }

    @Override
    public void writeToFile(ArrayList<Actor> array, PrintWriter writer) {
        for (Actor a : array) {
            writer.println(a.getName() + "," + a.getAge());
        }
        writer.close();
    }

    @Override
    public boolean isOlder(Actor first, Actor second) {
        return first.getAge() > second.getAge();
    }

    @Override
    public boolean hasLongerName(Actor first, Actor second) {
        return first.getName().length() > first.getName().length();
    }

    @Override
    public ArrayList<Actor> getActorsByFirstChar(ArrayList<Actor> array, char c) {
        ArrayList<Actor> list = new ArrayList<>();
        for (Actor actor : array) {
            if(actor.getName().charAt(0) == c){
                list.add(actor);
            }
        }
        return list;
    }

    @Override
    public ArrayList<Actor> getActorsByAge(ArrayList<Actor> array, int age) {
        ArrayList<Actor> list = new ArrayList<>();
        for (Actor actor : array) {
            if(actor.getAge() == age){
                list.add(actor);
            }
        }
        return list;
    }

}
