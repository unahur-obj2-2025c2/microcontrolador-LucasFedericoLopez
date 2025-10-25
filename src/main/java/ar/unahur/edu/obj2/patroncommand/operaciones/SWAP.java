package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class SWAP implements Operable{

    @Override
    public void execute(Programable micro) {
        int acumuladorA = micro.getAcumuladorA();
        micro.setAcumuladorA(micro.getAcumuladorB());
        micro.setAcumuladorB(acumuladorA);
    }

    @Override
    public void undo(Programable micro) {
        execute(micro);
    }

}
