package model;

public class CypherText {
	
	private String cypherText;
	private String originalText;
	
	public CypherText (String cypherText)
	{
		this.cypherText = cypherText;
		this.originalText = cypherText;
	}
	
	public void setCypherText(String cypherText)
	{
		this.cypherText = cypherText;
	}
	
	public String getCypherText()
	{
		return cypherText;
	}
	
	public String getOriginalText()
	{
		return originalText;
	}

}
