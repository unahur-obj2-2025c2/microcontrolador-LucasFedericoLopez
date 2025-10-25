package ar.unahur.edu.obj2.patroncommand.operaciones;

import java.util.List;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class IFNZ implements Operable {
    private List<Operable> instrucciones;

    public IFNZ(List<Operable> instrucciones) {
        this.instrucciones = instrucciones;
    }

    @Override
    public void execute(Programable micro) {
        if (micro.getAcumuladorA()!= 0) {
            for (Operable operable : instrucciones) {
                operable.execute(micro);
                micro.incProgramCounter();
            }
        }
    }

    @Override
    public void undo(Programable micro) {
        for (int i = instrucciones.size()-1; i>=i; i--) {
            instrucciones.get(i).undo(micro);
        }
    }

}
