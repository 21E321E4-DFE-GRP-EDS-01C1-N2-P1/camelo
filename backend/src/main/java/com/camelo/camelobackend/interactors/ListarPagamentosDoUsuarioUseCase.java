package com.camelo.camelobackend.interactors;

import com.camelo.camelobackend.domain.Cartao;
import com.camelo.camelobackend.ports.CartaoPort;
import com.camelo.camelobackend.ports.UserPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class ListarPagamentosDoUsuarioUseCase {

    private final UserPort userPort;
    private final CartaoPort cartaoPort;

    public ListarPagamentosDoUsuarioUseCase(UserPort userPort, CartaoPort cartaoPort) {
        this.userPort = userPort;
        this.cartaoPort = cartaoPort;
    }

    public List<Cartao> executar() {

        var userSS = UserService.authenticated();

        if (nonNull(userSS)) {
            var user = userPort.buscarPor(userSS.getUsername());
            return cartaoPort.buscarPor(user.getId());
        }
        throw new RuntimeException();
    }

    public Page<Cartao> executar(Integer page, Integer linesPerPage, String orderBy, String direction) {

        var userSS = UserService.authenticated();

        if (nonNull(userSS)) {
            var pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
            return cartaoPort.findAll(pageRequest);
        }
        throw new RuntimeException();
    }
}
