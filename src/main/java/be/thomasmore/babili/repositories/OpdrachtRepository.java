package be.thomasmore.babili.repositories;

import be.thomasmore.babili.model.Cursus;
import be.thomasmore.babili.model.Opdracht;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OpdrachtRepository extends CrudRepository<Opdracht, Integer> {
    Optional<Opdracht> findById(Integer id);
    Optional<Opdracht>findOpdrachtByTitel(String titel);
    Iterable<Opdracht> findAllByCursus_Id(Integer id);

}
