package quanLiSach_09_HoangVanCong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class LuuTru {
	
	boolean luuFile(Object obj, String filePath) throws FileNotFoundException, IOException {
		
		ObjectOutputStream oos = null;
		oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	
	Object docFile(String filePath) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}

}
