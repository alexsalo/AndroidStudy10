package androidstudy10.saloas.com;

import android.content.Context;
import android.widget.ImageView;

public class MygameImageView extends ImageView {
	private byte IndexCol;
	private byte IndexRow;
	public MygameImageView(Context context) {
		super(context);
	}
	public MygameImageView(Context context, byte Col, byte Row) {
		super(context);
		IndexCol = Col;
		IndexRow = Row;
	}
	public byte getCol(){
		return IndexCol;
	}
	public byte getRow(){
		return IndexRow;
	}	
}
