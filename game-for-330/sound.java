
import java.io.BufferedInputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class sound {
    Clip clip;
    URL soundurl[]=new URL[2];
    public sound()
    {
        soundurl[0] = getClass().getResource("/music/3.wav");
    soundurl[1] = getClass().getResource("/music/ch.wav");
    }
    public void setfile(int i)
    {
        
        try {
            
        AudioInputStream ais = AudioSystem.getAudioInputStream(soundurl[i]);
        clip = AudioSystem.getClip();
        clip.open(ais);
        
        } catch (Exception e) {
            System.out.println(e);     
        }
    }
    public void play()
    {
        clip.start();
    }
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        clip.stop();
    }
    
}
