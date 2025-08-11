package org.jbossgroup.numerico.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbossgroup.numerico.service.NumericoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/numerico")
public class NumericoController {

	
	@Autowired
	private NumericoService numericoService;
	
	// Cualquier usuario puede ver el mensaje de bienvenida
	@GetMapping("/welcome")
    public String welcome() {
       return "Bienvenidos todos al Generador de Numeros Primos! ";
    }

	// Solo los usuarios autorizados puedes realizar la operacion
	@GetMapping(path="/primos/{n}",produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('user_client') or hasRole('admin_client')")
	public  Map<String, Object> getPrimos(@PathVariable Long n){
		Map<String, Object> map = new HashMap<>();
	    map.put("primos", numericoService.getPrimos(n));
	    return map;		
	}
	
	// Solo un administrador puede ver los creditos
	@GetMapping("/creditos")
    @PreAuthorize("hasRole('admin_client')") 
    public String getCreditos() {
        return "Desarrollados por ccarrenovi@gmail.com - ONLY ADMIN";
    }

}
