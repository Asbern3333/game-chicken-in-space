import javax.swing.JFrame;  

  
public class MAIN{
    public static void main(String[] args)
    {
        JFrame window=new JFrame();//to make the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//make it be able to close
        window.setResizable(false);//if I want to resize it or not
        window.setTitle("checke game");
        Gamepanel gamepanel=new Gamepanel();// it is class to prepare the window perporaties
        window.add(gamepanel);//open the gamepanel
        window.pack();//Causes this Window to be sized to fit the preferred size and layouts of its subcomponents
        window.setLocationRelativeTo(null);//the window is placed in the center of the screen.
        window.setVisible(true);//Shows or hides this Window depending on the value of parameter 
        gamepanel.startgamethread();//start the game loop. start the thread.
    }

}
