package androidstudy10.saloas.com;

public class Thegame {
	private byte _size;
	private byte [][] _gamefield;
	public Thegame(byte size){
		_size = size;
		_gamefield = new byte[_size][_size];
		initGame();
	}
	private void initGame(){
		byte i,j;
		for (i=0; i<_size; i++){
			for(j=0; j<_size; j++){
				_gamefield[i][j] = 0;
			} //0-empty, 1 - white, 2- black
		}
	}
	public void setMove1(byte ColIndex, byte rowIndex){
		_gamefield[ColIndex][rowIndex] = 1;
	}
	public void setMove2(byte ColIndex, byte rowIndex){
		_gamefield[ColIndex][rowIndex] = 2;
	}
	public byte getCell(byte ColIndex, byte rowIndex){
		return _gamefield[ColIndex][rowIndex];
	}
}
