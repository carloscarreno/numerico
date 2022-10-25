package org.jbossgroup.numerico.service;

import java.util.List;

public interface NumericoService {
   public List<Long> getPrimos(Long n);
   
   public boolean isPrimo(Long n);
   
}
