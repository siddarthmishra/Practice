package misc;
/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* You may add any imports here, if you wish, but only from the 
   standard library */

public class Main {
	public static int processData(ArrayList<String> array) {
		/*
		 * Modify this method to process `array` as indicated in the question. At the
		 * end, return the appropriate value.
		 *
		 * Please create appropriate classes, and use appropriate data structures as
		 * necessary.
		 *
		 * Do not print anything in this method.
		 *
		 * Submit this entire program (not just this method) as your answer
		 */
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		int serverCount = 0;
		String latestVersion = null;
		for (String arr : array) {
			String[] split = arr.split(",");
			String software = split[2].trim();
			String version = split[3].trim();
			if (map.containsKey(software)) {
				List<String> list = map.get(software);
				list.add(version);
				map.put(software, list);
			} else {
				List<String> list = new ArrayList<String>();
				list.add(version);
				map.put(software, list);
			}
		}
		System.out.println(map);
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			List<String> versionList = entry.getValue();
			latestVersion = getLatestVersion(versionList);
		}
		return serverCount;
	}

	public static String getLatestVersion(List<String> versionList) {
		for (int i = 0; i < versionList.size() - 1; i++) {
			String version1 = versionList.get(i).trim();
			String version2 = versionList.get(i + 1).trim();
			String[] splitVersion1 = version1.split(".");
			String[] splitVersion2 = version2.split(".");
			
		}
		return "";
	}

	public static void main(String[] args) {
		ArrayList<String> inputData = new ArrayList<String>();
		try {
			Scanner in = new Scanner(new BufferedReader(new FileReader(new File("./src/input.txt"))));
			while (in.hasNextLine()) {
				String line = in.nextLine().trim();
				if (!line.isEmpty()) // Ignore blank lines
					inputData.add(line);
			}
			// System.out.println(inputData);
			int retVal = processData(inputData);
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
			output.println("" + retVal);
			output.close();
			in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
