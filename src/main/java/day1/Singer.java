package day1;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

public class Singer { //vo,dto 객체들은 Model객체라서 bean으로 관리하지 않는다. 
	private int idx;
	private String singer;
	private List<String> albums;

}
