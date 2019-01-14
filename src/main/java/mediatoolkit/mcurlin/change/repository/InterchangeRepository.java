package mediatoolkit.mcurlin.change.repository;

import mediatoolkit.mcurlin.change.domain.interchange.Interchange;
import org.springframework.data.repository.CrudRepository;

public interface InterchangeRepository extends CrudRepository<Interchange, Long> {

    Interchange getById(Long id);

}
