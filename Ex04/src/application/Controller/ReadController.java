package application.Controller;

import application.Main;
import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReadController {

    @FXML
    private Button btnList;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextArea taContent;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;
    
    @FXML
    private Label labelViews;
    
    private BoardService boardService = new BoardServiceImpl(); 

    @FXML
    void toList(ActionEvent event) throws Exception {
    	Main.setRoot("UI/List");
    }

    @FXML
    void toUpdate(ActionEvent event) throws Exception {
    	String fxml = "UI/Update";
		FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
		Parent root = fxmlLoader.load();
		UpdateController updateController = (UpdateController) fxmlLoader.getController();
		updateController.passData(boardNo);
		Main.setRoot(root);
	
		
    	
//    	Main.setRoot("UI/Update");
    }

    int boardNo;
    
	public void passData(int boardNo) {
		this.boardNo = boardNo;
		System.out.println("게시물 더블클릭 후 바로 실행");
		Board board = boardService.select(boardNo);
		tfTitle.setText(board.getTitle());
		tfWriter.setText(board.getWriter());
		taContent.setText(board.getContent());
		
//		String views = board.getView() + "";
		labelViews.setText(String.valueOf(board.getView()));   // or 바로 윗줄 주석 해제 후 labelViews.setText(views);
	}

}
