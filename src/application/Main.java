package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/*tableview muito usada para trabalhar dados de tabelas BD ou simples listas de objetos
 * processo: objetos -> ObservableList<Class> -> TableView
 * 		passo1: qualquer dado é  na verdade um objecto. aluno é um objeto da classe aluno
 * 		passo2: todos os alunos são carregados para uma lista de objetos oBSERVABLESlISTS<cLASS> sao listas de objetos
 * preparadas para tratar estes adados.
 * 		passo3: esta linha é carregada na TableView
 * 
 *  Nesta actividade vamos trabalhar com lista de objetos do tipo aluno para criar a lista da turma:
 *  
 *  1 - criar uma classe aluno, no projeto global 00, com 2 atributos: nAluno e nome -> getters6setters
 *  2 - criar uma ObservableLista<Aluno> para recolher os dados dos alunos na turma e devolver a tableview
 *  3 - criar a tableview e as suas colunas e associar a ObservableList a tableview
 * 
 * */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			TableView<Aluno> tableAlunos = new TableView<>();
			
			TableColumn<Aluno, String> colunaNome = new TableColumn<>("Nome");
			
			colunaNome.setMinWidth(200);
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			
			TableColumn<Aluno, String> colunaNumero = new TableColumn<>("Numero");
			colunaNumero.setMinWidth(200);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("nTurma"));
			
			tableAlunos.getColumns().addAll(colunaNome,colunaNumero);
			
			tableAlunos.setItems( carregarListaAlunos() );
			
			StackPane root = new StackPane();
			root.getChildren().add(tableAlunos);
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private ObservableList<Aluno> carregarListaAlunos() {
		// TODO Auto-generated method stub
		ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();
		
		listaAlunos.add(new Aluno(0, "A.Ferraz"));
		listaAlunos.add(new Aluno(1, "Bruno"));
		listaAlunos.add(new Aluno(2, "Catalin"));
		listaAlunos.add(new Aluno(3, "David"));
		listaAlunos.add(new Aluno(6, "Ventura"));
		listaAlunos.add(new Aluno(7, "Jorge"));
		listaAlunos.add(new Aluno(8, "Marcelo"));
		listaAlunos.add(new Aluno(9, "Mariana"));
		listaAlunos.add(new Aluno(10, "Patricia"));
		listaAlunos.add(new Aluno(11, "Ricardo"));
		listaAlunos.add(new Aluno(12, "Ruben"));
		listaAlunos.add(new Aluno(14, "Rui"));
		listaAlunos.add(new Aluno(15, "Samuel"));
		
		
		return listaAlunos;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
