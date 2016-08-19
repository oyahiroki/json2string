package json2string;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Json2StringTestMain4 {

	public static void main(String[] args) throws Exception {

		// Original JSON (ex. response of REST API)
		Path src = new File("sample/sample4.json").toPath();
		List<String> list = Files.readAllLines(src);
		String json = String.join("", list);

		System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "return json.Image.Width;";
		System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		System.err.println("OUTPUT: " + msg);
	}

}
