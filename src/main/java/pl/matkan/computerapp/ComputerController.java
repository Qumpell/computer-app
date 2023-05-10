package pl.matkan.computerapp;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("api/computer")
public class ComputerController {
    private final ComputerRepository computerRepository;
    private final ComputerModelAssembler assembler;

    public ComputerController(ComputerRepository computerRepository, ComputerModelAssembler assembler) {
        this.computerRepository = computerRepository;
        this.assembler = assembler;
    }


    @GetMapping("/all")
    public CollectionModel<EntityModel<Computer>> getAll(){
        List<EntityModel<Computer>> computers =  computerRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(computers, linkTo(methodOn(ComputerController.class).getAll()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Computer> getOne(@PathVariable Long id){
        Computer computer = computerRepository.findById(id)
                .orElseThrow(() -> new ComputerNotFoundException(id));

        return assembler.toModel(computer);


    }

    @PostMapping("/add")
    public Computer createComputer(@RequestBody Computer computer){
        return computerRepository.save(computer);
    }

    @PutMapping("/{id}")
    public Computer updateComputer(@RequestBody Computer computer,@PathVariable Long id){
        return computerRepository.findById(id)
                .map(comp -> {
                    comp.setDdrType(computer.getDdrType());
                    comp.setMhz(computer.getMhz());
                    comp.setMemorySize(computer.getMemorySize());
                    return computerRepository.save(comp);
                })
                .orElseGet(() -> {
                    computer.setId(id);
                    return computerRepository.save(computer);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteComputer(@PathVariable Long id){
        computerRepository.deleteById(id);
    }
}
