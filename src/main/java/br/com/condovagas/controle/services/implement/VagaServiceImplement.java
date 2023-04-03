package br.com.condovagas.controle.services.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.condovagas.controle.models.VagaModel;
import br.com.condovagas.controle.repository.VagaRepository;
import br.com.condovagas.controle.services.VagaService;

@Service
public class VagaServiceImplement implements VagaService{
	
	final VagaRepository vagaRepository;
	
	public VagaServiceImplement(VagaRepository vagaRepository) {
		this.vagaRepository = vagaRepository;
	}

	@Override
	public List<VagaModel> findAll() {
		
		return vagaRepository.findAll();
	}

	@Override
	public VagaModel findById(UUID id) {
		return vagaRepository.findById(id).get();
	}

	@Override
	public VagaModel save(VagaModel vagaModel) {
		
		return vagaRepository.save(vagaModel);
	}

	

}
