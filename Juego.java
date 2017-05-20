package PPTLS;

public class Juego {

    private Configuracion config;

    public Juego (Configuracion c){

        config=c;

    }

    public int  jugar(String jugador1, String jugador2){
        if (config.verificada()){
            if (config.elegirGanador(jugador1, jugador2).equals("empate")){
                return 0 ; //Devuelve cero si es un empate
            }
            if (config.elegirGanador(jugador1, jugador2).equals(jugador1)){
                
                return 1; //Devuelve 1 si el ganador es el jugador 1
            }
            if (config.elegirGanador(jugador1, jugador2).equals(jugador2)){
                return 2; //Devuelve 2 si el ganador es el jugador 2
            }
        }
    }
}
