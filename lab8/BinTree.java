package lab8;
import java.util.ArrayList;

class Node <T extends Comparable<T> >
{
	public T val;
	public Node<T> left, right;
	Node(T val){
		this.val = val;
		left = null;
		right = null;
	}
	Node () {}
}

public class BinTree <T extends Comparable<T> > {
	
	
	private Node <T> root;
	
	BinTree () { root = null;}
	private Node<T> add (Node<T> root, T el){
		if (root == null)
			return new Node<T>(el);
		
		int cmp = root.val.compareTo(el);
		if (cmp > 0)
			root.left = add(root.left, el);
		else
			root.right = add(root.right, el);
		
		return root;
	}
	
	public void add (T el){
		root = add (root, el);
	}
	
	private boolean find (Node<T> root,T el){
		if (root == null)
			return false;
		if (root.val.compareTo(el) == 0)
			return true;
		if (root.val.compareTo(el) > 0)
			return find(root.left, el);
		if (root.val.compareTo(el) < 0)
			return find(root.right, el);
		return false;
	}
	
	public boolean find (T el){
		return find (root, el);
	}
	
	private ArrayList<T> preorder(Node<T> root){
		if (root  == null)
			return new ArrayList<T>();
		ArrayList<T> res = new ArrayList<T> ();
		res.add(root.val);
		res.addAll(preorder(root.left));
		res.addAll(preorder(root.right));
		return res;
	}
	public ArrayList<T> preorder(){
		return preorder(root);
	}
	private ArrayList<T> inorder(Node<T> root){
		if (root  == null)
			return new ArrayList<T>();
		ArrayList<T> res = new ArrayList<T> ();
		res.addAll(inorder(root.left));
		res.add(root.val);
		res.addAll(inorder(root.right));
		return res;
	}
	public ArrayList<T> inorder(){
		return inorder(root);
	}
	private ArrayList<T> postorder(Node<T> root){
		if (root  == null)
			return new ArrayList<T>();
		ArrayList<T> res = new ArrayList<T> ();
		res.addAll(postorder(root.left));
		res.addAll(postorder(root.right));
		res.add(root.val);
		return res;
	}
	public ArrayList<T> postorder(){
		return postorder(root);
	}
	
	private Node<T> leftMost (Node <T> root){
		if (root.left.left == null){
			return root;
		}
		root.left = leftMost(root.left);
		return root;
	}
	private Node<T> delEl (Node<T> root){
		if (root.left == null && root.right == null){
			return null;
		}
		if (root.left != null && root.right != null){
			if (root.right.left == null){
				root.right.left = root.left;
				return root.right;
			}
			
			Node<T> tmp = root.right;
			while (tmp.left != null){
				tmp = tmp.left;
			}			
			root.val = tmp.val;
			root.right.left = leftMost(root.right.left);
			return root;
			
		}
		if (root.left == null){
			root = root.right;
		}
		else{
			root = root.left;
		}
		return root;
	}
	private Node<T> del (Node<T> root, T el){
		if (root == null){
			return null;
		}
		if (root.val.compareTo(el) < 0){
			root.right = del(root.right, el);
		}
		if (root.val.compareTo(el) > 0){
			root.left = del(root.left, el);
		}
		if (root.val.compareTo(el) == 0){
			root = delEl(root);
		}
		return root;
	}
	public void del (T el){
		root = del(root, el);
	}
	public static void main (String args[]){
	}
}
