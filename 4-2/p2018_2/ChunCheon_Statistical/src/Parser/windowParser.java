package Parser;

import java.io.File;

import main.autoCon;

public class windowParser implements autoCon{
	private String folderPath;

	// �ʱ� �ּ� �Է�
	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}
	
	// �ּ� �ȿ� �ִ� ���� ��� ������ ����	
	public String[] readFolder() {
		String[] folderList = null;
		File clsFolder = new File(folderPath);
		if (clsFolder.exists() == false) {
			System.err.println("folder is not found");
			return null;
		} else {
			File[] arrFile = clsFolder.listFiles();
			folderList = new String[arrFile.length];
			for (int i = 0; i < arrFile.length; ++i) {
//				System.out.println(arrFile[i].getName());
				folderList[i] = arrFile[i].getName();
			}
			return folderList;
		}
	}


	

//	public static void main(String[] args) {
//		String[] folders;
//		String[] files;
//		String path = "C:\\Users\\H\\Documents\\����1\\��õ�����";
//		w.setFolderPath(path);
//		w.setFolders(w.readFolder());
//		folders = w.getFolders();
//		folders = w.readFolder();
//		for(int a = 0; a < folders.length; a++) {
//			System.out.println(path + "\\" + folders[a]);
//			w.setFolderPath(path + "\\" + folders[a]);
//			files = w.readFolder();
//			
//			for(int b = 0; b < files.length; b++) {
//				System.out.println(path + "\\" + folders[a] + "\\" + files[b]);
//			}
//		}
//	}
	
	
}
