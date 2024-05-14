package com.codingdojo.adopt_me.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.adopt_me.models.LoginUser;
import com.codingdojo.adopt_me.models.User;
import com.codingdojo.adopt_me.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    public User register(User newUser, BindingResult result) {
     
    	 // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    	    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");    	
    	}
    	
    	 // Reject if email is taken (present in database)
    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
    	
    	if(potentialUser.isPresent()){
    		result.rejectValue("email", "Duplicate", "This email is already registered!");
    	}
    	
    	// Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    	
    	// Hash and set password, save user to database
    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashed);    		
        return userRepo.save(newUser);
    }

    
    public User login(LoginUser newLogin, BindingResult result) {
    	
    	// Find user in the DB by email. Reject if NOT present
    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail()); 
    	
    	if(potentialUser.isPresent()){
    		// Reject if BCrypt password match fails
        	User user = potentialUser.get();
        	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
        	    result.rejectValue("password", "Matches", "Invalid Password!");
        	 // Return null if result has errors
        	    return null;
        	}
        	else {
        		// Otherwise, return the user object
            	return user;
        	}
    	}
    	
    	else{
    		result.rejectValue("email", "notFound", "Account not found! Please try again.");
    		// Return null if result has errors
    		return null;
    	}
    }
}    
