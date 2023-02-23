package com.camblinks.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/rest")
public class GetPost {
	

	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getJsonDataUsingResponseEntity() throws JsonProcessingException {

		Map<String, String> data = new HashMap<>();
		data.put("name", "Ajay");
		data.put("age", "40");
		data.put("city", "Argyle");

		ObjectMapper om = new ObjectMapper();
		return ResponseEntity.ok(om.writerWithDefaultPrettyPrinter().writeValueAsString(data));
	}

	@GetMapping(value = "/getBody", produces = MediaType.APPLICATION_JSON_VALUE)
	public StreamingResponseBody getJsonDataUsingResponseBody() throws JsonProcessingException {
		return new StreamingResponseBody() {
			@Override
			public void writeTo(OutputStream outputStream) throws IOException {
				// TODO Auto-generated method stub

				Map<String, String> data = new HashMap<>();
				data.put("name", "Ajay");
				data.put("age", "40");
				data.put("city", "Argyle");

				ObjectMapper om = new ObjectMapper();
				om.writerWithDefaultPrettyPrinter().writeValue(outputStream, data);

			}
		};
	}

	@GetMapping(value = "/getParam", produces = MediaType.APPLICATION_JSON_VALUE)
	public StreamingResponseBody getJsonParamUsingResponseBody(
			@RequestParam(name = "name", defaultValue = "") String name) throws JsonProcessingException {
		return new StreamingResponseBody() {
			@Override
			public void writeTo(OutputStream outputStream) throws IOException {
				Map<String, String> data = new HashMap<>();
				// TODO Auto-generated method stub
				if ("ajay".equals(name)) {
					
					data.put("name", "Ajay");
					data.put("age", "40");
					data.put("city", "Argyle");
				} else {
					data.put("name", "dummy");
					data.put("age", "40");
					data.put("city", "sf");
				}
				ObjectMapper om = new ObjectMapper();
				om.writerWithDefaultPrettyPrinter().writeValue(outputStream, data);

			}
		};
	}
	
	@PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public StreamingResponseBody postJson(@RequestBody Map<String,Object> json) {
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
            	// TODO Auto-generated method stub
                ObjectMapper om = new ObjectMapper();
                om.writerWithDefaultPrettyPrinter().writeValue(outputStream, json);
            }
        };
    }
	
}
