package br.com.condovagas.controle.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.condovagas.controle.models.VagaModel;
@Service
public interface VagaService {
	
	   List<VagaModel> findAll();
	   VagaModel findById(UUID id);
	   VagaModel save(VagaModel vagaModel);
	
	
	
	
	
	
	

}
