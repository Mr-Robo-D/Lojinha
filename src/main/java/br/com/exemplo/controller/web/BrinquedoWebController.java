package br.com.exemplo.controller.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.exemplo.model.entity.Brinquedo;
import br.com.exemplo.model.repository.BrinquedoRepository;


@Controller
@RequestMapping("/brinquedos")
public class BrinquedoWebController {

	@Autowired
	private BrinquedoRepository brinquedoRepository;
	
	@GetMapping("/new")
	public String newBrinquedo(Model model) {
		
		model
			.addAttribute("brinquedo", new Brinquedo())
			.addAttribute("novo", true);
		
		return "form";
	}
	
	@GetMapping("/filtro")
	public String listAll4(Model model) {
		List<Brinquedo> brinquedos = brinquedoRepository.findAll();
		model.addAttribute("brinquedos", brinquedos);
        return "filtro";
	}
	
	
	  @GetMapping("/filtro/{g}") public String g(@PathVariable String g, Model
	  model ) { List<Brinquedo> brinquedos = brinquedoRepository.findAll();
	  model.addAttribute("brinquedos", brinquedos); return "catalogo"; }
	 
	  
	
	
	  
	/*
	 * @GetMapping("/index") public String index(Model model, @RequestParam(value =
	 * "nome", required = false) String nome) { if (nome != null) { // Executar
	 * lógica específica quando o parâmetro 'nome' está presente
	 * model.addAttribute("nome", nome); // ... outras lógicas específicas ...
	 * return "index"; } else { // Executar lógica padrão quando 'nome' não está
	 * presente List<Brinquedo> brinquedos = brinquedoRepository.findAll();
	 * model.addAttribute("brinquedos", brinquedos); // ... outras lógicas padrão
	 * ... return "index"; } }
	 */  
	  
		
		  @GetMapping("/index") public String index(Model model, @RequestParam("nome")
		  String nome) { model.addAttribute("nome", nome);
		  return "index"; }
		 
	
	@GetMapping("/list")
	
	public String listAll(Model model) {
		List<Brinquedo> brinquedos = brinquedoRepository.findAll();
		model.addAttribute("brinquedos", brinquedos);
		return "list";
		
	}
	
	/*
	 * @GetMapping("/index")
	 * 
	 * public String listAll3(Model model) { List<Brinquedo> brinquedos =
	 * brinquedoRepository.findAll(); model.addAttribute("brinquedos", brinquedos);
	 * return "index";
	 * 
	 * }
	 */

	@GetMapping("/{id}")
	public String getById(Model model, @PathVariable String id) {
	    Optional<Brinquedo> optionalBrinquedo = brinquedoRepository.findById(id);

	    if (optionalBrinquedo.isPresent()) {
	        model.addAttribute("brinquedo", optionalBrinquedo.get());
	        return "read";
	    } else {
	        // Tratar o caso em que o brinquedo não foi encontrado
	        return "brinquedoNaoEncontrado"; // ou redirecionar para uma página de erro
	    }
	}


	@PostMapping("/save")
	public String saveBrinquedo(Brinquedo brinquedo) {
		brinquedoRepository.save(brinquedo);
		return "redirect:/brinquedos/list";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteBrinquedo(@PathVariable String id) {
		Optional<Brinquedo> brinquedoDelete = brinquedoRepository.findById(id);
		if (brinquedoDelete.isPresent()) 
			brinquedoRepository.deleteById(id);
		
		return "redirect:/brinquedos/list";
	}
	
	@GetMapping("/{id}/edit")
	public String editBrinquedo(Model model, @PathVariable String id) {
		
		Brinquedo brinquedo = brinquedoRepository.findById(id).get();
		
		model
			.addAttribute("brinquedo", brinquedo)
			.addAttribute("novo", false);
		
		return "form";
	}
	
	@GetMapping("/sobre")
    public String sobre() {
        return "sobre";
	}
	



	
	
	
	























}
