package sageniuz.client;

import static sageniuz.client.Resources.GlobalResources.RESOURCE;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class FriendList extends Composite {

	interface FriendListUiBinder extends UiBinder<Widget, FriendList> {
	}

	private static final String PROPERTY_IMAGE_STYLE_NAME = "pointer";
	private static final int SECOND_COLUMN = 1;
	private static final int FIRST_COLUMN = 0;

	private static FriendListUiBinder uiBinder = GWT.create(FriendListUiBinder.class);

	@UiField
	protected FlexTable friendsTable;

	public FriendList() {
		initWidget(uiBinder.createAndBindUi(this));
		displayFriends();
	}

	private void displayFriends() {
		friendsTable.clear();
		for (int i = 0; i < 10; i++) {
			addItemToList(i);
		}
	}

	private void addItemToList(int row) {
		friendsTable.setWidget(row, FIRST_COLUMN, checkBoxName(row));
		friendsTable.setWidget(row, SECOND_COLUMN, imageProperty());
		friendsTable.getCellFormatter().addStyleName(row, FIRST_COLUMN, "friendNameInList");
	}

	private CheckBox checkBoxName(int postfix) {
		return new CheckBox("Name " + postfix);
	}

	private Image imageProperty() {
		Image propertyImg = new Image(RESOURCE.propertyButton());
		propertyImg.setStyleName(PROPERTY_IMAGE_STYLE_NAME);
		return propertyImg;
	}

	@UiHandler("addNew")
	void onSignOutClicked(ClickEvent event) {
		Window.alert("'Add New' clicked");
	}
}
