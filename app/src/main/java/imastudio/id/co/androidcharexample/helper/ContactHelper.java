package imastudio.id.co.androidcharexample.helper;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.PhoneLookup;
import android.provider.ContactsContract.RawContacts;

import java.util.ArrayList;

public class ContactHelper {

	public static Cursor getContactCursor(ContentResolver contactHelper,
			String startsWith) {

		String[] projection = { Phone._ID,
				Phone.DISPLAY_NAME,
				Phone.NUMBER };
		Cursor cur = null;

		try {
			if (startsWith != null && !startsWith.equals("")) {
				cur = contactHelper.query(
						Phone.CONTENT_URI,
						projection,
						Phone.DISPLAY_NAME
								+ " like \"" + startsWith + "%\"", null,
						Phone.DISPLAY_NAME
								+ " ASC");
			} else {
				cur = contactHelper.query(
						Phone.CONTENT_URI,
						projection, null, null,
						Phone.DISPLAY_NAME
								+ " ASC");
			}
			cur.moveToFirst();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cur;
	}

	private static long getContactID(ContentResolver contactHelper,
			String number) {
		Uri contactUri = Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI,
				Uri.encode(number));

		String[] projection = { PhoneLookup._ID };
		Cursor cursor = null;

		try {
			cursor = contactHelper.query(contactUri, projection, null, null,
					null);

			if (cursor.moveToFirst()) {
				int personID = cursor.getColumnIndex(PhoneLookup._ID);
				return cursor.getLong(personID);
			}

			return -1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
				cursor = null;
			}
		}

		return -1;
	}

	public static boolean insertContact(ContentResolver contactAdder,
			String firstName, String mobileNumber) {
		ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
		ops.add(ContentProviderOperation
				.newInsert(RawContacts.CONTENT_URI)
				.withValue(RawContacts.ACCOUNT_TYPE, null)
				.withValue(RawContacts.ACCOUNT_NAME, null)
				.build());
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
				.withValue(
						ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME,
						firstName).build());
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						Phone.CONTENT_ITEM_TYPE)
				.withValue(Phone.NUMBER,
						mobileNumber)
				.withValue(Phone.TYPE,
						Phone.TYPE_MOBILE).build());

		try {
			contactAdder.applyBatch(ContactsContract.AUTHORITY, ops);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public static void deleteContact(ContentResolver contactHelper,
			String number) {

		ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
		String[] args = new String[] { String.valueOf(getContactID(
				contactHelper, number)) };

		ops.add(ContentProviderOperation.newDelete(RawContacts.CONTENT_URI)
				.withSelection(RawContacts.CONTACT_ID + "=?", args).build());
		try {
			contactHelper.applyBatch(ContactsContract.AUTHORITY, ops);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (OperationApplicationException e) {
			e.printStackTrace();
		}
	}

}
