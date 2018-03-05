/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;

/**
 *
 * @author Og180
 */
public interface Handler {
    
    public int getOldestAge(ArrayList<Actor> array);
    
    public String getLongestName(ArrayList<Actor> array);
    
    public ArrayList<Actor> sortByAge(ArrayList<Actor> array);
    
    public ArrayList<Actor> sortByName(ArrayList<Actor> array);
    
    public ArrayList<Actor> readFromFile();
    
    public void writeToFile(ArrayList<Actor> array);
    
    public boolean isOlder(Actor first, Actor second);
    
    public boolean hasLongerName(Actor first, Actor second);
    
    public ArrayList<Actor> getActorsByFirstChar(ArrayList<Actor> array, char c);
    
    public ArrayList<Actor> getActorsByAge(ArrayList<Actor> array, int age);
    
    
}
