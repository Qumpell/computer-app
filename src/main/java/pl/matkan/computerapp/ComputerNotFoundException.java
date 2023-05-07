package pl.matkan.computerapp;

public class ComputerNotFoundException extends RuntimeException{

    ComputerNotFoundException(Long id){
        super("Could not find computer " + id);
    }
}
