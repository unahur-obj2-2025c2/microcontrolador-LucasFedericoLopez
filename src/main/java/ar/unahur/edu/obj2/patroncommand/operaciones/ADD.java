package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class ADD implements Operable{
    private Integer previoA;
    private Integer previoB;

    @Override
    public void execute(Programable micro) {
        previoA = micro.getAcumuladorA();
        previoB = micro.getAcumuladorB();
        int suma = previoA + previoB;
        micro.setAcumuladorA(suma);
        micro.setAcumuladorB(0);
    }

    @Override
    public void undo(Programable micro) {
        micro.setAcumuladorA(previoA);
        micro.setAcumuladorB(previoB);
    }

}
