/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Xenos
 */
public interface ClientInterface {
    
    Socket connection = null;
    ObjectInputStream inputStream = null;
    ObjectOutputStream outputStream = null;
    
    String localPath = "/localDirectory";
    
    File localDir = new File(localPath);
    File musicDir = new File(localPath, "/music");
    
    /**
     * This method initializes the client connection to server.
     * @param host Host name of socket connection
     * @param port Port number of socket connection
     * @return true if connection is successful, false if connection is unsuccessful
     */
    
    public boolean initializeClient(String host, int port);
    
    /**
     * Sends to ServerSocket "LOGIN", "<username>", "<password>"
     * Also sends "ASK_SYNC" to receive the updated directory.
     * @param username
     * @param password
     * @return 1 successful, 0 unsuccessful, -1 wrong username password combination
     */  
    public int logIn(String username, String password);
    
    /**
     * Sends to ServerSocket "SIGNUP", "<username>", "<password>"
     * @return 1 successful, 0 unsuccessful, -1 username already exist
     */
    public int signUp (String username, String password);
    
    /**
     * Sends to ServerSocket "ACCESS", "<target_username>"
     * @param user
     * @return 
     */
    public boolean accessProfile(String user);
    
     
    //TODO
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
     * Called after logIn method to sync local and remote directory.
     * A thread always "listens" for changes and calls this method.
    */
    public boolean retrieveDirectoryFromServer();
    
    
    /**
     * Send message "UPDATE" and after server sends the updated file.
     * @param file
     * @return 
     */
    public boolean sendFileToServer(File file);
    
    public List<String> searchSong(String trackName);
    
    /**
     * This method is used to post messages on my profile.
     * First updates my local directory via writePostToLocalDirectory(String message)
     * and then sends the updated file to server side via sendFileToServer(File file).
     * @param message The message (post)
     * @return true or false
     */
    public boolean postMessage(String message);
    
    /**
     * Writes the message to local directory Profile.txt
     * @param message
     * @return 
     */
    public boolean writePostToLocalDirectory(String message);
    
    public boolean reply(String message,boolean isPublic);
    
    public boolean requestTrack(String trackName);
    
    public boolean followUser(String user);
    
    public boolean unfollowUser(String user);
}
