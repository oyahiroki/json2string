package nlp4j.json2string;

public class Json2StringTestMain2 {

	public static void main(String[] args) {

		// Original JSON (ex. response of REST API)
		String json = "{\"msg\":\"xxx\",\"params\":[{\"type\":\"msg\",\"value\":\"Hello1\"},{\"type\":\"msg\",\"value\":\"Hello2\"}]}";
		System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "return json.params[0].value;";
		System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		System.err.println("OUTPUT: " + msg);
	}

}
