package io.github.fanky10.labs.sjbe.web.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.fanky10.labs.sjbe.config.AppConfig;

/**
 * Simple Rest Controller for managing app params
 * @author facundo.scoccia
 *
 */
@RestController
@RequestMapping("/api")
public class AppController {
	
	@Inject
	private AppConfig appConfiguration;
	
	/**
     * GET  /application -> get the current app configuration.
     */
    @RequestMapping(value = "/application",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> getAppVersion() {
    	Map<String, String> values = new HashMap<String, String>();
    	values.put("version", "1.0.1");
    	values.put("isDev", String.valueOf(appConfiguration.getIsDev()));
    	return new ResponseEntity<Map<String,String>>(values, HttpStatus.OK);
    }
}
