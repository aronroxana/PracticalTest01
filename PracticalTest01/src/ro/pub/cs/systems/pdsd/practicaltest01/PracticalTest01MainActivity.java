package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

public class PracticalTest01MainActivity extends Activity {
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	 
	  private class ButtonClickListener implements Button.OnClickListener {
	 
	    @Override
	    public void onClick(View view) {
	      EditText leftEditText = (EditText)PracticalTest01MainActivity.this.findViewById(R.id.left_edit_text);
	      EditText rightEditText = (EditText)PracticalTest01MainActivity.this.findViewById(R.id.right_edit_text);
	      int leftButtonClickedNumber = Integer.parseInt(leftEditText.getText().toString());
	      int rightButtonClickedNumber = Integer.parseInt(rightEditText.getText().toString());
	 
	      switch(view.getId()) {
	        case R.id.left_button:
	          leftButtonClickedNumber++;
	          leftEditText.setText(String.valueOf(leftButtonClickedNumber));
	          break;
	        case R.id.right_button:
	          rightButtonClickedNumber++;
	          rightEditText.setText(String.valueOf(rightButtonClickedNumber));
	          break;
	      }
	    }
	  } 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		EditText leftEditText = (EditText)findViewById(R.id.left_edit_text);
	    EditText rightEditText = (EditText)findViewById(R.id.right_edit_text);
	    
	    Button leftButton = (Button)findViewById(R.id.left_button);
	    leftButton.setOnClickListener(buttonClickListener);
        Button rightButton = (Button)findViewById(R.id.right_button);
        rightButton.setOnClickListener(buttonClickListener);
        
        if (savedInstanceState != null) {
        	Log.d("practicalTestEvents", "onCreate() method was invoked before, retrieve info");
            String leftCount = savedInstanceState.getString("leftCount");
            if (leftCount != null) {
              leftEditText.setText(leftCount);
            } else {
              leftEditText.setText(String.valueOf(0));
            }
            String rightCount = savedInstanceState.getString("rightCount");
            if (rightCount != null) {
              rightEditText.setText(rightCount);
            } else {
              rightEditText.setText(String.valueOf(0));
            }
            Log.d("practicalTestEvents", "Restored values: " + leftEditText.getText().toString() + "/" + rightEditText.getText().toString()); 
          } else {
        	Log.d("practicalTestEvents", "onCreate() method was invoked for the first time");  
            leftEditText.setText(String.valueOf(0));
            rightEditText.setText(String.valueOf(0));
          }
        
	}

	@Override
    protected void onRestart() {  	
    	super.onRestart();
    	Log.d("practicalTestEvents", "onRestart() method was invoked");       
    }
    
    @Override
    protected void onStart() {
       	super.onStart();
       	Log.d("practicalTestEvents", "onStart() method was invoked");
    }
        
    @Override
    public void onResume() {
        super.onResume();
        Log.d("practicalTestEvents", "onResume() method was invoked");
    }
        
    @Override
    public void onPause() {
        super.onPause();
        Log.d("practicalTestEvents", "onPause() method was invoked");
    }
        
    @Override
    public void onStop() {
        super.onStop();
        Log.d("practicalTestEvents", "onStop() method was invoked");
    }         
        
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("practicalTestEvents", "onDestroy() method was invoked");
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		
		EditText leftEditText = (EditText)findViewById(R.id.left_edit_text);
	    EditText rightEditText = (EditText)findViewById(R.id.right_edit_text);
	    savedInstanceState.putString("leftCount", leftEditText.getText().toString());
	    savedInstanceState.putString("rightCount", rightEditText.getText().toString());
		
    }
}
