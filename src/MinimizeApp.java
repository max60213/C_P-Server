import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MinimizeApp extends JFrame{
	public MinimizeApp() {
	}

	public void start() {
		
		//make app appeared in taskbar's icon stack
	    //checking for support
	    if(!SystemTray.isSupported()){
	        System.out.println("System tray is not supported !!! ");
	        return ;
	    }
	    //get the systemTray of the system
	    SystemTray systemTray = SystemTray.getSystemTray();
	    
	    //change app icon
	    Image ic = Toolkit.getDefaultToolkit().getImage("src/res/icon.png");
	    setIconImage(ic);

	    //get default toolkit
	    //Toolkit toolkit = Toolkit.getDefaultToolkit();
	    //get image 
	    //Toolkit.getDefaultToolkit().getImage("src/res/icon.png");
	    Image image = Toolkit.getDefaultToolkit().getImage("src/res/icon.png");
	    Image image16 = Toolkit.getDefaultToolkit().getImage("src/res/icon16.png");

	    //popupmenu
	    PopupMenu trayPopupMenu = new PopupMenu();

	    //menuitem of popupmenu
	    MenuItem close = new MenuItem("Close");
	    close.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.out.println("exit");
	            System.exit(0);             
	        }
	    });
	    trayPopupMenu.add(close);

	    //setting tray icon
	    TrayIcon trayIcon = new TrayIcon(image16, "Copy_Pass", trayPopupMenu);
	    //adjust to default size as per system recommendation 
	    trayIcon.setImageAutoSize(true);

	    try{
	        systemTray.add(trayIcon);
	    }catch(AWTException awtException){
	        awtException.printStackTrace();
	    }
	}
}
