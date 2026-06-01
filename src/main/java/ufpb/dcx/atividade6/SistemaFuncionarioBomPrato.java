package ufpb.dcx.atividade6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFuncionarioBomPrato implements SistemaFuncionario {

    private Map<String, Funcionario> funcionarios;

    public SistemaFuncionarioBomPrato(){
        this.funcionarios = new HashMap<String, Funcionario>();]
    }
    @Override
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaExisteException{

    }

    public void cadastrarFuncionario(String cpf, String nome, TipoFuncionario tipo, double salario) throws FuncionarioJaExisteException{
        if (this.funcionarios.containsKey(cpf)){
            throw new FuncionarioJaExisteException("Já existe funcionário com o cpf "+cpf);
        } else {
            this.funcionarios.put(cpf, new Funcionario(cpf, nome, tipo, salario));
        }
    }

    @Override
    public void alterarSalarioDeFuncionario(String cpfFuncionario, double novoSalario) throws FuncionarioInexistenteException {
        Funcionario fJaExiste = this.funcionarios.get(cpfFuncionario);
        if (fJaExiste != this.funcionarios.get(cpfFuncionario)){
            throw new FuncionarioInexistenteException("O funcionário não existe);
        }

        if (fJaExiste == this.funcionarios.get(cpfFuncionario)){
            this.funcionarios.keySet(salario = novoSalario);
        }
    }

    @Override
    public int contarFuncionariosDoTipo(TipoFuncionario tipo){
        int quantFuncTipo = 0;
        for (Funcionario f : this.funcionarios.values()){
            if (f.getTipo() == tipo){
                quantFuncTipo++;
            }
        }
    }

    @Override
    public boolean funcionarioJaExiste(String cpfFuncionario) {
        return this.funcionarios.containsKey(cpfFuncionario);
    }



    public List<Funcionario> pesquisarFuncionariosPorTipo(TipoFuncionario tipo){

    }

    public Funcionario pesquisarFuncionario(String cpfFuncionario) throws FuncionarioInexistenteException{
        Funcionario funcionarioEncontrado = this.funcionarios.get(cpfFuncionario);
    }

    public List <Funcionario> pesquisarFuncionariosComSalarioMaiorQue(double valor){

    }
}
