import tarefas.Prioridade;
import tarefas.Tarefa;

import javax.swing.plaf.IconUIResource;

void main() {
    Scanner in = new Scanner(System.in);
    List<Tarefa> listaTarefas = new ArrayList<Tarefa>();
    listaTarefas.add(new Tarefa("Estudar Java", false, Prioridade.ALTA));
    listaTarefas.add(new Tarefa("Terminar projeto", false, Prioridade.MÉDIA));
    listaTarefas.add(new Tarefa("Revisar PR do Claude Code", true, Prioridade.BAIXA));
    listaTarefas.add(new Tarefa("Corrigir bug no compareTo", false, Prioridade.ALTA));
    listaTarefas.add(new Tarefa("Estudar Collections", true, Prioridade.MÉDIA));
    listaTarefas.add(new Tarefa("Organizar mesa", false, Prioridade.BAIXA));
    listaTarefas.add(new Tarefa("Ler documentação Spring", false, Prioridade.MÉDIA));
    listaTarefas.add(new Tarefa("Atualizar currículo", true, Prioridade.ALTA));
    listaTarefas.add(new Tarefa("Testar TaskJava", false, Prioridade.BAIXA));


    boolean rodar = true;
// menu
    while (rodar) {
        System.out.println("""
                
                ****************************
                            MENU
                
                1 - Adicionar uma tarefa nova
                2 - Listar todas as tarefas, ordenadas da prioridade mais alta pra mais baixa
                3 - Marcar uma tarefa como concluída 
                4 - Remover uma tarefa 
                5 - Sair do programa
                
                ****************************""");
        int opcao = in.nextInt();
        in.nextLine();

        switch (opcao) {

            // Cria tarefa
            case 1:
                System.out.print("Digite o Título da tarefa: ");
                String tituloTarefa = in.nextLine();
                System.out.print("""
                        Qual o status da tarefa? (0 -> Pendente || 1 -> Concluída): """);
                int statusTarefa = in.nextInt();
                boolean concluido = (statusTarefa == 1);
                System.out.println("""
                        
                        Digite a prioridade da tarefa
                        (1 - BAIXA || 2 - MÉDIA || 3 - ALTA): """);
                int opcaoPrioridade = in.nextInt();
                in.nextLine();
                Prioridade prioridade = switch (opcaoPrioridade) {
                    case 1 -> Prioridade.BAIXA;
                    case 2 -> Prioridade.MÉDIA;
                    case 3 -> Prioridade.ALTA;
                    default -> Prioridade.BAIXA;
                };
                Tarefa task = new Tarefa(tituloTarefa, concluido, prioridade);
                listaTarefas.add(task);
                System.out.println("Tarefa criada!");
                break;

            // Lista tarefas
            case 2:
                Collections.sort(listaTarefas);
                System.out.println("""
                        Lista das tarefas:
                        
                        """);
                for (Tarefa tarefa : listaTarefas) {
                    System.out.println(tarefa);
                }
                break;
//    Marcar task as concluída
            case 3:
                System.out.println("Abaixo está as tarefas PENDENTES:");
                Collections.sort(listaTarefas);
                for (int i = 0; i < listaTarefas.size(); i++) {
                    Tarefa tarefa = listaTarefas.get(i);
                    if (!tarefa.isStatus()) {
                        System.out.printf("%d - %s\n", (i + 1), tarefa);
                    }
                }

                System.out.println("Digite o n° da tarefa que deseja CONCLUIR");
                int escolha = in.nextInt();
                in.nextLine();
                System.out.printf("Tarefa '%s' foi concluída!", listaTarefas.get(escolha - 1).getTitulo());
                listaTarefas.get(escolha - 1).setStatus(true);
                break;

//    remove task
            case 4:
                System.out.println("Abaixo está TODAS as tarefas:");
                for (int i = 0; i < listaTarefas.size(); i++) {
                    Tarefa tarefa = listaTarefas.get(i);
                    System.out.printf("%d - %s\n", (i + 1), tarefa);
                }


                System.out.println("\nDigite abaixo o n° da tarefa que deseja excluir");
                int opcaoRemover = in.nextInt();
                System.out.printf("\nTarefa '%s' foi removida da lista!", listaTarefas.get(opcaoRemover - 1).getTitulo());
                listaTarefas.remove(opcaoRemover - 1);

                break;
//    finish system
            case 5:
                System.out.println("Encerrando o TaskJava. Até logo!");
                rodar = false;
                break;

            default:
                break;
        }
    }


}