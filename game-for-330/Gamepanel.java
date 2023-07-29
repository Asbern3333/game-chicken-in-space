
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicComboBoxUI.KeyHandler;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Gamepanel extends JPanel implements Runnable{
    final int orTilesize=16;//16*16 tile
    final int scal=3;
   public final int titlesize=scal*orTilesize;//48*48 tile
    final int maxsccol=12;
    final int maxscrow=16;
    final int width=maxsccol*titlesize;//576
    final int hight=maxscrow*titlesize;//768
    int FPS= 60;//FPS Frames per second
    move  keyH = new move();
    Thread gameThread; 
    Player player=new Player(this, keyH);
    sound sou=new sound();
    bullet b=new bullet(player.x+50,player.y,keyH);
    monster monster1=new monster();
    egg e=new egg();
    int playersp=4;
    public Gamepanel(){
        this.setPreferredSize(new Dimension(width,hight));//size for the console
        this.setBackground(Color.black);//to paint the backgroud
        this.setDoubleBuffered(true);   
        this.addKeyListener(keyH);//to handle a keyinput
        this.setFocusable(true);
    }
    
    public void startgamethread()
    {
        gameThread=new Thread(this);//make a thread
        gameThread.start();// the starting point 
        playmusic(0);
    }
    @Override
    public void run() {
       
        double drawinterval=1000000000/FPS;//one second in nano= 1 b nanot second   1000000000/60=1/60=0.01666666
        double delta=0;
        long lasttime= System.nanoTime();//to draw the screen next time current time +
        long currenttime;
        long timer=0; 
        int drawcount=0;
        //nanot second =//1billon nanotsecond = 1 second  I used it because it is small
        
       while(gameThread!=null)//the game loop if game Thread==null the game will stoped
    {
        currenttime=System.nanoTime();
        
        delta+= (currenttime- lasttime)/drawinterval;
        timer+=(currenttime-lasttime);
        lasttime=currenttime;
        
        //System.out.println("check the loop");
        //update information character postion
        if(delta>=1){
        update();
        //draw screen with the update info
        repaint();  
        delta--;
        drawcount++;
        }
        if(timer>=1000000000)//if timer get 1 second
        {
           // System.out.println("FPS: "+drawcount);
            drawcount=0;
            timer=0;
        }
       }
    }
    public void update(){
        player.update();//update player
        b.update(player.x,player.y);//update bullet
        monster1.update(b);//update chickent
        e.update(monster1);//update egg
      
        if(((player.x-39<=(e.r1)&&(e.r1)<player.x+70&&player.y-25<=(e.y[0])&&(e.y[0])<player.y+50)// to stop the game
        ||(player.x-39<=(e.r2)&&(e.r2)<player.x+70&&player.y-25<=(e.y[1])&&(e.y[1])<player.y+50)
        ||(player.x-39<=(e.r3)&&(e.r3)<player.x+70&&player.y-25<=(e.y[2])&&(e.y[2])<player.y+50)))
        {  
        player.gameover=false;
        gameThread=null;
        } 
        if(monster1.fboss==true)
        {
            
            gameThread=null;
        }




        

    }
    public void paintComponent(Graphics g)
    {
    super.paintComponent(g);
    Graphics2D g2=(Graphics2D)g;// class extends the graphic class to provide more sophisticated control over geomtry
    //,corrdinate transformation,color mangment, and text layout
   player.drawbackground(g2);
    b.draw(g2);
    player.draw(g2);
    e.draw(g2,monster1);
    monster1.draw(g2);
    if(player.gameover==false)
    {player.gameover(g2);
    stopM();}
    if(monster1.fboss==true)
    {player.win(g2);
    stopM();
    playSE(1);
    }
     g2.dispose();//dispose of these graphics' context and release any resource system that is using it
    }
    public void playmusic(int i)
    {
        sou.setfile(i);
        sou.play();
        sou.loop();
    }
    public void stopM(){
        sou.stop();
    }
    public void playSE(int i){
        sou.setfile(i);
        sou.play();
    }
}