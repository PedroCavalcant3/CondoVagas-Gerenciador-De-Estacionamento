package br.com.condovagas.controle.repository;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.condovagas.controle.models.VagaModel;

@Repository
public interface VagaRepository extends JpaRepository<VagaModel, UUID>{



}
