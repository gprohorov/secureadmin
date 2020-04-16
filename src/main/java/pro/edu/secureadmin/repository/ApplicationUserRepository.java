package pro.edu.secureadmin.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pro.edu.secureadmin.model.ApplicationUser;

@Repository
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {

}
