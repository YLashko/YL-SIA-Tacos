package files.data;

import org.springframework.data.repository.CrudRepository;

import files.Taco;

public interface TacoRepository 
         extends CrudRepository<Taco, Long> {

}
