runTests: BackendDeveloperTests.class
	java -jar junit5.jar -cp . --scan-classpath -n BackendDeveloperTests

BackendDeveloperTests.class: BEdge.class BIEdge.class BIMadisonMap.class BMadisonMap.class BIMapLoader.class BMapLoader.class BIShortestPath.class BShortestPath.class BIVertex.class BVertex.class IMadisonMapBackend.class MadisonMapBackend.class GraphADT.class BackendDeveloperTests.java
	javac -cp .:junit5.jar BackendDeveloperTests.java

BIEdge.class: BIEdge.java
	javac BIEdge.java

BEdge.class: BEdge.java
	javac BEdge.java

BIVertex.class: BIVertex.java
	javac BIVertex.java

BVertex.class: BVertex.java
	javac BVertex.java

BIMadisonMap.class: BIMadisonMap.java
	javac BIMadisonMap.java

BMadisonMap.class: BMadisonMap.java
	javac BMadisonMap.java

BIMapLoader.class: BIMapLoader.java
	javac BIMapLoader.java

BMapLoader.class: BMapLoader.java
	javac BMapLoader.java

BIShortestPath.class: BIShortestPath.java
	javac BIShortestPath.java

BShortestPath.class: BShortestPath.java
	javac BShortestPath.java

GraphADT.class: GraphADT.java
	javac GraphADT.java

IMadisonMapBackend.class: IMadisonMapBackend.java
	javac IMadisonMapBackend.java

MadisonMapBackend.class: MadisonMapBackend.java
	javac MadisonMapBackend.java

clean:
	@rm *.class
