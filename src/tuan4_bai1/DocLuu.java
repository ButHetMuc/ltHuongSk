package tuan4_bai1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DocLuu {
	public boolean luuFile(Object obj, String filePath) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	public Object docFile(String filePath) throws ClassNotFoundException, IOException {
		ObjectInputStream ois = null;
		ois = new ObjectInputStream(new FileInputStream(filePath));
		Object o=  ois.readObject();
		ois.close();
		
		return o;
	}
}
