package comparator.student;

import java.util.Comparator;
import entity.Student;

public class StudentNameComparator implements Comparator<Student>{

	@Override
	public int compare(Student b1, Student b2) {
		
		return b1.getSname().compareToIgnoreCase(b2.getSname());
	}
}
