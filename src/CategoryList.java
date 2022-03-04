import java.util.ArrayList;

public class CategoryList {
	private ArrayList<String> categories = new ArrayList<>();
	
	public void addCategory(String category) {
		this.categories.add(category);
	}
	
	public String toString() {
		String categoriesStr = "";
		
		for( int i = 0; i < this.categories.size(); i++ ) {
			categoriesStr += "\n[" + i + "] " + this.categories.get(i);
		}
		
		return categoriesStr;
	}
	
	public int getTotalNumOfCategories() {
		return this.categories.size();
	}
	
	public String getCategoryById(int id) {
		try {
			return this.categories.get(id);
		} catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public void updateCategoryName(int id, String newName) {
		this.categories.set(id, newName);
	}
	
	public void deleteCategory(int idx) {
		this.categories.remove(idx);
	}
}
