runTests: MadisonMap.class AlgorithmEngineerTests.class
	java -jar junit5.jar --class-path . --scan-classpath -n AlgorithmEngineerTests

MadisonMap.class: IMadisonMap.class MadisonMap.java Edge.class Vertex.class Path.class ShortestPath.class
	javac MadisonMap.java
IMadisonMap.class: MadisonMap.java GraphADT.class
	javac IMadisonMap.java
GraphADT.class: GraphADT.java
	javac GraphADT.java
Edge.class: Edge.java IEdge.java
	javac Edge.java
	javac IEdge.java
Vertex.class: Vertex.java IVertex.java
	javac Vertex.java
	javac IVertex.java
Path.class: Path.java IShortestPath.java
	javac Path.java
	javac IShortestPath.java
ShortestPath.class: ShortestPath.java IShortestPath.java
	javac ShortestPath.java
	javac IShortestPath.java
	
AlgorithmEngineerTests.class: MadisonMap.class AlgorithmEngineerTests.java
	javac -cp .:junit5.jar AlgorithmEngineerTests.java -Xlint
clean:
	rm *.class
