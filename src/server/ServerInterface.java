/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.File;
import java.util.List;

/**
 *
 * @author Xenos
 */
public interface ServerInterface {
    
    public boolean initializeServer(int port);
    
    public void welcomeUser(Object out);
    
    public boolean localSynchronisationDirectory(File file);
    
    public boolean clientSynchronisationDirectory();
    
    public List<String> searchSong(String trackName);
}
