package com.cg.onlinepizza.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinepizza.dto.User;

public interface IUserRepository extends CrudRepository<User, Integer> {
	@Transactional 
	@Modifying
    @Query(value="update user set logged_in=:b where user_id=:userId",nativeQuery=true)
	void setLoggedIn(@Param("b")boolean b, @Param("userId")int userId);
	
	@Transactional 
	@Modifying
	@Query(value="update user set password=:newPassword where password=:oldPassword and user_id=:id", nativeQuery=true )
   void replace( @Param("id")int id,@Param("oldPassword")String oldPassword,@Param("newPassword")String newPassword);
   
	
}
