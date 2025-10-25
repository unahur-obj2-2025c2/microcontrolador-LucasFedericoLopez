package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class LODaddr implements Operable{

    private Integer direccionMemoria;
    private Integer contenidoPrevioA;

    public LODaddr(Integer direccionMemoria) {
        this.direccionMemoria = direccionMemoria;
    }

    @Override
    public void execute(Programable micro) {
        contenidoPrevioA = micro.getAcumuladorA();
        micro.setAcumuladorA(micro.getAddr(direccionMemoria));
    }

    @Override
    public void undo(Programable micro) {
        micro.setAcumuladorA(contenidoPrevioA);
    }

}
