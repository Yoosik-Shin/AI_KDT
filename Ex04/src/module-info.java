module Ex04 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires lombok;
	opens application to javafx.graphics, javafx.fxml, lombok, java.sql;
	opens application.Controller to javafx.fxml;
	opens application.DTO to javafx.base;
}
