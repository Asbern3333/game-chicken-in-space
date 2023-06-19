import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import javax.imageio.ImageIO;
public class Player  extends entity{
    Gamepanel gp; 
    move keyH;
    public boolean gameover=true,win=false;
    public String text1;
    public Player(Gamepanel gp,move keyH){
        this.gp=gp;
        this.keyH=keyH;
        setdefaultvalues();
        getPlayerimage();

    }
    public void setdefaultvalues(){
        x=350;
        y=450;
        speed=4;
        dirction="down";
    }
    public void getPlayerimage(){
        try {
            ll= ImageIO.read(getClass().getResourceAsStream("/a/ll.png"));
            l= ImageIO.read(getClass().getResourceAsStream("/a/l.png"));
            n= ImageIO.read(getClass().getResourceAsStream("/a/n.png"));
            rr= ImageIO.read(getClass().getResourceAsStream("/a/rr.png"));
            r= ImageIO.read(getClass().getResourceAsStream("/a/r.png"));
            chk=ImageIO.read(getClass().getResourceAsStream("/a/chk.jpg"));
            llg=ImageIO.read(getClass().getResourceAsStream("/a/space.png"));
        } catch (Exception e) {
            
        }
    }
    public void update()
    {
       
            if(keyH.upPressed == true&&y>=450)
            {
                dirction="up";
                y -= speed;
            }
            else if(keyH.downPressed == true&&y<=660)
            {
                dirction="down";
                y += speed;
    
            }
            else if (keyH.leftPressed== true&&x>+2)
            {dirction="left";
            x -= speed;
            }
            else if (keyH.rightPressed==true&&x<480)
            {dirction="right";
                x += speed;
            }
            else 
            dirction="normal";
            /*  spritecounter++;
            if(spritecounter>10)
            {
                if(spritenum==1)
                {
                    spritenum=2;
                }
                else if (spritenum==2)
                spritenum=1;
            }to make it run*/
           // if(keyH.upPressed==true||keyH.leftPressed==true||keyH.rightPressed==true||
           // keyH.downPressed==true){  } if keypressed
        
    }
    public void draw(Graphics2D g2 )
    {
       // g2.setColor(Color.BLUE);//make blue
       // g2.fillRect(x, y, 500, 500);//make rectngle
       BufferedImage image=null;//to access to image data
       switch(dirction)
       {
        case "left": image=ll;
       // if(spritenum==1)image=l;
      //  if(spritenum==2)image=ll;
        break;
        case "up": image=n;
       // if(spritenum==1&&image==ll)image=l;
        //if(spritenum==1&&image==rr)image=r;
       // if(spritenum==2)image=n;
        break;
        case "down": image=n;break;
        //if(spritenum==1&&image==ll)image=l;
       //if(spritenum==1&&image==rr)image=r;
        //if(spritenum==2)image=n;
        case "right":image=rr;break;
        case "normal":image=n;break;
        //if(spritenum==1)image=r;
       //if(spritenum==2)image=rr; break;
       } 
      
      g2.drawImage(image, x, y,100,100, null);//draw image at x and y with width and high of the plane last one image obsever
    }
    public void gameover(Graphics2D g1)
{
    g1.setColor(new Color(0,0,0,150));
    g1.fillRect(0,0,50,50); 

    int x=40;
    int y=80;
    String text;
    g1.setFont(g1.getFont().deriveFont(Font.BOLD,80f));
    text= "Game Over";
    //shadow
    g1.setColor(Color.BLACK);
    g1.drawString(text, x+40-10, y+150);
    g1.setColor(Color.white);
    g1.drawString(text, x+40, y+160 );
    
    //retry
   /* g1.setFont(g1.getFont().deriveFont(Font.BOLD,40f));

  
    g1.setColor(Color.white);
    g1.drawString("try again", 200, 400 );
    g1.setColor(Color.BLACK);
    g1.drawString("quit", 250-10, 450-10);
    g1.setColor(Color.white);
    g1.drawString("quit", 250, 450);*/
    //back
}
public void win(Graphics2D g1)
{
    g1.setColor(new Color(0,0,0,150));
    g1.fillRect(0,0,50,50); 

    int x=40;
    int y=80;
    String text;
    g1.setFont(g1.getFont().deriveFont(Font.BOLD,80f));
    text= "You WIN!";
    text1="Enjoy The meal!";
    //shadow
    g1.setColor(Color.blue);
    g1.drawString(text, x+30, y);
    g1.setColor(Color.white);
    g1.drawString(text, x+40, y+10 );
    g1.drawImage(chk,120,250,300,200,null);
    g1.setFont(g1.getFont().deriveFont(Font.BOLD,40f));
    g1.setColor(Color.blue);
    g1.drawString(text1, x+60, y+140);
    g1.setColor(Color.white);
    g1.drawString(text1, x+60, y+150 );
}
public void drawbackground(Graphics2D g1)
{
    g1.drawImage(llg, 0, 0,700,700, null);
}
}
