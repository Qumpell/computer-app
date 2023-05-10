package pl.matkan.computerapp;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ComputerModelAssembler implements RepresentationModelAssembler<Computer, EntityModel<Computer>> {

    @Override
    public EntityModel<Computer> toModel(Computer computer) {

        return EntityModel.of(computer,
                linkTo(methodOn(ComputerController.class).getOne(computer.getId())).withSelfRel(),
                linkTo(methodOn(ComputerController.class).getAll()).withRel("computers"));
    }
}
