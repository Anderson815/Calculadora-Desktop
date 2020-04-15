package calculadora;

import javax.swing.JOptionPane;

public class Matematica {
    //Atributos
    private float[] numeros = new float[20];
    private int[] operacoes = new int[20];
    private int indice = 0;
    float resultado = 0;
  //  private int[] teste = new int[20];
    
    /* Solução para usar de forma geral
    public float igual(){
        float resultado = 0, resultado_posterior = 0;
        
        for(int contador_indice = 0; contador_indice < 19; contador_indice++){
            switch(this.operacoes[contador_indice]){
                case 1:
                    resultado_posterior = this.adicao(this.numeros[contador_indice], this.numeros[contador_indice + 1]);
                    break;
                case 2:
                    resultado_posterior = this.subtracao(this.numeros[contador_indice], this.numeros[contador_indice + 1]);
                    break;
                case 3:
                    resultado_posterior = this.multiplicacao(this.numeros[contador_indice], this.numeros[contador_indice + 1]);
                    break;
                case 4:
                    resultado_posterior = this.divicao(this.numeros[contador_indice], this.numeros[contador_indice + 1]);
                    break;
            }
            //resultado = resultado_posterior;
            this.numeros[contador_indice + 1] = resultado_posterior;
            resultado = this.numeros[contador_indice + 1];
        }
        return resultado;
    }
    */
    
    
    public float igual(){       
        
        float resultado_temporario = 0;
        
        float etapa2N[] = new float[20];
        int etapa2O[] = new int[20];
        int indice = 0;
        
        int etapa_expressao = 1;
        
        do{
            for(int contador = 0; contador < 20; contador++){
                if(etapa_expressao == 1){
                    if(this.operacoes[contador] == 3){
                        resultado_temporario = this.multiplicacao(this.numeros[contador], this.numeros[contador + 1]);
                        this.numeros[contador + 1] = resultado_temporario;
                    }else if(this.operacoes[contador] == 4){
                        resultado_temporario = this.divicao(this.numeros[contador], this.numeros[contador + 1]);
                        this.numeros[contador + 1] = resultado_temporario;
                    }else{
                        etapa2N[indice] = this.numeros[contador];
                        etapa2O[indice] = this.operacoes[contador];
                        indice++;
                    }
                    
                    if(contador == 19){
                        etapa_expressao = 2;
                    }
                }else{
                    if(etapa2O[contador] == 1){
                        resultado_temporario = this.adicao(etapa2N[contador], etapa2N[contador + 1]);
                        etapa2N[contador + 1] = resultado_temporario;
                    }else if(etapa2O[contador] == 2){
                        resultado_temporario = this.subtracao(etapa2N[contador], etapa2N[contador + 1]);
                        etapa2N[contador + 1] = resultado_temporario;
                    }else{
                        this.setResultado(etapa2N[contador]);
                        etapa_expressao = 0;
                        break;
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
        this.numeros[this.getIndice()] = numero;
        if(this.getIndice() <= 19){
            this.operacoes[this.getIndice()] = operacao;
        }
        this.setIndice(this.getIndice() + 1);
    }
        
    public void apagaExpressao(){
        for(int indice_set = 0; indice_set < 20; indice_set++){
            this.numeros[indice_set] = 0;
            if(indice_set < 20){
                this.operacoes[indice_set] = 0;
            }
        }
        this.setIndice(0);
        this.setResultado(0);
    }
     
    public float getNumero (int indice){
        return this.numeros[indice];
    }
    
    public void setNumero(int indice, float valor){
        this.numeros[indice] = valor;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }
    
    
}
