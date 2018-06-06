package dreamertn9527.top.design.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 策略模式
 * 不关心过程，返回的结果都是一样的
 * @author tangniannian
 *
 */
public class Main {

	public static void main(String[] args) {
		List<Long> numbers = new ArrayList<>();
		Collections.sort(numbers, new Comparator<Long>() {
			
			/**
			 * 返回固定的结果
			 * 如 -1, 0, 1
			 */
			@Override
			public int compare(Long o1, Long o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		
		});
	}
}
