package pl.matkan.computerapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Computer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private int ddrType;
    private int Mhz;
    private int memorySize;

    public Computer(){
    }
    public Computer(int ddrType, int mhz, int memorySize) {
        this.ddrType = ddrType;
        Mhz = mhz;
        this.memorySize = memorySize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDdrType() {
        return ddrType;
    }

    public void setDdrType(int ddrType) {
        this.ddrType = ddrType;
    }

    public int getMhz() {
        return Mhz;
    }

    public void setMhz(int mhz) {
        Mhz = mhz;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }
}
