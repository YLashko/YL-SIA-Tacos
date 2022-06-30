package files.data;
import org.springframework.data.repository.CrudRepository;
import files.User;

public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
  
}
