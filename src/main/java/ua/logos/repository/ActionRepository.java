package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.logos.entity.ActionEntity;
@Repository
public interface ActionRepository extends JpaRepository<ActionEntity, Long> {

}
