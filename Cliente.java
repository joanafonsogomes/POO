public class Cliente extends Pessoa{
    private double x;
    private double y;
    
    /**
    *CONSTRUTOR VAZIO
    */
    public Cliente(){
        this.x = 0.0;
        this.y = 0.0;
    }
    
    /**
    *CONSTRUTOR PARAMETERIZADO
    */
    public Cliente(double cx, double cy){
        this.x = cx;
        this.y = cy;
    }
    
    /**
    *CONSTRUTOR DE COPIA
    */
    public Cliente(Cliente outroCliente){
        this.x = outroCliente.getX();
        this.y = outroCliente.getY();
    }
    
//GETTERS E SETTERS

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

}
