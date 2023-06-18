package infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import usuario.UsuarioRepository;

/**
 *
 * @author EduardoM
 */

@Component
public class SecurityFilter extends OncePerRequestFilter{
    
    @Autowired
    private TokenService tokenService;
    
    private UsuarioRepository usuarioRepository;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{
       
        var authHeader =request.getHeader("Authorization"); // 
        
        if(authHeader!= null){
            var token = authHeader.replace("Bearer ", "");
            var nombreUsuario = tokenService.getSubject(authHeader);
            if(nombreUsuario != null){
                //Token valido 
                var usuario = usuarioRepository.findByLogin(nombreUsuario);
                var authentication = new UsernamePasswordAuthenticationToken(usuario, 
                        null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
