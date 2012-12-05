package com.turlutux.taskpaper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Taskpaper extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	private InputStream GetTodoList() {
		URL url = new URL("http://turlutux.perso.sfr.fr/upload/perso.todo");
		URLConnection conn = url.openConnection();

		return conn.getInputStream();
	}

	public void displayTodo(View view) {
		TextView tw = findViewById(R.id.todoTw);
		tw.setText(GetTodoList().read());
	}
}
