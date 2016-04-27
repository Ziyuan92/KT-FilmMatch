import java.util.*;

/**
 * Ngram
 * general matching two strings Ngram method, N could be passed as an argument
 */
public class Ngram {
	private String tar;
	private String unknown;
	private int N;
	
	public Ngram(String tar,String unknown,int N){
		this.tar=tar;
		this.unknown=unknown;
		this.N=N;
	}
	
	/**
	 * match two strings using Ngram
	 * @return the Ngram distance
	 */
	public int match(){
		
		List<String> sub_tar=new ArrayList<String>();
		List<String> sub_unknown=new ArrayList<String>();
		
		if(tar.length()<N||unknown.length()<N){
			N=Math.min(tar.length(), unknown.length());
		}
		for(int i=0;i<tar.length()-N+1;i++){
			StringBuilder sb=new StringBuilder("");
			for(int j=0;j<N;j++){
				sb.append(tar.charAt(i+j));
			}
			sub_tar.add(sb.toString().trim());
		}
		
		for(int i=0;i<unknown.length()-N+1;i++){
			StringBuilder sb=new StringBuilder("");
			for(int j=0;j<N;j++){
				sb.append(unknown.charAt(i+j));
			}
			sub_unknown.add(sb.toString().trim());
		}
		
		
		int ltar=sub_tar.size();
		int lunknown=sub_unknown.size();
		int count=0;
		if(sub_tar.size()<=sub_unknown.size()){
		    sub_tar.retainAll(sub_unknown);
		    count=sub_tar.size();
		}else{
			sub_unknown.retainAll(sub_tar);
			count=sub_unknown.size();
		}
		
		//System.out.println(count);
		int distance=ltar+lunknown-2*count;
		//System.out.println(distance);
		return distance;
	}

}
