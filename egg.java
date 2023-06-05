import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

import javax.imageio.ImageIO;

class egg extends GenerateRandom{
    public int sum[]=new int[3];
    public int x[]=new int[3],y[]=new int[3],timer;
    public boolean b[]=new boolean[3];
    public BufferedImage tegg1,tegg2,fegg1,fegg2,aegg;public int k;
    public int g=rand.nextInt(7);
    public int s=rand.nextInt(7);
    public int j=rand.nextInt(7);
    public egg()
    {
        x[0]=0;
        y[0]=0;
        y[1]=40;
        x[1]=0;
        x[2]=0;
        y[2]=80;
        //b[0]=true;
        setimage();
    }
    public void setimage()
    {try{
            tegg1=ImageIO.read(getClass().getResourceAsStream("/a/tegg1.png"));
            tegg2=ImageIO.read(getClass().getResourceAsStream("/a/tegg1.png"));
            fegg1=ImageIO.read(getClass().getResourceAsStream("/a/fegg1.png"));
            fegg2=ImageIO.read(getClass().getResourceAsStream("/a/fegg2.png"));
            aegg=ImageIO.read(getClass().getResourceAsStream("/a/aegg.png"));
        }
        catch (Exception e) {
            
        }
    }




public void update(monster m)
{
    
y[0]+=4;
y[1]+=4;
y[2]+=4;

for(int i=0;i<7;i++)
{if(y[0]>=670){
if(m.bool[g]==true){
y[0]=0;
r1= m.chki[g];
}
g=rand.nextInt(7);
}

if(y[1]>=670){
if(m.bool[s]==true)
{y[1]=40;
 r2= m.chki[s];
}s=rand.nextInt(7);}

if(y[2]>=670){
if(m.bool[j]==true)
{y[2]=80;
    r3= m.chki[j];
   
} j=rand.nextInt(7);
System.out.println(r3);}

}
    /*if(b[0]==false)  
    {x[0]=checkx;}
    if(b[0]==true)
    {y[0]+=4;}
    
    if(b[1]==false)
    {x[1]=checkx+40;}
    if(b[1]==true)
    {y[1]+=4;}
    timer++;
    if(timer>=10000)
    timer=0;*/
}
public void draw(Graphics2D g2,monster m )
    {
        /*if(timer%60==0||b[0]==true)
        {g2.drawImage(n,x[0],y[0],40,40,null );
            b[0]=true;
        }
        if(y[0]>=500&&b[0]==true) {
            b[0]=false;
            y[0]=0;
        }
        if(timer%20==0||b[1]==true)
        {g2.drawImage(n,x[1]+40,y[1],40,40,null );
            b[1]=true;
        }
         if(y[1]>=500&&b[1]==true) {
            b[1]=false;
            y[1]=0;
        }*/
                
                g2.drawImage(tegg1,r1,y[0],40,40,null );
                
            
            
                
                g2.drawImage(fegg1,r2,y[1],40,40,null );
        
                
                g2.drawImage(aegg,r3,y[2],40,40,null );
            

        
    }
};