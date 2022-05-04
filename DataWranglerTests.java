import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

class DataWranglerTests {

	/**
	 * This JUnit test ensures that the right exception is thrown when a file name
	 * that does not correspond to a real file is passed
	 */
	@Test
	void NonExistentFile() {
		try {
			MapLoader ml = new MapLoader();
			ml.loadMap("this file does not exist");
			fail("FileNotFoundException was not thrown");
		} catch (FileNotFoundException fnfe) {
		}
	}

	/**
	 * This JUnit test ensures that the right number of vertices is loaded
	 */
	@Test
	void loadsAllVertices() {
		MapLoader ml = new MapLoader();
		try {
			List<IVertex> vertices = ml.loadMapList("/Users/noahjillson/Desktop/CS 400/P03/src/hotSpots.tsv");
			assertEquals(vertices.size(), 22, "Improper number of vertices loaded");
		} catch (Exception e) {
			fail("An Exception with the following message was thrown: " + e.getMessage());
		}
	}

	/**
	 * This JUnit test ensures that a given Vertex in the list has the same
	 * reference as the Vertex stored in the edge of another Vertex that points to
	 * our given Vertex (This is the least confusing way to say it but basically
	 * Bascom hill in the Vertex list is the same Bascom hill stored in the edge
	 * stored in the Witte Vertex)
	 */
	@Test
	void edgeReferencesMatchVertexReferences() {
		MapLoader ml = new MapLoader();
		try {
			List<IVertex> vertices = ml.loadMapList("/Users/noahjillson/Desktop/CS 400/P03/src/hotSpots.tsv");
			assertEquals(vertices.get(1), vertices.get(10).getEdges().get(1).getTarget(),
					"Vertex " + vertices.get(1).getName() + " and Vertex "
							+ vertices.get(10).getEdges().get(1).getTarget() + " do no share the same reference");
		} catch (Exception e) {
			fail("An Exception with the following message was thrown: " + e.getMessage());
		}
	}

	/**
	 * This JUnit test ensures that a Vertex with a space in its name will be loaded
	 * entirely properly
	 */
	@Test
	void vertexesWithSpacesAndAmpersands() {
		MapLoader ml = new MapLoader();
		try {
			List<IVertex> vertices = ml.loadMapList("/Users/noahjillson/Desktop/CS 400/P03/src/hotSpots.tsv");
			assertEquals("Witte Residence Hall", vertices.get(0).getName(),
					"The space in the name did not load properly");
			assertEquals("Langdon & Lake", vertices.get(1).getName(), "The & in the name did not load properly");
		} catch (Exception e) {
			fail("An Exception with the following message was thrown: " + e.getMessage());
		}
	}

	/**
	 * This JUnit test ensures that a X and Y coordinates are loaded properly into a
	 * vertex
	 */
	@Test
	void allEdgesLoaded() {
		MapLoader ml = new MapLoader();
		try {
			List<IVertex> vertices = ml.loadMapList("/Users/noahjillson/Desktop/CS 400/P03/src/hotSpots.tsv");
			// Witte at index 0
			for (IVertex v : vertices) {
				System.out.println(v.getName());
			}
			assertEquals(vertices.get(0).getEdges().size(), 3,
					"Not all edges were loaded and connected to this vertex");
			// Red at index 1
			assertEquals(vertices.get(7).getEdges().size(), 4,
					"Not all edges were loaded and connected to this vertex ");
		} catch (Exception e) {
			fail("An Exception with the following message was thrown: " + e.getMessage());
		}

	}

	/**
	 * This JUnit test ensures that a X and Y coordinates are loaded properly into a
	 * vertex
	 */
	@Test
	void allEdgesLoadedForLeastConnectedVertex() {
		MapLoader ml = new MapLoader();
		try {
			
		} catch (Exception e) {
			fail("An Exception with the following message was thrown: " + e.getMessage());

		}
	}
	
	/**
	 * This JUnit test ensures that a X and Y coordinates are loaded properly into a
	 * vertex
	 * MadisonMap mm = new MadisonMap()
	 */
	@Test
	void allEdgesLoadedForMostConnectedVertex() {
		MapLoader ml = new MapLoader();
		try {
			List<IVertex> vertices = ml.loadMapList("/Users/noahjillson/Desktop/CS 400/P03/src/hotSpots.tsv");
			// Witte at index 0
			for (IVertex v : vertices) {
				System.out.println(v.getName());
			}
			assertEquals(vertices.get(0).getEdges().size(), 3,
					"Not all edges were loaded and connected to this vertex");
			// Red at index 1
			assertEquals(vertices.get(7).getEdges().size(), 4,
					"Not all edges were loaded and connected to this vertex ");
		} catch (Exception e) {
			fail("An Exception with the following message was thrown: " + e.getMessage());

		}
	}

}

