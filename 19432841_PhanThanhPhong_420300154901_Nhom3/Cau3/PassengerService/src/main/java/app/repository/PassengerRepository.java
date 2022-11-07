package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entity.Passenger;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, String> {

}
