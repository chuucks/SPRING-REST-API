package org.codesolt.repository;

import java.util.List;

import org.codesolt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	
    @Transactional
    Long deleteByUserName(String userName);
    
    @Transactional
    @Query(value=
    	"SELECT u.userName, u.email, u.role, u.active, u.createTs, u.lastUpdtTs FROM User u WHERE u.userName = :userName")
    List<User> findByUserName(@Param("userName") String userName);
    
    @Override
    @Transactional
    @Query(value=
        "SELECT u.userName, u.email, u.role, u.active, u.createTs, u.lastUpdtTs FROM User u")
    List<User> findAll();
}
