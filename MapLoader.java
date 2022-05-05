import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * A class that loads the Map into IVertex objects
 * 
 * @author Noah Jillson
 */
public class MapLoader implements IMapLoader {
	/**
	 * loads the map stored in the .tsv file into a Hashtable of IVertex objects
	 *
	 * @param path string representing the file path
	 * @return a Hashtable of IVertex objects
	 * @throws FileNotFoundException when there is not a .tsv file stored at the location of path
	 */
	@Override
	public Hashtable<String, IVertex> loadMap(String path) throws FileNotFoundException {
		File file = new File(path);

		if (!file.exists()) {
			throw new FileNotFoundException("File at " + path + " does not Exist");
		}

		Scanner scanner = new Scanner(file);

		ArrayList<String[]> allLines = new ArrayList<String[]>();

		Hashtable<String, IVertex> allVertices = new Hashtable<String, IVertex>();

		try {
			if (!scanner.hasNextLine()) {
				scanner.close();
				return allVertices;
			}

			scanner.nextLine();

			// extracts each line of the tsv file into a ArrayList
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] splitLine = line.split("	");
				// Instantiates the first node from each line so that the exact node can be
				// referenced when adding edges later
				Vertex vertex = new Vertex(splitLine[0]);
				allVertices.put(vertex.getName(), vertex);
				allLines.add(splitLine);
			}

			// re-traverses each line of the file and adds all of the outgoing connections
			for (String[] splitLine : allLines) {
				IVertex currentVertex = allVertices.get(splitLine[0]);
				for (int i = 1; i + 1 < splitLine.length; i += 2) {
					currentVertex.addConnectingEdge(allVertices.get(splitLine[i]),
							Integer.parseInt(splitLine[i+1]));
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			// Ensures that the scanner is closed no matter what
			scanner.close();
		}
		return allVertices;
	}

	/**
	 * loads the map stored in the .tsv file into a list of IVertex objects
	 *
	 * @param path string representing the file path
	 * @return a list of IVertex objects
	 * @throws FileNotFoundException when there is not a .tsv file stored at the location of path
	 */
	public List<IVertex> loadMapList(String path) throws FileNotFoundException {
		ArrayList<IVertex> vertices =new ArrayList<IVertex>();
	        Hashtable<String, IVertex> vertexTable = this.loadMap(path);

		// Puts all of the vertices stored in the HashTable into an ArrayList
		for (IVertex v : vertexTable.values()) {
			vertices.add(v);
		}
		return vertices;
	}
}

