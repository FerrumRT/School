package kz.school.School.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles implements GrantedAuthority {

    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
