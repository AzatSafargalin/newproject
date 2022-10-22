package ru.ilb.newproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ilb.newproject.model.LoanTreaty;

/**
 *
 * @author AndrewSych
 */
public interface LoanTreatyRepository  extends JpaRepository<LoanTreaty, Long> {
    
}
