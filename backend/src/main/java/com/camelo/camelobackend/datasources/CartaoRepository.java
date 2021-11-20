package com.camelo.camelobackend.datasources;

import com.camelo.camelobackend.datasources.h2.data.CartaoData;
import com.camelo.camelobackend.datasources.h2.data.UserData;
import com.camelo.camelobackend.datasources.h2.mapper.CartaoModelMapper;
import com.camelo.camelobackend.datasources.h2.model.CartaoModel;
import com.camelo.camelobackend.datasources.h2.model.UserModel;
import com.camelo.camelobackend.domain.Cartao;
import com.camelo.camelobackend.domain.User;
import com.camelo.camelobackend.ports.CartaoPort;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class CartaoRepository implements CartaoPort {

    private final CartaoData data;
    private final UserData userData;
    private final CartaoModelMapper mapper;

    public CartaoRepository(CartaoData data, UserData userData) {
        this.data = data;
        this.userData = userData;
        this.mapper = Mappers.getMapper(CartaoModelMapper.class);
    }

    @Override
    public Cartao salvar(Cartao cartao) {
        var cartaoModel = getCartaoModel(cartao);
        var cartaoSalvo = data.save(cartaoModel);
        return getCartao(cartaoSalvo);
    }

    @Override
    public List<Cartao> buscarPor(Long id) {
        var userModel = userData.findById(id).orElseThrow();
        var response = data.findCartaoModelByUser(userModel);
        return response.stream().map(this::getCartao).collect(Collectors.toList());
    }

    @Override
    public Page<Cartao> findAll(PageRequest pageRequest) {
        var cartaoModelPage = data.findAll(pageRequest);

        return cartaoModelPage.map(new Function<CartaoModel, Cartao>() {
            @Override
            public Cartao apply(CartaoModel model) {
                var userModel = model.getUser();
                var user = new User(userModel.getId(), userModel.getName(), userModel.getEmail(), userModel.getPassword(), userModel.getEndereco(), userModel.getCep(), userModel.getBairro(), userModel.getCidade());
                return  new Cartao(model.getId(), model.getNumero(), model.getNome(), model.getVencimento(), model.getCvv(), user);
            }
        });
    }

    private CartaoModel getCartaoModel(Cartao cartao) {
        var cartaoModel = new CartaoModel();
        cartaoModel.setId(null);
        cartaoModel.setNome(cartao.getNome());
        cartaoModel.setNumero(cartao.getNumero());
        cartaoModel.setCvv(cartao.getCvv());
        cartaoModel.setVencimento(cartao.getVencimento());
        cartaoModel.setUser(userData.getById(cartao.getUser().getId()));
        return cartaoModel;
    }

    private Cartao getCartao(CartaoModel cartaoModel) {
        return new Cartao(cartaoModel.getId(), cartaoModel.getNumero(), cartaoModel.getNome(), cartaoModel.getVencimento(), cartaoModel.getCvv(), getUser(cartaoModel.getUser()));
    }

    private User getUser(UserModel userModel) {
        return new User(
                userModel.getId(),
                userModel.getName(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getEndereco(),
                userModel.getCep(),
                userModel.getBairro(),
                userModel.getCidade()
        );
    }
}
