public class VistaBatalla {

    // Constructor
    public VistaBatalla() {

    }

    // Muestra el inicio de la batalla
    public void mostrarInicio() {

        System.out.println("=================================");
        System.out.println("       BATALLA POKEMON");
        System.out.println("=================================");
        System.out.println("La batalla ha comenzado.");
        System.out.println();
    }

    // Muestra la informacion de una ronda
    public void mostrarRonda(int numeroRonda, Ronda ronda) {

    Pokemon atacante = ronda.getAtacante();
    Pokemon defensor = ronda.getDefensor();


    System.out.println("=================================");
    System.out.println("           RONDA " + numeroRonda);
    System.out.println("=================================");


    // =====================================
    // ATACANTE
    // =====================================

    System.out.println();
    System.out.println("ATACANTE: " + atacante.getNombre());
    System.out.println("Tipo: " + atacante.getTipo());
    System.out.println("Ataque base: " + atacante.getAtaque());

    System.out.println(
            "Habilidad: "
            + atacante.getHabilidadEspecial().getNombre()
    );


    if (ronda.getHabilidadAtacanteActivada()) {

        System.out.println("La habilidad se activo.");

        System.out.println(
                "Potenciador: +"
                + ronda.getPotenciadorAtacante()
                + "%"
        );

    } else {

        System.out.println("La habilidad no se activo.");
    }


    System.out.println(
            "Ataque efectivo: "
            + ronda.getAtaqueEfectivo()
    );


    // =====================================
    // DEFENSOR
    // =====================================

    System.out.println();
    System.out.println("DEFENSOR: " + defensor.getNombre());
    System.out.println("Tipo: " + defensor.getTipo());
    System.out.println("Defensa base: " + defensor.getDefensa());

    System.out.println(
            "Habilidad: "
            + defensor.getHabilidadEspecial().getNombre()
    );


    if (ronda.getHabilidadDefensorActivada()) {

        System.out.println("La habilidad se activo.");

        System.out.println(
                "Potenciador: +"
                + ronda.getPotenciadorDefensor()
                + "%"
        );

    } else {

        System.out.println("La habilidad no se activo.");
    }


    System.out.println(
            "Defensa efectiva: "
            + ronda.getDefensaEfectiva()
    );


    
    System.out.println();
    System.out.println(
            "Efecto de tipo: "
            + ronda.getEfectoTipo()
    );


    // =====================================
// RESULTADO
// =====================================

System.out.println();
System.out.println("RESULTADO DEL ENFRENTAMIENTO");

System.out.println(
        "Ataque efectivo: "
        + ronda.getAtaqueEfectivo()
);

System.out.println(
        "Efecto de tipo: "
        + ronda.getEfectoTipo()
);

System.out.println(
        "Defensa efectiva: "
        + ronda.getDefensaEfectiva()
);

System.out.println();

System.out.println(
        "Calculo: "
        + ronda.getAtaqueEfectivo()
        + " + "
        + ronda.getEfectoTipo()
        + " - "
        + ronda.getDefensaEfectiva()
        + " = "
        + ronda.getAtaqueTotal()
);

System.out.println();


if (ronda.getAtaqueTotal() > 0) {

    System.out.println(
            "El ataque supero la defensa."
    );

} else if (ronda.getAtaqueTotal() < 0) {

    System.out.println(
            "El defensor resistio el ataque."
    );

} else {

    System.out.println(
            "El ataque y la defensa fueron iguales."
    );
}


System.out.println(
        "Ganador de la ronda: "
        + ronda.getGanador()
);

System.out.println();
    }

    // Muestra el ganador final de la batalla
    public void mostrarGanador(String ganador) {

        System.out.println("=================================");
        System.out.println("        FIN DE LA BATALLA");
        System.out.println("=================================");

        if (ganador.equals("Empate")) {
            System.out.println("La batalla termino en empate.");
        } else {
            System.out.println("Ganador: " + ganador);
        }
    }
}