package com.metadot.book.connectr.server;

import javax.jdo.PersistenceManager;

import com.metadot.book.connectr.server.domain.Friend;
import com.metadot.book.connectr.server.domain.UserAccount;

public class AppMisc {

	private static final String[] friendsFirstNameData = new String[] { "Jean", "Billy", "Jacques", "Zoe", "Bella", "Napoleon", "Dona", "Daniel", "Amy" };
	private static final String[] friendsLastNameData = new String[] { "Voss", "Kit", "Martin", "Smith", "Austin", "Dubois", "Houston", "Normand", "Peterson" };
	private static final String[] friendsEmailData = new String[] { "jean@example.com", "billy@example.com", "jacques@example.com", "zoe@example.com", "bella@example.com", "napoleon@example.com",
			"dona@example.com", "daniel@example.com", "amy@example.com" };

	static void populateDataStoreOnce() {
		UserAccount defaultUser = UserAccount.getDefaultUser();
		if (defaultUser != null) {
			return; // already populated
		}

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Friend friend = null;

		try {

			defaultUser = new UserAccount();
			defaultUser.setBasicInfo("bob", "default@default.com");
			// give our user some friends
			for (int i = 0; i < friendsFirstNameData.length; ++i) {
				friend = new Friend();
				friend.setBasicInfo(friendsFirstNameData[i], friendsLastNameData[i], friendsEmailData[i]);

				pm.makePersistent(friend);

				defaultUser.addFriendKey(friend.getId());
			}

			pm.makePersistent(defaultUser);

		} // end try
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			pm.close();
		}

	}
}
