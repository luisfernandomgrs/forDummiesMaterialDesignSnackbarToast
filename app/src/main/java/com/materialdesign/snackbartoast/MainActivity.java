package com.materialdesign.snackbartoast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

	private FloatingActionButton fabMessage;
	private AlertDialog alertDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final View constraintLayout_Main = findViewById(R.id.activity_Main);

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Message result");
		builder.setPositiveButton("Yes", null);
		alertDialog = builder.create();

		fabMessage = findViewById(R.id.fabMessage);
		fabMessage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Snackbar snackbar = Snackbar.make(constraintLayout_Main, "Showing result of last action", Snackbar.LENGTH_LONG);
				snackbar.setAction("Dimiss", new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						alertDialog.show();
					}
				});
				snackbar.show();
			}
		});
	}
}