
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class sound {
    Clip clip;
    URL soundurl[]=new URL[3];
    public sound()
    {
        soundurl[0] = getClass().getResource("/Game/ch.wav");
        soundurl[1] = getClass().getResource("/a/fire.mp3");
        soundurl[2] = getClass().getResource("/a/chkdie.mp3");
    }   
    public void setfile(int i)
    {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundurl[i]);
        clip = AudioSystem.getClip();
        clip.open(ais);
        
        } catch (Exception e) {
            // TODO: handle exception
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
