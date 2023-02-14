package com.materialdesign.snackbartoast;

import static com.materialdesign.snackbartoast.R.color.teal_700;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

	private FloatingActionButton fabMessage, fabMessagePersonal;
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
						snackbar.dismiss();
					}
				});
				snackbar.show();
			}
		});

		final View main_Activity = findViewById(R.id.activity_Main);

		fabMessagePersonal = findViewById(R.id.fabMessagePersonal);
		fabMessagePersonal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar snackbar = Snackbar.make(view, "Message Information after event of FloatActionButton", Snackbar.LENGTH_LONG)
						.setActionTextColor(getResources().getColor(R.color.yellow, null));
				snackbar.setAction("Ok", new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						snackbar.dismiss();
					}
				});
				snackbar.show();
			}
		});
	}
}