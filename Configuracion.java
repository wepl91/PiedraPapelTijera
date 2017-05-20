package PPTLS;

import java.util.ArrayList;

import java.util.HashMap;

public class Configuracion {

    private ArrayList<String> elementos;

    private HashMap<String,ArrayList<String>> elementosParecidos;

    private ArrayList <String> 	ganadores;

    private ArrayList <String>  perdedores;

    public Configuracion(){

        elementos = new ArrayList <String>();

        ganadores =new ArrayList<String>();

        perdedores =new ArrayList<String>();

        elementosParecidos=new HashMap <String, ArrayList<String>>();

    }

    public void agregarElemento(String elem){

        if (!elementos.contains(elem)){

            elementos.add(elem);

            ArrayList <String> innerArray=new ArrayList<String>();

            elementosParecidos.put(elem, innerArray);

        }

    }

    public void agregarElementoParecido(String base, String parecido){

        if(!elementosParecidos.containsKey(base)){

            throw new RuntimeException("El elemento base ingresado es invalido");

            return;

        }

        for (String key:elementosParecidos.keySet()){

            if(elementosParecidos.get(key).contains(parecido)){

                throw new RuntimeException("el elemento parecido ingresado ya existe");

                return;

            }

        }

        elementosParecidos.get(base).add(parecido);

    }

    public void agregarRegla(String ganador,String perdedor){

        boolean valida=true;

        if(!elementos.contains(ganador) || !elementos.contains(perdedor)){

            throw new RuntimeException("Alguno de los elementos no pertenece a los elementos base");

            return;

        }

        if(ganador.equals(perdedor)){

            // un elemento no puede ganarse a si mismo

            throw new RuntimeException( "Un elemento no puede ganarse a si mismo");

            return;

        }

        if(ganador.isEmpty()&&perdedor.isEmpty()){

            //si estan vacios los agrego directamente

            ganadores.add(ganador);

            perdedores.add(perdedor);

        }else{

            if(ganadores.size()>=((elementos.size() - 1) / 2) * elementos.size()){

               throw new RuntimeException("ya no se pueden agregar mas reglas");

            }else{

                //chequea que no se agregen mas reglas de las permitidas

                if((ganadores.contains(ganador)&& perdedores.contains(perdedor))||(ganadores.contains(perdedor)&& perdedores.contains(ganador))){

                    for(int i=0;i<ganadores.size();i++){

                        if(ganadores.get(i).equals(ganador)&& perdedores.get(i).equals(perdedor)){

                            //la regla ya esta presente
                            System.out.println("la regla  le gana a  ya esta presente");

                            valida=false;

                        }

                        if(perdedores.get(i).equals(ganador)&& ganadores.get(i).equals(perdedor)){
                            //la regla ya se encuentra, pero al revez
                           throw new RuntimeException("la regla  le gana a  se contradice con alguna anterior");

                            valida=false;

                        }

                    }

                }

                if(valida){

                    ganadores.add(ganador);

                    perdedores.add(perdedor);

                }

            }

        }

    }

    public boolean verificada(){

        if(elementos.size()<=1 || elementos.size()%2==0){

            throw new RuntimeException("La cantidad de elementos no es correcta, debe ser impar y mayor que 1");

            return false;

        }

        if (ganadores.size()!=((elementos.size() - 1) / 2) * elementos.size()){

            throw new RuntimeException("Hasta que no esten todas las reglas, no se puede jugar");

            return false;

        }

        return true;

    }

    public String elegirGanador(String jugador1, String jugador2){

        if(entregarElemBase(jugador1).equals(entregarElemBase(jugador2))){

            return "empate";

        }else{

            for(int i=0;i<ganadores.size();i++){

                if(ganadores.get(i).equals(entregarElemBase(jugador1))&&perdedores.get(i).equals(entregarElemBase(jugador2))){

                    return jugador1;

                }else if(ganadores.get(i).equals(entregarElemBase(jugador2))&&perdedores.get(i).equals(entregarElemBase(jugador1))){

                    return jugador2;

                }

            }

        }

        return null;

    }

    public String entregarElemBase(String parecido){

        for (String key:elementosParecidos.keySet()){

            if(elementosParecidos.get(key).contains(parecido)){

                return key;

            }

        }

        throw new RuntimeException("el elemento  no se corresponde con ningun objeto base");

    }

}
