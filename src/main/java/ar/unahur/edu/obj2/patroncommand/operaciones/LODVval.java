package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class LODVval implements Operable{
    private Integer valor;
    private Integer valorPrevio;

    public LODVval(Integer valor) {
        this.valor = valor;
    }

    @Override
    public void execute(Programable micro) {
        valorPrevio = micro.getAcumuladorA();
        micro.setAcumuladorA(valor);
    }

    @Override
    public void undo(Programable micro) {
        micro.setAcumuladorA(valorPrevio);
    }

}
