module net.radley {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.media;
	requires java.logging;
	requires com.fasterxml.jackson.databind;
	
	opens net.radley to javafx.graphics, javafx.fxml, javafx.media;
}
