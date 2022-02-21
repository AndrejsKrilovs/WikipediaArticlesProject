package interview.wikicredit.repository;

import interview.wikicredit.data.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Company repository for database operations
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
