package androidstudy10.saloas.com;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class AndroidStudy10Activity extends Activity {
    /** Called when the activity is first created. */
	int _cellCount = 8;
	int _cellSize; 
	int _displayWidth;
	boolean _turn;
	TableLayout _tableLayout;
	int _clickCounter;
	int _clickDefault =10;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);      
        initialize();      
    }
    private void initialize(){
    	_displayWidth = getDisplayWidth(); 
    	_clickCounter = 0;
    	TableLayout _mainLayerLayout = new TableLayout(this);
    	
    	Button _newGameButton = new Button(this);
        _newGameButton.setText("New Game");       
        tableInit();
        
        _mainLayerLayout.addView(_tableLayout);
        _mainLayerLayout.addView(_newGameButton);
        
        _newGameButton.setOnClickListener(new MyNewGameBtnClick());
        
        setContentView(_mainLayerLayout);
        Toast.makeText(getApplicationContext(), 
        		"Game succesfully refreshed", Toast.LENGTH_SHORT).show();
    }    
    private void tableInit(){
    	_turn = true;
    	_cellSize = (_displayWidth/_cellCount)-2; 	
        //MyImageTouch _imageTouch = new MyImageTouch();
        MyImageClick _imageClick = new MyImageClick();
        
    	_tableLayout = new TableLayout(this);
        TableRow.LayoutParams param = new TableRow.LayoutParams(_cellSize, _cellSize);
        param.setMargins(1, 1, 1, 1);
        for(int i=1; i<= _cellCount; i++){
        	TableRow tableRow=new TableRow(this);
        	for(int j=1;j<=_cellCount;j++)
        	{
		         ImageView imageView=new ImageView(this);
		         String s1 = Integer.toString(i)+Integer.toString(j);
		         int id = Integer.parseInt(s1);
		         imageView.setId(id);	         
		         imageView.setLayoutParams(param);
		         imageView.setBackgroundColor(Color.parseColor("#c26400"));
		         //imageView.setOnTouchListener(_imageTouch);
		         imageView.setOnClickListener(_imageClick);
		         tableRow.addView(imageView);
              }
        	_tableLayout.addView(tableRow);
        }
        
    }	

    private class MyImageTouch implements View.OnTouchListener{
		public boolean onTouch(View v, MotionEvent event) {
			//v.setBackgroundDrawable(getWallpaper());
			return true;
		}
    }
    private class MyImageClick implements View.OnClickListener{
    	public void onClick(View v) {
    		Toast.makeText(getApplicationContext(), 
					"Cell choosen", Toast.LENGTH_SHORT).show();
    		_clickCounter++;
			//v.setBackgroundDrawable(getWallpaper());
			if (_turn) {
				v.setBackgroundColor(Color.WHITE);
				_turn = false;
			}
			else {
				v.setBackgroundColor(Color.BLACK);
				_turn = true;
			}
			if (_clickCounter>_clickDefault){
				_clickDefault = _clickDefault *2;
				_cellCount = _cellCount + 2;
				initialize();
			}
		}
    }
    private class MyNewGameBtnClick implements View.OnClickListener{
    	public void onClick(View v) {
    		initialize();
    	}
    }
    private Bitmap drawCycle(int width, int height){
		Bitmap bmp = Bitmap.createBitmap(width, height, null);
		Canvas c = new  Canvas(bmp);
		c.drawCircle(width, height, width/2, null);
    	return bmp;
    }
	private int getDisplayWidth(){
		Display display = getWindowManager().getDefaultDisplay();
	 	return display.getWidth();
	}
}