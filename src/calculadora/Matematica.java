package calculadora;

import java.util.List;
import java.util.ArrayList;

/**
 * Operações e regras dos calculos
 */
public class Matematica {
    //Atributos
    //private float[] numeros = new float[20];
    //private int[] operacoes = new int[20];
    
    private List<Float> num = new ArrayList<>(); 
    private List<Integer> ope = new ArrayList<>();
    
    float resultado = 0;
    
    public float igual(){       
        
        float resultado_temporario = 0;     
        int etapa_expressao = 1;
        
        do{
            for(int contador = 0; contador < this.num.size(); contador++){
                if(etapa_expressao == 1){
                    //etapa 1 - Operações de multiplicação e divisão
                    if(this.ope.get(contador) == 3){
                        resultado_temporario = this.multiplicacao(this.num.get(contador), this.num.get(contador + 1));
                        this.num.set(contador, resultado_temporario);
                        
                        this.num.remove(contador + 1);
                        this.ope.remove(contador);
                        
                        contador--;
                    }else if(this.ope.get(contador) == 4){
                        resultado_temporario = this.divicao(this.num.get(contador), this.num.get(contador + 1));
                        this.num.set(contador, resultado_temporario); 
                        
                        this.num.remove(contador + 1);
                        this.ope.remove(contador);
                        
                        contador--;
                    }
                    
                    if(contador == this.num.size() - 1){
                        etapa_expressao = 2;
                    }
                    
                }else{
                    //etapa 2 - Operações de adição e subtração
                    if(this.ope.get(contador) == 1){
                        resultado_temporario = this.adicao(this.num.get(contador), this.num.get(contador + 1));
                        this.num.set(contador, resultado_temporario);

                        this.num.remove(contador + 1);
                        this.ope.remove(contador);

                        contador--;
                    }else if(this.ope.get(contador) == 2){
                        resultado_temporario = this.subtracao(this.num.get(contador), this.num.get(contador + 1));
                        this.num.set(contador, resultado_temporario);

                        this.num.remove(contador + 1);
                        this.ope.remove(contador);

                        contador--;
                    }else{
                        this.setResultado(this.num.get(0));
                        etapa_expressao = 0;
                    }               
                }                
            }
        }while(etapa_expressao == 2);
        
        return this.getResultado();
    }
    
    
    // Métodos das Operações
    
    private float adicao(float n1, float n2){
        float resultado = n1 + n2;
        return resultado;
    }
    
    private float subtracao(float n1, float n2){
        float resultado = n1 - n2;
        return resultado;
    }
    
    private float multiplicacao(float n1, float n2){
        float resultado = n1 * n2;
        return resultado;
    }
    
    private float divicao(float n1, float n2){
        float resultado = n1 / n2;
        return resultado;
    }
    
    // Métodos padrões
    
    public Matematica(){
        this.apagaExpressao();
    }

    public void gravarNumeroOperacao(float numero, int operacao){
        this.num.add(numero);
        this.ope.add(operacao);
    }
        
    public void apagaExpressao(){
        this.num.clear();
        this.ope.clear();   
        this.setResultado(0);
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }  
}
