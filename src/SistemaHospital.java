import java.util.ArrayList;

class SistemaHospital {
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();

    public void cadastrarPaciente(String nome, String cpf, int idade, String telefone) {
        pacientes.add(new Paciente(nome, cpf, idade, telefone));
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void cadastrarMedico(String nome, String cpf, String telefone, Boolean status) {
        medicos.add(new Medico(nome, cpf, telefone, status));
        System.out.println("Médico cadastrado com sucesso!");
    }

    public void agendarConsulta(String cpf, String data, String horario, String especialidade, String medico) {
        Paciente pacienteEncontrado = null;
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                pacienteEncontrado = p;
                break;
            }
        }
        if (pacienteEncontrado != null) {
            consultas.add(new Consulta(pacienteEncontrado, data, horario, especialidade, medico));
            System.out.println("Consulta agendada com sucesso!");
        } else {
            System.out.println("Paciente não encontrado!");
        }
    }

    public void listarConsultasPaciente(String cpf) {
        boolean encontrou = false;
        for (Consulta c : consultas) {
            if (c.getCpfPaciente().equals(cpf)) {
                c.exibirDetalhes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma consulta encontrada para este CPF.");
        }
    }

    public void listarMedicosDisponiveis() {
        boolean encontrou = false;
        System.out.println("Médicos Disponíveis:");
        for (Medico m : medicos) {
            if (m.getStatus().equals(true)) {
                System.out.println("    - " + m.getNome());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum médico disponível, cancele a consulta.");
        }
    }
}