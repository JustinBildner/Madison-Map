run: MadisonMap.class FrontendMadisonMap.class MadisonMapBackend.class MapLoader.class Edge.class Vertex.class ShortestPath.class Path.class
	java FrontendMadisonMap
runTests: runFrontendDeveloperTests runAlgorithmEngineerTests runBackendDeveloperTests runDataWranglerTests
	java -jar junit5.jar -cp . --scan-classpath -n BackendDeveloperTests

runFrontendDeveloperTests: FrontendDeveloperTests.class
	java -jar junit5.jar -cp . --scan-classpath -n FrontendDeveloperTests
FrontendDeveloperTests.class: MadisonMap.class MadisonMapBackend.class FrontendMadisonMap.class Edge.class ShortestPath.class Vertex.class Path.class 
	javac -cp .:junit5.jar FrontendDeveloperTests.java
FrontendMadisonMap.class: FrontendMadisonMap.java IFrontendMadisonMap.class
	javac FrontendMadisonMap.java
IFrontendMadisonMap.class: IFrontendMadisonMap.java
	javac IFrontendMadisonMap.java


runDataWranglerTests: DataWranglerTests.class
	java -jar junit5.jar -cp . --scan-classpath -n DataWranglerTests
DataWranglerTests.class: DataWranglerTests.java Vertex.class IVertex.class Edge.class IEdge.class MapLoader.class
	javac -cp .:junit5.jar DataWranglerTests.java
MapLoader.class: MapLoader.java IMapLoader.class
	javac MapLoader.java
IMapLoader.class: IMapLoader.java
	javac IMapLoader.java


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
BMadisonMap.class: BMadisonMap.java
	javac BMadisonMap.java
BMapLoader.class: BMapLoader.java
	javac BMapLoader.java
IMadisonMapBackend.class: IMadisonMapBackend.java
	javac IMadisonMapBackend.java
MadisonMapBackend.class: MadisonMapBackend.java
	javac MadisonMapBackend.java

clean:
	@rm *.class
