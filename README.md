# Json2String

A lightweight Java library for converting JSON data to formatted strings using JavaScript configuration.

## Overview

Json2String is a simple yet powerful utility that allows you to extract and transform data from JSON objects using JavaScript expressions. It leverages Java's built-in JavaScript engine (Nashorn/Rhino) to provide flexible JSON-to-string conversion without requiring complex parsing logic.

## Features

- **Simple API**: Single method call to convert JSON to string
- **JavaScript Configuration**: Use familiar JavaScript syntax to define extraction logic
- **Thread-Safe**: Synchronized method ensures safe multi-threaded usage
- **No External Dependencies**: Uses only Java's built-in ScriptEngine
- **Flexible**: Supports complex JSON structures, arrays, and nested objects
- **Numeric Support**: Handles both string and numeric JSON attributes

## Requirements

- Java 8 or higher
- Maven (for building)

## Installation

### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>Json2String</groupId>
    <artifactId>json2string</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### Manual Build

```bash
git clone <repository-url>
cd json2string
mvn clean install
```

## Usage

### Basic Example

Extract a simple value from JSON:

```java
import nlp4j.json2string.Json2String;

public class Example {
    public static void main(String[] args) {
        // Original JSON (e.g., response from REST API)
        String json = "{\"msg\":\"Hello\"}";
        
        // Configuration in JavaScript
        String configJS = "return json.msg;";
        
        // Convert JSON to String
        String result = Json2String.format(json, configJS);
        
        System.out.println(result); // Output: Hello
    }
}
```

### Array Access

Extract values from JSON arrays:

```java
String json = "{\"msg\":\"xxx\",\"params\":[{\"type\":\"msg\",\"value\":\"Hello1\"},{\"type\":\"msg\",\"value\":\"Hello2\"}]}";

String configJS = "return json.params[0].value;";

String result = Json2String.format(json, configJS);
System.out.println(result); // Output: Hello1
```

### Loop Through Arrays

Process multiple array elements:

```java
String json = "{\"msg\":\"xxx\",\"params\":[{\"type\":\"msg\",\"value\":\"Hello1\"},{\"type\":\"msg\",\"value\":\"Hello2\"}]}";

String configJS = "var s=''; for(var i=0; i<json.params.length; i++){ s+=json.params[i].value; } return s;";

String result = Json2String.format(json, configJS);
System.out.println(result); // Output: Hello1Hello2
```

### Nested Objects

Access deeply nested properties:

```java
String json = "{\"Image\":{\"Width\":800,\"Height\":600,\"Title\":\"View from 15th Floor\"}}";

String configJS = "return json.Image.Width;";

String result = Json2String.format(json, configJS);
System.out.println(result); // Output: 800
```

### JSON Stringify

Convert JSON back to string format:

```java
String json = "{\"msg\":\"Hello\"}";

String configJS = "return JSON.stringify(json, null, '');";

String result = Json2String.format(json, configJS);
System.out.println(result); // Output: {"msg":"Hello"}
```

## API Reference

### Json2String.format()

```java
public static synchronized String format(String json, String configJS)
```

**Parameters:**
- `json` - A valid JSON string to be processed
- `configJS` - JavaScript code that processes the JSON object and returns a string

**Returns:**
- The formatted string result, or `null` if an error occurs

**Thread Safety:**
- This method is synchronized to ensure thread-safe operation in multi-threaded environments

## Error Handling

The library returns `null` when:
- Invalid JSON is provided
- Invalid JavaScript configuration is provided
- Script execution fails

Example:

```java
// Invalid JSON
String json = "{\"msg\":\"Hello\"}xx";
String result = Json2String.format(json, configJS);
// result will be null

// Invalid JavaScript
String configJS = "returnxx json.msg;"; // syntax error
String result = Json2String.format(json, configJS);
// result will be null
```

## Multi-Threading Support

Json2String is thread-safe and can be used in multi-threaded applications. The `format()` method is synchronized to prevent concurrent access issues with the JavaScript engine.

## Version History

- **0.3** - Added multi-thread support
- **0.2** - Added support for numeric attributes in JSON
- **0.1** - Initial release

## Examples

See the `src_sample` directory for complete working examples:
- `Json2StringTestMain1.java` - Basic usage
- `Json2StringTestMain2.java` - Array access
- `Json2StringTestMain3.java` - Loop through arrays
- `Json2StringTestMain4.java` - Reading JSON from file

## Testing

Run the test suite:

```bash
mvn test
```

The project includes comprehensive unit tests covering:
- Basic JSON extraction
- Array handling
- Nested objects
- Numeric values
- Error cases
- Multi-threaded scenarios

## Use Cases

- **REST API Response Processing**: Extract specific fields from API responses
- **Configuration Management**: Parse JSON configuration files
- **Data Transformation**: Convert JSON data to custom string formats
- **Logging**: Format JSON data for log messages
- **Report Generation**: Extract and format data for reports

## Author

Hiroki Oya

## License

[Specify your license here]

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Reference

- [Qiita Article](http://qiita.com/cotrpepe/items/7cafaacb538425a78f1f)