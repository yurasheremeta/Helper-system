package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.logos.entity.CategoryEntity;
import ua.logos.entity.EventsEntity;
@Repository
public interface EventsRepository extends JpaRepository<EventsEntity, Long> {

}
