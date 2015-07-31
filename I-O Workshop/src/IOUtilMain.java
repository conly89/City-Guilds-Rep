
public class IOUtilMain {
	public static void main(String[] args){
		StringBuffer myBuffer = IOUtil.openFile();//Calls our openFile method and saves the file contents to myBuffer.
		System.out.println(myBuffer);//Prints out the contents of myBuffer.
		IOUtil.saveFile("Test save string");//Calls our saveFile method.
	}
}
