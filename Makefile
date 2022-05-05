run: MadisonMap.class FrontendMadisonMap.class BackendMadisonMap.class

runTests: runFrontendDeveloperTests runAlgorithmEngineerTests runBackendDeveloperTests runDataWranglerTests
	java -jar junit5.jar -cp . --scan-classpath -n BackendDeveloperTests

runAlgorithmEngineerTests: MadisonMap.class AlgorithmEngineerTests.class
	java -jar junit5.jar --class-path . --scan-classpath -n AlgorithmEngineerTests
AlgorithmEngineerTests.class: MadisonMap.class AlgorithmEngineerTests.java
	javac -cp .:junit5.jar AlgorithmEngineerTests.java -Xlint
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


runBackendDeveloperTests: BackendDeveloperTests.class
	java -jar junit5.jar -cp . --scan-classpath -n BackendDeveloperTests

BackendDeveloperTests.class: Edge.class IEdge.class IMadisonMap.class BMadisonMap.class IMapLoader.class BMapLoader.class IShortestPath.class ShortestPath.class GraphADT.class IMadisonMapBackend.class MadisonMapBackend.class BackendDeveloperTests.java
	javac -cp .:junit5.jar BackendDeveloperTests.java
IMadisonMap.class: IMadisonMap.java
	javac IMadisonMap.java
BMadisonMap.class: BMadisonMap.java
	javac BMadisonMap.java
IMapLoader.class: IMapLoader.java
	javac IMapLoader.java
BMapLoader.class: BMapLoader.java
	javac BMapLoader.java
GraphADT.class: GraphADT.java
	javac GraphADT.java
IMadisonMapBackend.class: IMadisonMapBackend.java
	javac IMadisonMapBackend.java
MadisonMapBackend.class: MadisonMapBackend.java
	javac MadisonMapBackend.java


clean:
	@rm *.class
