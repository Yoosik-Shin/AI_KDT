package application.Controller;

import java.util.List;

import application.Main;
import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ListController {

    @FXML
    private TableView<Board> boardTableView;


    @FXML
    private TableColumn<Board, Integer> colNo;
    
    @FXML
    private TableColumn<Board, String> colTitle;
    
    @FXML
    private TableColumn<Board, String> colWriter;
    
    @FXML
    private TableColumn<Board, String> colDate;

    @FXML
    private TableColumn<Board, Integer> colView;

    @FXML
    private Button btnCreate;
    
    @FXML
    private Button btnMain;
    
    List<Board> boardList = null;

    private BoardService boardService = new BoardServiceImpl();
    
    @FXML
    public void initialize() {
    	boardList = boardService.list();
    	
    	colNo.setCellValueFactory(new PropertyValueFactory<>("No"));
    	colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
    	colWriter.setCellValueFactory(new PropertyValueFactory<>("Writer"));
    	colDate.setCellValueFactory(new PropertyValueFactory<>("createDate"));
    	colView.setCellValueFactory(new PropertyValueFactory<>("View"));
    	
    	ObservableList<Board> list = FXCollections.observableArrayList(boardList);
    	boardTableView.setItems(list);
    	
    	boardTableView.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// double clicked 게시물 더블클릭해서 들어가기
				if (event.getClickCount() == 2 && boardTableView.getSelectionModel().getSelectedItem() != null) {
					int boardNo = boardTableView.getSelectionModel().getSelectedItem().getNo();
//					System.out.println(boardNo);
					try {
						String fxml = "UI/Read";
						FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
						Parent root = fxmlLoader.load();
						ReadController readController = (ReadController) fxmlLoader.getController();
						readController.passData(boardNo);
						Main.setRoot(root);
					} catch (Exception e) {
						System.err.println("게시물 조회 에러 발생");
					}
				}
			}
    		
		});
    }
    
    
    @FXML
    void toCreate(ActionEvent event) throws Exception {
    	Main.setRoot("UI/Create");
    }

    @FXML
    void toMain(ActionEvent event) throws Exception {
    	Main.setRoot("Main");
    }

}
