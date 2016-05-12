package com.example.ensai.proj.Bdd;

import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.ensai.proj.Elements.ContactTel;
import com.example.ensai.proj.R;

import java.util.ArrayList;

/**
 * Created by ensai on 10/05/16.
 */
public class ListeContactsTel extends ListActivity {


    public ArrayList<ContactTel> displayContacts() {

        ArrayList<ContactTel> liste = new ArrayList<>();

        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
                String nom = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (Integer.parseInt(cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String tel = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        liste.add( new ContactTel(nom, tel));
                    }
                    pCur.close();
                }
            }
        }
        return liste;
    }




}
