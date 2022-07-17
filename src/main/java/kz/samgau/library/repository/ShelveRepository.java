package kz.samgau.library.repository;

import kz.samgau.library.model.Shelve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelveRepository extends JpaRepository<Shelve, Long> {
}
