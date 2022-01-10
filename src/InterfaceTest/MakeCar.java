package InterfaceTest;

public interface MakeCar {
	public int tireCnt = 0;
	
	public String color = "red";
	
	void makeTire(int tireCnt);
	
	void makeColor(String color);
	
	void completeCar(int tireCnt, String color);

}
