package ar.unahur.edu.obj2.patroncommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.operaciones.ADD;
import ar.unahur.edu.obj2.patroncommand.operaciones.LODVval;
import ar.unahur.edu.obj2.patroncommand.operaciones.LODaddr;
import ar.unahur.edu.obj2.patroncommand.operaciones.NOP;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;
import ar.unahur.edu.obj2.patroncommand.operaciones.STRaddr;
import ar.unahur.edu.obj2.patroncommand.operaciones.SWAP;

public class testsMicrocontrolador {
    Microcontrolador micro = new Microcontrolador();
    
    @BeforeEach 
    void setUp() {
        micro.reset();
    }

    @Test
    void alRealizar3OperacionesNOP_ElProgramCounterPasaDe0a3() {
        List<Operable> programa = List.of(
            new NOP(),
            new NOP(),
            new NOP()
        );
        micro.run(programa);
        assertEquals(3, micro.getProgramCounter());
    }

    @Test
    void alRealizarLaSuma20mas17ElAcumuladorAEs37_ElProgramCounterPasaDe0a4() {
        List<Operable> programa = List.of(
            new LODVval(20),
            new SWAP(),
            new LODVval(17),
            new ADD()
        );
        micro.run(programa);
        assertEquals(37, micro.getAcumuladorA());
        assertEquals(4, micro.getProgramCounter());
    }

    @Test
    void alRealizarLaSuma2mas8mas5ElAcumuladorAEs15_ElAcumuladorBEs0() {
        List<Operable> programa = List.of(
            new LODVval(2),
            new STRaddr(0),
            new LODVval(8),
            new SWAP(),
            new LODVval(5),
            new ADD(),
            new SWAP(),
            new LODaddr(0),
            new ADD()
        );
        micro.run(programa);
        assertEquals(15, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
    }
}
