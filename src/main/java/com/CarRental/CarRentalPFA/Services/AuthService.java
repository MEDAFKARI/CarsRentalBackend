package com.CarRental.CarRentalPFA.Services;

import com.CarRental.CarRentalPFA.DAO.Entities.Store;
import com.CarRental.CarRentalPFA.DAO.Entities.User;
import com.CarRental.CarRentalPFA.DAO.Enum.Role;
import com.CarRental.CarRentalPFA.DAO.Repositories.StoreRepository;
import com.CarRental.CarRentalPFA.DAO.Repositories.UserRepository;
import com.CarRental.CarRentalPFA.DTO.StoreDTO;
import com.CarRental.CarRentalPFA.Requests.SigninRequest;
import com.CarRental.CarRentalPFA.Requests.SignupRequest;
import com.CarRental.CarRentalPFA.Responses.JwtResponse;
import com.CarRental.CarRentalPFA.Security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final StoreRepository storeRepository;

    public JwtResponse login(SigninRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            Optional<User> user = userRepository.findById(authRequest.getUsername());
            Role role = null;
            if (user.isPresent()) {
                role = user.get().getRole();
            }
            String token = jwtService.GenerateToken(authRequest.getUsername());
            return new JwtResponse(token, role);
        } else {
            throw new UsernameNotFoundException("User does not exist !");
        }
    }

    public String signup(SignupRequest req) {
        String password = passwordEncoder.encode(req.getPassword());
        System.out.println(password);
        User user1 = new User(req.getUsername(),req.getEmail(), password, Role.USER,null,null,null);
        userRepository.save(user1);
        return "Created";
    }

    public User signupStoreOwner(SignupRequest req) {
        String password = passwordEncoder.encode(req.getPassword());
        System.out.println(password);

        Store storeDTO = new Store(null, req.getUsername() + "'s Store", null, null, null, null, null, null);
        Store store = storeRepository.save(storeDTO);
        System.out.println(store);

        User user1 = new User(req.getUsername(), req.getEmail(), password, Role.STORE_OWNER, null, null, null);
        User u = userRepository.save(user1);

        System.out.println(u);

        store.setOwner(u);
        u.setStore(store);
        storeRepository.save(store);
        userRepository.save(u);

        return u;
    }

}
