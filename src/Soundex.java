/**
 * Soundex
 * general matching two strings using Soundex method
 * generate the Soundex code and then Using GED method to calculate the distance between the two code
 */
public class Soundex {
	//aehiouwy-->0  both upper case and lower case
	//bfpv-->1
	//cgjkqsxz-->2
	//dt-->3
	//l-->4
	//mn-->5
	//r-->6
	//0-9-->7
	//others-->8
	private String tar;
	private String unknown;
	private static int[] code;  //store the code for all the 256 chars in ACSII
	private String codeTar;
	private String codeUnknown;
	
	static{
		//initialize code
				code=new int[256];
				for(int i=0;i<code.length;i++){
					if(i>=48&&i<=57){//0-9
						code[i]=7;
					}else if(i==65||i==69||i==72||i==73||i==79||i==85||
							i==87||i==89||i==97||i==101||i==104||i==105||
							i==111||i==117||i==119||i==121){//aehiouwy
						code[i]=0;
					}else if(i==66||i==70||i==80||i==86||i==98||i==102||
							i==112||i==118){//bfpv
						code[i]=1;
					}else if(i==67||i==71||i==74||i==75||i==81||i==83||
							i==88||i==90||i==99||i==103||i==106||i==107||
							i==113||i==115||i==120||i==122){//cgjkqsxz
						code[i]=2;
					}else if(i==68||i==84||i==100||i==116){//dt
						code[i]=3;
					}else if(i==76||i==108){//l
						code[i]=4;
					}else if(i==77||i==78||i==109||i==110){//mn
						code[i]=5;
					}else if(i==82||i==114){//r
						code[i]=6;
					}else{
						code[i]=8;
					}			
				}
				
	}
	
	public Soundex(String tar,String unknown){
		this.tar=tar;
		this.unknown=unknown;
	}
	
	/**
	 * generate the Soundex code for the two strings
	 */
	public void generateCode(){
		String code_tar;
		String code_unknown;
		//original tar
		StringBuilder sb1=new StringBuilder("");
		sb1.append(tar.charAt(0));
		for(int i=1;i<tar.length();i++){
			int index=(int)tar.charAt(i);
			if(index>=256||index<0){
				index=0;
			}
			sb1.append(code[index]);
		}
		code_tar=sb1.toString().trim();
		//original unknown
		StringBuilder sb2=new StringBuilder("");
		sb2.append(unknown.charAt(0));
		for(int i=1;i<unknown.length();i++){
			int index=(int)unknown.charAt(i);
			if(index>=256||index<0){
				index=0;
			}
			sb2.append(code[index]);
		}
		code_unknown=sb2.toString().trim();
		
		//remove doubles
		String temp1="";
		for(int i=0;i<code_tar.length();i++){
			if(i<code_tar.length()-1){
				if(code_tar.charAt(i)!=code_tar.charAt(i+1)){
					temp1+=code_tar.charAt(i);
				}
			}else{
				temp1+=code_tar.charAt(i);
			}
		}
		code_tar=temp1;
		String temp2="";
		for(int i=0;i<code_unknown.length();i++){
			if(i<code_unknown.length()-1){
				if(code_unknown.charAt(i)!=code_unknown.charAt(i+1)){
					temp2+=code_unknown.charAt(i);
				}
			}else{
				temp2+=code_unknown.charAt(i);
			}
		}
		code_unknown=temp2;
		
		//remove 0s
		temp1="";
		for(int i=0;i<code_tar.length();i++){
			if(code_tar.charAt(i)!='0'){
				temp1+=code_tar.charAt(i);
			}
		}
		code_tar=temp1;
		temp2="";
		for(int i=0;i<code_unknown.length();i++){
			if(code_unknown.charAt(i)!='0'){
				temp2+=code_unknown.charAt(i);
			}
		}
		code_unknown=temp2;
		
		this.codeTar=code_tar;
		this.codeUnknown=code_unknown;
	}
	
	/**
	 * calculate the global edit distance between the two generated soundex code
	 * @return
	 */
	public int match(){
		GED ged=new GED(codeTar,codeUnknown);
		int distance=ged.match();
		return distance;
	}

}
