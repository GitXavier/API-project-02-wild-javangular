package com.wildapi.api.services.algo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/algos")
public class AlgoController {
    @Autowired
    AlgoService service;

    @GetMapping()
    public List<Algo> getAlgos() {
        return service.getAll();
    }

    @GetMapping("/battle/{battleId}")
    public List<Algo> getAlgosByBattleId(@PathVariable(value = "battleId") long battleId) {
        return service.getAlgosByBattleId(battleId);
    }

    @PostMapping()
    public Algo createAlgo(@RequestBody Algo algo) {
        return service.save(algo);
    }

    @PutMapping("/{id}")
    public Algo updateAlgo(@RequestBody AlgoPutDTO algoPutDTO, @PathVariable(value = "id") long id) {
        return service.update(algoPutDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAlgo(@PathVariable(value = "id") long id) {
        service.delete(id);
    }
}