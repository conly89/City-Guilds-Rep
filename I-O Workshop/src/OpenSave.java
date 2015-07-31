import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;


public class OpenSave extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	//Instance variable.
	JTextArea textAreaFile = new JTextArea();
	
	public OpenSave() {
		setLayout(null);
		
		
		JScrollPane scroll = new JScrollPane(textAreaFile);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(10, 26, 318, 193);
		add(scroll);
		
		JButton btnOpenFile = new JButton("Open File");
		btnOpenFile.setBounds(56, 242, 89, 47);
		btnOpenFile.addActionListener(myActionlistener);
		add(btnOpenFile);
		
		JButton btnSaveFile = new JButton("Save File");
		btnSaveFile.setBounds(168, 242, 89, 47);
		btnSaveFile.addActionListener(myActionlistener);
		add(btnSaveFile);
		
	}
	ActionListener myActionlistener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent event) {
			String buttonPressed = event.getActionCommand();
			
			if(buttonPressed.equalsIgnoreCase("Open File")){
				textAreaFile.setText(IOUtil.openFile().toString());
			}else{
				IOUtil.saveFile(textAreaFile.getText());
			}
		}
		
	};
}
