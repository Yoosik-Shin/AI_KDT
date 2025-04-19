package application.Controller;

import application.Main;
import application.DTO.Board;
import application.Service.BoardService;
import application.Service.BoardServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateController {

    @FXML
    private Button btnList;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;
    
    @FXML
    private TextArea taContent;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfWriter;

    @FXML
    void toList(ActionEvent event) throws Exception {
    	Main.setRoot("UI/List");
    }

    private BoardService boardService = new BoardServiceImpl();
    
    int boardNo;
    
    @FXML
    private void update(ActionEvent event) throws Exception {
    	// Update 버튼 첫 클릭시 수정화면 그대로 리프레쉬 되면서 수정사항이 수정 전으로 리셋됨
    	// 이 후에 다시 수정한 후 Update버튼 클릭하면 제대로 동작함.
    	// ..... Read먼저 갔다가 업데이트 눌러야 업데이트로 가는거였어.. 두번눌러야 동작하는게 아니고... 하...
    	System.out.println("[update 호출됨]");
        System.out.println("제목: " + tfTitle.getText());
        System.out.println("작성자: " + tfWriter.getText());
        System.out.println("내용: " + taContent.getText());
        
    	Board board = new Board(tfTitle.getText(), tfWriter.getText(), taContent.getText());
    	board.setNo(boardNo);
    	System.out.println("이거 왜 두번째에 실행되는거지 대체...");
    	int result = boardService.update(board);
    	if (result > 0) {
			System.out.println("게시물 수정 성공!");
			Main.setRoot("UI/List");
		} 
    }
    
    
    @FXML
    void delete(ActionEvent event) throws Exception {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("게시글을 삭제합니다.");
    	alert.setHeaderText("이 게시글을 진짜 삭제하시겠습니까? no : " + boardNo);
    	alert.setContentText("삭제 후에는 되돌릴 수 없습니다.");
    	
    	int result = 0;
    	if (alert.showAndWait().get() == ButtonType.OK) {
			result = boardService.delete(boardNo);
		}
    	if (result > 0) {
			System.err.println("삭제되었습니다.");
			Main.setRoot("UI/List");
		}
    }
    
    
	public void passData(int boardNo) {
		System.out.println("게시물 수정 후에 Update버튼 첫번째 클릭시 실행");
		this.boardNo = boardNo;
		
		System.out.println("passdata 보드넘버 : " + boardNo);
		
		Board board = boardService.select(boardNo);
		
	    System.out.println("뭘 가져왔니: " + board);
		tfTitle.setText(board.getTitle());
		tfWriter.setText(board.getWriter());
		taContent.setText(board.getContent());
		
		System.out.println("title: " + tfTitle.getText());
		System.out.println("writer: " + tfWriter.getText());
		System.out.println("content: " + taContent.getText());
	}
}
