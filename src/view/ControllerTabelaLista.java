package view;
import java.util.List;

import com.pessoa.Pessoa;
import dao.PessoaDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

//Este trabalho foi feito usando o banco, portanto
//deve ser alterado as informações dele em SRC/com.db/ConexaoHSQLDB

public class ControllerTabelaLista extends Pessoa{

    @FXML
    private TableView<String> tableViewPessoas;

    @FXML
    private TableColumn<Pessoa, Integer> columnId;

    @FXML
    private TableColumn<Pessoa, String> columnNome;

    @FXML
    private TableColumn<Pessoa, String> columnEmail;

    @FXML
    private Button btDeletar;

    @FXML
    private Button btAlterar;

    public void listarPessoa() {
    	List<Pessoa> listaPessoa = new PessoaDAO().listAll();
    	listaPessoa.forEach(Pessoa -> {    	
        	columnId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        	columnNome.setCellValueFactory(new PropertyValueFactory<>("NOME"));
        	columnEmail.setCellValueFactory(new PropertyValueFactory<>("EMAIL"));
    	});

    }
    
	/* métodos de alteração */
    public void onBtDeletar() {
    	
    }
    
    public void onBtAlterar() {
    	
    }
}
