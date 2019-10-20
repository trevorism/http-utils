 # Http Utils
![Jenkins](https://img.shields.io/jenkins/build/http/trevorism-build.eastus.cloudapp.azure.com/http-utils)
![Jenkins Coverage](https://img.shields.io/jenkins/coverage/jacoco/http/trevorism-build.eastus.cloudapp.azure.com/http-utils)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/http-utils)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/http-utils)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/http-utils)
 
Latest Version: 1.0.2 

 
Simple java library to perform REST calls. 
 
## How to Use 
```java
//Simple json request/response
String url = "http://....";
HttpClient httpClient = new JsonHttpClient();
String json = httpClient.get(url);
String jsonResponse = httpClient.post(url, "{}");
```

```java
//Request or response with headers exposed
String url = "http://....";
HeadersHttpClient headersClient = new HeadersJsonHttpClient();
CloseableHttpResponse response = null;
try {
    Map<String, String> headersMap = createHeaderMap();
    response = headersClient.post(url, "{}", headersMap);
    return ResponseUtils.getEntity(response);
}catch (Exception e){
    throw new RuntimeException(e);
}finally{
    ResponseUtils.closeSilently(response);
}
```

## How to Build
`gradle clean build`