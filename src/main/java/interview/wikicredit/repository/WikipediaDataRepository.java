package interview.wikicredit.repository;

import interview.wikicredit.data.Company;
import interview.wikicredit.data.WikipediaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for database operations for Wikipedia data
 */
@Repository
public interface WikipediaDataRepository extends JpaRepository<WikipediaData, Integer> {
    Optional<WikipediaData> findByCompany(Company company);
}
