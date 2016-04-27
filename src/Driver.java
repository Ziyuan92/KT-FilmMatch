import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * read filmNames and all the reviews from txt file
 * do the approximate match with different methods
 */
public class Driver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//read filmNames and stored in filmNames
		ArrayList<String> filmList=new ArrayList<String>();
		String pathname1 = "F:\\filmData\\film_titles.txt";
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathname1))));
		String str=null; 
		while((str=br.readLine())!=null) {
			filmList.add(str);
		}
		String[] filmNames=new String[filmList.size()];
		filmList.toArray(filmNames);
		br.close();
		
		//read the rev list and stores in reviews
		String FILE_IN = "F:\\filmData\\revs";  
        File f = new File(FILE_IN);  
        ArrayList<String> fileList = new ArrayList<String>();  
        fileList = getFileList(f);  
        
        ArrayList<String> revList=new ArrayList<String>();
        for(int i=0;i<fileList.size();i++){
        	String rev = "";
    		String pathname2 = fileList.get(i);
    		BufferedReader brR=new BufferedReader(new InputStreamReader(new FileInputStream(new File(pathname2))));
    		String content=null;
    		while((content=brR.readLine())!=null){
    			rev+=content.trim();
    		}
    		brR.close();
    		revList.add(rev);
        }
        String[] reviews=new String[revList.size()];
        revList.toArray(reviews);
				
		
        for(int i=0;i<reviews.length;i++){
        	//for review i
        	MatchFilm matchF=new MatchFilm(filmNames,reviews[i]);
        	//find the most matched film using Ngram method, parameter 2 is N
        	//String film=matchF.oneNgram(2);
        	//find the most matched film using soudex method
        	//String film=matchF.oneSoundex();
        	String film=matchF.oneGED();
        	//print result
            System.out.println("review"+i+" "+fileList.get(i)+": "+film);
        	
        	//find multiple matched film using GED method
        	//String[] films=matchF.mulGED();
        	//print result
        	/*System.out.print("review"+i+" "+fileList.get(i)+": ");
        	for(int k=0;k<films.length;k++){
        	System.out.print(films[k]+",\t");
        	}
        	System.out.println(" ");*/
        }
	}
	
	public static ArrayList<String> getFileList(File file) {  
		  
        ArrayList<String> result = new ArrayList<String>();  
  
        if (!file.isDirectory()) {  
            System.out.println(file.getAbsolutePath());  
            result.add(file.getAbsolutePath());  
        } else {  
            File[] directoryList = file.listFiles(new FileFilter() {  
                public boolean accept(File file) {  
                    if (file.isFile() && file.getName().indexOf("txt") > -1) {  
                        return true;  
                    } else {  
                        return false;  
                    }  
                }  
            });  
            for (int i = 0; i < directoryList.length; i++) {  
                result.add(directoryList[i].getPath()); 
            } 
            
        }  
  
        return result;  
    }  

}
