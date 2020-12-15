/*
 * Filename: MixerControls.java
 * Short description: 
 * @author  Bret Talley
 * @version Oct 3, 2020
 */
package Model;
/**
 * @author bret_
 * @version 1.0 Oct 3, 2020
 */
public abstract class MixerControls 
{
    // Instance Variables -- define your private data    // Constructors
    public MixerControls()
    {
            // initialize default values
    }
    public MixerControls(int data) // pass in data to initialize variables
    {
    }    

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable    
    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable    
    // Additional methods -- such as for calculation, display    

    abstract public void ChangeSlider();
        
    abstract public void AlterAudio();
    
    abstract public void SendData();
    
}