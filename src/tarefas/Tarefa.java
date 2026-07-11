import java.util.ArrayList;

public class Tarefa {
    private String titulo;
    enum Prioridade {ALTA, MÉDIA, BAIXA};
    private Prioridade prioridade;
    private boolean status;

    public Tarefa(String titulo, Prioridade prioridade, boolean status){
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.status = status;
    }


}
