package ar.unahur.edu.obj2.patroncommand.microcontrolador;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

public class Microcontrolador implements Programable {
    private Integer acumuladorA = 0;
    private Integer acumuladorB = 0;
    private Integer pc;
    private Integer[] memoria = new Integer[1024];
    private List<Operable> historialOperaciones = new ArrayList<>();
    @Override
    public void run(List<Operable> operaciones) {
        try {
            for (Operable operable : operaciones) {
                operable.execute(this);
                this.incProgramCounter();
                historialOperaciones.add(operable);
            }
        } catch (Exception e){
            System.out.println("Error en instruccion " + getProgramCounter() + ": " + e.getMessage());
        }
    }
    @Override
    public void incProgramCounter() {
        pc++;
    }
    @Override
    public Integer getProgramCounter() {
        return pc;
    }
    @Override
    public void setAcumuladorA(Integer value) {
        this.acumuladorA = value;
    }
    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }
    @Override
    public void setAcumuladorB(Integer value) {
        this.acumuladorB = value;
    }
    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }
    @Override
    public void setAddr(Integer addr) {
        if (addr < 0 || addr >= 1024) {
            throw new IllegalArgumentException("Direccion fuera de rango");
        } else {
            memoria[addr] = acumuladorA;
        }
    }
    @Override
    public Integer getAddr(Integer addr) {
        if (addr < 0 || addr >= 1024) {
            throw new IllegalArgumentException("Direccion fuera de rango");
        } else {
            return memoria[addr];
        }
    }
    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        pc = 0;
        memoria = new Integer[1024];
        historialOperaciones = new ArrayList<>();
    }

    public void undo() {
        if (!historialOperaciones.isEmpty()) {
            Operable ultimaOperacion = historialOperaciones.get(historialOperaciones.size() - 1);
            ultimaOperacion.undo(this);
            pc--;
        }
    }

}
