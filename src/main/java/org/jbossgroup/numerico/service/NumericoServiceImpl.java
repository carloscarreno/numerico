package org.jbossgroup.numerico.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NumericoServiceImpl implements NumericoService {

	@Override
	public List<Long> getPrimos(Long n) {
		List<Long> lista = new ArrayList<Long>();
		for(Long l=2L ; l < n; l++) {
			if (isPrimo(l))
				lista.add(l);			
		}
		return lista;
	}

	@Override
	public boolean isPrimo(Long n) {
		Long i=2L;
		boolean flag = true;
		while(i < n) {
			if (n%i == 0) {
				flag =  false;
			    break;
			}
			i++;
		}
		return flag;
	}

}
