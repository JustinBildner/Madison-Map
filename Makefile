runTests: BackendDeveloperTests.class
	java -jar junit5.jar -cp . --scan-classpath -n BackendDeveloperTests

BackendDeveloperTests.class: Edge.class IEdge.class BIMadisonMap.class BMadisonMap.class BIMapLoader.class BMapLoader.class IShortestPath.class ShortestPath.class IVertex.class Vertex.class IMadisonMapBackend.class MadisonMapBackend.class GraphADT.class BackendDeveloperTests.java
	javac -cp .:junit5.jar BackendDeveloperTests.java

IEdge.class: IEdge.java
	javac IEdge.java

Edge.class: Edge.java
	javac Edge.java

IVertex.class: IVertex.java
	javac IVertex.java

Vertex.class: Vertex.java
	javac Vertex.java

BIMadisonMap.class: BIMadisonMap.java
	javac BIMadisonMap.java

BMadisonMap.class: BMadisonMap.java
	javac BMadisonMap.java

BIMapLoader.class: BIMapLoader.java
	javac BIMapLoader.java

BMapLoader.class: BMapLoader.java
	javac BMapLoader.java

IShortestPath.class: IShortestPath.java
	javac IShortestPath.java

ShortestPath.class: ShortestPath.java
	javac ShortestPath.java

GraphADT.class: GraphADT.java
	javac GraphADT.java

IMadisonMapBackend.class: IMadisonMapBackend.java
	javac IMadisonMapBackend.java

MadisonMapBackend.class: MadisonMapBackend.java
	javac MadisonMapBackend.java

clean:
	@rm *.class
