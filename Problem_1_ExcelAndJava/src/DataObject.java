public class DataObject
{
	private double rollNumber;
	private String candidateName;
	private String collegeName;
	private double physicsMarks;
	private double mathsMarks;
	private double chemistryMarks;
	private double biologyMarks;
	private double englishMarks;
	private double computerMarks;
	
	public void setRollNumber(double rollNumber){
		this.rollNumber=rollNumber;
	}
	
	public double getRollNumber(){
		return this.rollNumber;
	}
	
	public void setCandidateName(String candidateName){
		this.candidateName=candidateName;
	}
	
	public String getCandidateName(){
		return this.candidateName;
	}
	
	public void setCollegeName(String collegeName){
		this.collegeName=collegeName;
	}
	
	public String getCollegeName(){
		return this.collegeName;
	}

	public void setPhysicsMarks(double physicsMarks){
		this.physicsMarks=physicsMarks;
	}
	
	public double getPhysicsMarks(){
		return this.physicsMarks;
	}
	
	public void setChemistryMarks(double chemistryMarks){
		this.chemistryMarks=chemistryMarks;
	}
	
	public double getChemistryMarks(){
		return this.chemistryMarks;
	}
	
	public void setMathsMarks(double mathsMarks){
		this.mathsMarks=mathsMarks;
	}
	
	public double getMathsMarks(){
		return this.mathsMarks;
	}
	
	public void setEnglishMarks(double englishMarks){
		this.englishMarks=englishMarks;
	}
	
	public double getEnglishMarks(){
		return this.englishMarks;
	}
	
	public void setComputerMarks(double computerMarks){
		this.computerMarks=computerMarks;
	}
	
	public double getComputerMarks(){
		return this.computerMarks;
	}
	
	public void setBiologyMarks(double biologyMarks){
		this.biologyMarks=biologyMarks;
	}
	
	public double getBiologyMarks(){
		return this.biologyMarks;
	}
	
	public double getTotal(){
		return this.mathsMarks+this.physicsMarks+this.chemistryMarks+this.englishMarks+this.biologyMarks+this.computerMarks;
	}
	
	
}