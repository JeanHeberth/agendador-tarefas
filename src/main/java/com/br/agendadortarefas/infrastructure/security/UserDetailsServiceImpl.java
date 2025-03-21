package com.br.agendadortarefas.infrastructure.security;


import com.br.agendadortarefas.business.dto.UsuarioDTO;
import com.br.agendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl {

    private final UsuarioClient usuarioClient;

    public UserDetails carregaDadosUsuario(String email, String token) throws UsernameNotFoundException {

        UsuarioDTO usuarioDTO = usuarioClient.buscarPorEmail(email, token);
        return User
                .withUsername(usuarioDTO.getEmail()) // Define o nome de usuário como o e-mail
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails


    }
}
