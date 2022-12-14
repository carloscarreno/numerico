package org.jbossgroup.numerico.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbossgroup.numerico.service.NumericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/numerico")
public class NumericoController {

	
	@Autowired
	private NumericoService numericoService;
	
	@GetMapping(path="/primos/{n}",produces=MediaType.APPLICATION_JSON_VALUE)
	public  Map<String, Object> getPrimos(@PathVariable Long n){
		Map<String, Object> map = new HashMap<>();
	    map.put("primos", numericoService.getPrimos(n));
	    return map;		
	}
	
}
