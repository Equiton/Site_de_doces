package com.doces.doces.Enum;


import java.util.HashMap;
import java.util.Map;

public enum  FormaPagamento {
   
    DINHEIRO("DINHEIRO"),
    CARTAO("CARTAO DE CREDITO"),
    PIX_EMAIL("CHAVE PIX POR EMAIL"),
    PIX_NUMERO("CHAVE PIX POR NUMERO DE CELULAR"),
    PIX_CPF("CHAVE PIX POR CPF"),
    PIX_ALEATORIA("PIX POR CHAVE ALEATORIA");

    private String valor;
    
    FormaPagamento(String valor){
        this.valor=valor;
    }
        
    private static final Map <String, FormaPagamento> funcaoPorTipo = new HashMap<>();
    
    
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    @Override
    public String toString(){
        return valor;
    }


    public static FormaPagamento porTipo(String valor){

        for (FormaPagamento t: FormaPagamento.values()){
            if(t.valor.equalsIgnoreCase(valor)){
                return t;
            }
        }
        return null;
    }
    public static FormaPagamento categoriaPorTipo(String valor) {
        return funcaoPorTipo.get(valor);
    }
}