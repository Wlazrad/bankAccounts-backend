package pl.wlazrad.demo.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pl.wlazrad.demo.repositories.SubaccountRepository;
import pl.wlazrad.demo.security.User;
import pl.wlazrad.demo.security.jwt.JwtUtils;
import pl.wlazrad.demo.security.repository.UserRepository;
import pl.wlazrad.demo.security.request.LoginRequest;
import pl.wlazrad.demo.security.request.SignupRequest;
import pl.wlazrad.demo.security.response.JwtResponse;
import pl.wlazrad.demo.security.response.MessageResponse;
import pl.wlazrad.demo.security.services.UserDetailsImpl;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    SubaccountRepository subaccountRepository;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getPesel(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByPesel(signUpRequest.getPesel())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Pesel is already taken!"));
        }

        // Create new user's accounts
        User user = new User(signUpRequest.getName(),
                signUpRequest.getSurname(),
                signUpRequest.getPesel(),
                encoder.encode(signUpRequest.getPassword()));
        userRepository.flush();
        userRepository.save(user);

//        Subaccount subaccountPln = new Subaccount();
//        subaccountPln.setAmount(signUpRequest.getMoney());
//        subaccountPln.setCurrency(Currency.PLN);
//
//        subaccountRepository.flush();
//        Subaccount subaccountUsd = new Subaccount();
//        subaccountUsd.setAmount(new BigDecimal(0));
//        subaccountUsd.setCurrency(Currency.USD);
//        user.setSubaccountList(List.of(subaccountPln, subaccountUsd));
//
//        userRepository.flush();
//        userRepository.save(user);




        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}

