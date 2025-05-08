package br.com.exemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.model.entity.Brinquedo;
import br.com.exemplo.model.repository.BrinquedoRepository;


/*
 * GET        /api/mongo/brinquedos      -> listAll()
 * GET        /api/mongo/brinquedos/1    -> getById()
 * POST       /api/mongo/brinquedos      -> insert()
 * PUT        /api/mongo/brinquedos/1    -> update()
 * DELETE     /api/mongo/brinquedos/1    -> delete()
 */

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {
	

	@Autowired
	private BrinquedoRepository BrinquedoRepository;
	
	@GetMapping
	public List<Brinquedo> listAll(){
		List<Brinquedo> brinquedos = BrinquedoRepository.findAll();
		return brinquedos;
	}
	
	 @PostMapping
	public List<Brinquedo> insert(@RequestBody List<Brinquedo> Brinquedo) {
	    return BrinquedoRepository.saveAll(Brinquedo);
	    }  
	
	 @PutMapping("/{id}")
		public Brinquedo update(@RequestBody Brinquedo Brinquedo, @PathVariable String id){
			// obter o Brinquedo a ser atualizado
			Brinquedo brinquedoUpdate = BrinquedoRepository.findById(id).get();
			// atualizar os dados
			brinquedoUpdate.setNome(Brinquedo.getNome());
			brinquedoUpdate.setCategoria(Brinquedo.getCategoria());
			brinquedoUpdate.setCor(Brinquedo.getCor());
			brinquedoUpdate.setImagem(Brinquedo.getImagem());
			brinquedoUpdate.setDescricao(Brinquedo.getDescricao());
			brinquedoUpdate.setDetalhes(Brinquedo.getDetalhes());
			brinquedoUpdate.setMarca(Brinquedo.getMarca());
	
			
			BrinquedoRepository.save(brinquedoUpdate);
			return brinquedoUpdate; 
		}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		BrinquedoRepository.deleteById(id);
		return "Brinquedo Excluído com Sucesso!";
	}
	
}