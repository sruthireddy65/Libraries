# Spring boot rest xml service
1. Usually we work with REST enpoints which sends and received payload in JSON format. 
   This module is to practice how xml requests are sent to a REST endpoint and how XML Response is consumed from a REST endpoint.
2. JSON support is provided with the help of jackson-databind jar which gets downloaded as part of spring-boot-starter-web dependency.
   To support XML format,
   1. we need to add jackson-dataformat-xml dependency explicitly.
   2. In the RestController, populate produces and consumes fields in required mapping annotation. Example for @PostMapping annotation
      @PostMapping(value = "/employees", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
      This accepts and also returns only json and xml requests and responses.
   3. If we are using postman as rest client, populate accept and content-type fields to specify produces and consumes values i.e.
      if accept field is application/json and content-type is application/xml , rest endpoint accepts or consumes xml format in the request and returns or produces json response.
       