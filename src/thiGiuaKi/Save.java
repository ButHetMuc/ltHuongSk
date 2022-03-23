package thiGiuaKi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Save {
	public boolean saveFile(Object obj, String filePath) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = null;
		oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	public Object readFile(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = null;
		ois = new ObjectInputStream(new FileInputStream(filePath));
		Object o = ois.readObject();
		ois.close();
		return o;
	}
}
