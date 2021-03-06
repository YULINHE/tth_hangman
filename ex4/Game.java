public class Game {
	public static final int MAX_MISSES = 7;
	
	private String answer;

    
	private String hits;
	private String misses;

	public Game(String answer) {
		this.answer = answer.toLowerCase(); // this changes higher case to lower case
		hits = "";
		misses = "";

	}

	public String getAnwer(){
		return answer;
	}
	private char normalizeGuess(char letter) {
		if ( ! Character.isLetter(letter)) {
			throw new IllegalArgumentException( " A letter is required ");//illegalArgumentException extends RuntimeException
		} 
		// to make sure the input is a letter
		letter = Character.toLowerCase(letter);
		if (misses.indexOf(letter) !=-1 || hits.indexOf(letter) != -1) {
			throw new IllegalArgumentException(letter + "has already been guessed");
		}
		return letter;
		
	}
	public boolean applyGuess(String letters){
		if (letter.length() == 0) {
			throw new IllegalArgumentException ("No letter found");
		}

		return applyGuess(letter.charAt(0));
		
	}
	public boolean applyGuess(char letter) {
		letter = normalizeGuess(letter);
		//raise Exeption 
		boolean isHit = answer.indexOf(letter) != -1;
		if (isHit) {
			hits += letter;
		} else { 
			misses += letter;
		}
		return isHit;
	}
	public int getRemainingTries(){
		return MAX_MISSES - misses.length();
	}
	public String getCurrentProgress() {
		String progress = "";
		for (char letter : answer.toCharArray()){
			char display = '-';
			if(hits.indexOf(letter)!= -1) {
				display = letter;
			}
			progress += display;
		}
		return progress;
	}
	public boolean isWon(){
		return getCurrentProgress().indexOf('-') == -1;
		
	}
}
