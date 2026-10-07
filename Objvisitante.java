public class Objvisitante {
    private String visitante;
    private int idVisitante;
    private int identificación;
    private String funcionario;
    private int estado; //1: en espera (por defecto con cada refgistro) 2: llamado.
    //3. no responde 4: Atendido 5: Cancelar turno;
    public Objvisitante() {
    }

    public Objvisitante(int estado, String visitante, int idVisitante, int identificación, String funcionario) {
        this.visitante = visitante;
        this.idVisitante = idVisitante;
        this.identificación = identificación;
        this.funcionario = funcionario;
        this.estado = estado;

        
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }

    public int getIdentificación() {
        return identificación;
    }

    public void setIdentificación(int identificación) {
        this.identificación = identificación;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    

}
