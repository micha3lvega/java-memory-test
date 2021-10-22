package co.com.foo.test.memory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.foo.test.memory.repository.model.entity.DummyEntity;

public interface IFooRepository extends JpaRepository<DummyEntity, Long> {

	@Query(value = "SELECT DUMMY FROM DUAL", nativeQuery = true)
	String getDummyValue();

}
