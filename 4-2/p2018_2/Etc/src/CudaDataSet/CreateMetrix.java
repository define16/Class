package CudaDataSet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class CreateMetrix {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Random random = new Random();
		int max = 100;
		int min = -100;
		int row = 400;
		int col = 400;
		
		float rand = 0;
		String data = "";
		File file = new File("DataSet.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
		for(int i = 0; i < col; i++) {
			data = "";
			for(int j = 0; j < row; j++) {
				rand = random.nextInt(max - min + 1) + min + random.nextFloat();
				data += rand;
//				data += String.format("%.2f",rand);
				if(j != row-1) {
					data += " ";
				}
			}
			bufferedWriter.write(data);
			if(i != col-1) {

				bufferedWriter.newLine();
			}
		}

		
		System.out.println("done");
	}

}
