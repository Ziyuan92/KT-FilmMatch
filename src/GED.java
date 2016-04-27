/**
 * Global Edit Distance
 * general matching two strings using global edit distance method
 *
 */
public class GED {
	//[m,i,d,r]=[0,1,1,1]
	private String tar;
	private String unknown;
	private int[][] F;
	
	public GED(String tar, String unknown){
		this.tar=tar;
		this.unknown=unknown;
		F=new int[tar.length()+1][unknown.length()+1];
	}
	
	private int[][] generateMatrix(){
		int ltar=tar.length();
		int lun=unknown.length();
		for(int i=0;i<=ltar;i++){
			F[i][0]=i;
		}
		for(int j=0;j<=lun;j++){
			F[0][j]=j;
		}
		for(int i=1;i<=ltar;i++){
			for(int j=1;j<=lun;j++){
				int temp=Math.min(F[i-1][j]+1, F[i][j-1]+1);
				F[i][j]=Math.min(temp, F[i-1][j-1]+equal(tar.charAt(i-1),unknown.charAt(j-1)));
			}
		}
		return F;
	}
	/**
	 * match the two strings using ged
	 * @return the global distance between the two strings
	 */
	public int match(){
		this.F=generateMatrix();
		int distance=F[tar.length()][unknown.length()];
		return distance;
	}
	private int equal(char a, char b){
		return a==b?0:1;
	}

}
