package tarefas;
import tarefas.Prioridade;

import java.util.Comparator;

public class Tarefa implements Comparable<Tarefa> {
    private String titulo;
    private boolean status;
    private Prioridade prioridade;

    public Tarefa(String titulo,boolean status, Prioridade prioridade){
        this.titulo = titulo;
        this.status = status;
        this.prioridade = prioridade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public int compareTo(Tarefa outraTarefa) {
        return this.prioridade.compareTo(outraTarefa.prioridade);
    }

    @Override
    public String toString() {
        return "%s | %s | %s".formatted(titulo,prioridade,status ? "Concluída" : "Pendente");
    }
}
