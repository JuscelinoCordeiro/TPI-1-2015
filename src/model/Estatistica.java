/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author jfilho
 */
public class Estatistica {
    
    //retornar um array de estatisticas
    public static int calculaTempoExecucaoProcesso(Processo p){
        int inicio = p.getInterrupcoes().get(0).getInicio();
        int termino = 0;
        List<Interrupcao> interrupcoes = p.getInterrupcoes();
        for(Interrupcao i : interrupcoes){
            
        }
        return (termino - inicio);
    }
    
}
