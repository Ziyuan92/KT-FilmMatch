import java.util.ArrayList;

/**
 * match one review with all the film in the list
 * find the most matched film , e.g. method oneGED(),
 * or some matched films that distance smaller than threshold, e.g. method mulGED(),
 * call relative methods in class CalDistance
 */
public class MatchFilm {
	private String[] filmNames;
	private String rev;
	
	public MatchFilm(String[] filmNames, String rev){
		this.filmNames=filmNames;
		this.rev=rev;
	}
	
	/**
	 * Find the most match one (smallest distance)using GED method
	 */
	public String oneGED(){
		int distance=0;
		String matchedFilm = null;
		for(int i=0;i<filmNames.length;i++){
			int result=0;
			CalDistance cd=new CalDistance(filmNames[i],rev);
			result=cd.usingGED();
			if(i==0){
				distance=result;
				matchedFilm=filmNames[i];
			}else{
				if(result<distance){
					distance=result;
					matchedFilm=filmNames[i];
				}
			}
		}
		return matchedFilm;
	}
	
	/**
	 * Find the most match one (smallest distance)using Ngram method
	 */
	public String oneNgram(int n){
		int distance=0;
		String matchedFilm = null;
		for(int i=0;i<filmNames.length;i++){
			int result=0;
			CalDistance cd=new CalDistance(filmNames[i],rev);
			result=cd.UsingNgram(n);
			if(i==0){
				distance=result;
				matchedFilm=filmNames[i];
			}else{
				if(result<distance){
					distance=result;
					matchedFilm=filmNames[i];
				}
			}
		}
		return matchedFilm;
	}
	
	public String oneSoundex(){
		int distance=0;
		String matchedFilm = null;
		for(int i=0;i<filmNames.length;i++){
			int result=0;
			CalDistance cd=new CalDistance(filmNames[i],rev);
			result=cd.UsingSoundex();
			if(i==0){
				distance=result;
				matchedFilm=filmNames[i];
			}else{
				if(result<distance){
					distance=result;
					matchedFilm=filmNames[i];
				}
			}
		}
		return matchedFilm;
	}
	/**
	 * find more than one matched films that satisfy the threshold using GED
	 * @return
	 */
	public String[] mulGED(){
		ArrayList<String> mF=new ArrayList<String>();
		for(int i=0;i<filmNames.length;i++){
			int threshold=(int)(0.5*filmNames[i].length());
			if(filmNames[i].length()>5){
				threshold=(int)(0.3*filmNames[i].length());
			}
			CalDistance cd=new CalDistance(filmNames[i],rev);
			int result=cd.usingGED();
			if(result<threshold){
				mF.add(filmNames[i]);
			}
		}
		String[] matchedFilm = new String[mF.size()];
		mF.toArray(matchedFilm);
		return matchedFilm;
	}
	
	/**
	 * find films that satisfy the threshold using Ngram
	 * @param n
	 * @return all the satisfied films
	 */
	public String[] mulNgram(int n){
		ArrayList<String> mF=new ArrayList<String>();
		for(int i=0;i<filmNames.length;i++){
			int threshold=(int)(0.8*filmNames[i].length());
			if(filmNames[i].length()>5){
				threshold=(int)(0.3*filmNames[i].length());
			}
			CalDistance cd=new CalDistance(filmNames[i],rev);
			int result=cd.UsingNgram(n);
			if(result<threshold){
				mF.add(filmNames[i]);
			}
		}
		String[] matchedFilm = new String[mF.size()];
		mF.toArray(matchedFilm);
		return matchedFilm;
	}
	
	/**
	 * find films that satisfy the threshold using Soundex
	 * @return all the satisfied films
	 */
	public String[] mulSoundex(){
		ArrayList<String> mF=new ArrayList<String>();
		for(int i=0;i<filmNames.length;i++){
			int threshold=(int)(0.8*filmNames[i].length());
			if(filmNames[i].length()>5){
				threshold=(int)(0.3*filmNames[i].length());
			}
			CalDistance cd=new CalDistance(filmNames[i],rev);
			int result=cd.UsingSoundex();
			if(result<threshold){
				mF.add(filmNames[i]);
			}
		}
		String[] matchedFilm = new String[mF.size()];
		mF.toArray(matchedFilm);
		return matchedFilm;
	}

}
