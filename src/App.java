import br.com.rsm.dao.ClienteMapDAO;
import br.com.rsm.dao.iClienteDAO;
import br.com.rsm.domain.Cliente;

import javax.swing.*;
import javax.swing.text.Element;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    private static iClienteDAO iClienteDAO;
    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração e 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null, "Opção invalida. Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração e 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isCadastro(opcao)){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsulta(opcao)){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF: ",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                consulta(dados);
            }

            opcao = JOptionPane.showInputDialog(null, "Opção invalida. Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para alteração e 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consulta(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.valueOf(dados));

        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(),
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isConsulta(String opcao) {
        if ("2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void cadastrar(String dados) {

        String[] dadosSeparados = dados.split(",");

        if (dadosSeparados.length < 7 || dadosSeparados.length > 7) {
            JOptionPane.showMessageDialog(null, "Dados incorretos, por favor, preencha os campos corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3], dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);

        boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo: ",
                "Sair", JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isOpcaoValida(String opcao) {

        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)){
            return true;
        }
        return false;

    }

    private static boolean isOpcaoCadastro(String opcao) {
        if ("1".equals(opcao)){
            return true;
        }
        return false;
    }
}