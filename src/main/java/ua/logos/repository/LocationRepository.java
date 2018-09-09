package ua.logos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.logos.entity.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

}
