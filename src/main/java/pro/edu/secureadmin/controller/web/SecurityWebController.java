package pro.edu.secureadmin.controller.web;


import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.edu.secureadmin.model.ApplicationUser;
import pro.edu.secureadmin.model.DTOUser;
import pro.edu.secureadmin.service.impls.ApplicationUserServiceImpl;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/web/user")
@Controller
public class SecurityWebController {

    @Autowired
    ApplicationUserServiceImpl service;

   @RequestMapping("/get/list")
    public String showAll(Model model){


       List<DTOUser> dtoList = new ArrayList<>();
       List<ApplicationUser> users = service.getAll();

       users.stream().forEach(item ->{

                   final String role = item.getAuthorities().stream()
                         //  .filter(el -> el.toString().contains("ROLE_")).toString()
                           .filter(el -> el.getAuthority().contains("ROLE_"))
                           .findFirst()
                           .get().getAuthority()
                           .replace("ROLE_","")
                           ;
                   DTOUser  dto = new DTOUser(
                           item.getId(),
                           role,
                           item.getPassword(),
                           item.getUsername(),
                           item.isAccountNonExpired(),
                           item.isAccountNonLocked(),
                           item.isCredentialsNonExpired(),
                           item.isEnabled()
                   );
                   dtoList.add(dto);
               }
       );




       model.addAttribute("items", dtoList );
       return "userlist";
   }




}
