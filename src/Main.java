import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaHospital sistema = new SistemaHospital();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Médico");
            System.out.println("2 - Cadastrar Paciente");
            System.out.println("3 - Agendar Consulta");
            System.out.println("4 - Listar Consultas de um Paciente");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Telefone: ");
                String telefone = scanner.nextLine();
                System.out.print("Status (true or false): ");
                String aux = scanner.nextLine();
                Boolean status = Boolean.parseBoolean(aux);
                sistema.cadastrarMedico(nome, cpf, telefone, status);

            } else if (opcao == 2) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Telefone: ");
                String telefone = scanner.nextLine();
                sistema.cadastrarPaciente(nome, cpf, idade, telefone);

            } else if (opcao == 3) {
                System.out.print("CPF do paciente: ");
                String cpf = scanner.nextLine();
                System.out.print("Data (dd/mm/aaaa): ");
                String data = scanner.nextLine();
                System.out.print("Horário (hh:mm): ");
                String horario = scanner.nextLine();
                System.out.print("Especialidade: ");
                String especialidade = scanner.nextLine();
                sistema.listarMedicosDisponiveis();
                System.out.print("Médico (0 para cancelar): ");
                String medico = scanner.nextLine();
                if (medico.equals("0")){
                    System.out.print("Consulta cancelada!");
                }
                else {
                    sistema.agendarConsulta(cpf, data, horario, especialidade, medico);
                }

            } else if (opcao == 4) {
                System.out.print("CPF do paciente: ");
                String cpf = scanner.nextLine();
                sistema.listarConsultasPaciente(cpf);

            } else if (opcao == 5) {
                System.out.println("\nSaindo...");
                break;
            } else {
                System.out.println("\nOpção inválida! Tente novamente.");
            }
        }  
        scanner.close(); 
    }
}