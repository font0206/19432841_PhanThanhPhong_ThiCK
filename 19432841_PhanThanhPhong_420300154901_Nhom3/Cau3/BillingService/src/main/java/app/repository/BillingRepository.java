package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Billing;
@Repository
public interface BillingRepository extends JpaRepository<Billing, String>{

}
