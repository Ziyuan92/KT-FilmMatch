/**
 * match one review with one filmName
 * Split the review and filmName into words,
 * match word to word using the three different methods separately,
 * calculate the minimum whole distance between the multiple words in filmName
 * and particular segment in review
 */
public class CalDistance {
	private String filmName;
	private String review;
	private String[] revWords;
	private String[] fnWords;
	
	public CalDistance(String filmName, String review){
		this.filmName=filmName;
		this.review=review;
		this.revWords=this.review.split(" ");
		this.fnWords=this.filmName.split(" ");
	}
	
	/**
	 * match Using GED method
	 * @return the total distance of the whole filmName
	 */
	public int usingGED(){
		int distance=0;
		for(int i=0;i<revWords.length-fnWords.length+1;i++){
			int result=0;
			for(int j=0;j<fnWords.length;j++){
				GED ged=new GED(fnWords[j],revWords[i+j]);
				result+=ged.match();
			}
			if(i==0){
				distance=result;
			}else{
				if(result<distance){
					distance=result;
				}
			}
		}
		return distance;
	}
	
	/**
	 * match Using Ngram method
	 * @param N
	 * @return the total distance of the whole filmName
	 */
	public int UsingNgram(int n){
		int distance=0;
		for(int i=0;i<revWords.length-fnWords.length+1;i++){
			int result=0;
			for(int j=0;j<fnWords.length;j++){
				Ngram ng=new Ngram(fnWords[j],revWords[i+j],n);
				result+=ng.match();
			}
			if(i==0){
				distance=result;
			}else{
				if(result<distance){
					distance=result;
				}
			}
		}
		return distance;
	}
	
	/**
	 * match Using Soundex method
	 * @return the total distance of the whole filmName
	 */
	public int UsingSoundex(){
		int distance=0;
		for(int i=0;i<revWords.length-fnWords.length+1;i++){
			int result=0;
			for(int j=0;j<fnWords.length;j++){
				Soundex s=new Soundex(fnWords[j],revWords[i+j]);
				s.generateCode();
				result+=s.match();
			}
			if(i==0){
				distance=result;
			}else{
				if(result<distance){
					distance=result;
				}
			}
		}
		return distance;
	}

}
