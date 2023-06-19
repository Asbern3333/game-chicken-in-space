import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class bullet {
    move keyH;
    public BufferedImage n;
    public int x,y;
    public int speed=12;
    public boolean on;//on plane

  public bullet(int x,int y,move keyH)
    {
        this.keyH=keyH;
        this.x=x;
        this.y=y;
        getthebulletimage();
    }    
    
    public void getthebulletimage()
    {
        try{
            
            n= ImageIO.read(getClass().getResourceAsStream("/a/fire.png"));
        }
        catch (Exception e) {
            
        }
    }
public void update(int x,int y1)
    { 
        if(on!=true)
        {this.x=x+45;
        this.y=y1;
        }
        if(keyH.bullet==true||on==true)
           {on=true;
           this.y -=speed;
           }
        if(this.y<=-2)
        {
            on=false;
            this.y=y1;
        }
    }
    

public void draw(Graphics2D g2 )
    {
        BufferedImage image=n;
        g2.drawImage(image,x,y,30,45,null );

    }


}