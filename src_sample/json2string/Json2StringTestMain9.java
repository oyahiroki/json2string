package json2string;

public class Json2StringTestMain9 {

	public static void main(String[] args) {

		// Original JSON (ex. response of REST API)
		String json = "{\"msg\":\"Hello\"}";
		System.err.println("JSON: " + json);

		// Your configuration (in JavaScript)
		String configJS = "return \"\"+JSON.stringify(json, null, \"\");";
		System.err.println("CONFIG: " + configJS);

		// Hello message
		String msg = Json2String.format(json, configJS);

		// Hello
		System.err.println("OUTPUT: " + msg);
	}

}
