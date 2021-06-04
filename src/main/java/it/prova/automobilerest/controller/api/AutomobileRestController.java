package it.prova.automobilerest.controller.api;

import it.prova.automobilerest.model.Automobile;
import it.prova.automobilerest.service.AutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/automobile", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AutomobileRestController {

    @Autowired
    private AutomobileService automobileService;

    @GetMapping("/{idInput}")
    public Automobile getAutomobile(@PathVariable(required = true) Long idInput) {
        return automobileService.get(idInput);
    }

    @GetMapping
    public List<Automobile> getAll() {
        return automobileService.listAll();
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Automobile>> searchAndPagination(@RequestBody Automobile automobileExample,
                                                                @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,
                                                                @RequestParam(defaultValue = "id") String sortBy) {

        Page<Automobile> results = automobileService.searchAndPaginate(automobileExample, pageNo, pageSize, sortBy);

        return new ResponseEntity<Page<Automobile>>(results, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public Automobile createNewAutomobile(@RequestBody Automobile automobileInput) {
        return automobileService.save(automobileInput);
    }

    @PutMapping("/{id}")
    public Automobile updateAutomobile(@RequestBody Automobile automobileInput, @PathVariable Long id) {
        Automobile automobileToUpdate = automobileService.get(id);
        automobileToUpdate.setMarca(automobileInput.getMarca());
        automobileToUpdate.setModello(automobileInput.getModello());
        automobileToUpdate.setTarga(automobileInput.getTarga());
        automobileToUpdate.setDataImmatricolazione(automobileInput.getDataImmatricolazione());
        automobileToUpdate.setInProduzione(automobileInput.getInProduzione());
        return automobileService.save(automobileToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteAutomobile(@PathVariable(required = true) Long id) {
        automobileService.delete(automobileService.get(id));
    }
}