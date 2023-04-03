package br.com.condovagas.controle.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.condovagas.controle.dto.FormVagaDto;
import br.com.condovagas.controle.models.VagaModel;
import br.com.condovagas.controle.services.VagaService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vagas")
public class VagaController {

	final VagaService vagaService;

	public VagaController(VagaService vagaService) {
		this.vagaService = vagaService;
	}

	@GetMapping
	public ModelAndView getVagas() {
		ModelAndView mv = new ModelAndView("vagas");
		List<VagaModel> vagas = vagaService.findAll();
		mv.addObject("vagas", vagas);
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView getVaga(@PathVariable("id") UUID id) {
		ModelAndView mv = new ModelAndView("detalhesVaga");
		VagaModel vaga = vagaService.findById(id);
		mv.addObject("vaga", vaga);
		return mv;
	}

	// redirecionar ao cadastro de vagas
	@GetMapping("/novavaga")
	public ModelAndView getVagaForm(FormVagaDto formVagaDto) {
		ModelAndView mv = new ModelAndView("vagaForm");
		return mv;
	}

	@PostMapping("/novavaga")
	public ModelAndView criarVaga(@Valid FormVagaDto formVagaDto, BindingResult bindingResult) {
	
		if (bindingResult.hasErrors()) { 
			System.out.println("deu erro");
			ModelAndView mv = new ModelAndView("vagaForm");
			return mv;
		}
		VagaModel vagamodel = new VagaModel();
		vagamodel.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
		vagamodel.setDataAtualizacao(LocalDateTime.now(ZoneId.of("UTC")));
		BeanUtils.copyProperties(formVagaDto, vagamodel);
		vagaService.save(vagamodel);
		return new ModelAndView("redirect:/vagas");
	}
	

}
