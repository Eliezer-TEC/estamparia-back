package estampariaback.estamparia.dw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estampariaback.estamparia.dw.exception.CampoInvalidoException;
import estampariaback.estamparia.dw.model.entity.Pessoa;
import estampariaback.estamparia.dw.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa inserir(Pessoa novaPessoa) throws CampoInvalidoException {
        validarCamposObrigatorios(novaPessoa);
        return pessoaRepository.save(novaPessoa);
    }

    private void validarCamposObrigatorios(Pessoa novaPessoa) throws CampoInvalidoException {
        // Implemente a validação dos campos obrigatórios para a entidade Pessoa aqui
        // Certifique-se de verificar se os campos necessários estão preenchidos antes de salvar
    }

    public boolean excluir(Integer id) {
        pessoaRepository.deleteById(id.longValue());
        return true;
    }

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa atualizar(Pessoa pessoaParaAtualizar) throws CampoInvalidoException {
        validarCamposObrigatorios(pessoaParaAtualizar);
        return pessoaRepository.save(pessoaParaAtualizar);
    }
}
