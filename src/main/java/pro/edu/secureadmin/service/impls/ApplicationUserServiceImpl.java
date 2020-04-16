package pro.edu.secureadmin.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pro.edu.secureadmin.model.ApplicationUser;
import pro.edu.secureadmin.repository.ApplicationUserRepository;
import pro.edu.secureadmin.service.interfaces.IApplicationUserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static pro.edu.secureadmin.config.ApplicationUserRole.*;

@Service
public class ApplicationUserServiceImpl implements IApplicationUserService {

    private final ApplicationUserRepository repository;

    @Autowired
    public ApplicationUserServiceImpl(ApplicationUserRepository repository) {
        this.repository = repository;
    }

    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    private List<ApplicationUser> list = new ArrayList<>(

            Arrays.asList(
                    new ApplicationUser(
                            ADMIN.getGrantedAuthorities()
                            ,passwordEncoder().encode("admin")
                            ,"admin"
                            , true
                            , true
                            , true
                            ,true),
                   new ApplicationUser(DOCTOR.getGrantedAuthorities(), passwordEncoder().encode("doctor"), "doctor", true, true, true, true)
            )
    );

    @PostConstruct
    void init(){
        repository.saveAll(list);
    }



    @Override
    public ApplicationUser create(ApplicationUser applicationUser) {
        return null;
    }

    @Override
    public ApplicationUser get(String id) {
        return null;
    }

    @Override
    public ApplicationUser update(ApplicationUser applicationUser) {
        return null;
    }

    @Override
    public ApplicationUser delete(String id) {
        return null;
    }

    @Override
    public List<ApplicationUser> getAll() {
        return null;
    }
}
