import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class monster extends entity{
    Gamepanel gp; 
    move keyH;
    boolean on,fboss;
    public int chki[]={0,60,120,180,240,300,360,
                       0,60,120,180,240,300,360,
                       0,60,120,180,240,300,360};
    public boolean bool[]={true,true,true,true,true,true,true,
                           true,true,true,true,true,true,true,
                           true,true,true,true,true,true,true};
    public boolean boss=false;
    public monster(){
        setdefaultvalues();
        getPlayerimage();
        

    }
    public void setdefaultvalues(){
        x=0;
        y=0;
        speed=2;
        dirction="right";
        witdth=60;
        hight=60;
    }
    public void getPlayerimage(){
        try {

            llg= ImageIO.read(getClass().getResourceAsStream("/a/greenchklm.png"));//left walking greenck
            lg=ImageIO.read(getClass().getResourceAsStream("/a/greenchkls.png"));//leftstop greenck

            rg=ImageIO.read(getClass().getResourceAsStream("/a/greenchkrs.png"));//right stop  green ck
            rrg=ImageIO.read(getClass().getResourceAsStream("/a/greenchkrm.png"));//right move //green ck

            llw= ImageIO.read(getClass().getResourceAsStream("/a/wchklm.png"));//left walking white ch
            lw=ImageIO.read(getClass().getResourceAsStream("/a/wchkls.png"));//left move white ch 

            rw=ImageIO.read(getClass().getResourceAsStream("/a/wchkrs.png"));//right stop  white ck
            rrw=ImageIO.read(getClass().getResourceAsStream("/a/wchkrm.png"));//right move white ck

            lly= ImageIO.read(getClass().getResourceAsStream("/a/ychklm.png"));//left walking yellow ch
            ly=ImageIO.read(getClass().getResourceAsStream("/a/ychkls.png"));//left move yellow ch 

            ry=ImageIO.read(getClass().getResourceAsStream("/a/ychkrs.png"));//right stop  yellow ck
            rry=ImageIO.read(getClass().getResourceAsStream("/a/ychkrm.png"));//right move yellow ck

            
        } catch (Exception e) {
            
        }
    }
    public void update(bullet b)
    {
            if (dirction=="right"&&x+360>=530)//to stop the last check on the right in the 
            {dirction="left";
            x -= speed;
            for(int i=0;i<21;i++)
            {if(i<7)
            chki[i]=x+(60*i);
            if(i>7&&i<14)
            chki[i]=x+(60*i);
            if(i>14)
            chki[i]=x+(60*i);}//problem egg
            }
            else if (dirction=="left"&&x<=0)
            {dirction="right";
                x += speed;
                for(int i=0;i<21;i++)
            {if(i<7)
                chki[i]=x+(60*i);
                if(i>7&&i<14)
                chki[i]=x+(60*i);
                if(i>14)
                chki[i]=x+(60*i);}
            }
            else if (dirction=="right")
            { x += speed;
                for(int i=0;i<21;i++)
            {if(i<7)
                chki[i]=x+(60*i);
                if(i>7&&i<14)
                chki[i]=x+(60*i);
                if(i>14)
                chki[i]=x+(60*i);}
            }
            else if (dirction=="left")
            { x -= speed;
            for(int i=0;i<21;i++)
            {if(i<7)
                chki[i]=x+(60*i);
                if(i>7&&i<14)
                chki[i]=x+(60*i);
                if(i>14)
                chki[i]=x+(60*i);}
            }
            spritecounter++;
            if(spritecounter>=20)
            {
                if(spritenum==1)
                {
                    spritenum=2;
                }
                else if(spritenum==2)
                spritenum=1;
                spritecounter=0;
            }
           //to make it run*/
           // if(keyH.upPressed==true||keyH.leftPressed==true||keyH.rightPressed==true||
           // keyH.downPressed==true){  } if keypressed
           for(int i=14;i<21;i++)
           { //bool[i]=false; //to finishe the game
            if((b.x>((x-witdth/2)+(60*(i-14)))&&b.x<((x+witdth/2)+(60*(i-14)))&& b.y>y-hight/2+80&&b.y<y+hight/2+80)&&bool[i]==true)
              {
                bool[i]=false;
                b.on=false;
              }
           }
           for(int i=7;i<14;i++)
            { //bool[i]=false;//to finish the game
                if((b.x>((x-witdth/2)+(60*(i-7)))&&b.x<((x+witdth/2)+(60*(i-7)))&& b.y>y-hight/2+40&&b.y<y+hight/2+40)&&bool[i]==true)
             {
                bool[i]=false;
                b.on=false;
                }
            } 
           for(int i=0;i<7;i++)
             { //bool[i]=false;// to finish the game
                if((b.x>((x-witdth/2)+(60*i))&&b.x<((x+witdth/2)+(60*i))&& b.y>y-hight/2&&b.y<y+hight/2)&&bool[i]==true)
              {
                bool[i]=false;
                b.on=false;
              }
            }   
            fboss=true;
            for(int i=0;i<21;i++)
            {if(bool[i]==true)
                {fboss=false;
                }
            }


    }
    public void draw(Graphics2D g2)
    {
       // g2.setColor(Color.BLUE);//make blue
       // g2.fillRect(x, y, 500, 500);//make rectngle
       BufferedImage greench=null;//to access to image data
       BufferedImage whitech=null;
       BufferedImage yellowch=null;
       switch(dirction)
       {
        case "left": 
        if(spritenum==1)
        {greench=lg;
        whitech=lw;
        yellowch=ly;
        }
       if(spritenum==2){
        greench=llg;
        whitech=llw;
        yellowch=lly;}
        break;
        case "right":
        if(spritenum==1)
        {greench=rg;
            whitech=rw;
            yellowch=ry;
        }
       if(spritenum==2)
       {
        greench=rrg;
        whitech=rrw;
        yellowch=rry; }
       break;
       } 

       for(int i=0;i<7;i++)
       {if(bool[i]==true)
        g2.drawImage(greench, x+(60*i), y,witdth,hight, null);
       }
       for(int i=7;i<14;i++)
       {if(bool[i]==true)
        g2.drawImage(whitech, x+(60*(i-7)), y+40,witdth,hight, null);//draw image at x and y with width and high of the plane last one image obsever
       }
       for(int i=14;i<21;i++)
       {if(bool[i]==true)
        g2.drawImage(yellowch, x+(60*(i-14)), y+80,witdth,hight, null);//draw image at x and y with width and high of the plane last one image obsever
       }
    }
}
