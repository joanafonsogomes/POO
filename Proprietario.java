

public class Proprietario extends Pessoa{
    private int avaliacao;
    
    /**
    *CONSTRUTOR VAZIO
    */
    public Proprietario(){
        this.avaliacao = 0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Proprietario(int a){
        this.avaliacao = a;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Proprietario(Proprietario outroProprietario){
        this.avaliacao = outroProprietario.getAvaliacao();
    }
    
//GETTERS E SETTERS

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

   
    
    /**
     *EQUALS
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Proprietario that = (Proprietario) o;
        return (this.avaliacao == that.getAvaliacao());
    }
    
    /**
     *TO STRING
     */
    
    public String toString(){
        StringBuffer sb = new StringBuffer("Proprietario: ");
        sb.append("Avaliação: ").append(this.avaliacao).append(", ");
        return sb.toString();
    }
}

