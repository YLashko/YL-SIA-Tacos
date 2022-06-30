package files.data;

import org.springframework.data.repository.CrudRepository;

import files.Ingredient;

public interface IngredientRepository 
         extends CrudRepository<Ingredient, String> {

}
