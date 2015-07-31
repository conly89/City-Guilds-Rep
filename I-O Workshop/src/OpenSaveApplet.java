import javax.swing.JApplet;


public class OpenSaveApplet extends JApplet {
	private static final long serialVersionUID = 1L;
	/**
	 * Create the applet.
	 */
	public OpenSaveApplet() {
		OpenSave os = new OpenSave();
		setContentPane(os);
	}
	/**
	 * Initialize the applet
	 */
	public void init(){
		setSize(500,300);
	}
}
