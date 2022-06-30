package files;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import files.Ingredient.Type;
import files.data.IngredientRepository;
import files.data.OrderRepository;
import files.data.TacoRepository;
import files.data.UserRepository;
import files.web.DesignTacoController;

@RunWith(SpringRunner.class)
@WebMvcTest(DesignTacoController.class)
public class DesignTacoControllerTest {

  @Autowired
  private MockMvc mockMvc;
  
  private List<Ingredient> ingredients;

  private Taco design;
  
  @MockBean
  private IngredientRepository ingredientRepository;

  @MockBean
  private TacoRepository designRepository;

  @MockBean
  private OrderRepository orderRepository;

  @MockBean
  private UserRepository userRepository;

  @Before
  public void setup() {
    ingredients = Arrays.asList(
      new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
      new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
      new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
      new Ingredient("CARN", "Carnitas", Type.PROTEIN),
      new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
      new Ingredient("LETC", "Lettuce", Type.VEGGIES),
      new Ingredient("CHED", "Cheddar", Type.CHEESE),
      new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
      new Ingredient("SLSA", "Salsa", Type.SAUCE),
      new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
    );
    
    when(ingredientRepository.findAll())
        .thenReturn(ingredients);
        
    when(ingredientRepository.findById("FLTO")).thenReturn(Optional.of(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP)));
    when(ingredientRepository.findById("GRBF")).thenReturn(Optional.of(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN)));
    when(ingredientRepository.findById("CHED")).thenReturn(Optional.of(new Ingredient("CHED", "Cheddar", Type.CHEESE)));
    
    design = new Taco();
    design.setName("Test Taco");

    design.setIngredients(Arrays.asList(
        new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
        new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
        new Ingredient("CHED", "Cheddar", Type.CHEESE)
    	));

    when(userRepository.findByUsername("testuser"))
    		.thenReturn(new User("testuser", "testpass", "Test User", "123 Street", "Someville", "CO", "12345", "123-123-1234"));
  }

}
