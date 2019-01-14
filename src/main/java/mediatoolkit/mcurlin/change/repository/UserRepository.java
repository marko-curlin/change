package mediatoolkit.mcurlin.change.repository;

import mediatoolkit.mcurlin.change.domain.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User getById(Long id);
}
