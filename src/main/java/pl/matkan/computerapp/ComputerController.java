package pl.matkan.computerapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/computer")
public class ComputerController {
    private final ComputerRepository computerRepository;

    public ComputerController(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }


    @GetMapping("/all")
    public List<Computer> getAll(){
        return computerRepository.findAll();
    }

    @GetMapping("/one/{id}")
    public Computer getOne(@PathVariable Long id){
        return computerRepository.findById(id)
                .orElseThrow(() -> new ComputerNotFoundException(id));
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
