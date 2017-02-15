package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.root);
	}

	private int height(BSTNode<T> node) {
		int resultLeft = -1;
		int resultRight = -1;
		
		if(!node.isEmpty()) {
			resultLeft = 1 + height((BSTNode<T>) node.getLeft());
			resultRight = 1 + height((BSTNode<T>) node.getRight());
		}
		
		if(resultLeft > resultRight) {
			return resultLeft;
		} else {			
			return resultRight;
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		if(element != null) {			
			return search(this.root, element);
		} else if(isEmpty()) {
			return new BSTNode<T>();
		} else {	
			return null;
		}		
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		if(node.isEmpty())
			return new BSTNode<T>();
		else {			
			if(node.getData().compareTo(element) < 0) {
				return search((BSTNode<T>) node.getRight(), element);
			} else if (node.getData().compareTo(element) > 0) {
				return search((BSTNode<T>) node.getLeft(), element);
			} else {
				return node;
			}
		}
	}

	@Override
	public void insert(T element) {
		if(element != null) {			
			this.insert(this.root, element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if(node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		} else if (node.getData().compareTo(element) < 0){
			insert((BSTNode<T>) node.getRight(), element);
		} else if(node.getData().compareTo(element) > 0) {
			insert((BSTNode<T>) node.getLeft(), element);
		}
		
	}

	@Override
	public BSTNode<T> maximum() {
		if(isEmpty()) {
			return null;
		} else {			
			return maximum(this.root);
		}
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if(node.getRight().isEmpty()) {
			return node;
		} else {
			return maximum((BSTNode<T>) node.getRight());
		}
	}

	@Override
	public BSTNode<T> minimum() {
		if(isEmpty()) {
			return null;
		} else {
			return minimum(this.root);
		}
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if(node.getLeft().isEmpty()) {
			return node;
		} else {
			return minimum((BSTNode<T>) node.getLeft());
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		
		if(element != null && !node.isEmpty()) {
			if(!node.getRight().isEmpty()) {
				return minimum((BSTNode<T>) node.getRight());
			} else {
				return sucessor(node, node.getParent());
			}
		} else {
			return null;
		}
	}


	private BSTNode<T> sucessor(BSTNode<T> node, BTNode<T> parent) {
		if(parent == null) {
			return null;			
		} else if(parent.getData().compareTo(node.getData()) > 0) {
			return (BSTNode<T>) parent;
		} else {
			return sucessor(node, parent.getParent());
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		
		if(element == null || node.isEmpty()) {
			return null;
		} else {
			if(!node.getLeft().isEmpty()) {
				return maximum((BSTNode<T>) node.getLeft());
			} else {
				return predecessor(node, node.getParent());
			}
		}
	}

	private BSTNode<T> predecessor(BSTNode<T> node, BTNode<T> parent) {
		if(parent == null){
			return null;	
		} else if(parent.getData().compareTo(node.getData()) < 0) {
			return (BSTNode<T>) parent;
		} else {
			return predecessor(node, parent.getParent());
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		
		if(element != null && !node.isEmpty()) {
			remove(node);
		}
	}

	private void remove(BSTNode<T> node) {
		if(node.isLeaf()) {
			removeLeaf(node);
		} else if(singleChild(node)) {
			if(node.getLeft().isEmpty()) {
				removeRight(node);
			} else{
				removeLeft(node);
			}
		} else {
			removeTwoChild(node);
		}
		
	}
	
	

	private void removeTwoChild(BSTNode<T> node) {
		BSTNode<T> sucessor = sucessor(node.getData());
		T sucessorData = sucessor.getData();
		sucessor.setData(node.getData());
		node.setData(sucessorData);
		remove(sucessor);
	}

	private void removeRight(BSTNode<T> node) {
		if(node.equals(this.root)) {
			removeRoot(node);
		} else {
			node.getRight().setParent(node.getParent());
			if(node.getParent().getLeft().equals(node)) {
				node.getParent().setLeft(node.getRight());
			} else {
				node.getParent().setRight(node.getRight());
			}
		}
	}

	private void removeLeft(BSTNode<T> node) {
		if(node.equals(this.root)) {
			removeRoot(node);
		} else {
			node.getLeft().setParent(node.getParent());
			if(node.getParent().getLeft().equals(node)) {
				node.getParent().setLeft(node.getLeft());
			} else {
				node.getParent().setRight(node.getLeft());
			}
		}
		
	}

	private void removeRoot(BSTNode<T> node) {
		if(node.getRight().isEmpty()) {
			this.root = (BSTNode<T>) node.getLeft();
			node.getLeft().setParent(node.getParent());
			node.setLeft(null);
		} else {
			this.root = (BSTNode<T>) node.getRight();
			node.getRight().setParent(node.getParent());
			node.setRight(null);
		}
		
	}
	
	private boolean singleChild(BSTNode<T> node) {
		if(node.getLeft().isEmpty() && !node.getRight().isEmpty())
			return true;
		else if(!node.getLeft().isEmpty() && node.getRight().isEmpty())
			return true;
		else
			return false;
	}

	private void removeLeaf(BSTNode<T> node) {
		node.setData(null);
		node.setRight(null);
		node.setLeft(null);
	}

	@Override
	public T[] preOrder() {
		T[] array = (T[]) new Comparable[this.size()];
		preOrder(this.root, array, 0);
		return array;
	}

	private int preOrder(BSTNode<T> node, T[] array, int index) {
		if(!node.isEmpty()) {
			array[index] = node.getData();
			index = preOrder((BSTNode<T>) node.getLeft(), array, ++index);
			index = preOrder((BSTNode<T>) node.getRight(), array, index);
		}
		return index;
	}

	@Override
	public T[] order() {
		T[] array = (T[]) new Comparable[this.size()];
		Order(this.root, array, 0);
		return array;
	}

	private int Order(BSTNode<T> node, T[] array, int index) {
		if(!node.isEmpty()) {
			index = Order((BSTNode<T>) node.getLeft(), array, index);
			array[index++] = node.getData(); 
			index = Order((BSTNode<T>) node.getRight(), array, index);
		}
		return index;
	}

	@Override
	public T[] postOrder() {
		T[] array = (T[]) new Comparable[this.size()];
		postOrder(this.root, array, 0);
		return array;
	}

	private int postOrder(BSTNode<T> node, T[] array, int index) {
		if(!node.isEmpty()) {
			index = postOrder((BSTNode<T>) node.getLeft(), array, index);
			index = postOrder((BSTNode<T>) node.getRight(), array, index);
			array[index++] = node.getData();
		}
		return index;
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
