package sageniuz.client.Resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface GlobalResources extends ClientBundle {
	public static final GlobalResources RESOURCE = GWT.create(GlobalResources.class);

	@Source("sageniuz/client/Resources/logo.png")
	ImageResource logo();

	@Source("sageniuz/client/Resources/logo_small.png")
	ImageResource logo_small();

	@Source("sageniuz/client/Resources/propertyButton.png")
	ImageResource propertyButton();

	@Source("sageniuz/client/Resources/GlobalStyles.css")
	GlobalStylesheet globalStyles();

}
