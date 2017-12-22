package org.codesolt.repository;

import java.util.List;

import org.codesolt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
    @Transactional
    Long deleteByUserName(String username);
    
    @Transactional
    List<User> findByUserName(String username);
}
