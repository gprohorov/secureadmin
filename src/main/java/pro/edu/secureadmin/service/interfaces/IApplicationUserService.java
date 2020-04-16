package pro.edu.secureadmin.service.interfaces;

import pro.edu.secureadmin.model.ApplicationUser;

import java.util.List;

public interface IApplicationUserService {
    ApplicationUser create(ApplicationUser applicationUser);
    ApplicationUser get(String id);
    ApplicationUser update(ApplicationUser applicationUser);
    ApplicationUser delete(String id);
    List<ApplicationUser>   getAll();
}
