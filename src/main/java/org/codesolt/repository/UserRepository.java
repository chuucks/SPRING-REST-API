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
	
    Long deleteByUserName(String userName);

    @Query(value=
    	"SELECT u.id FROM User u WHERE u.userName = :userName")
    Integer findIdByUserName(@Param("userName") String userName);    
    
    @Query(value=
    	"SELECT new User(u.id, u.userName, u.email, u.role, u.active, u.createTs, u.lastUpdtTs) FROM User u WHERE u.userName = :userName")
    List<User> findByUserName(@Param("userName") String userName);
    
    @Override
    @Query(value=
        "SELECT new User(u.id, u.userName, u.email, u.role, u.active, u.createTs, u.lastUpdtTs) FROM User u")
    List<User> findAll();
}
