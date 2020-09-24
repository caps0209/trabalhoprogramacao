package view;

import java.io.IOException;
import java.util.List;
import com.pessoa.Pessoa;
import dao.PessoaDAO;
import gui.util.Alerts;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//Este trabalho foi feito usando o banco, portanto
//deve ser alterado as informações dele em SRC/com.db/ConexaoHSQLDB

public class ControllerPessoa extends Application {

	@FXML
	private TextField textFieldNome;

	@FXML
	private TextField textFieldEmail;

	@FXML
	private TextArea textAreaLista;

	@FXML
	private Button btDeletar;

	@FXML
	private Button btAlterar;

	@FXML
	private Button btListar;

	@FXML
	private Button btSair;

	@FXML
	private TextField textFieldBuscaId;

	@FXML
	private Button btPesquisaPessoa;

	@FXML
	void inserirPessoa(ActionEvent event) {
		Pessoa pessoa = pegaDados();
		limpaCampos();

		int quantidade = new PessoaDAO().inserir(pessoa);
		Alerts.showAlert("Alerta", "Pessoa Cadastrada", null, AlertType.INFORMATION);
	}

	@FXML
	void BuscarPessoa(ActionEvent event) {
		String idString = textFieldBuscaId.getText();
		Pessoa pessoa = null;
		if (!idString.equals(" ")) {
			try {
				int id = Integer.valueOf(idString);
				pessoa = new PessoaDAO().findByID(id);
			} catch (Exception e) {
				
			}
			if (pessoa != null) {
				textFieldNome.setText(pessoa.getNome());
				textFieldEmail.setText(pessoa.getEmail());
			}
		}
	}

	@FXML
	public void listarPessoa() {
		List<Pessoa> listaPessoa = new PessoaDAO().listAll();
		listaPessoa.forEach(pessoa -> {
			textAreaLista.appendText(pessoa.toString() + "\n");
		});
	}

	private void limpaCampos() {
		textFieldNome.clear();
		textFieldEmail.clear();
		textFieldNome.requestFocus();
	}

	@FXML
	public void Sair() {
		btSair.setOnAction((e) -> Platform.exit());
		Platform.exit();
	}

	private Pessoa pegaDados() {
		return new Pessoa(textFieldNome.getText(), textFieldEmail.getText());
	}

	public void btListarPessoas() {
		listarPessoa();
	}

	public void execute() {
		launch();
	}

	@Override
	public void start(Stage stage) {
		try {
			AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("/view/Pessoa.fxml"));
			stage.setTitle("Primeira tela");
			Scene sc = new Scene(pane);
			stage.setScene(sc);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}