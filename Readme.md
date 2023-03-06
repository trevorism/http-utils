 # Http Utils
![Build](https://github.com/trevorism/http-utils/actions/workflows/build.yml/badge.svg)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/http-utils)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/http-utils)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/http-utils)
 
Latest [Version](https://github.com/trevorism/http-utils/releases/latest)
 
Simple java library to perform HTTP calls. 
 
## How to Use 
```java_holder_method_tree
//Simple json request/response
String url = "http://....";
HttpClient httpClient = new JsonHttpClient();
String json = httpClient.get(url);
String jsonResponse = httpClient.post(url, "{}");
```

```java_holder_method_tree
//Request or response with headers exposed
String url = "http://....";
HttpClient headersClient = new JsonHttpClient();
CloseableHttpResponse response = null;
Map<String, String> headersMap = createHeaderMap();
String jsonResponse = headersClient.post(url, "{}", headersMap).getValue();
Map<String, String> responseHeaders = headersClient.post(url, "{}", headersMap).getHeaders();
```

```java_holder_method_tree
//Async request allows client to invoke a request without waiting.
String url = "http://....";
AsyncJsonHttpClient client = new AsyncJsonHttpClient();
Future<SimpleHttpResponse> future = client.get(url);
String jsonResponse = future.get().getBody().getBodyText();
```

## How to Build
`gradle clean build`