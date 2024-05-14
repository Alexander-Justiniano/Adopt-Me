package com.codingdojo.adopt_me.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.adopt_me.models.LoginUser;
import com.codingdojo.adopt_me.models.Pet;
import com.codingdojo.adopt_me.models.User;
import com.codingdojo.adopt_me.services.PetService;
import com.codingdojo.adopt_me.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
    
    @Autowired
    private UserService userServ;
    
    @Autowired
    private PetService petServ;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "loginAndRegistration.jsp";
    }
    
    @GetMapping("/home")
    public String dashboard(@ModelAttribute("pet") Pet pet,
    		Model model, HttpSession session) {
    	
    	model.addAttribute("pets", petServ.all());
    	
    	if(session.getAttribute("user_id")!= null) {    		
    		return "dashboard.jsp";
    	}
    	else {
    		return "redirect:/";
    	}
    }
    
    @GetMapping("/pets/new")
	public String newPet(@Valid @ModelAttribute("newPet") Pet newPet,
			BindingResult result, Model model, HttpSession session) {
		
		model.addAttribute("newPet", new Pet());
		
		if(session.getAttribute("user_id")!= null) {    		
    		return "addPet.jsp";
    	}
    	else {
    		return "redirect:/";
    	}
    }
    
	@GetMapping("/pets/{id}")
		public String show(@PathVariable("id") Long id, Model model, HttpSession session) {
			
			model.addAttribute("pet", petServ.findPet(id));
			
			return "show.jsp";
		}
	
	@GetMapping("/pets/{id}/edit")
		public String edit(@PathVariable("id") Long id, Model model) {
			
			model.addAttribute("pet", petServ.findPet(id));
			
			return "edit.jsp";
		}
	
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	
    	session.invalidate();
    	
    	return "redirect:/";
    }
	
    
    @PostMapping("/createPet")
    public String createPet(@Valid @ModelAttribute("newPet") Pet newPet, 
    		BindingResult result, Model model, HttpSession session) {
    	
    	petServ.create(newPet, result);
    	
    	if(result.hasErrors()) {
    		return "addPet.jsp";
        }

    	return "redirect:/home";
    }
    
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {

    	userServ.register(newUser, result);
        
        if(result.hasErrors()) {
        	model.addAttribute("newLogin", new LoginUser());
            return "loginAndRegistration.jsp";
        }
        
        session.setAttribute("user_id", newUser.getId());
        session.setAttribute("userName", newUser.getUserName());
    
        return "redirect:/home";
    }    
    
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
    	
    	User loggedIn = userServ.login(newLogin, result);		
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "loginAndRegistration.jsp";
        }
    
        session.setAttribute("user_id", loggedIn.getId());
        session.setAttribute("userName", loggedIn.getUserName());
    
        return "redirect:/home";
    }
    
    @PutMapping("/pets/{id}/edit")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("pet") Pet pet, BindingResult result, Model model) {
		
    	if (result.hasErrors()) {
			model.addAttribute("pets", petServ.all());
			return "edit.jsp";
		}
		
		petServ.update(pet, result);
		
		return "redirect:/home";
	}
    
    @DeleteMapping("/pets/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		petServ.delete(id);
		
		return "redirect:/home";
	}
    
}
