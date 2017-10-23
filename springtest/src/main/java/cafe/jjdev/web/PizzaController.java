package cafe.jjdev.web;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	//�� Ŭ������ �������� ��Ҹ� �߰��ؼ� ��Ʈ�ѷ��� ��������	//���̼� ���ڿ��� ����
public class PizzaController {
	//private PizzaDao pizzaDao;

	@RequestMapping(value="/pizzaPieChart")
	public ArrayList<Pizza> pizzaPieChart() {
		//ArrayList<Pizza> list = pizzaDao.selectPizzaList();
		ArrayList<Pizza> list  = new ArrayList<Pizza>();
		list.add(new Pizza("Mushrooms",3));
		list.add(new Pizza("Onions",1));
		list.add(new Pizza("Olives",1));
		list.add(new Pizza("Zucchini",1));
		list.add(new Pizza("Pepperoni",2));
		return list;
	}
	//pizza class�� �ۿ� �־�ߵǴµ� �����Ƽ� ����� ����
	class Pizza{
		private String topping;
		private int slices;
		
		public Pizza(String topping, int slices) {
			super();
			this.topping = topping;
			this.slices = slices;
		}
		public String getTopping() {
			return topping;
		}
		public void setTopping(String topping) {
			this.topping = topping;
		}
		public int getSlices() {
			return slices;
		}
		public void setSlices(int slices) {
			this.slices = slices;
		}
		
	}
}
