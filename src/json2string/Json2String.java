package json2string;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Json2String {
	static public String format(String json, String configJS) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		String script = "var json = " + json + ";"//
				+ "msg = function(json){" + configJS + "}(json);";
		try {
			engine.eval(script);
			String msg = (String) engine.eval("msg");
			return msg;
		} catch (ScriptException e) {
			e.printStackTrace();
			return null;
		}
	}
}
