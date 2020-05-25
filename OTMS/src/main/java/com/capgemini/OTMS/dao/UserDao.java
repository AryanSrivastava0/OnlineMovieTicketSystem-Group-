package com.capgemini.OTMS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.OTMS.entity.User;
/****************************
 *          @author          Aryan Srivastava
 *          Description      It is a Dao interface class typically used in combination 
 *                           with annotated handler methods based on the mapping annotation  
 *          Version          1.0
 *          Created Date     10-MAY-2020
 ****************************/
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	@Query("select user from User user where user.userName=:uname and user.password=:pass")
	public User validate(@Param("uname") String uname,@Param("pass") String pass);

	@Query("select u from User u where username=?1 and password=?2 ")
	public User getUser(String uName, String uPass);

}
