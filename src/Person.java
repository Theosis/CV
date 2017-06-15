import java.util.ArrayList;

public class Person {
	
	// Class de-encapsulated, private vars + getters/setter gone to deliver MVP in time.
	// More sophistication next time; function trumps style.
	
	//Config parameters
	final int maxEdAch = 10;		//Educational Achievements
	final int maxWrkXp = 10;	//Work Experiences
	final int maxSkills = 20;		//
			
	String name;
	String email;
	ArrayList<String> edAch		= new ArrayList<String>(maxEdAch); 
	ArrayList<String> wrkXp 	= new ArrayList<String>(maxWrkXp);
	ArrayList<String> skills 	= new ArrayList<String>(maxSkills);

	//Not used in this iteration:
	//ArrayList<String> skillLvl 	= new ArrayList<String>(maxSkills);
	
}