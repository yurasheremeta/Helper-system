package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ua.logos.entity.EventsEntity;
@Repository
public interface EventsRepository extends JpaRepository<EventsEntity, Long> {
	
	EventsEntity deleteByEventId(String eventId);
	
	EventsEntity findByEventId(String eventId);
	
	boolean existsByEventId(String eventId);

}
