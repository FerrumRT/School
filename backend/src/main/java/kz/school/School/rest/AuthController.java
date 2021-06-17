package kz.school.School.rest;

import kz.school.School.dto.AuthRequest;
import kz.school.School.dto.AuthResponse;
import kz.school.School.dto.TeacherResponse;
import kz.school.School.jwt.JWTTokenGenerator;
import kz.school.School.models.Teachers;
import kz.school.School.services.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private JWTTokenGenerator jwtTokenGenerator;

    @Autowired
    private TeachersService teacherService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody AuthRequest request) throws Exception {

        final Teachers user = teacherService.findByEmailAndPassword(request.getEmail(), request.getPassword());

        if (user == null)
            return new ResponseEntity<>("Wrong email or password", HttpStatus.OK);

        authenticate(request.getEmail(), request.getPassword());

        TeacherResponse userResponse = new TeacherResponse(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.isAdmin()
        );

        final String token = jwtTokenGenerator.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token, userResponse));
    }

    public void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
