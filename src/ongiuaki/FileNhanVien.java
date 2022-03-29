package ongiuaki;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class FileNhanVien {
	
	public Object docFile(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		Object o = ois.readObject();
		ois.close();	
		return o;
	}
	
	public boolean luuFile (Object o, String filePath) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(o);
		oos.flush();
		oos.close();
		return true;
	}

}
