package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class STRaddr implements Operable{

    private Integer direccionMemoria;
    private Integer direccionPrevia;

    public STRaddr(Integer direccionMemoria) {
        this.direccionMemoria = direccionMemoria;
    }

    @Override
    public void execute(Programable micro) {
        direccionPrevia = micro.getAddr(direccionMemoria);
        micro.setAddr(direccionMemoria);
    }

    @Override
    public void undo(Programable micro) {
        micro.setAcumuladorA(direccionPrevia);
        micro.setAddr(direccionMemoria);
    }

}
