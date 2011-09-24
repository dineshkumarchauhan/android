package de.metafinanz.mixnmatch.frontend.android;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyRequests extends ListActivity {
	private static final int DIALOG_CHOICE = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,R.layout.my_requests, DATES));

		ListView lv = getListView();
		  lv.setTextFilterEnabled(true);

		  lv.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
				showDialog(DIALOG_CHOICE);
		    }
		  });
	}

	static final String[] DATES = new String[] {
	    "01.08., Unterf�hring", "02.08., Schwabing", "03.08., Unterf�hring"
	  };

	@Override
	protected Dialog onCreateDialog(int id) {

		Dialog dialog;

		switch (id) {
		case DIALOG_CHOICE:
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("Willst du den Eintrag l�schen oder �ndern?").setCancelable(
					false).setPositiveButton("L�schen",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							Toast.makeText(getApplicationContext(), "L�schen",
									Toast.LENGTH_SHORT).show();
						}
					}).setNegativeButton("�ndern",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							Toast.makeText(getApplicationContext(), "�ndern",
									Toast.LENGTH_SHORT).show();
						}
					});
			dialog = builder.create();
			break;
		default:
			dialog = null;
		}
		return dialog;

	}

}
