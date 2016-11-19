package lab8;
import lab8.BinTree;

public class Test {
	public static void main(String[] args){
		BinTree <Double> bt = new BinTree<Double>();
		System.out.println(bt.inorder());
		bt.add(10.);
		bt.add(5.);
		bt.add(3.);
		bt.add(8.);
		bt.add(15.);
		bt.add(16.);
		System.out.println(bt.inorder());
	}
}
