/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import java.util.List;

/**
 *
 * @author Xenos
 */
public interface ClientInterface {
    //File directory=null;
    
    
    /**
     * 
     * @param username
     * @param password
     * @return 1 successful, 0 unsuccessful, -1 wrong username password combination
     */
    
    public int logIn(String username, String password);
    
    /**
     * @return 1 successful, 0 unsuccessful, -1 username already exist
     */
    
    public int signUp (String username, String password);
    
    public boolean accessProfile(String user);
    
    
    /**
     *Uploads file to music directory
     * <p>
     * this method calls the sync method
     * 
     * @param musicFile
     * @return 
     */
    public boolean uploadMusic(File musicFile);
    
    /**
     * 
    */
    public boolean localDirectorySynchronisation();
    
    public boolean serverDirectorySynchronisation(File file);
    
    public List<String> searchSong(String trackName);
    
    public boolean postMessage(String message);
    
    public boolean reply(String message,boolean isPublic);
    
    public boolean requestTrack(String trackName);
    
    public boolean followUser(String user);
    
    public boolean unfollowUser(String user);
}
