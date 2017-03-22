public class Game {
	private String answer;
    private String hits;
    private String misses;

	public Game(String answer) {
		this.answer = answer;
        hits = "";
        misses = ""'
        // constructor
	}
	public boolean application(char letter) {
		boolean isHit = answer.indexOf(letter) != -1;
		if (isHit) {
				hits += letter;
		} else {
			misses +=letter;
		}
        return isHit;
	}		


}
