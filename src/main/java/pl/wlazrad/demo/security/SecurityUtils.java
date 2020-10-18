package pl.wlazrad.demo.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component

public class SecurityUtils {

    public static String getCurrentUserPesel() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String pesel = null;
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                pesel = springSecurityUser.getUsername().toLowerCase();
            } else if (authentication.getPrincipal() instanceof String) {
                pesel = ((String) authentication.getPrincipal()).toLowerCase();
            }
        }
        return pesel != null ? pesel.toLowerCase() : null;
    }
}


