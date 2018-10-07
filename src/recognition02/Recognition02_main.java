package recognition02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

public class Recognition02_main {
	public static void main(String[] args) {
	VisualRecognition service = new VisualRecognition("2018-03-19");
	service.setApiKey("---");

	InputStream imagesStream = null;
	try {
		imagesStream = new FileInputStream("img/fruitbowl.jpg");
		

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
			  .imagesFile(imagesStream)
			  .imagesFilename("fruitbowl.jpg")
			  .threshold((float) 0.6)
			  .owners(Arrays.asList("IBM"))
			  .build();
	ClassifiedImages result = service.classify(classifyOptions).execute();
	//System.out.println(result.getImages().);
	//System.out.println(result.getImages().iterator().next().getClassifiers().iterator().next().getClasses().iterator().next().getScore());
	//System.out.println(result);
	//ObjectMapper mapper = new ObjectMapper();
	//JsonNode node = mapper.readTree(String.valueOf(result));
	
	

}
}
