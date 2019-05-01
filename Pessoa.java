import java.time.LocalDate;

public abstract class Pessoa {
   private String email;
   private String nome;
   private String password;
   private String morada;
   private LocalDate data;

    /**
    *CONSTRUTOR VAZIO
    */
    public Pessoa() {
            this.email = new String();
            this.nome = new String();
            this.password = new String();
            this.morada = new String();
            this.data = LocalDate.now();
    }
   
    /**
     *CONSTRUTOR PARAMETERIZADO
     */
    public Pessoa(String email, String nome, String password, String morada, LocalDate data) {
            this.email = email;
            this.nome = nome;
            this.password = password;
            this.morada = morada;
            this.data = data;
    }

    /**
     *CONSTRUTOR DE COPIA
     */
    public Pessoa(Pessoa outraPessoa) {
            this.email = outraPessoa.getEmail();
            this.nome = outraPessoa.getNome();
            this.password = outraPessoa.getPassword();
            this.morada = outraPessoa.getMorada();
            this.data = outraPessoa.getData();
    }

//GETTERS E SETTERS
    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getPassword() {
        return password;
    }

    public String getMorada() {
        return morada;
    }

    public LocalDate getData() {
        return data;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     *EQUALS
     */
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        
        Pessoa that = (Pessoa) o;
        return (this.email.equals(that.getEmail())
                && this.nome.equals(that.getNome())
                && this.password.equals(that.getPassword())
                && this.morada.equals(that.getMorada())
                && this.data.equals(that.getData()));
    }
    
    /**
     *TO STRING
     */
    public String toString(){
        StringBuffer sb = new StringBuffer("Pessoa: ");
        sb.append("Email: ").append(this.email).append(", ");
        sb.append("Nome: ").append(this.nome).append(", ");
        sb.append("Password: ").append(this.password).append(", ");
        sb.append("Morada: ").append(this.morada).append(", ");
        sb.append("Data: ").append(this.data).append(", ");
        return sb.toString();
    }
}