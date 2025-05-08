package br.com.exemplo.model.repository;

import java.util.List;

//import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.exemplo.model.entity.Brinquedo;

public interface BrinquedoRepository extends MongoRepository<Brinquedo, String> {
	
	// pesquisa por nome
	Brinquedo findByNome(String nome);

	// lista de alunos pelo primeiro nome
	List<Brinquedo> findByNomeStartsWith(String nome);
	
	// lista de alunos pelo ultimo nome
		List<Brinquedo> findByNomeEndsWith(String nome);

		// lista de qualquer aluno 
		List<Brinquedo> findByNomeContains(String nome);
		
		// @Aggregation("{ $group: { _id: '$categoria' } }")
		 //   List<String> findDistinctCategorias();
	
}





