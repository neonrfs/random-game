module net.radley {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.media;
	
	opens net.radley to javafx.graphics, javafx.fxml, javafx.media;
}
