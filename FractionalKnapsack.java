import java.util.Scanner;

class Greedyks{
	int no_of_objects;
	item objects[];
	float W;
	class item{
		int weight;
		int value;
		int index;
		float unit_value;
		
		void read_item(Scanner sc ,int index) {
			weight = sc.nextInt();
			value = sc.nextInt();
			this.index = index;
			unit_value = (float)value/weight;
		}
	}
	
	public void read_data() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of objects and sack capacity:");
		no_of_objects = sc.nextInt();
		W = sc.nextFloat();
		objects = new item[no_of_objects];
		System.out.println("Enter weight and value for the objects:");
		for(int i = 0 ; i < no_of_objects; i++) {
			objects[i] = new item();
			objects[i].read_item(sc,i+1);
		}
	}
	 
	public void sort(item objects[]) {
		item temp;
		for(int i = 0 ; i < no_of_objects; i++) {
			for(int j = 0; j < no_of_objects-1; j++) {
				if(objects[j].unit_value < objects[j+1].unit_value) {
					temp = objects[j];
					objects[j] = objects[j+1];
					objects[j+1]= temp;
				}
			}
		}
		System.out.println("List of items in order of unit value are:");
		for(int i = 0 ; i < no_of_objects; i++) {
			System.out.println("item: " + objects[i].index +" unit-value: " + objects[i].unit_value);
		}
	}
	
	public void find_value() {
		sort(objects);
		System.out.println("");
		float value = 0, w=0,k=W, fraction_value;
		int i = 0;
		System.out.println("Operation performed for greedy approach are:");
		while(k > 0 && i < no_of_objects) {
			if(k >= objects[i].weight) {
				k = k - objects[i].weight;
				value = value + objects[i].value;
				w = w + objects[i].weight;
				System.out.printf("%d units of item %d taken with value %d\n", objects[i].weight,objects[i].index,objects[i].value);
			}
			else {
				fraction_value = k * objects[i].unit_value;
				value = value + fraction_value;
				w = w + k;
				System.out.printf("%f units of item %d taken with value of %f\n",k,objects[i].index,fraction_value);
				k=0;
			}
			i = i + 1; 
		}
		System.out.printf("Total value of item taken is %f\n", value);
		System.out.printf("Total weight of item taken is %f\n", w);
	}
}

public class FractionalKnapsack {
	public static void main(String[] args) {
		Greedyks obj = new Greedyks();
		obj.read_data();
		obj.find_value();
	}
}