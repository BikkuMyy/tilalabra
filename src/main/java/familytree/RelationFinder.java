package familytree;

import java.util.*;
import graph.Family;

public class RelationFinder {
	
	private Family family;

	public RelationFinder(Family family) {
		this.family = family;
	}

	public boolean areRelated(String p1, String p2){
		if(!this.family.containsPerson(p1) || !this.family.containsPerson(p2)){
			return false;
		}
		
		return true;
	}
}