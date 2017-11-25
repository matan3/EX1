import java.util.List;

public class Row 
{
	List<Wifi> element;
	Details head;
	
	public Row(List<Wifi> element,Details head){
		this.element=element;
		this.head=head;		
	}
	public List<Wifi> getElement() {
		return this.element;
	}
	public void setElement(List<Wifi> element) {
		this.element = element;
	}
	public Details getHead() {
		return this.head;
	}
	public void setHead(Details head) {
		this.head = head;
	}
	@Override
	public String toString() {
		return "Row [element=" + element + ", head=" + head + "]";
	}

}
