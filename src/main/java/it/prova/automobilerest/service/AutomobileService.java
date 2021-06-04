package it.prova.automobilerest.service;

import it.prova.automobilerest.model.Automobile;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AutomobileService {

    List<Automobile> listAll();

    Page<Automobile> searchAndPaginate(Automobile automobileExample, Integer pageNo, Integer pageSize, String sortBy);

    Automobile get(Long idInput);

    Automobile save(Automobile input);

    void delete(Automobile input);
}
