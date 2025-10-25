package ar.unahur.edu.obj2.patroncommand.operaciones;

import java.util.ArrayList;
import java.util.List;


public class Programa {
    private List<Operable> listaComandos = new ArrayList<>();

    public void agregarComando(Operable comando) {
        listaComandos.add(comando);
    }

    public List<Operable> getListaComandos() {
        return listaComandos;
    }

}
