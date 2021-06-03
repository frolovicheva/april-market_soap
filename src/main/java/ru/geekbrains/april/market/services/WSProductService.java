package ru.geekbrains.april.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.april.market.models.WSProduct;
import ru.geekbrains.april.market.repositories.WSProductRepository;
import ru.geekbrains.april.market.wsproducts.Wsproduct;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WSProductService {
    private final WSProductRepository wsProductRepository;

    public static final Function<WSProduct, Wsproduct> functionEntityToSoap = se -> {
        Wsproduct p = new Wsproduct ();
        p.setId(se.getId());
        p.setTitle (se.getTitle ());
        p.setPrice(se.getPrice());
        return p;
    };

    public List<Wsproduct> getAllWSProducts() {
        return wsProductRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public Wsproduct getById(Long id) {
        return wsProductRepository.findById(id).map(functionEntityToSoap).get();
    }
}
