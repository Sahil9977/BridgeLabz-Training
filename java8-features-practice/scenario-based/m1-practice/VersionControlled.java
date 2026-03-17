package MT_PRACTICE;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Version{
	int fileSize;
	String version;
	
	public Version(int fileSize, String version) {
		this.fileSize = fileSize;
		this.version = version;
	}
	
	public String getVersion() {
		return version;
	}
	
	public int getFileSize() {
		return fileSize;
	}

	
}
public class VersionControlled {
	
	static HashMap<String ,ArrayList<Version>> hm = new HashMap<>();

	public static void upload(String fileName , String version , int size) {
		Version v1 = new Version(size, version);
		hm.computeIfAbsent(fileName,k-> new ArrayList<>()).add(v1);
		
	}
	
	public static void fetch(String fileName) {
		
		if(hm.containsKey(fileName)) {
			hm.get(fileName).stream()
			.sorted(Comparator.comparing(Version::getFileSize).thenComparing(Version::getVersion))
			.forEach(k->{
				System.out.println(fileName+" "+k.version+" "+k.fileSize);
			});
		}else System.out.println("File Not Found");

	}
	
	public static void latest(String fileName) {
		System.out.println(fileName+" "+hm.get(fileName).get(hm.get(fileName).size()-1).version+" "+hm.get(fileName).get(hm.get(fileName).size()-1).fileSize);
	}
	
	public static void totalStorage(String fileName) {
		int sum =0;
		
		for(int i=0;i<hm.get(fileName).size();i++) {
			sum+=hm.get(fileName).get(i).getFileSize();
		}
		
		System.out.println(fileName+" "+sum);
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<n;i++) {
			String ip = sc.nextLine();
			String [] arr = ip.split(" ");
			if(ip.charAt(0)=='U') {
				upload(arr[1],arr[2], Integer.parseInt(arr[3]));
			}
			else if(ip.charAt(0)=='F') {
				fetch(arr[1]);
			}
			else if(ip.charAt(0)=='L') {
				latest(arr[1]);
			}
			else if(ip.charAt(0)=='T') {
				totalStorage(arr[1]);
			}else {}
		}

	}

}
