package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.avaje.ebean.*;

@Entity
public class SearchHistory extends Model{
	
	@Id
	public String searchWord;
	
	
	
	
}
