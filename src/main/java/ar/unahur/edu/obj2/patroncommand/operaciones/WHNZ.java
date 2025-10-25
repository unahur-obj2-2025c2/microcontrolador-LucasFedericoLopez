package ar.unahur.edu.obj2.patroncommand.operaciones;

import java.util.List;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class WHNZ implements Operable{
    
    private List<Operable> instrucciones;

    public WHNZ(List<Operable> instrucciones) {
        this.instrucciones = instrucciones;
    }

    @Override
    public void execute(Programable micro) {
        while (micro.getAcumuladorA() != 0) {
            for (Operable operable : instrucciones) {
                operable.execute(micro);
                micro.incProgramCounter();
            }
        }
    }

    @Override
    public void undo(Programable micro) {
        //Nose como implementarlo.
    }

}
