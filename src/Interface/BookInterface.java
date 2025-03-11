package Interface;

public interface BookInterface {
	public abstract boolean borrow(int bookID, int borrowedUserID);
	public abstract boolean returningBook(int bookID);
}
