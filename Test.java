package PPTLS;

public class Test {


    public static void main(String[] args) {


        ///////TEST POSITIVO//////

        Configuracion c=new Configuracion();

        ///////AGRAGAR ELEMENTOS//////

        c.agregarElemento ("piedra"); //objeto base

        c.agregarElemento ("papel");

        c.agregarElemento ("tijera");

        c.agregarElemento ("lagarto");

        c.agregarElemento ("spock");

        //////AGRAGAR ELEMENTOS PARECIDOS///////

        c.agregarElementoParecido ("piedra","piedra roja");  //objeto base , objeto parecido

        c.agregarElementoParecido ("piedra","piedra verde");

        c.agregarElementoParecido ("piedra","piedra azul");

        c.agregarElementoParecido ("piedra","piedra violeta");

        c.agregarElementoParecido ("papel","papel A4");

        c.agregarElementoParecido ("tijera","tijeras oxidadas");

        c.agregarElementoParecido ("spock","spock jubilado");

        c.agregarElementoParecido ("lagarto","lagarto juancho");

        //////REGLAS//////

        c.agregarRegla("tijera","papel"); //primero le gana a segundo

        c.agregarRegla("papel","piedra");

        c.agregarRegla("piedra","lagarto");

        c.agregarRegla("lagarto","spock");

        c.agregarRegla("spock","tijera");

        c.agregarRegla("tijera","lagarto");

        c.agregarRegla("lagarto","papel");

        c.agregarRegla("papel","spock");

        c.agregarRegla("spock","piedra");

        c.agregarRegla("piedra","tijera");

        //////CREAR JUEGO//////

        Juego j=new Juego (c);

        //////JUGAR//////

        j.jugar("spock jubilado", "piedra azul"); //jugador1 , jugador 2


        ///////TEST NEGATIVO////////

        Configuracion c2=new Configuracion();

        ///////AGRAGAR ELEMENTOS//////

        c2.agregarElemento ("piedra"); //objeto base

        c2.agregarElemento ("papel");

        c2.agregarElemento ("tijera");

        c2.agregarElemento ("tijera"); ///Este elemento base esta repetido

        c2.agregarElemento("pelota"); ///La cantidad de elementos es par

        //////AGRAGAR ELEMENTOS PARECIDOS///////

        c2.agregarElementoParecido ("piedra","piedra roja");  //objeto base , objeto parecido

        c2.agregarElementoParecido ("piedra","piedra verde");

        c2.agregarElementoParecido ("piedra","piedra azul");

        c2.agregarElementoParecido ("piedra","piedra violeta");

        c2.agregarElementoParecido ("papel","papel A4");

        c2.agregarElementoParecido ("tijera","tijeras oxidadas");

        c2.agregarElementoParecido ("tijera","tijeras oxidadas"); //Este elemento parecido esta repetido

        //c2.agregarElementoParecido ("tijeras","tijeras oxidadas"); //Este elemento base no existe
        //////REGLAS//////

        c2.agregarRegla("tijera","papel"); //primero le gana a segundo

        c2.agregarRegla("papel","piedra");

        c2.agregarRegla("piedra","tijera");

        c2.agregarRegla("piedra","tijera"); //Esta regla ya existe

        c2.agregarRegla("piedra","piedra"); //Los elementos estan repetidos

        c2.agregarRegla("papel","tijera"); //Contradice a "tijera le gana a papel"

        //////CREAR JUEGO//////

        Juego j2=new Juego (c2);

        //////JUGAR//////

        j2.jugar("papel A4", "piedra azul"); //jugador1 , jugador 2


    }

}
