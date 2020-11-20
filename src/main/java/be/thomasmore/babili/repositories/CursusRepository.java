package be.thomasmore.babili.repositories;

import be.thomasmore.babili.model.Cursus;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CursusRepository extends CrudRepository <Cursus, Integer> {
    Optional<Cursus>findCursusByNaam(String naam);
    Iterable<Cursus> findAllByDocent_Username(String username);
}
