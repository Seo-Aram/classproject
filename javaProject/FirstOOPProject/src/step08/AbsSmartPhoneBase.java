package step08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

abstract class AbsSmartPhoneBase implements ISmartPhone {
	final private String FILE_NAME;
	
	public AbsSmartPhoneBase(String fileName) {
		if(fileName == null || fileName.trim().length() == 0) {
			this.FILE_NAME = "defaultFile.ser";
		} else {
			this.FILE_NAME = fileName;
		}
	}

	@Override
	public void saveDataFile(Object obj) {
		ObjectOutputStream outStream = null;
		
		try { 
			outStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			outStream.writeObject(obj);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("파일 저장 완료");

	}

	@Override
	public Object readDataFile() {
		ObjectInputStream inStream = null;
		Object result = null;
		
		try {
			inStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
			
			if(inStream != null) result = inStream.readObject();
			
		} catch (IOException e) {
			System.out.println("불러오기 데이터가 존재하지 않습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("해당 타입을 찾을 수 없습니다.");
		} catch (Exception e) {
			System.out.println("데이터 불러오기 실패.");
		}
		
		return result;
	}

}
